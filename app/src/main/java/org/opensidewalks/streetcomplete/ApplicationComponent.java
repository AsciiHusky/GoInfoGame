package org.opensidewalks.streetcomplete;

import org.opensidewalks.streetcomplete.data.DbModule;
import org.opensidewalks.streetcomplete.data.download.QuestDownloadService;
import org.opensidewalks.streetcomplete.data.meta.MetadataModule;
import org.opensidewalks.streetcomplete.data.osm.upload.ChangesetAutoCloserService;
import org.opensidewalks.streetcomplete.data.upload.QuestChangesUploadService;
import org.opensidewalks.streetcomplete.oauth.OAuthModule;
import org.opensidewalks.streetcomplete.quests.AbstractQuestAnswerFragment;
import org.opensidewalks.streetcomplete.quests.QuestModule;
import org.opensidewalks.streetcomplete.quests.note_discussion.NoteDiscussionForm;
import org.opensidewalks.streetcomplete.quests.opening_hours.AddOpeningHoursForm;
import org.opensidewalks.streetcomplete.quests.road_name.AddRoadNameForm;
import org.opensidewalks.streetcomplete.settings.SettingsActivity;
import org.opensidewalks.streetcomplete.settings.SettingsFragment;
import org.opensidewalks.streetcomplete.tangram.QuestsMapFragment;

import javax.inject.Singleton;

import dagger.Component;

import org.opensidewalks.streetcomplete.data.OsmModule;
import org.opensidewalks.streetcomplete.oauth.OsmOAuthDialogFragment;
import org.opensidewalks.streetcomplete.statistics.AnswersCounter;
import org.opensidewalks.streetcomplete.util.SerializedSavedState;

@Singleton
@Component(modules = {ApplicationModule.class, OAuthModule.class, OsmModule.class, QuestModule.class,
		DbModule.class, MetadataModule.class})
public interface ApplicationComponent
{
	void inject(StreetCompleteApplication app);

	void inject(MainActivity mainActivity);
	void inject(NoteDiscussionForm noteDiscussionForm);
	void inject(SerializedSavedState tSerializedSavedState);

	void inject(QuestChangesUploadService questChangesUploadService);
	void inject(QuestDownloadService questChangesDownloadService);
	void inject(ChangesetAutoCloserService changesetAutoCloserService);

	void inject(SettingsFragment settingsFragment);
	void inject(SettingsActivity settingsActivity);

	void inject(AnswersCounter answersCounter);

	void inject(AddOpeningHoursForm addOpeningHoursForm);
	void inject(AddRoadNameForm addRoadNameForm);

	void inject(OsmOAuthDialogFragment osmOAuthDialogFragment);

	void inject(AbstractQuestAnswerFragment abstractQuestAnswerFragment);

	void inject(QuestsMapFragment questsMapFragment);
}
