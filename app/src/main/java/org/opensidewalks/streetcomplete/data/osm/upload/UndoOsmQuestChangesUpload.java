package org.opensidewalks.streetcomplete.data.osm.upload;

import android.content.SharedPreferences;

import org.opensidewalks.streetcomplete.data.osm.persist.MergedElementDao;

import javax.inject.Inject;

import de.westnordost.osmapi.changesets.ChangesetsDao;
import de.westnordost.osmapi.map.MapDataDao;
import org.opensidewalks.streetcomplete.data.changesets.OpenChangesetsDao;
import org.opensidewalks.streetcomplete.data.osm.OsmQuestUnlocker;
import org.opensidewalks.streetcomplete.data.osm.persist.ElementGeometryDao;
import org.opensidewalks.streetcomplete.data.osm.persist.UndoOsmQuestDao;
import org.opensidewalks.streetcomplete.data.statistics.QuestStatisticsDao;
import org.opensidewalks.streetcomplete.data.tiles.DownloadedTilesDao;

public class UndoOsmQuestChangesUpload extends AOsmQuestChangesUpload
{
	@Inject public UndoOsmQuestChangesUpload(
			MapDataDao osmDao, UndoOsmQuestDao questDB, MergedElementDao elementDB,
			ElementGeometryDao elementGeometryDB, QuestStatisticsDao statisticsDB,
			OpenChangesetsDao openChangesetsDB, ChangesetsDao changesetsDao,
			DownloadedTilesDao downloadedTilesDao, SharedPreferences prefs,
			OsmQuestUnlocker questUnlocker)
	{
		super(osmDao, questDB, elementDB, elementGeometryDB, statisticsDB, openChangesetsDB,
				changesetsDao, downloadedTilesDao, prefs, questUnlocker);
	}
}
