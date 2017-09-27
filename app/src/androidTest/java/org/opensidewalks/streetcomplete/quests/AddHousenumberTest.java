package org.opensidewalks.streetcomplete.quests;

import org.opensidewalks.streetcomplete.data.osm.OsmElementQuestType;
import org.opensidewalks.streetcomplete.data.osm.changes.StringMapEntryAdd;
import org.opensidewalks.streetcomplete.quests.housenumber.AddHousenumber;
import org.opensidewalks.streetcomplete.quests.housenumber.AddHousenumberForm;

public class AddHousenumberTest extends AOsmElementQuestTypeTest
{
	@Override public void setUp()
	{
		super.setUp();
		tags.put("building","house");
	}

	public void testRegex()
	{
		String r = AddHousenumberForm.VALID_HOUSENUMBER_REGEX;
		assertTrue("1".matches(r));
		assertTrue("1234".matches(r));

		assertTrue("1234a".matches(r));
		assertTrue("1234/a".matches(r));
		assertTrue("1234 / a".matches(r));
		assertTrue("1234 / A".matches(r));
		assertTrue("1234A".matches(r));
		assertTrue("1234/9".matches(r));
		assertTrue("1234 / 9".matches(r));

		assertFalse("12345".matches(r));
		assertFalse("1234 5".matches(r));
		assertFalse("1234/55".matches(r));
		assertFalse("1234AB".matches(r));
	}

	public void testNumber()
	{
		bundle.putString(AddHousenumberForm.HOUSENUMBER, "99b");
		verify(new StringMapEntryAdd("addr:housenumber","99b"));
	}

	public void testName()
	{
		bundle.putString(AddHousenumberForm.HOUSENAME, "La Escalera");
		verify(new StringMapEntryAdd("addr:housename","La Escalera"));
	}

	@Override protected OsmElementQuestType createQuestType()
	{
		return new AddHousenumber(null);
	}
}
