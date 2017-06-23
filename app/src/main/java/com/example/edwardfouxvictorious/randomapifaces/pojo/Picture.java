package com.example.edwardfouxvictorious.randomapifaces.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Picture implements Parcelable {

    private String thumbnail;
    private String large;
    private String medium;

    public String getThumbnail() {
        return thumbnail;
    }

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.thumbnail);
        dest.writeString(this.large);
        dest.writeString(this.medium);
    }

    public Picture() {
    }

    protected Picture(Parcel in) {
        this.thumbnail = in.readString();
        this.large = in.readString();
        this.medium = in.readString();
    }

    public static final Parcelable.Creator<Picture> CREATOR = new Parcelable.Creator<Picture>() {
        @Override
        public Picture createFromParcel(Parcel source) {
            return new Picture(source);
        }

        @Override
        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    };
}
