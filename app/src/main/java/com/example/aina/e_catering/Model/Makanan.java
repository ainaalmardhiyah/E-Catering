package com.example.aina.e_catering.Model;

/**
 * Created by ASUS on 16/12/2017.
 */

public class Makanan {
    private String Nama, Gambar, Deskripsi, Harga, Diskon, MenuId;

    public Makanan() {
    }

    public Makanan(String nama, String gambar, String deskripsi, String harga, String diskon, String menuId) {
        Nama = nama;
        Gambar = gambar;
        Deskripsi = deskripsi;
        Harga = harga;
        Diskon = diskon;
        MenuId = menuId;
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

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        Deskripsi = deskripsi;
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

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
