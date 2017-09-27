package org.opensidewalks.goinfo.data;

import java.util.Date;

import org.opensidewalks.goinfo.data.osm.ElementGeometry;
import de.westnordost.osmapi.map.data.LatLon;

/** Represents one task for the user to complete/correct */
public interface Quest
{
	Long getId();
	void setId(long id);

	LatLon getMarkerLocation();
	ElementGeometry getGeometry();

	QuestType getType();

	QuestStatus getStatus();
	void setStatus(QuestStatus status);

	Date getLastUpdate();
}
