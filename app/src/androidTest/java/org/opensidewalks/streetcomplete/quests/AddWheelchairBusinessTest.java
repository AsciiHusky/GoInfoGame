package org.opensidewalks.streetcomplete.quests;

import org.opensidewalks.streetcomplete.data.osm.OsmElementQuestType;
import org.opensidewalks.streetcomplete.data.osm.changes.StringMapEntryAdd;
import org.opensidewalks.streetcomplete.quests.wheelchair_access.AddWheelchairAccessBusiness;
import org.opensidewalks.streetcomplete.quests.wheelchair_access.AddWheelchairAccessBusinessForm;

public class AddWheelchairBusinessTest extends AOsmElementQuestTypeTest
{
	@Override public void setUp()
	{
		super.setUp();
		tags.put("shop","yes");
	}

	public void testBusinessYes()
	{
		bundle.putString(AddWheelchairAccessBusinessForm.ANSWER, "yes");
		verify(new StringMapEntryAdd("wheelchair","yes"));
	}

	public void testBusinessNo()
	{
		bundle.putString(AddWheelchairAccessBusinessForm.ANSWER, "no");
		verify(new StringMapEntryAdd("wheelchair","no"));
	}

	public void testBusinessLimited()
	{
		bundle.putString(AddWheelchairAccessBusinessForm.ANSWER, "limited");
		verify(new StringMapEntryAdd("wheelchair","limited"));
	}

	@Override protected OsmElementQuestType createQuestType()
	{
		return new AddWheelchairAccessBusiness(null);
	}
}