package com.example.edwardfouxvictorious.randomapifaces.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class RandomFace implements Parcelable {

    private String gender;
    private Name name;
    private String email;
    private String dob;
    private String registered;
    private String phone;
    private String cell;
    private Picture picture;

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }


    public String getDob() {
        return dob;
    }

    public String getRegistered() {
        return registered;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

    public Name getName() {
        return name;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.gender);
        dest.writeParcelable(this.name, flags);
        dest.writeString(this.email);
        dest.writeString(this.dob);
        dest.writeString(this.registered);
        dest.writeString(this.phone);
        dest.writeString(this.cell);
        dest.writeParcelable(this.picture, flags);
    }

    public RandomFace() {
    }

    protected RandomFace(Parcel in) {
        this.gender = in.readString();
        this.name = in.readParcelable(Name.class.getClassLoader());
        this.email = in.readString();
        this.dob = in.readString();
        this.registered = in.readString();
        this.phone = in.readString();
        this.cell = in.readString();
        this.picture = in.readParcelable(Picture.class.getClassLoader());
    }

    public static final Parcelable.Creator<RandomFace> CREATOR = new Parcelable.Creator<RandomFace>() {
        @Override
        public RandomFace createFromParcel(Parcel source) {
            return new RandomFace(source);
        }

        @Override
        public RandomFace[] newArray(int size) {
            return new RandomFace[size];
        }
    };
}
