package com.example.pc.myapplication;


import java.util.Date;

public class basvuranBilgileri {
    private String ad;
    private String soyad;
    private String cinsiyet;
    private String dogumYeri;
    private String dogumTarih;
    private String medeniDurum;
    private String surucuBelgesi;
    private String evNumarasi;
    private String cepNumarasi;
    private String adres;
    private String email;
    private String egitimSeviye;
    private String hobi;
    private String webSite;
    private String durum;



    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    public String getEgitimSeviye() {
        return egitimSeviye;
    }

    public void setEgitimSeviye(String egitimSeviye) {
        this.egitimSeviye = egitimSeviye;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }

    public String getDogumTarih() {
        return dogumTarih;
    }

    public void setDogumTarih(String dogumTarih) {
        this.dogumTarih = dogumTarih;
    }

    public String getMedeniDurum() {
        return medeniDurum;
    }

    public void setMedeniDurum(String medeniDurum) {
        this.medeniDurum = medeniDurum;
    }

    public String getSurucuBelgesi() {
        return surucuBelgesi;
    }

    public void setSurucuBelgesi(String surucuBelgesi) {
        this.surucuBelgesi = surucuBelgesi;
    }

    public String getEvNumarasi() {
        return evNumarasi;
    }

    public void setEvNumarasi(String evNumarasi) {
        this.evNumarasi = evNumarasi;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getCepNumarasi() {
        return cepNumarasi;
    }

    public void setCepNumarasi(String cepNumarasi) {
        this.cepNumarasi = cepNumarasi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }


    public void setBasvuranBilgileri(String ad, String soyad, String cinsiyet, String dogumYeri, String dogumTarih, String medeniDurum, String surucuBelgesi, String evNumarasi, String cepNumarasi, String adres, String email, String egitimSeviye, String hobi, String webSite, String durum) {
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.dogumYeri = dogumYeri;
        this.dogumTarih = dogumTarih;
        this.medeniDurum = medeniDurum;
        this.surucuBelgesi = surucuBelgesi;
        this.evNumarasi = evNumarasi;
        this.cepNumarasi = cepNumarasi;
        this.adres = adres;
        this.email = email;
        this.egitimSeviye=egitimSeviye;
        this.hobi=hobi;
        this.webSite=webSite;
        this.durum=durum;

    }

    public basvuranBilgileri() {
        ad=" ";
        this.soyad =" ";
        this.cinsiyet = " ";
        this.dogumYeri = " ";
        this.dogumTarih = " ";
        this.medeniDurum =" ";
        this.surucuBelgesi = " ";
        this.evNumarasi = " ";
        this.cepNumarasi = " ";
        this.adres =" ";
        this.email = " ";
        this.egitimSeviye=" ";
        this.hobi=" ";
        this.webSite=" ";
        this.durum=" ";
    }



    public void setAd(String s1) {
      ad=s1;
    }

    public String getAd() { return ad;}

    public String getSoyad() { return soyad;}




}
