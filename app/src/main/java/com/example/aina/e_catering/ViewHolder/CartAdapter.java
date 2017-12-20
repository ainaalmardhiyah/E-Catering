package com.example.aina.e_catering.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.aina.e_catering.Interface.ItemClickListener;
import com.example.aina.e_catering.Model.Order;
import com.example.aina.e_catering.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by ASUS on 18/12/2017.
 */

class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txtNamaCart, txtHarga;
    public ImageView gambarCartCount;

    private ItemClickListener itemClickListener;

    public void setTxtnamaCart(TextView txtNamaCart)
    {
        this.txtNamaCart = txtNamaCart;
    }

    public CartViewHolder(View itemView)
    {
        super(itemView);
        txtNamaCart =(TextView)itemView.findViewById(R.id.cart_item_nama);
        txtHarga = (TextView)itemView.findViewById(R.id.cart_item_harga);
        gambarCartCount = (ImageView)itemView.findViewById(R.id.cart_item_count);
    }

    @Override
    public void onClick(View view) {
        //itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}


public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    private List<Order> listData = new ArrayList<>();
    private Context context;

    public CartAdapter(List<Order> listData, Context context)
    {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.cart_layout,parent,false);
        return  new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(""+listData.get(position).getQuantity(), Color.RED);
        holder.gambarCartCount.setImageDrawable(drawable);

        Locale locale = new Locale("in_ID","id");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        int price = (Integer.parseInt(listData.get(position).getHarga()))*(Integer.parseInt(listData.get(position).getQuantity()));
        holder.txtHarga.setText(format.format(price));
        holder.txtNamaCart.setText(listData.get(position).getNamaMakanan());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
