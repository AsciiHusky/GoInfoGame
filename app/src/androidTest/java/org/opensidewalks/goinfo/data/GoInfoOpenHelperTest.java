package org.opensidewalks.goinfo.data;

import android.database.sqlite.SQLiteOpenHelper;

public class GoInfoOpenHelperTest extends AndroidDbTestCase
{
	private SQLiteOpenHelper helper;

	public GoInfoOpenHelperTest()
	{
		super(GoInfoOpenHelper.DB_NAME);
	}

	@Override public void setUp()
	{
		super.setUp();
		helper = DbModule.sqliteOpenHelper(getContext());
	}

	@Override public void tearDown()
	{
		// first close, then call super (= delete database) to avoid warning
		helper.close();
		super.tearDown();
	}

	public void testSetUp()
	{
		assertNotNull(helper.getReadableDatabase());
	}
}
