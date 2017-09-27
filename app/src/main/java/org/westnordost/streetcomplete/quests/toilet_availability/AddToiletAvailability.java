package org.westnordost.streetcomplete.quests.toilet_availability;

import android.os.Bundle;
import android.support.annotation.NonNull;

import org.westnordost.streetcomplete.data.osm.changes.StringMapChangesBuilder;
import org.westnordost.streetcomplete.data.osm.download.OverpassMapDataDao;
import org.westnordost.streetcomplete.quests.AbstractQuestAnswerFragment;

import java.util.Map;

import javax.inject.Inject;

import de.westnordost.streetcomplete.R;
import org.westnordost.streetcomplete.data.osm.SimpleOverpassQuestType;
import org.westnordost.streetcomplete.quests.YesNoQuestAnswerFragment;

public class AddToiletAvailability extends SimpleOverpassQuestType
{
	@Inject public AddToiletAvailability(OverpassMapDataDao overpassServer) { super(overpassServer); }

	@Override protected String getTagFilters()
	{
		return "nodes, ways with shop ~ mall|department_store and name and !toilets";
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new YesNoQuestAnswerFragment();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		String yesno = answer.getBoolean(YesNoQuestAnswerFragment.ANSWER) ? "yes" : "no";
		changes.add("toilets", yesno);
	}

	@Override public String getCommitMessage() { return "Add toilet availability"; }
	@Override public int getIcon() { return R.drawable.ic_quest_toilets; }
	@Override public int getTitle(@NonNull Map<String, String> tags)
	{
		return R.string.quest_toiletAvailability_name_title;
	}
}
