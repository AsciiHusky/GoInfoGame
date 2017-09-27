package org.opensidewalks.streetcomplete.data.osm.upload;

import android.content.SharedPreferences;

import org.opensidewalks.streetcomplete.data.changesets.OpenChangesetsDao;
import org.opensidewalks.streetcomplete.data.osm.OsmQuestUnlocker;
import org.opensidewalks.streetcomplete.data.osm.persist.ElementGeometryDao;
import org.opensidewalks.streetcomplete.data.osm.persist.MergedElementDao;
import org.opensidewalks.streetcomplete.data.osm.persist.OsmQuestDao;
import org.opensidewalks.streetcomplete.data.statistics.QuestStatisticsDao;
import org.opensidewalks.streetcomplete.data.tiles.DownloadedTilesDao;

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
