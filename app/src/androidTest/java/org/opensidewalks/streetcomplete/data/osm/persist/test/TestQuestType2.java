package org.opensidewalks.streetcomplete.data.osm.persist.test;

import android.os.Bundle;

import java.util.Map;

import de.westnordost.osmapi.map.data.BoundingBox;
import de.westnordost.osmapi.map.data.Element;
import org.opensidewalks.streetcomplete.data.osm.changes.StringMapChangesBuilder;
import org.opensidewalks.streetcomplete.data.osm.download.MapDataWithGeometryHandler;
import org.opensidewalks.streetcomplete.quests.AbstractQuestAnswerFragment;
import org.opensidewalks.streetcomplete.data.osm.OsmElementQuestType;

public class TestQuestType2 implements OsmElementQuestType
{
	@Override public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes) { }
	@Override public String getCommitMessage() { return null; }
	@Override public boolean download(BoundingBox bbox, MapDataWithGeometryHandler handler)
	{
		return false;
	}
	@Override public AbstractQuestAnswerFragment createForm()
	{
		return null;
	}
	@Override public int getIcon() { return 0; }
	@Override public int getTitle() { return 0; }
	@Override public int getTitle(Map<String,String> tags) { return 0; }
	@Override public boolean appliesTo(Element element) { return false; }
}