package org.opensidewalks.goinfo.quests.roof_shape;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import org.opensidewalks.goinfo.R;
import org.opensidewalks.goinfo.data.osm.SimpleOverpassQuestType;
import org.opensidewalks.goinfo.data.osm.changes.StringMapChangesBuilder;
import org.opensidewalks.goinfo.data.osm.download.OverpassMapDataDao;
import org.opensidewalks.goinfo.quests.AbstractQuestAnswerFragment;

public class AddRoofShape extends SimpleOverpassQuestType
{
	@Inject public AddRoofShape(OverpassMapDataDao overpassServer) { super(overpassServer); }

	@Override protected String getTagFilters()
	{
		return "ways, relations with roof:levels and roof:levels!=0 and !roof:shape";
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new AddRoofShapeForm();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		ArrayList<String> values = answer.getStringArrayList(AddRoofShapeForm.OSM_VALUES);
		if(values != null  && values.size() == 1)
		{
			changes.add("roof:shape", values.get(0));
		}
	}

	@Override public String getCommitMessage() { return "Add roof shapes"; }
	@Override public int getIcon() { return R.drawable.ic_quest_roof_shape; }
	@Override public int getTitle(Map<String, String> tags)
	{
		return R.string.quest_roofShape_title;
	}
}
