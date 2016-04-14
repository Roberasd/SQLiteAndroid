package com.roberasd.sqliteandroid.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by roberasd on 08/03/16.
 */
public class UserModel implements Parcelable {
    int id;
    String name;
    String lastName;
    int age;
    String email;
    String password;

    public UserModel(){

    }

    protected UserModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        lastName = in.readString();
        age = in.readInt();
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeInt(age);
        dest.writeString(email);
        dest.writeString(password);
    }
}
