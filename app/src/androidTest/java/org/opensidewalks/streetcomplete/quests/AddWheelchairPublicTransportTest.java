package org.opensidewalks.streetcomplete.quests;

import org.opensidewalks.streetcomplete.data.osm.OsmElementQuestType;
import org.opensidewalks.streetcomplete.data.osm.changes.StringMapEntryAdd;
import org.opensidewalks.streetcomplete.quests.wheelchair_access.AddWheelChairAccessPublicTransport;
import org.opensidewalks.streetcomplete.quests.wheelchair_access.AddWheelchairAccessPublicTransportForm;

public class AddWheelchairPublicTransportTest extends AOsmElementQuestTypeTest
{
	@Override public void setUp()
	{
		super.setUp();
		tags.put("highway","bus_stop");
	}

	public void testPublicTransportYes()
	{
		bundle.putString(AddWheelchairAccessPublicTransportForm.ANSWER, "yes");
		verify(new StringMapEntryAdd("wheelchair","yes"));
	}

	public void testPublicTransportNo()
	{
		bundle.putString(AddWheelchairAccessPublicTransportForm.ANSWER, "no");
		verify(new StringMapEntryAdd("wheelchair","no"));
	}

	public void testPublicTransportLimited()
	{
		bundle.putString(AddWheelchairAccessPublicTransportForm.ANSWER, "limited");
		verify(new StringMapEntryAdd("wheelchair","limited"));
	}

	@Override protected OsmElementQuestType createQuestType()
	{
		return new AddWheelChairAccessPublicTransport(null);
	}
}
