package org.westnordost.streetcomplete.quests.toilets_fee;

import android.os.Bundle;

import org.westnordost.streetcomplete.data.osm.SimpleOverpassQuestType;
import org.westnordost.streetcomplete.data.osm.changes.StringMapChangesBuilder;
import org.westnordost.streetcomplete.data.osm.download.OverpassMapDataDao;
import org.westnordost.streetcomplete.quests.AbstractQuestAnswerFragment;
import org.westnordost.streetcomplete.quests.YesNoQuestAnswerFragment;

import java.util.Map;

import javax.inject.Inject;

import de.westnordost.streetcomplete.R;

public class AddToiletsFee extends SimpleOverpassQuestType
{
	@Inject public AddToiletsFee(OverpassMapDataDao overpassServer) { super(overpassServer); }

	@Override protected String getTagFilters()
	{
		return "nodes, ways with amenity = toilets and access !~ private|customers and !fee";
	}

	public AbstractQuestAnswerFragment createForm() { return new YesNoQuestAnswerFragment(); }

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		String yesno = answer.getBoolean(YesNoQuestAnswerFragment.ANSWER) ? "yes" : "no";
		changes.add("fee", yesno);
	}

	@Override public String getCommitMessage() { return "Add toilets fee"; }
	@Override public int getIcon() { return R.drawable.ic_quest_toilets; }
	@Override public int getTitle(Map<String, String> tags)
	{
		return R.string.quest_toiletsFee_title;
	}
}
