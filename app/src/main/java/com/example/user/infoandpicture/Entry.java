package com.example.user.infoandpicture;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Entry implements Parcelable {

    private String firstName;
    private String lastName;
    private Bitmap picture;



    public Entry() {
    }

    public Entry(String firstName, String lastName, Bitmap picture) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }
    @Override
    public String toString() {
        return "Entry{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", picture=" + picture +
                '}';
    }

    protected Entry(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        picture = (Bitmap) in.readValue(Bitmap.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeValue(picture);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() {
        @Override
        public Entry createFromParcel(Parcel in) {
            return new Entry(in);
        }

        @Override
        public Entry[] newArray(int size) {
            return new Entry[size];
        }
    };
}