package org.opensidewalks.goinfo.data;

import android.database.sqlite.SQLiteOpenHelper;

import org.opensidewalks.goinfo.util.KryoSerializer;
import org.opensidewalks.goinfo.util.Serializer;

public class ApplicationDbTestCase extends AndroidDbTestCase
{
	protected SQLiteOpenHelper dbHelper;
	protected Serializer serializer;

	public ApplicationDbTestCase()
	{
		super(StreetCompleteOpenHelper.DB_NAME);
	}

	@Override public void setUp()
	{
		super.setUp();
		serializer = new KryoSerializer();
		dbHelper = DbModule.sqliteOpenHelper(getContext());
	}

	@Override public void tearDown()
	{
		// first close, then call super (= delete database) to avoid warning
		dbHelper.close();
		super.tearDown();
	}
}
