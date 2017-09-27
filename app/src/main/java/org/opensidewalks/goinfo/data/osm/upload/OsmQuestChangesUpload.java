package org.opensidewalks.goinfo.data.osm.upload;

import android.content.SharedPreferences;

import org.opensidewalks.goinfo.data.changesets.OpenChangesetsDao;
import org.opensidewalks.goinfo.data.osm.OsmQuestUnlocker;
import org.opensidewalks.goinfo.data.osm.persist.ElementGeometryDao;
import org.opensidewalks.goinfo.data.osm.persist.MergedElementDao;
import org.opensidewalks.goinfo.data.osm.persist.OsmQuestDao;
import org.opensidewalks.goinfo.data.statistics.QuestStatisticsDao;
import org.opensidewalks.goinfo.data.tiles.DownloadedTilesDao;

import javax.inject.Inject;

import de.westnordost.osmapi.changesets.ChangesetsDao;
import de.westnordost.osmapi.map.MapDataDao;

public class OsmQuestChangesUpload extends AOsmQuestChangesUpload
{
	@Inject public OsmQuestChangesUpload(
            MapDataDao osmDao, OsmQuestDao questDB, MergedElementDao elementDB,
            ElementGeometryDao elementGeometryDB, QuestStatisticsDao statisticsDB,
            OpenChangesetsDao openChangesetsDB, ChangesetsDao changesetsDao,
            DownloadedTilesDao downloadedTilesDao, SharedPreferences prefs,
            OsmQuestUnlocker questUnlocker)
	{
		super(osmDao, questDB, elementDB, elementGeometryDB, statisticsDB, openChangesetsDB,
				changesetsDao, downloadedTilesDao, prefs, questUnlocker);
	}
}
