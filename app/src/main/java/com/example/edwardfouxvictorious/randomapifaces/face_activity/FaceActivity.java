package com.example.edwardfouxvictorious.randomapifaces.face_activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edwardfouxvictorious.randomapifaces.R;
import com.example.edwardfouxvictorious.randomapifaces.pojo.RandomFace;
import com.squareup.picasso.Picasso;

public class FaceActivity extends AppCompatActivity {
    public static final String FACE = "FACE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.face_activity);

        ImageView imageView = (ImageView) findViewById(R.id.face_view);

        RandomFace randomFace = getIntent().getParcelableExtra(FACE);
        Picasso.with(imageView.getContext()).load(randomFace.getPicture().getLarge()).into(imageView);

        TextView textView = (TextView) findViewById(R.id.name);
        textView.setText(randomFace.getName().getFirst() + " " + randomFace.getName().getLast());
    }
}
