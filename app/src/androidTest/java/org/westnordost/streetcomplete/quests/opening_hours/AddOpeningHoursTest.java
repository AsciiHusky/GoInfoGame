package org.westnordost.streetcomplete.quests.opening_hours;

import org.westnordost.streetcomplete.data.osm.OsmElementQuestType;
import org.westnordost.streetcomplete.data.osm.changes.StringMapEntryAdd;
import org.westnordost.streetcomplete.quests.AOsmElementQuestTypeTest;

public class AddOpeningHoursTest extends AOsmElementQuestTypeTest
{
	@Override protected OsmElementQuestType createQuestType()
	{
		return new AddOpeningHours(null);
	}

	public void testOpeningHours()
	{
		bundle.putString(AddOpeningHoursForm.OPENING_HOURS, "my cool opening hours");
		verify(new StringMapEntryAdd("opening_hours", "my cool opening hours"));
	}
}
