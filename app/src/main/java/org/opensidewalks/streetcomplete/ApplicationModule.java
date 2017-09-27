package org.opensidewalks.streetcomplete;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import org.opensidewalks.streetcomplete.data.QuestController;
import org.opensidewalks.streetcomplete.data.osm.persist.MergedElementDao;
import org.opensidewalks.streetcomplete.data.osm.persist.OsmQuestDao;
import org.opensidewalks.streetcomplete.tools.CrashReportExceptionHandler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import org.opensidewalks.streetcomplete.data.QuestTypes;
import org.opensidewalks.streetcomplete.data.changesets.OpenChangesetsDao;
import org.opensidewalks.streetcomplete.data.download.MobileDataAutoDownloadStrategy;
import org.opensidewalks.streetcomplete.data.download.WifiAutoDownloadStrategy;
import org.opensidewalks.streetcomplete.data.osm.persist.ElementGeometryDao;
import org.opensidewalks.streetcomplete.data.osm.persist.UndoOsmQuestDao;
import org.opensidewalks.streetcomplete.data.osmnotes.CreateNoteDao;
import org.opensidewalks.streetcomplete.data.osmnotes.OsmNoteQuestDao;
import org.opensidewalks.streetcomplete.data.tiles.DownloadedTilesDao;
import org.opensidewalks.streetcomplete.location.LocationRequestFragment;
import org.opensidewalks.streetcomplete.oauth.OsmOAuthDialogFragment;

@Module
public class ApplicationModule
{
	private final Application application;

	public ApplicationModule(Application application)
	{
		this.application = application;
	}

	@Provides public Context appContext()
	{
		return application;
	}

	@Provides public Application application()
	{
		return application;
	}

	@Provides public SharedPreferences preferences()
	{
		return PreferenceManager.getDefaultSharedPreferences(application);
	}

	@Provides public AssetManager assetManager()
	{
		return application.getAssets();
	}

	@Provides public Resources resources()
	{
		return application.getResources();
	}

	@Provides public QuestController questController(
            OsmQuestDao osmQuestDB, UndoOsmQuestDao undoOsmQuestDB, MergedElementDao osmElementDB,
            ElementGeometryDao geometryDB, OsmNoteQuestDao osmNoteQuestDB,
            CreateNoteDao createNoteDB, OpenChangesetsDao manageChangesetsDB)
	{
		return new QuestController(
				osmQuestDB, undoOsmQuestDB, osmElementDB, geometryDB, osmNoteQuestDB, createNoteDB,
				manageChangesetsDB,	appContext());
	}

	@Provides public static MobileDataAutoDownloadStrategy mobileDataAutoDownloadStrategy(
			OsmQuestDao osmQuestDB, DownloadedTilesDao downloadedTilesDao, QuestTypes questTypes,
			SharedPreferences preferences
	)
	{
		return new MobileDataAutoDownloadStrategy(osmQuestDB, downloadedTilesDao, questTypes,
				preferences);
	}

	@Provides public static WifiAutoDownloadStrategy wifiAutoDownloadStrategy(
			OsmQuestDao osmQuestDB, DownloadedTilesDao downloadedTilesDao, QuestTypes questTypes,
			SharedPreferences preferences
	)
	{
		return new WifiAutoDownloadStrategy(osmQuestDB, downloadedTilesDao, questTypes,
				preferences);
	}

	@Provides public static LocationRequestFragment locationRequestComponent()
	{
		return new LocationRequestFragment();
	}

	@Provides @Singleton public static CrashReportExceptionHandler serializer(Context ctx)
	{
		return new CrashReportExceptionHandler(ctx);
	}

	@Provides public static OsmOAuthDialogFragment osmOAuthFragment()
	{
		return new OsmOAuthDialogFragment();
	}
}
