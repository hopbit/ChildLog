package com.example.childlog.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ChildLogDbHelper extends SQLiteOpenHelper {

	public static final String TABLE_EVENTS = "events";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_EVENT_TIME = "event_time";
	public static final String COLUMN_EVENT_TYPE = "event_type";
	

	private static final String DATABASE_NAME = "childlog.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_EVENTS + "( " + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_EVENT_TIME
			+ " integer not null, " + COLUMN_EVENT_TYPE
			+ " string not null );";

	public ChildLogDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(ChildLogDbHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_EVENTS);
		onCreate(db);
	}

}
