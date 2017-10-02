package org.opensidewalks.goinfo.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import org.opensidewalks.goinfo.data.changesets.OpenChangesetsDao;
import org.opensidewalks.goinfo.data.osm.persist.OsmQuestDao;
import org.opensidewalks.goinfo.data.osm.persist.UndoOsmQuestDao;
import org.opensidewalks.goinfo.data.statistics.QuestStatisticsDao;
import org.opensidewalks.goinfo.quests.road_name.data.RoadNamesTablesHelper;
import org.opensidewalks.goinfo.util.KryoSerializer;
import org.opensidewalks.goinfo.util.Serializer;
import de.westnordost.osmapi.changesets.ChangesetsDao;

@Module
public class DbModule
{
	@Provides @Singleton public static SQLiteOpenHelper sqliteOpenHelper(Context ctx)
	{
		return new StreetCompleteOpenHelper(ctx, new TablesHelper[]{ new RoadNamesTablesHelper() });
	}

	@Provides @Singleton public static Serializer serializer()
	{
		return new KryoSerializer();
	}

	@Provides @Singleton public static QuestStatisticsDao questStatisticsDao(
			SQLiteOpenHelper dbHelper, ChangesetsDao changesetsDao)
	{
		return new QuestStatisticsDao(dbHelper, changesetsDao);
	}

	@Provides @Singleton public static OpenChangesetsDao changesetsManagerDao(
			SQLiteOpenHelper dbHelper, SharedPreferences prefs)
	{
		return new OpenChangesetsDao(dbHelper,prefs);
	}

	@Provides @Singleton public static OsmQuestDao osmQuestDao(
			SQLiteOpenHelper dbHelper, Serializer serializer, QuestTypes questTypeList)
	{
		return new OsmQuestDao(dbHelper, serializer, questTypeList);
	}

	@Provides @Singleton public static UndoOsmQuestDao undoOsmQuestDao(
			SQLiteOpenHelper dbHelper, Serializer serializer, QuestTypes questTypeList)
	{
		return new UndoOsmQuestDao(dbHelper, serializer, questTypeList);
	}
}
