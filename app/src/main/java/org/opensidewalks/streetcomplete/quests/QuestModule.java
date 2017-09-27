package org.opensidewalks.streetcomplete.quests;

import org.opensidewalks.streetcomplete.data.QuestType;
import org.opensidewalks.streetcomplete.data.osm.download.OverpassMapDataDao;
import org.opensidewalks.streetcomplete.data.osmnotes.OsmNoteQuestType;
import org.opensidewalks.streetcomplete.quests.bin.AddBin;
import org.opensidewalks.streetcomplete.quests.bus_stop_bench.AddBusStopBench;
import org.opensidewalks.streetcomplete.quests.passenger_information_display.AddPassengerInformationDisplay;
import org.opensidewalks.streetcomplete.quests.road_name.data.PutRoadNameSuggestionsHandler;
import org.opensidewalks.streetcomplete.quests.tactile_paving.AddTactilePavingBusStop;

import java.util.Arrays;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import org.opensidewalks.streetcomplete.data.QuestTypes;
import org.opensidewalks.streetcomplete.quests.bus_stop_lit.AddBusStopLit;

import org.opensidewalks.streetcomplete.quests.bus_stop_shelter.AddBusStopShelter;
import org.opensidewalks.streetcomplete.quests.road_name.data.RoadNameSuggestionsDao;

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
