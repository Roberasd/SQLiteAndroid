package com.roberasd.sqliteandroid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.roberasd.sqliteandroid.models.PersonModel;

/**
 * Created by roberasd on 05/04/16.
 */
public class UsersDAO {

    public static String TABLE_NAME_USER = "users";
    public static String ID = "id_user";
    public static String NAME = "name";
    public static String LAST_NAME = "last_name";
    public static String AGE = "age";
    public static String EMAIL = "email";
    public static String COUNTRY = "country";
    public static String PASSWORD = "password";

    private DBAdapter mDBAdapter;
    public UsersDAO(Context context){
        mDBAdapter = new DBAdapter(context);
    }


    public long insertUser(PersonModel model){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, model.getName());
        contentValues.put(LAST_NAME, model.getLastName());
        contentValues.put(AGE, model.getAge());
        contentValues.put(EMAIL, model.getEmail());
        contentValues.put(COUNTRY, model.getCountry());
        contentValues.put(PASSWORD, model.getPassword());

        return mDBAdapter.insert(TABLE_NAME_USER, contentValues);
    }

    public PersonModel getUser(String email, String pass){
        PersonModel personModel = new PersonModel();
        String[] fields = {ID, NAME, LAST_NAME, AGE, EMAIL, COUNTRY, PASSWORD};
        String condition = EMAIL  + " = " + "'" + email + "' AND '" + pass + "'";
        mDBAdapter.open();
        Cursor cursor = mDBAdapter.getData(TABLE_NAME_USER, fields, condition);
        cursor.moveToFirst();

        /*int id = cursor.getColumnIndex(ID);
        int name = cursor.getColumnIndex(NAME);
        int lastName = cursor.getColumnIndex(LAST_NAME);
        int age = cursor.getColumnIndex(AGE);
        int emailAddress = cursor.getColumnIndex(EMAIL);
        int country = cursor.getColumnIndex(COUNTRY);
        int password = cursor.getColumnIndex(PASSWORD);*/

        personModel.setId(cursor.getColumnIndex(ID));
        personModel.setName(cursor.getString(cursor.getColumnIndex(NAME)));
        personModel.setLastName(cursor.getString(cursor.getColumnIndex(LAST_NAME)));
        personModel.setAge(cursor.getInt(cursor.getColumnIndex(AGE)));
        personModel.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL)));
        personModel.setCountry(cursor.getString(cursor.getColumnIndex(COUNTRY)));
        personModel.setPassword(cursor.getString(cursor.getColumnIndex(PASSWORD)));

        return personModel;

    }

    public boolean isRegistered(String email){

        boolean b;

        String[] fields = {ID};
        mDBAdapter.open();
        String condition = EMAIL  + " = " + "'" + email + "'";
        Cursor cursor = mDBAdapter.getData(TABLE_NAME_USER, fields, condition);
        cursor.moveToFirst();

        if(cursor.getCount() > 0)
            b = true;
        else
            b = false;

        cursor.close();
        mDBAdapter.close();

        return b;


    }
}
