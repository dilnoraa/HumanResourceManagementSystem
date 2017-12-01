package com.example.pc.myapplication;

/**
 * Created by pc on 10.3.2016.
 */
public class personelClass {

    private Integer sicil;
    private String ad;
    private String soyad;
    private String cinsiyet;
    private String dogumYeri;
    private String dogumTarih;
    private String surucuBelgesi;
    private String medeniDurum;
    private String egitimSeviye;
    private String departman;
    private String pozisyon;
    private String maas;
    private String cepNumarasi;
    private String evNumarasi;
    private String adres;
    private String email;
    private String webSite;


    public personelClass(Integer sicil, String ad, String soyad, String cinsiyet, String dogumYeri, String dogumTarih, String surucuBelgesi, String medeniDurum, String egitimSeviye, String departman, String pozisyon, String maas, String cepNumarasi, String evNumarasi, String adres, String email, String webSite) {
        this.sicil = sicil;
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.dogumYeri = dogumYeri;
        this.dogumTarih = dogumTarih;
        this.surucuBelgesi = surucuBelgesi;
        this.medeniDurum = medeniDurum;
        this.egitimSeviye = egitimSeviye;
        this.departman = departman;
        this.pozisyon = pozisyon;
        this.maas = maas;
        this.cepNumarasi = cepNumarasi;
        this.evNumarasi = evNumarasi;
        this.adres = adres;
        this.email = email;
        this.webSite = webSite;
    }


    public void setpersonelClass( Integer sicil, String ad, String soyad, String cinsiyet, String dogumYeri, String dogumTarih, String surucuBelgesi, String medeniDurum, String egitimSeviye, String departman, String pozisyon, String maas, String cepNumarasi, String evNumarasi, String adres, String email, String webSite) {

        this.sicil=sicil;
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.dogumYeri = dogumYeri;
        this.dogumTarih = dogumTarih;
        this.surucuBelgesi = surucuBelgesi;
        this.medeniDurum = medeniDurum;
        this.egitimSeviye = egitimSeviye;
        this.departman = departman;
        this.pozisyon = pozisyon;
        this.maas = maas;
        this.cepNumarasi = cepNumarasi;
        this.evNumarasi = evNumarasi;
        this.adres = adres;
        this.email = email;
        this.webSite = webSite;
    }


    public personelClass() {
        this.sicil = -1;
        this.ad = " ";
        this.soyad = " ";
        this.cinsiyet = " ";
        this.dogumYeri = " ";
        this.dogumTarih = " ";
        this.surucuBelgesi = " ";
        this.medeniDurum = " ";
        this.egitimSeviye = " ";
        this.departman = " ";
        this.pozisyon = " ";
        this.maas = " ";
        this.cepNumarasi = " ";
        this.evNumarasi = " ";
        this.adres = " ";
        this.email = " ";
        this.webSite = " ";
    }


    public Integer getSicil() {
        return sicil;
    }

    public void setSicil(Integer sicil) {
        this.sicil = sicil;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
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

    public String getSurucuBelgesi() {
        return surucuBelgesi;
    }

    public void setSurucuBelgesi(String surucuBelgesi) {
        this.surucuBelgesi = surucuBelgesi;
    }

    public String getMedeniDurum() {
        return medeniDurum;
    }

    public void setMedeniDurum(String medeniDurum) {
        this.medeniDurum = medeniDurum;
    }

    public String getEgitimSeviye() {
        return egitimSeviye;
    }

    public void setEgitimSeviye(String egitimSeviye) {
        this.egitimSeviye = egitimSeviye;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }

    public String getMaas() {
        return maas;
    }

    public void setMaas(String maas) {
        this.maas = maas;
    }

    public String getCepNumarasi() {
        return cepNumarasi;
    }

    public void setCepNumarasi(String cepNumarasi) {
        this.cepNumarasi = cepNumarasi;
    }

    public String getEvNumarasi() {
        return evNumarasi;
    }

    public void setEvNumarasi(String evNumarasi) {
        this.evNumarasi = evNumarasi;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
