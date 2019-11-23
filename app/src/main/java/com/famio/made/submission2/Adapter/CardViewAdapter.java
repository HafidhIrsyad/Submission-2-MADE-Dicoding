    package com.famio.made.submission2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.famio.made.submission2.Activity.DetailActivity;
import com.famio.made.submission2.Pojo.DaftarTayang;
import com.famio.made.submission2.R;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<DaftarTayang> listDaftarTayang;

    public ArrayList<DaftarTayang> getListDaftarTayang() {
        return listDaftarTayang;
    }

    public void setListDaftarTayang(ArrayList<DaftarTayang> listDaftarTayang) {
        this.listDaftarTayang = listDaftarTayang;
    }

    public CardViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewAdapter.CardViewViewHolder cardViewViewHolder, int i) {
        DaftarTayang daftarTayang = getListDaftarTayang().get(i);
        Glide.with(context)
                .load(daftarTayang.getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);
        cardViewViewHolder.tvName.setText(daftarTayang.getName());
        cardViewViewHolder.tvRating.setText(daftarTayang.getRating());
        cardViewViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveWithObjectIntent = new Intent(context, DetailActivity.class);
                moveWithObjectIntent.putExtra(DetailActivity.EXTRA_SHOW, listDaftarTayang.get(cardViewViewHolder.getAdapterPosition()));
                context.startActivity(moveWithObjectIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListDaftarTayang().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRating;
        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRating = itemView.findViewById(R.id.tv_item_rating);
        }
    }
}
