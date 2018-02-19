package de.westnordost.streetcomplete.quests;

import java.util.Arrays;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.westnordost.streetcomplete.data.QuestType;
import de.westnordost.streetcomplete.data.QuestTypes;
import de.westnordost.streetcomplete.data.osm.download.OverpassMapDataDao;
import de.westnordost.streetcomplete.data.osmnotes.OsmNoteQuestType;
import de.westnordost.streetcomplete.quests.bus_stop_lit.AddBusStopLit;

import de.westnordost.streetcomplete.quests.bus_stop_bench.AddBusStopBench;
import de.westnordost.streetcomplete.quests.bus_stop_shelter.AddBusStopShelter;
import de.westnordost.streetcomplete.quests.crossing_type.AddCrossingType;
import de.westnordost.streetcomplete.quests.curb_ramps_tactile_pavings.CheckCurbRamps_TactilePavings;
import de.westnordost.streetcomplete.quests.road_name.data.PutRoadNameSuggestionsHandler;
import de.westnordost.streetcomplete.quests.road_name.data.RoadNameSuggestionsDao;
import de.westnordost.streetcomplete.quests.sidewalk_lit.SidewalkLit;
import de.westnordost.streetcomplete.quests.sidewalk_surface.AddFootwaySurface;
import de.westnordost.streetcomplete.quests.bin.AddBin;

@Module
public class QuestModule
{
	@Provides @Singleton public static QuestTypes questTypeList(
			OsmNoteQuestType osmNoteQuestType, OverpassMapDataDao o,
			RoadNameSuggestionsDao roadNameSuggestionsDao,
			PutRoadNameSuggestionsHandler putRoadNameSuggestionsHandler)
	{
		QuestType[] questTypesOrderedByImportance = new QuestType[]{
				// ↓ notes
				osmNoteQuestType,
				new SidewalkLit(o),
				new AddFootwaySurface(o),
				new CheckCurbRamps_TactilePavings(o),
				new AddBusStopBench(o),
				new AddBusStopShelter(o),
				new AddBusStopLit(o),
				new AddBin(o)
		};
		return new QuestTypes(Arrays.asList(questTypesOrderedByImportance));
	}

	@Provides @Singleton public static OsmNoteQuestType osmNoteQuestType()
	{
		return new OsmNoteQuestType();
	}
}
