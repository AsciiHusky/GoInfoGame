package org.opensidewalks.streetcomplete.quests.building_levels;

import android.os.Bundle;

import org.opensidewalks.streetcomplete.data.osm.changes.StringMapChangesBuilder;
import org.opensidewalks.streetcomplete.data.osm.download.OverpassMapDataDao;
import org.opensidewalks.streetcomplete.quests.AbstractQuestAnswerFragment;

import java.util.Map;

import javax.inject.Inject;

import de.westnordost.streetcomplete.R;
import org.opensidewalks.streetcomplete.data.osm.SimpleOverpassQuestType;

public class AddBuildingLevels extends SimpleOverpassQuestType
{
	@Inject public AddBuildingLevels(OverpassMapDataDao overpassServer) { super(overpassServer); }

	@Override
	protected String getTagFilters()
	{
		return " ways, relations with " +
		       " building ~ house|residential|apartments|detached|terrace|farm|hotel|dormitory|houseboat|" +
							"school|civic|college|university|public|hospital|kindergarten|transportation|train_station|"+
							"retail|commercial|warehouse|industrial|manufacture" +
		       " and !building:levels and !height and !building:height";
		// building:height is undocumented, but used the same way as height and currently over 50k times
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new AddBuildingLevelsForm();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		changes.add("building:levels", ""+answer.getInt(AddBuildingLevelsForm.BUILDING_LEVELS));

		// only set the roof levels if the user supplied that in the form
		int roofLevels = answer.getInt(AddBuildingLevelsForm.ROOF_LEVELS,-1);
		if(roofLevels != -1)
		{
			changes.addOrModify("roof:levels", "" + roofLevels);
		}
	}

	@Override public String getCommitMessage() { return "Add building and roof levels"; }
	@Override public int getIcon() { return R.drawable.ic_quest_building_levels; }
	@Override public int getTitle(Map<String,String> tags)
	{
		boolean isBuildingPart = tags.containsKey("building:part");
		if(isBuildingPart) return R.string.quest_buildingLevels_title_buildingPart;
		else               return R.string.quest_buildingLevels_title;
	}
}
