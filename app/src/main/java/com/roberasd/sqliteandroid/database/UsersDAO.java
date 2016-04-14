package com.roberasd.sqliteandroid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.roberasd.sqliteandroid.models.UserModel;

import java.util.ArrayList;

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
    public static String PASSWORD = "password";

    private DBAdapter mDBAdapter;
    public UsersDAO(Context context){
        mDBAdapter = new DBAdapter(context);
    }


    public long insertUser(UserModel model){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, model.getName());
        contentValues.put(LAST_NAME, model.getLastName());
        contentValues.put(AGE, model.getAge());
        contentValues.put(EMAIL, model.getEmail());
        contentValues.put(PASSWORD, model.getPassword());

        return mDBAdapter.insert(TABLE_NAME_USER, contentValues);
    }

    public UserModel getUser(String email, String pass){
        UserModel userModel = new UserModel();
        String[] fields = {ID, NAME, LAST_NAME, AGE, EMAIL, PASSWORD};
        String condition = EMAIL  + " = " + "'" + email + "' AND '" + pass + "'";
        mDBAdapter.open();
        Cursor cursor = mDBAdapter.getData(TABLE_NAME_USER, fields, condition);
        cursor.moveToFirst();

        userModel.setId(cursor.getColumnIndex(ID));
        userModel.setName(cursor.getString(cursor.getColumnIndex(NAME)));
        userModel.setLastName(cursor.getString(cursor.getColumnIndex(LAST_NAME)));
        userModel.setAge(cursor.getInt(cursor.getColumnIndex(AGE)));
        userModel.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL)));
        userModel.setPassword(cursor.getString(cursor.getColumnIndex(PASSWORD)));

        return userModel;

    }

    public ArrayList<UserModel> getAllUsers(){
        ArrayList<UserModel> userModelArrayList = new ArrayList<>();
        String[] fields = {ID, NAME, LAST_NAME, AGE, EMAIL, PASSWORD};
        mDBAdapter.open();
        Cursor cursor = mDBAdapter.getData(TABLE_NAME_USER, fields, null);
        cursor.moveToFirst();

        for(int i = 0; i < cursor.getCount(); i++){
            UserModel userModel = new UserModel();

            userModel.setId(cursor.getColumnIndex(ID));
            userModel.setName(cursor.getString(cursor.getColumnIndex(NAME)));
            userModel.setLastName(cursor.getString(cursor.getColumnIndex(LAST_NAME)));
            userModel.setAge(cursor.getInt(cursor.getColumnIndex(AGE)));
            userModel.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL)));
            userModel.setPassword(cursor.getString(cursor.getColumnIndex(PASSWORD)));

            userModelArrayList.add(userModel);
        }

        return userModelArrayList;
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
