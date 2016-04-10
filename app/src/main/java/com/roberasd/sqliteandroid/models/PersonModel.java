package com.roberasd.sqliteandroid.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by roberasd on 08/03/16.
 */
public class PersonModel implements Parcelable {
    int id;
    String name;
    String lastName;
    int age;
    String country;
    String email;
    String password;

    public PersonModel (){

    }

    protected PersonModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        lastName = in.readString();
        age = in.readInt();
        country = in.readString();
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<PersonModel> CREATOR = new Creator<PersonModel>() {
        @Override
        public PersonModel createFromParcel(Parcel in) {
            return new PersonModel(in);
        }

        @Override
        public PersonModel[] newArray(int size) {
            return new PersonModel[size];
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        dest.writeString(country);
        dest.writeString(email);
        dest.writeString(password);
    }
}
