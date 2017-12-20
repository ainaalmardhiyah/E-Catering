package com.example.aina.e_catering.Model;

/**
 * Created by ASUS on 18/12/2017.
 */

public class Order {

    private String MakananID;
    private String NamaMakanan;
    private String Quantity;
    private String Harga;
    private String Diskon;

    public Order() {
    }

    public Order(String makananID, String namaMakanan, String quantity, String harga, String diskon) {
        MakananID = makananID;
        NamaMakanan = namaMakanan;
        Quantity = quantity;
        Harga = harga;
        Diskon = diskon;
    }

    public String getMakananID() {
        return MakananID;
    }

    public void setMakananID(String makananID) {
        MakananID = makananID;
    }

    public String getNamaMakanan() {
        return NamaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        NamaMakanan = namaMakanan;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getDiskon() {
        return Diskon;
    }

    public void setDiskon(String diskon) {
        Diskon = diskon;
    }
}
