package org.opensidewalks.goinfo.data.osm;

import junit.framework.TestCase;

import java.util.List;

import org.opensidewalks.goinfo.data.QuestType;
import org.opensidewalks.goinfo.data.osmnotes.OsmNoteQuestType;
import org.opensidewalks.goinfo.quests.QuestModule;

public class SimpleOverpassQuestsValidityTest extends TestCase
{
	public void testQueryValid()
	{
		List<QuestType> questTypes = QuestModule.questTypeList(new OsmNoteQuestType(),
				null,null,null).getQuestTypesSortedByImportance();
		for(QuestType questType : questTypes)
		{
			if(questType instanceof SimpleOverpassQuestType)
			{
				// if this fails and the returned exception is not informative, catch here and record
				// the name of the SimpleOverpassQuestType
				((SimpleOverpassQuestType) questType).getOverpassQuery(null);
			}
		}
		// parsing the query threw no errors -> valid
		assertTrue(true);
	}
}
