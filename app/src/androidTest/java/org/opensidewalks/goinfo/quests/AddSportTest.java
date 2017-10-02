package org.opensidewalks.goinfo.quests;

import org.opensidewalks.goinfo.data.osm.OsmElementQuestType;
import org.opensidewalks.goinfo.data.osm.changes.StringMapEntryAdd;
import org.opensidewalks.goinfo.data.osm.changes.StringMapEntryModify;
import org.opensidewalks.goinfo.quests.sport.AddSport;
import org.opensidewalks.goinfo.quests.sport.AddSportForm;

import java.util.ArrayList;

public class AddSportTest extends AOsmElementQuestTypeTest
{
	@Override public void setUp()
	{
		super.setUp();
		tags.put("leisure","pitch");
	}

	public void testReplaceHockey()
	{
		tags.put("sport","hockey");
		bundle.putStringArrayList(AddSportForm.OSM_VALUES, getAsStringArray("field_hockey"));
		verify(new StringMapEntryModify("sport","hockey","field_hockey"));
	}

	public void testReplaceTeamHandball()
	{
		tags.put("sport","team_handball");
		bundle.putStringArrayList(AddSportForm.OSM_VALUES, getAsStringArray("handball"));
		verify(new StringMapEntryModify("sport","team_handball","handball"));
	}

	public void testAddSport()
	{
		bundle.putStringArrayList(AddSportForm.OSM_VALUES, getAsStringArray("soccer"));
		verify(new StringMapEntryAdd("sport","soccer"));
	}

	private ArrayList<String> getAsStringArray(String value)
	{
		ArrayList<String> values = new ArrayList<>();
		values.add(value);
		return values;
	}

	@Override protected OsmElementQuestType createQuestType()
	{
		return new AddSport(null);
	}
}
