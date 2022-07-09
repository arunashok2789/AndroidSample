package com.example.HeroProject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.HeroProject.R;
import com.example.HeroProject.pojo.Hero;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {
    Context context;
    List<Hero> heroList;

    public HeroAdapter(Context context, List<Hero> heroList) {
        this.context = context;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Hero hero = heroList.get(position);
        Glide.with(context)
                .load(hero.getImageurl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
