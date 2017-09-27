package org.opensidewalks.goinfo.quests;

import org.opensidewalks.goinfo.data.osm.OsmElementQuestType;
import org.opensidewalks.goinfo.data.osm.changes.StringMapEntryAdd;
import org.opensidewalks.goinfo.quests.place_name.AddPlaceName;
import org.opensidewalks.goinfo.quests.place_name.AddPlaceNameForm;

public class AddPlaceNameTest extends AOsmElementQuestTypeTest
{
	@Override public void setUp()
	{
		super.setUp();
		tags.put("shop","kiosk");
	}

	public void testNoName()
	{
		bundle.putBoolean(AddPlaceNameForm.NO_NAME, true);
		verify(
				new StringMapEntryAdd("noname","yes"));
	}

	public void testName()
	{
		bundle.putString(AddPlaceNameForm.NAME, "my name");
		verify(
				new StringMapEntryAdd("name","my name"));
	}

	@Override protected OsmElementQuestType createQuestType()
	{
		return new AddPlaceName(null);
	}
}
