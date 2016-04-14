package com.roberasd.sqliteandroid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

/**
 * Created by roberasd on 05/04/16.
 */
public class DBAdapter {
    private static final String mDbName = "midb.s3db";
    private static int mDbVersion = 1; //Upgrade everytime you have to change bd in store
    private SQLiteDatabase mDb;
    private DatabaseHelper mDbHelper;
    private final Context mContext;

    private static String TABLE_USERS = " CREATE TABLE "
            + UsersDAO.TABLE_NAME_USER + " ("
            + UsersDAO.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + UsersDAO.NAME + " TEXT, "
            + UsersDAO.LAST_NAME + " TEXT, "
            + UsersDAO.AGE + " NUMERIC, "
            + UsersDAO.EMAIL + " TEXT, "
            + UsersDAO.PASSWORD + " TEXT);";

    public DBAdapter(Context context) {
        this.mContext = context;
        mDbHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, mDbName, null, mDbVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d("DBAdapter", "Creating DataBase");
            db.execSQL(TABLE_USERS);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            Log.d("DBAdapter", "Upgrading DataBase from v " + oldVersion + " to v " + newVersion);
            db.execSQL(TABLE_USERS);
        }
    }

    public DBAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mContext);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public long insert(String table, ContentValues contentValues){
        long insertedData = -1;

        try {
            open();
            insertedData = mDb.insert(table, null, contentValues);

        }catch (Exception error){
            Log.e("DBAdapter", "failed to insert data. Error: " + error);

        }finally { // siempre va a ocurrir, independientemente
            close();
        }

        return insertedData;
    }

    public Cursor getData(String tables, String[] columns, String conditional){

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(tables);

        return queryBuilder.query(mDb, columns , conditional, null, null, null, null);
    }
}
