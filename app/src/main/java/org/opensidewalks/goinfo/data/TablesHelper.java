package org.opensidewalks.goinfo.data;

import android.database.sqlite.SQLiteDatabase;

public interface TablesHelper
{
	void onCreate(SQLiteDatabase db);
	void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
}
