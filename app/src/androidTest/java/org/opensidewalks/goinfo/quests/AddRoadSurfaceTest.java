package org.opensidewalks.goinfo.quests;

import org.opensidewalks.goinfo.data.osm.OsmElementQuestType;
import org.opensidewalks.goinfo.data.osm.changes.StringMapEntryAdd;
import org.opensidewalks.goinfo.quests.road_surface.AddRoadSurface;
import org.opensidewalks.goinfo.quests.road_surface.AddRoadSurfaceForm;

public class AddRoadSurfaceTest extends AOsmElementQuestTypeTest
{
	@Override public void setUp()
	{
		super.setUp();
		tags.put("highway","residential");
	}

	public void testSurface()
	{
		bundle.putString(AddRoadSurfaceForm.SURFACE, "cobblestone");
		verify(new StringMapEntryAdd("surface","cobblestone"));
	}

	@Override protected OsmElementQuestType createQuestType()
	{
		return new AddRoadSurface(null);
	}
}
