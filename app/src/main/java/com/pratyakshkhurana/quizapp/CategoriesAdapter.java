package com.pratyakshkhurana.quizapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {
    private final ArrayList<CategoryView> data;
    private final OnClicked listener;

    public CategoriesAdapter(ArrayList<CategoryView> data, OnClicked listener) {
        this.data = data;
        this.listener = listener;
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_category_view, parent, false);
        CategoriesViewHolder viewHolder = new CategoriesViewHolder(view);
        view.setOnClickListener(v -> listener.categoryClicked(data.get(viewHolder.getAdapterPosition())));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoriesViewHolder holder, int position) {
        CategoryView curr = data.get(position);
        holder.categoryText.setText(curr.category);
        holder.card.setBackground(curr.cardImage);
        Glide.with(holder.itemView.getContext()).load(curr.icon).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class CategoriesViewHolder extends RecyclerView.ViewHolder {
        final TextView categoryText;
        final ImageView image;
        final CardView card;

        CategoriesViewHolder(View view) {
            super(view);
            categoryText = view.findViewById(R.id.categoryText);
            image = view.findViewById(R.id.image);
            card = view.findViewById(R.id.cardView);
        }
    }
}

interface OnClicked {
    void categoryClicked(CategoryView s);
}

