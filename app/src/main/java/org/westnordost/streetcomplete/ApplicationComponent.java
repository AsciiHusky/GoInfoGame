package org.westnordost.streetcomplete;

import org.westnordost.streetcomplete.data.DbModule;
import org.westnordost.streetcomplete.data.download.QuestDownloadService;
import org.westnordost.streetcomplete.data.meta.MetadataModule;
import org.westnordost.streetcomplete.data.osm.upload.ChangesetAutoCloserService;
import org.westnordost.streetcomplete.data.upload.QuestChangesUploadService;
import org.westnordost.streetcomplete.oauth.OAuthModule;
import org.westnordost.streetcomplete.quests.AbstractQuestAnswerFragment;
import org.westnordost.streetcomplete.quests.QuestModule;
import org.westnordost.streetcomplete.quests.note_discussion.NoteDiscussionForm;
import org.westnordost.streetcomplete.quests.opening_hours.AddOpeningHoursForm;
import org.westnordost.streetcomplete.quests.road_name.AddRoadNameForm;
import org.westnordost.streetcomplete.settings.SettingsActivity;
import org.westnordost.streetcomplete.settings.SettingsFragment;
import org.westnordost.streetcomplete.tangram.QuestsMapFragment;

import javax.inject.Singleton;

import dagger.Component;

import org.westnordost.streetcomplete.data.OsmModule;
import org.westnordost.streetcomplete.oauth.OsmOAuthDialogFragment;
import org.westnordost.streetcomplete.statistics.AnswersCounter;
import org.westnordost.streetcomplete.util.SerializedSavedState;

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
