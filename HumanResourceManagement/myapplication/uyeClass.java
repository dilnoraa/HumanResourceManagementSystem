package com.example.pc.myapplication;

/**
 * Created by pc on 16.3.2016.
 */
public class uyeClass {

    private Integer id;
    private String kullanici_ad;
    private String sifre;
    private String ad;
    private String soyad;
    private String posta;


    public uyeClass(Integer id, String kullanici_ad, String sifre, String ad, String soyad, String posta) {
        this.id = id;
        this.kullanici_ad = kullanici_ad;
        this.sifre = sifre;
        this.ad = ad;
        this.soyad = soyad;
        this.posta = posta;
    }

    public void setuyeClass( Integer id,String kullanici_ad, String sifre, String ad, String soyad, String posta) {

        this.id = id;
        this.kullanici_ad = kullanici_ad;
        this.sifre = sifre;
        this.ad = ad;
        this.soyad = soyad;
        this.posta = posta;
    }


    public uyeClass() {
        this.id = -1;
        this.kullanici_ad = " ";
        this.sifre = " ";
        this.ad = " ";
        this.soyad = " ";
        this.posta = " ";
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKullanici_ad() {
        return kullanici_ad;
    }

    public void setKullanici_ad(String kullanici_ad) {
        this.kullanici_ad = kullanici_ad;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
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

    public String getPosta() {
        return posta;
    }

    public void setPosta(String posta) {
        this.posta = posta;
    }
}
