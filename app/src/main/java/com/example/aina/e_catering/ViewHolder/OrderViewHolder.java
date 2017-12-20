package com.example.aina.e_catering.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.aina.e_catering.Interface.ItemClickListener;
import com.example.aina.e_catering.R;

/**
 * Created by ASUS on 19/12/2017.
 */

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txtOrderId, txtOrderStatus, txtOrdernoHP,txtOrderAlamat;
    private ItemClickListener itemClickListener;

    public OrderViewHolder(View itemView) {
        super(itemView);
        txtOrderAlamat = (TextView)itemView.findViewById(R.id.order_alamat);
        txtOrderId = (TextView)itemView.findViewById(R.id.order_id);
        txtOrderStatus = (TextView)itemView.findViewById(R.id.order_status);
        txtOrdernoHP = (TextView)itemView.findViewById(R.id.order_noHp);

//        itemView.setOnClickListener(this);
    }
//    public void setItemClickListener(ItemClickListener itemClickListener) {
//        this.itemClickListener = itemClickListener;
//    }
    @Override
    public void onClick(View view) {
//        itemClickListener.onClick(view,getAdapterPosition(),false);
    }


}
