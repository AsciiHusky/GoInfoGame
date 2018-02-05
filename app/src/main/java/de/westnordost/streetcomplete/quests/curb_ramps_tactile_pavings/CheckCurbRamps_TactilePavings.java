package de.westnordost.streetcomplete.quests.curb_ramps_tactile_pavings;

import android.os.Bundle;

import java.util.Map;

import javax.inject.Inject;

import de.westnordost.streetcomplete.R;
import de.westnordost.streetcomplete.data.osm.SimpleOverpassQuestType;
import de.westnordost.streetcomplete.data.osm.changes.StringMapChangesBuilder;
import de.westnordost.streetcomplete.data.osm.download.OverpassMapDataDao;
import de.westnordost.streetcomplete.quests.AbstractQuestAnswerFragment;
import de.westnordost.streetcomplete.quests.YesNoQuestAnswerFragment;

public class CheckCurbRamps_TactilePavings extends SimpleOverpassQuestType
{
	@Inject public CheckCurbRamps_TactilePavings(OverpassMapDataDao overpassServer) { super(overpassServer); }

	@Override protected String getTagFilters()
	{
		//return "nodes, ways with "(("footway"="crossing") "and" ("kerb"="lowered"))";

		return "nodes, ways with (" +
				"((footway=crossing) and (kerb=lowered))" +
				 "and (tactile_paving= No))";
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new YesNoQuestAnswerFragment();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		String yesno = answer.getBoolean(YesNoQuestAnswerFragment.ANSWER) ? "yes" : "no";
		changes.add("curb_ramps", yesno);
	}

	@Override public String getCommitMessage() { return "Add curb ramps"; }
	@Override public int getIcon() { return R.drawable.ic_quest_label; }
	@Override public int getTitle(Map<String, String> tags)
	{
		boolean hasName = tags.containsKey("name");
		if(hasName) return R.string.quest_curb_ramps;
		else        return R.string.quest_curb_ramps;
	}
}
