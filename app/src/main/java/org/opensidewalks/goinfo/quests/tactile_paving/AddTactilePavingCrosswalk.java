package org.opensidewalks.goinfo.quests.tactile_paving;

import android.os.Bundle;

import java.util.Map;

import javax.inject.Inject;

import org.opensidewalks.goinfo.R;
import org.opensidewalks.goinfo.data.osm.SimpleOverpassQuestType;
import org.opensidewalks.goinfo.data.osm.changes.StringMapChangesBuilder;
import org.opensidewalks.goinfo.data.osm.download.OverpassMapDataDao;
import org.opensidewalks.goinfo.quests.AbstractQuestAnswerFragment;
import org.opensidewalks.goinfo.quests.YesNoQuestAnswerFragment;

public class AddTactilePavingCrosswalk extends SimpleOverpassQuestType
{
	@Inject public AddTactilePavingCrosswalk(OverpassMapDataDao overpassServer)
	{
		super(overpassServer);
	}

	@Override protected String getTagFilters()
	{
		return "nodes with highway=crossing and !tactile_paving";
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new TactilePavingCrosswalkForm();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		String yesno = answer.getBoolean(YesNoQuestAnswerFragment.ANSWER) ? "yes" : "no";
		changes.add("tactile_paving", yesno);
	}

	@Override public String getCommitMessage() { return "Add tactile pavings on crosswalks"; }
	@Override public int getIcon() { return R.drawable.ic_quest_blind_pedestrian_crossing; }
	@Override public int getTitle(Map<String, String> tags)
	{
		return R.string.quest_tactilePaving_title_crosswalk;
	}
}
