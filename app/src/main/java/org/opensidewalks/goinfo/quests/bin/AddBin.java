package org.opensidewalks.goinfo.quests.bin;

import android.os.Bundle;

import org.opensidewalks.goinfo.data.osm.download.OverpassMapDataDao;
import org.opensidewalks.goinfo.quests.AbstractQuestAnswerFragment;

import java.util.Map;

import javax.inject.Inject;

import de.westnordost.streetcomplete.R;
import org.opensidewalks.goinfo.data.osm.SimpleOverpassQuestType;
import org.opensidewalks.goinfo.data.osm.changes.StringMapChangesBuilder;
import org.opensidewalks.goinfo.quests.YesNoQuestAnswerFragment;

public class AddBin extends SimpleOverpassQuestType
{
    @Inject public AddBin(OverpassMapDataDao overpassServer) { super(overpassServer); }

    @Override protected String getTagFilters()
    {
        return "nodes with (public_transport=platform or (highway=bus_stop and public_transport!=stop_position)) and !bin";
    }

    public AbstractQuestAnswerFragment createForm()
    {
        return new YesNoQuestAnswerFragment();
    }

    public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
    {
        String yesno = answer.getBoolean(YesNoQuestAnswerFragment.ANSWER) ? "yes" : "no";
        changes.add("bin", yesno);
    }

    @Override public String getCommitMessage() { return "Add bus stop bin"; }
    @Override public int getIcon() { return R.drawable.ic_quest_bus; }
    @Override public int getTitle(Map<String, String> tags)
    {
        boolean hasName = tags.containsKey("name");
        if(hasName) return R.string.quest_bin_name_title;
        else        return R.string.quest_bin_title;
    }
}
