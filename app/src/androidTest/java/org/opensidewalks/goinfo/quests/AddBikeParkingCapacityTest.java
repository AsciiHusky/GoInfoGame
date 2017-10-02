package org.opensidewalks.goinfo.quests;

import org.opensidewalks.goinfo.data.osm.OsmElementQuestType;
import org.opensidewalks.goinfo.data.osm.changes.StringMapEntryAdd;
import org.opensidewalks.goinfo.quests.bike_parking_capacity.AddBikeParkingCapacity;
import org.opensidewalks.goinfo.quests.bike_parking_capacity.AddBikeParkingCapacityForm;

public class AddBikeParkingCapacityTest extends AOsmElementQuestTypeTest
{
	@Override public void setUp()
	{
		super.setUp();
		tags.put("amenity","bicycle_parking");
	}

	public void testCapacity()
	{
		bundle.putInt(AddBikeParkingCapacityForm.BIKE_PARKING_CAPACITY, 10);
		verify(
				new StringMapEntryAdd("capacity","10"));
	}

	@Override protected OsmElementQuestType createQuestType()
	{
		return new AddBikeParkingCapacity(null);
	}
}
