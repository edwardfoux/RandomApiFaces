package com.example.edwardfouxvictorious.randomapifaces.list_activity;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.edwardfouxvictorious.randomapifaces.pojo.RandomFace;

import java.util.ArrayList;
import java.util.List;

public class RandomUserResponse implements Parcelable {

    private List<RandomFace> results;

    public List<RandomFace> getResults() {
        return results;
    }

    public void setResults(List<RandomFace> results) {
        this.results = results;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.results);
    }

    public RandomUserResponse() {
    }

    protected RandomUserResponse(Parcel in) {
        this.results = new ArrayList<RandomFace>();
        in.readList(this.results, RandomFace.class.getClassLoader());
    }

    public static final Parcelable.Creator<RandomUserResponse> CREATOR = new Parcelable.Creator<RandomUserResponse>() {
        @Override
        public RandomUserResponse createFromParcel(Parcel source) {
            return new RandomUserResponse(source);
        }

        @Override
        public RandomUserResponse[] newArray(int size) {
            return new RandomUserResponse[size];
        }
    };
}
