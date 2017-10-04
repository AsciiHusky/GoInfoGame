package org.opensidewalks.goinfo.quests.toilets_fee;

import android.os.Bundle;

import org.opensidewalks.goinfo.data.osm.SimpleOverpassQuestType;
import org.opensidewalks.goinfo.data.osm.changes.StringMapChangesBuilder;
import org.opensidewalks.goinfo.data.osm.download.OverpassMapDataDao;
import org.opensidewalks.goinfo.quests.AbstractQuestAnswerFragment;
import org.opensidewalks.goinfo.quests.YesNoQuestAnswerFragment;

import java.util.Map;

import javax.inject.Inject;

import org.opensidewalks.goinfo.R;

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
