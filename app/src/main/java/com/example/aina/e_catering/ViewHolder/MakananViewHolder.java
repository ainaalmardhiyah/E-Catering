package com.example.aina.e_catering.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aina.e_catering.Interface.ItemClickListener;
import com.example.aina.e_catering.R;

/**
 * Created by ASUS on 16/12/2017.
 */

public class MakananViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView MakananNama;
    public ImageView MakananGambar;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;

    }

    public MakananViewHolder(View itemView) {
        super(itemView);
        MakananNama = (TextView)itemView.findViewById(R.id.makanan_nama);
        MakananGambar = (ImageView)itemView.findViewById(R.id.makanan_gambar);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
