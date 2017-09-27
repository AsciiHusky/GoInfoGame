package org.opensidewalks.goinfo.quests;

import android.os.Bundle;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.opensidewalks.goinfo.data.osm.OsmElementQuestType;
import org.opensidewalks.goinfo.data.osm.changes.StringMapChangesBuilder;
import org.opensidewalks.goinfo.data.osm.changes.StringMapEntryChange;

public abstract class AOsmElementQuestTypeTest extends TestCase
{
	protected Bundle bundle;
	protected Map<String,String> tags;

	public void setUp()
	{
		bundle = new Bundle();
		tags = new HashMap<>();
	}

	protected final void verify(StringMapEntryChange... expectedChanges)
	{
		StringMapChangesBuilder cb = new StringMapChangesBuilder(tags);
		createQuestType().applyAnswerTo(bundle, cb);
		List<StringMapEntryChange> changes = cb.create().getChanges();
		for(StringMapEntryChange expectedChange : expectedChanges)
		{
			assertTrue(changes.contains(expectedChange));
		}
	}

	protected abstract OsmElementQuestType createQuestType();
}
