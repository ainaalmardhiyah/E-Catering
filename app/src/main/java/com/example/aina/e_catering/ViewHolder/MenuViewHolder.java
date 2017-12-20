package com.example.aina.e_catering.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aina.e_catering.Interface.ItemClickListener;
import com.example.aina.e_catering.R;

import org.w3c.dom.Text;

/**
 * Created by ASUS on 12/12/2017.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView MenuNama;
    public ImageView imageView;

    private ItemClickListener itemClickListener;

    public MenuViewHolder(View itemView) {
        super(itemView);

        MenuNama = (TextView)itemView.findViewById(R.id.menu_nama);
        imageView = (ImageView)itemView.findViewById(R.id.menu_gambar);

        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
