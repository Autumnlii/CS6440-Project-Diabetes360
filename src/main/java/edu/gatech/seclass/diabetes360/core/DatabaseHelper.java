package edu.gatech.seclass.diabetes360.core;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAppDatabase.db";
//    private static DatabaseHelper instance;

    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME_BS = "blood_sugar";
    public static final String TABLE_NAME_EX = "exercise";

    public static final String COLUMN_ID = "_id";
    public static final String MONTH = "month";

    public static final String DAY = "day";

    public static final String VALUE = "value";

    // Create the database
    private static final String DATABASE_CREATE_BS = "create table IF NOT EXISTS "
            + TABLE_NAME_BS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + MONTH
            + " integer not null, "
            + DAY
            + " integer not null, "
            + VALUE
            + " integer not null);";

    private static final String DATABASE_CREATE_EX = "create table IF NOT EXISTS "
            + TABLE_NAME_EX + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + MONTH
            + " integer not null, "
            + DAY
            + " integer not null, "
            + VALUE
            + " integer not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
//
//    public static void startup() {
//        instance = new DatabaseHelper(null);
//    }
//
//    public static DatabaseHelper getInstance() {
//        if (instance == null) {
//            startup();
//        }
//        return instance;
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_BS);
        db.execSQL(DATABASE_CREATE_EX);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_BS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_EX);
        onCreate(db);
    }

    public void debug(String table) {
//        db.execSQL("SELECT * FROM " + table);
        SQLiteDatabase newdb = this.getReadableDatabase();
        Cursor cursor = newdb.rawQuery(String.format("SELECT * FROM %s", table), null);

        if (cursor.moveToFirst()) {
            do {
                String dbm = cursor.getString(cursor.getColumnIndex("month"));
                String dbd = cursor.getString(cursor.getColumnIndex("day"));
                String dbv = cursor.getString(cursor.getColumnIndex("value"));
                Log.d("row has: ", String.format("month: %s, day: %s, value: %s", dbm, dbd, dbv));
            } while (cursor.moveToNext());
        }

        cursor.close();
        newdb.close();
    }
}
