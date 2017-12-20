package com.example.aina.e_catering.Model;

/**
 * Created by ASUS on 12/12/2017.
 */

public class Category {
    private  String Nama;
    private  String Gambar;

    public Category(String nama, String gambar) {
        Nama = nama;
        Gambar = gambar;
    }

    public Category ()
    {

    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getGambar() {
        return Gambar;
    }

    public void setGambar(String gambar) {
        Gambar = gambar;
    }
}
