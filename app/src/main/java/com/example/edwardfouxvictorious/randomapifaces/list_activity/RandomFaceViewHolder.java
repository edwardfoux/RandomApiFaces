package com.example.edwardfouxvictorious.randomapifaces.list_activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edwardfouxvictorious.randomapifaces.R;
import com.example.edwardfouxvictorious.randomapifaces.pojo.RandomFace;
import com.squareup.picasso.Picasso;

class RandomFaceViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView textView;
    private ImageView imageView;
    private View view;
    private RandomFacesAdapter.ItemClickListener itemClickListener;
    private RandomFace randomFace;

    RandomFaceViewHolder(View itemView) {
        super(itemView);
        this.view = itemView;
        textView = (TextView) itemView.findViewById(R.id.text_view);
        imageView = (ImageView) itemView.findViewById(R.id.image_album);
    }

    void setup(RandomFace randomFace, RandomFacesAdapter.ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        view.setOnClickListener(this);

        textView.setText(randomFace.getName().getFirst());
        Picasso.with(imageView.getContext()).load(randomFace.getPicture().getLarge()).into(imageView);
        this.randomFace = randomFace;

    }

    @Override
    public void onClick(View v) {
        itemClickListener.onItemCLicked(randomFace);
    }
}