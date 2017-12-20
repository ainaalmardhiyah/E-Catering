package com.example.aina.e_catering.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.aina.e_catering.Model.Order;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 18/12/2017.
 */

public class Database extends SQLiteAssetHelper{
    private static final String DB_Nama="ecateringDB.db";
    private static final int DB_VER=1;


    public Database(Context context) {
        super(context, DB_Nama, null, DB_VER);
    }
    public List<Order> getCarts()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"NamaMakanan","MakananID","Quantity","Harga","Diskon"};
        String sqlTable = "OrderDetail";

        qb.setTables(sqlTable);
        Cursor c = qb.query(db,sqlSelect,null,null,null,null,null);

        final List<Order> result = new ArrayList<>();
        if (c.moveToFirst())
        {
            do {
                result.add(new Order(c.getString(c.getColumnIndex("MakananID")),
                        c.getString(c.getColumnIndex("NamaMakanan")),
                        c.getString(c.getColumnIndex("Quantity")),
                        c.getString(c.getColumnIndex("Harga")),
                        c.getString(c.getColumnIndex("Diskon"))
                        ));
            }while (c.moveToNext());
        }return result;
    }

    public void addToCart (Order order)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT INTO OrderDetail(MakananID,NamaMakanan,Quantity,Harga,Diskon) VALUES('%s','%s','%s','%s','%s');",
                order.getMakananID(),
                order.getNamaMakanan(),
                order.getQuantity(),
                order.getHarga(),
                order.getDiskon());
        db.execSQL(query);
    }
    public void cleanCart ()
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM OrderDetail");
        db.execSQL(query);
    }


}
