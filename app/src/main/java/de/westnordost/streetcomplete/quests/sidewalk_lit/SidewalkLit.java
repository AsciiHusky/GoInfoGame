package de.westnordost.streetcomplete.quests.sidewalk_lit;
import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import javax.inject.Inject;

import de.westnordost.streetcomplete.R;
import de.westnordost.streetcomplete.data.osm.SimpleOverpassQuestType;
import de.westnordost.streetcomplete.data.osm.changes.StringMapChangesBuilder;
import de.westnordost.streetcomplete.data.osm.download.OverpassMapDataDao;
import de.westnordost.streetcomplete.quests.AbstractQuestAnswerFragment;
//import de.westnordost.streetcomplete.quests.RangeQuestAnswerFragment;
//import de.westnordost.streetcomplete.quests.TwoLevelQuestAnswerFragment;
import de.westnordost.streetcomplete.quests.YesNoQuestAnswerFragment;

public class SidewalkLit extends SimpleOverpassQuestType
{
    @Inject public SidewalkLit(OverpassMapDataDao overpassServer) { super(overpassServer); }

    @Override protected String getTagFilters()
    {
       return "ways with (" +
                "((highway=footway) and (footway=sidewalk)" +
                " or foot=yes" +
                ") and !lit)";
    }


    public AbstractQuestAnswerFragment createForm()
    {
        return new YesNoQuestAnswerFragment();
    }

    public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
    {
        String yesno = answer.getBoolean(SidewalkLitForm.ANSWER) ? "yes" : "no";
        changes.add("lit", yesno);
    }

    @Override public String getCommitMessage() { return "Add sidewalk lit"; }
    @Override public int getIcon() { return R.drawable.ic_quest_lantern; }
    @Override public int getTitle(Map<String, String> tags)
    {
        boolean hasName = tags.containsKey("name");
        if(hasName) return R.string.quest_SidewalkLit_title;
        else        return R.string.quest_SidewalkLit_title;
    }
}
