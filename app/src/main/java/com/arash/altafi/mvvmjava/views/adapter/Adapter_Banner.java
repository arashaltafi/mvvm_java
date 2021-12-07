package com.arash.altafi.mvvmjava.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arash.altafi.mvvmjava.R;
import com.arash.altafi.mvvmjava.models.ResponseBanner;
import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter_Banner extends RecyclerView.Adapter<Adapter_Banner.ViewHolder> {

    List<ResponseBanner> responseBanners;

    public Adapter_Banner(List<ResponseBanner> responseBanners) {
        this.responseBanners = responseBanners;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(responseBanners.get(position));
    }

    @Override
    public int getItemCount() {
        return responseBanners.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_banner);
        }

        private void bind(ResponseBanner banner)
        {
            Glide.with(itemView.getContext()).load(banner.getImage()).into(imageView);
        }

    }

}