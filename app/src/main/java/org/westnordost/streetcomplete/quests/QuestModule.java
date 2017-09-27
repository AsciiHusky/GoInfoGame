package org.westnordost.streetcomplete.quests;

import org.westnordost.streetcomplete.data.QuestType;
import org.westnordost.streetcomplete.data.osm.download.OverpassMapDataDao;
import org.westnordost.streetcomplete.data.osmnotes.OsmNoteQuestType;
import org.westnordost.streetcomplete.quests.bin.AddBin;
import org.westnordost.streetcomplete.quests.bus_stop_bench.AddBusStopBench;
import org.westnordost.streetcomplete.quests.passenger_information_display.AddPassengerInformationDisplay;
import org.westnordost.streetcomplete.quests.road_name.data.PutRoadNameSuggestionsHandler;
import org.westnordost.streetcomplete.quests.tactile_paving.AddTactilePavingBusStop;

import java.util.Arrays;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import org.westnordost.streetcomplete.data.QuestTypes;
import org.westnordost.streetcomplete.quests.bus_stop_lit.AddBusStopLit;

import org.westnordost.streetcomplete.quests.bus_stop_shelter.AddBusStopShelter;
import org.westnordost.streetcomplete.quests.road_name.data.RoadNameSuggestionsDao;

@Module
public class QuestModule
{
	@Provides @Singleton public static QuestTypes questTypeList(
            OsmNoteQuestType osmNoteQuestType, OverpassMapDataDao o,
            RoadNameSuggestionsDao roadNameSuggestionsDao,
            PutRoadNameSuggestionsHandler putRoadNameSuggestionsHandler)
	{
		QuestType[] questTypesOrderedByImportance = {
				// ↓ notes
				osmNoteQuestType,

				new AddBusStopBench(o),
				new AddBusStopShelter(o),
				new AddBusStopLit(o),
				new AddBin(o),
				new AddPassengerInformationDisplay(o),
				new AddTactilePavingBusStop(o)
		};

		return new QuestTypes(Arrays.asList(questTypesOrderedByImportance));
	}

	@Provides @Singleton public static OsmNoteQuestType osmNoteQuestType()
	{
		return new OsmNoteQuestType();
	}
}
