package org.opensidewalks.goinfo.quests.passenger_information_display;

import android.os.Bundle;

import org.opensidewalks.goinfo.data.osm.download.OverpassMapDataDao;

import java.util.Map;

import javax.inject.Inject;

import de.westnordost.goinfo.R;
import org.opensidewalks.goinfo.data.osm.SimpleOverpassQuestType;
import org.opensidewalks.goinfo.data.osm.changes.StringMapChangesBuilder;
import org.opensidewalks.goinfo.quests.AbstractQuestAnswerFragment;
import org.opensidewalks.goinfo.quests.YesNoQuestAnswerFragment;

public class AddPassengerInformationDisplay extends SimpleOverpassQuestType {
    @Inject
    public AddPassengerInformationDisplay(OverpassMapDataDao overpassServer) { super(overpassServer); }

    @Override protected String getTagFilters()
    {
        return "nodes with (public_transport=platform or (highway=bus_stop and public_transport!=stop_position)) and !passenger_information_display";
    }

    public AbstractQuestAnswerFragment createForm()
    {
        return new YesNoQuestAnswerFragment();
    }

    public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
    {
        String yesno = answer.getBoolean(YesNoQuestAnswerFragment.ANSWER) ? "yes" : "no";
        changes.add("passenger_information_display", yesno);
    }

    @Override public String getCommitMessage() { return "Add bus stop information display"; }
    @Override public int getIcon() { return R.drawable.ic_quest_bus; }
    @Override public int getTitle(Map<String, String> tags)
    {
        boolean hasName = tags.containsKey("name");
        if(hasName) return R.string.quest_passengerInformation_name_title;
        else        return R.string.quest_passengerInformationDisplay_title;
    }
}

