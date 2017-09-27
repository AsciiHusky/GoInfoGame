package org.opensidewalks.goinfo.quests;

import org.opensidewalks.goinfo.data.QuestType;
import org.opensidewalks.goinfo.data.osm.download.OverpassMapDataDao;
import org.opensidewalks.goinfo.data.osmnotes.OsmNoteQuestType;
import org.opensidewalks.goinfo.quests.bin.AddBin;
import org.opensidewalks.goinfo.quests.bus_stop_bench.AddBusStopBench;
import org.opensidewalks.goinfo.quests.passenger_information_display.AddPassengerInformationDisplay;
import org.opensidewalks.goinfo.quests.road_name.data.PutRoadNameSuggestionsHandler;
import org.opensidewalks.goinfo.quests.tactile_paving.AddTactilePavingBusStop;

import java.util.Arrays;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import org.opensidewalks.goinfo.data.QuestTypes;
import org.opensidewalks.goinfo.quests.bus_stop_lit.AddBusStopLit;

import org.opensidewalks.goinfo.quests.bus_stop_shelter.AddBusStopShelter;
import org.opensidewalks.goinfo.quests.road_name.data.RoadNameSuggestionsDao;

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
