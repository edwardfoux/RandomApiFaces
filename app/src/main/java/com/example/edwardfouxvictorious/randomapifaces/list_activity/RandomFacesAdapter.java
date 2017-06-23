package com.example.edwardfouxvictorious.randomapifaces.list_activity;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.edwardfouxvictorious.randomapifaces.R;
import com.example.edwardfouxvictorious.randomapifaces.pojo.RandomFace;

import java.util.ArrayList;
import java.util.List;

public class RandomFacesAdapter extends RecyclerView.Adapter<RandomFaceViewHolder> {

    private List<RandomFace> list = new ArrayList<>();
    ItemClickListener itemClickListener;

    RandomFacesAdapter(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    void setList(List<RandomFace> list) {
        this.list = list;
    }

    List<RandomFace> getList() {
        return list;
    }

    @Override
    public RandomFaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.random_face_view_holder, null);
        WindowManager windowManager = (WindowManager) parent.getContext().getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        int width = point.x;
        view.setLayoutParams(new LinearLayoutCompat.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT));
        return new RandomFaceViewHolder(view);
    }

    @Override
    @VisibleForTesting
    public void onBindViewHolder(RandomFaceViewHolder holder, int position) {
        RandomFace album = list.get(position);
        holder.setup(album, itemClickListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    interface ItemClickListener {
        void onItemCLicked(RandomFace album);
    }
}