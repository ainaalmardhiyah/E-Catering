package com.example.aina.e_catering;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.aina.e_catering.Database.Database;
import com.example.aina.e_catering.Model.Makanan;
import com.example.aina.e_catering.Model.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MakananDetail extends AppCompatActivity {

    TextView namaMakanan, hargaMakanan, deskripsiMakanan;
    ImageView gambarMakanan;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton tombolCart;
    ElegantNumberButton numberButton;

    String MakananId="";

    FirebaseDatabase database;
    DatabaseReference Makanan;

    Makanan crMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_detail);

        //Link Firebase
        database = FirebaseDatabase.getInstance();
        Makanan = database.getReference("Makanan");

        //Init View
        numberButton = (ElegantNumberButton)findViewById(R.id.number_button);
        tombolCart = (FloatingActionButton)findViewById(R.id.tombolCart);

        tombolCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Database(getBaseContext()).addToCart(new Order(
                        MakananId,
                        crMakanan.getNama(),
                        numberButton.getNumber(),
                        crMakanan.getHarga(),
                        crMakanan.getDiskon()
                ));
                Toast.makeText(MakananDetail.this, "Add to Cart", Toast.LENGTH_SHORT).show();
            }
        });

        deskripsiMakanan = (TextView)findViewById(R.id.deskripsiMakanan);
        namaMakanan = (TextView)findViewById(R.id.namaMakanan);
        hargaMakanan =(TextView)findViewById(R.id.hargaMakanan);
        gambarMakanan = (ImageView)findViewById(R.id.gambarMakanan);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        //Makanan Id dari Intent
        if (getIntent() != null)
            MakananId = getIntent().getStringExtra("MakananId");
        if (!MakananId.isEmpty())
        {
            getDetailFood(MakananId);
        }
    }

    private void getDetailFood(final String makananId) {
        Makanan.child(makananId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                crMakanan = dataSnapshot.getValue(com.example.aina.e_catering.Model.Makanan.class);

                //Set Gambar
                Picasso.with(getBaseContext()).load(crMakanan.getGambar())
                        .into(gambarMakanan);
                collapsingToolbarLayout.setTitle(crMakanan.getNama());

                hargaMakanan.setText(crMakanan.getHarga());
                namaMakanan.setText(crMakanan.getNama());
                deskripsiMakanan.setText(crMakanan.getDeskripsi());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
