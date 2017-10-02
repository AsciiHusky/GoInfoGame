package org.opensidewalks.goinfo;

import javax.inject.Singleton;

import dagger.Component;
import org.opensidewalks.goinfo.data.DbModule;
import org.opensidewalks.goinfo.data.OsmModule;
import org.opensidewalks.goinfo.data.upload.QuestChangesUploadService;
import org.opensidewalks.goinfo.data.download.QuestDownloadService;
import org.opensidewalks.goinfo.data.meta.MetadataModule;
import org.opensidewalks.goinfo.data.osm.upload.ChangesetAutoCloserService;
import org.opensidewalks.goinfo.oauth.OAuthModule;
import org.opensidewalks.goinfo.oauth.OsmOAuthDialogFragment;
import org.opensidewalks.goinfo.quests.AbstractQuestAnswerFragment;
import org.opensidewalks.goinfo.quests.QuestModule;
import org.opensidewalks.goinfo.quests.opening_hours.AddOpeningHoursForm;
import org.opensidewalks.goinfo.quests.road_name.AddRoadNameForm;
import org.opensidewalks.goinfo.quests.note_discussion.NoteDiscussionForm;
import org.opensidewalks.goinfo.settings.SettingsActivity;
import org.opensidewalks.goinfo.settings.SettingsFragment;
import org.opensidewalks.goinfo.statistics.AnswersCounter;
import org.opensidewalks.goinfo.tangram.QuestsMapFragment;
import org.opensidewalks.goinfo.util.SerializedSavedState;

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
