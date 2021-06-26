package com.example.shopinglist;

public class Alisveris {
    private int id;
    private String alisverisAdi,urunAdi,urunMiktari,urunAdedi,urunFiyati,urunNot;

    public Alisveris(int id, String alisverisAdi, String urunAdi, String urunMiktari, String urunAdedi, String urunFiyati, String urunNot) {
        this.id = id;
        this.alisverisAdi = alisverisAdi;
        this.urunAdi = urunAdi;
        this.urunMiktari = urunMiktari;
        this.urunAdedi = urunAdedi;
        this.urunFiyati = urunFiyati;
        this.urunNot = urunNot;
    }

    public int getId() {
        return id;
    }

    public String getAlisverisAdi() {
        return alisverisAdi;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public String getUrunMiktari() {
        return urunMiktari;
    }

    public String getUrunAdedi() {
        return urunAdedi;
    }

    public String getUrunFiyati() {
        return urunFiyati;
    }

    public String getUrunNot() {
        return urunNot;
    }


}

