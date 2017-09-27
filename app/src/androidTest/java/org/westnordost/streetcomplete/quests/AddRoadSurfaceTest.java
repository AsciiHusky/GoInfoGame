package org.westnordost.streetcomplete.quests;

import org.westnordost.streetcomplete.data.osm.OsmElementQuestType;
import org.westnordost.streetcomplete.data.osm.changes.StringMapEntryAdd;
import org.westnordost.streetcomplete.quests.road_surface.AddRoadSurface;
import org.westnordost.streetcomplete.quests.road_surface.AddRoadSurfaceForm;

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
