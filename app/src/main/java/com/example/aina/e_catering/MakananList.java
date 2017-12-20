package com.example.aina.e_catering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.aina.e_catering.Interface.ItemClickListener;
import com.example.aina.e_catering.Model.Makanan;
import com.example.aina.e_catering.ViewHolder.MakananViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MakananList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference makananList;

    String KategoriId = "";
    FirebaseRecyclerAdapter<Makanan,MakananViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_list);

        //Memanggil Firebase Database
        database = FirebaseDatabase.getInstance();
        makananList = database.getReference("Makanan");
        recyclerView = (RecyclerView)findViewById(R.id.recycleMakanan);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if (getIntent() != null)
            KategoriId = getIntent().getStringExtra("KategoriId");
        if (!KategoriId.isEmpty() && KategoriId != null)
        {
            loadListMakanan(KategoriId);
        }
    }

    private void loadListMakanan(String kategoriId) {
        adapter = new FirebaseRecyclerAdapter<Makanan, MakananViewHolder>(Makanan.class,
                R.layout.makanan_item,
                MakananViewHolder.class,
                makananList.orderByChild("MenuId").equalTo(kategoriId) //dari Makanan where Menuid
                ) {
            @Override
            protected void populateViewHolder(MakananViewHolder viewHolder, Makanan model, int position) {
                viewHolder.MakananNama.setText(model.getNama());
                Picasso.with(getBaseContext()).load(model.getGambar())
                        .into(viewHolder.MakananGambar);
                final Makanan local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //Start New Activity
                        Intent MakananDetail = new Intent(MakananList.this, com.example.aina.e_catering.MakananDetail.class);
                        MakananDetail.putExtra("MakananId",adapter.getRef(position).getKey());//Kirim MakananId ke new Activity
                        startActivity(MakananDetail);
                    }
                });
            }
        };
        //Set Adapter
        recyclerView.setAdapter(adapter);

    }
}
