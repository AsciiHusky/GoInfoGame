package org.opensidewalks.goinfo.settings;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import javax.inject.Inject;

import org.opensidewalks.goinfo.Injector;
import org.opensidewalks.goinfo.Prefs;
import org.opensidewalks.goinfo.data.QuestStatus;
import org.opensidewalks.goinfo.data.osmnotes.OsmNoteQuest;
import org.opensidewalks.goinfo.data.osmnotes.OsmNoteQuestDao;
import org.opensidewalks.goinfo.oauth.OAuthPrefs;
import org.opensidewalks.goinfo.R;
import org.opensidewalks.goinfo.oauth.OsmOAuthDialogFragment;

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener
{
	@Inject SharedPreferences prefs;
	@Inject OAuthPrefs oAuth;
	@Inject OsmNoteQuestDao osmNoteQuestDao;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		Injector.instance.getApplicationComponent().inject(this);

		addPreferencesFromResource(R.xml.preferences);

		Preference oauth = getPreferenceScreen().findPreference("oauth");
		oauth.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
		{
			@Override
			public boolean onPreferenceClick(Preference preference)
			{
				new OsmOAuthDialogFragment().show(getFragmentManager(), OsmOAuthDialogFragment.TAG);
				return true;
			}
		});
	}

	@Override
	public void onStart()
	{
		super.onStart();
		updateOsmAuthSummary();
	}

	private void updateOsmAuthSummary()
	{
		Preference oauth = getPreferenceScreen().findPreference("oauth");
		String username = prefs.getString(Prefs.OSM_USER_NAME, null);
		if (oAuth.isAuthorized())
		{
			String summary = String.format(getResources().getString(R.string.pref_title_authorized_username_summary), username);
			oauth.setSummary(summary);
		}
		else
		{
			oauth.setSummary(R.string.pref_title_not_authorized_summary);
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		prefs.registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	public void onPause() {
		super.onPause();
		prefs.unregisterOnSharedPreferenceChangeListener(this);
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
	{
		if(key.equals(Prefs.OAUTH_ACCESS_TOKEN_SECRET))
		{
			updateOsmAuthSummary();
		}
		else if(key.equals(Prefs.SHOW_NOTES_NOT_PHRASED_AS_QUESTIONS))
		{
			final Preference pref = getPreferenceScreen().findPreference(Prefs.SHOW_NOTES_NOT_PHRASED_AS_QUESTIONS);

			pref.setEnabled(false);
			new AsyncTask<Void, Void, Void>()
			{
				@Override protected Void doInBackground(Void... params)
				{
					for(OsmNoteQuest quest : osmNoteQuestDao.getAll(null,null))
					{
						if (quest.getStatus() == QuestStatus.NEW || quest.getStatus() == QuestStatus.INVISIBLE)
						{
							boolean showNonQuestionNotes = prefs.getBoolean(Prefs.SHOW_NOTES_NOT_PHRASED_AS_QUESTIONS, false);
							boolean visible = quest.probablyContainsQuestion() || showNonQuestionNotes;
							QuestStatus newQuestStatus = visible ? QuestStatus.NEW : QuestStatus.INVISIBLE;

							if (quest.getStatus() != newQuestStatus)
							{
								quest.setStatus(newQuestStatus);
								osmNoteQuestDao.update(quest);
							}
						}
					}
					return null;
				}

				@Override protected void onPostExecute(Void result)
				{
					pref.setEnabled(true);
				}

			}.execute();
		}
	}
}
