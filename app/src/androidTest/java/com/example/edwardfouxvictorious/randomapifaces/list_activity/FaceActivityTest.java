package com.example.edwardfouxvictorious.randomapifaces.list_activity;


import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.edwardfouxvictorious.randomapifaces.R;
import com.example.edwardfouxvictorious.randomapifaces.face_activity.FaceActivity;
import com.example.edwardfouxvictorious.randomapifaces.pojo.Name;
import com.example.edwardfouxvictorious.randomapifaces.pojo.Picture;
import com.example.edwardfouxvictorious.randomapifaces.pojo.RandomFace;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class FaceActivityTest {

    @Rule
    public ActivityTestRule<FaceActivity> mActivityTestRule = new ActivityTestRule<>(FaceActivity.class, true, false);

    @Test
    public void faceActivityTest() {
        RandomFace randomFace = new RandomFace();
        Name name = new Name();
        Picture picture = new Picture();
        picture.setLarge("http://cdn.quotesgram.com/small/40/66/727102654-e847a965f8bcde942b458484bbc248a0.jpg");
        name.setFirst("Alex");
        name.setLast("Johns");
        randomFace.setName(name);
        randomFace.setPicture(picture);
        Intent intent = new Intent();
        intent.putExtra(FaceActivity.FACE, randomFace);

        mActivityTestRule.launchActivity(intent);

        Espresso.onView(withId(R.id.name)).check(matches(withText("Alex Johns")));
    }
}
