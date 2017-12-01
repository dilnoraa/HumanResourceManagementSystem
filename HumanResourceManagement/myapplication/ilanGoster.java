package com.example.pc.myapplication;

/**
 * Created by pc on 24.2.2016.
 */
public class ilanGoster {
    private String incele;
    private String baslangcTarih;
    private String bitisTarih;
    private String kisiSay;
    private String egitim;
    private String departman;
    private String aktiflik;

    public ilanGoster(String incele,String baslangcTarih, String bitisTarih, String kisiSay, String egitim, String departman, String aktiflik) {
        this.incele=incele;
        this.baslangcTarih = baslangcTarih;
        this.bitisTarih = bitisTarih;
        this.kisiSay = kisiSay;
        this.egitim = egitim;
        this.departman = departman;
        this.aktiflik = aktiflik;
    }


    public void setilanGoster(String baslangcTarih, String bitisTarih, String kisiSay, String egitim, String departman, String aktiflik) {
        this.incele=incele;
        this.baslangcTarih = baslangcTarih;
        this.bitisTarih = bitisTarih;
        this.kisiSay = kisiSay;
        this.egitim = egitim;
        this.departman = departman;
        this.aktiflik = aktiflik;
    }


    public ilanGoster() {
        incele="incele";
        baslangcTarih = " ";
        bitisTarih = " ";
        kisiSay = " ";
        egitim = " ";
        departman = " ";
        aktiflik = " ";
    }

    public String getBaslangcTarih() {
        return baslangcTarih;
    }

    public void setBaslangcTarih(String baslangcTarih) {
        this.baslangcTarih = baslangcTarih;
    }

    public String getBitisTarih() {
        return bitisTarih;
    }

    public void setBitisTarih(String bitisTarih) {
        this.bitisTarih = bitisTarih;
    }

    public String getKisiSay() {
        return kisiSay;
    }

    public void setKisiSay(String kisiSay) {
        this.kisiSay = kisiSay;
    }

    public String getEgitim() {
        return egitim;
    }

    public void setEgitim(String egitim) {
        this.egitim = egitim;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public String getAktiflik() {
        return aktiflik;
    }

    public void setAktiflik(String aktiflik) {
        this.aktiflik = aktiflik;
    }
}
