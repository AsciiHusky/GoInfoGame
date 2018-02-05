package de.westnordost.streetcomplete.quests.sidewalk_surface;

import android.os.Bundle;
import android.text.TextUtils;

import java.util.Map;

import javax.inject.Inject;

import de.westnordost.streetcomplete.R;
import de.westnordost.streetcomplete.data.osm.SimpleOverpassQuestType;
import de.westnordost.streetcomplete.data.osm.changes.StringMapChangesBuilder;
import de.westnordost.streetcomplete.data.osm.download.OverpassMapDataDao;
import de.westnordost.streetcomplete.quests.AbstractQuestAnswerFragment;
import de.westnordost.streetcomplete.quests.road_surface.AddRoadSurfaceForm;

/**
 * Created by Neelam Purswani on 12-01-2018.
 */

public class AddSideWalkSurface extends SimpleOverpassQuestType
{
    // well, all roads have surfaces, what I mean is that not all ways with highway key are
    // "something with a surface"
  /*  private static final String[] ROADS_WITH_SURFACES = {
            // "trunk","trunk_link","motorway","motorway_link", // too much, motorways are almost by definition asphalt (or concrete)
            "primary", "primary_link",
            "secondary", "secondary_link", "tertiary", "tertiary_link",
            "unclassified", "residential", "living_street", "pedestrian",
            "track", "road",
			*//*"service", *//* // this is too much, and the information value is very low
    };*/

    @Inject
    public AddSideWalkSurface(OverpassMapDataDao overpassServer) { super(overpassServer); }

    @Override protected String getTagFilters()
    {
        return "nodes, ways with (" +
                "((highway=footway) and (footway=sidewalk)" +
                " or way=foot and foot=sidewalk" +
                ") and !surface)";
    }

    public AbstractQuestAnswerFragment createForm()
    {
        return new AddSideWalkSurfaceForm();
    }

    public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
    {
        changes.add("surface", answer.getString(AddSideWalkSurfaceForm.SURFACE));
    }

    @Override public String getCommitMessage() { return "Add sidewalk surfaces"; }
    @Override public int getIcon() { return R.drawable.ic_quest_street_surface; }
    @Override public int getTitle(Map<String, String> tags)
    {
        boolean hasName = tags.containsKey("name");
        if(hasName) return R.string.quest_sideWalk_name_title;
        else        return R.string.quest_sideWalk_title;
    }
}

