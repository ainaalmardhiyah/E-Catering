package com.example.aina.e_catering.Model;

import java.util.List;

/**
 * Created by ASUS on 18/12/2017.
 */

public class Request {
    private String noHP;
    private String alamat;
    private String nama;
    private String total;
    private String status;
    private List<Order> makanan;

    public Request() {
    }
    //Urutan Array Jangan Kebalik
    public Request(String noHP, String nama, String alamat, String total, List<Order> makanan) {
        this.noHP = noHP;
        this.alamat = alamat;
        this.nama = nama;
        this.total = total;
        this.makanan = makanan;
        this.status = "0";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getMakanan() {
        return makanan;
    }

    public void setMakanan(List<Order> makanan) {
        this.makanan = makanan;
    }
}
