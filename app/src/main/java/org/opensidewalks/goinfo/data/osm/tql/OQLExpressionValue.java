package org.opensidewalks.goinfo.data.osm.tql;

public interface OQLExpressionValue extends BooleanExpressionValue
{
	String toOverpassQLString();
}
