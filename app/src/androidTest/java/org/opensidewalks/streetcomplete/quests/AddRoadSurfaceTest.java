package org.opensidewalks.streetcomplete.quests;

import org.opensidewalks.streetcomplete.data.osm.OsmElementQuestType;
import org.opensidewalks.streetcomplete.data.osm.changes.StringMapEntryAdd;
import org.opensidewalks.streetcomplete.quests.road_surface.AddRoadSurface;
import org.opensidewalks.streetcomplete.quests.road_surface.AddRoadSurfaceForm;

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
