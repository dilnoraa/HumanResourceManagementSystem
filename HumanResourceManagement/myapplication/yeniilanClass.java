package com.example.pc.myapplication;

/**
 * Created by pc on 22.2.2016.
 */
public class yeniilanClass {

    private Integer id;
   private String baslangicTarih;
    private String bitisTarih;
    private String kisiSayi;
    private String departman;
   private String minYas;
    private String maxYas;
    private String cinsiyet;
    private String egitim;
    private String tecrube;
    private String dil;
    private String ekbilgi;
    private String aktiflik;

    public yeniilanClass(Integer id,String baslangicTarih, String bitisTarih,String kisiSayi, String departman, String minYas, String maxYas, String cinsiyet, String egitim, String tecrube, String dil, String ekbilgi, String aktiflik) {

        this.id=id;
        this.baslangicTarih = baslangicTarih;
        this.bitisTarih = bitisTarih;
        this.kisiSayi=kisiSayi;
        this.departman = departman;
        this.minYas = minYas;
        this.maxYas = maxYas;
        this.cinsiyet = cinsiyet;
        this.egitim = egitim;
        this.tecrube = tecrube;
        this.dil = dil;
        this.ekbilgi = ekbilgi;
        this.aktiflik=aktiflik;

    }

    public void setYeniilanClass(String baslangicTarih, String bitisTarih,String kisiSayi, String departman, String minYas, String maxYas, String cinsiyet, String egitim, String tecrube, String dil, String ekbilgi, String aktiflik) {


        this.baslangicTarih = baslangicTarih;
        this.bitisTarih = bitisTarih;
        this.kisiSayi=kisiSayi;
        this.departman = departman;
        this.minYas = minYas;
        this.maxYas = maxYas;
        this.cinsiyet = cinsiyet;
        this.egitim = egitim;
        this.tecrube = tecrube;
        this.dil = dil;
        this.ekbilgi = ekbilgi;
        this.aktiflik=aktiflik;

    }

    public yeniilanClass() {

        this.id=-1;
        this.baslangicTarih = " ";
        this.bitisTarih = " ";
        this.kisiSayi=" ";
        this.departman = " ";
        this.minYas = " ";
        this.maxYas = " ";
        this.cinsiyet = " ";
        this.egitim = " ";
        this.tecrube = " ";
        this.dil = " ";
        this.ekbilgi = " ";
        this.aktiflik=" ";


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKisiSayi() {
        return kisiSayi;
    }

    public void setKisiSayi(String kisiSayi) {
        this.kisiSayi = kisiSayi;
    }

    public String getAktiflik() {
        return aktiflik;
    }

    public void setAktiflik(String aktiflik) {
        this.aktiflik = aktiflik;
    }

    public String getBaslangicTarih() {
        return baslangicTarih;
    }

    public void setBaslangicTarih(String baslangicTarih) {
        this.baslangicTarih = baslangicTarih;
    }

    public String getBitisTarih() {
        return bitisTarih;
    }

    public void setBitisTarih(String bitisTarih) {
        this.bitisTarih = bitisTarih;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public String getMinYas() {
        return minYas;
    }

    public void setMinYas(String minYas) {
        this.minYas = minYas;
    }

    public String getMaxYas() {
        return maxYas;
    }

    public void setMaxYas(String maxYas) {
        this.maxYas = maxYas;
    }

    public String getEgitim() {
        return egitim;
    }

    public void setEgitim(String egitim) {
        this.egitim = egitim;
    }

    public String getTecrube() {
        return tecrube;
    }

    public void setTecrube(String tecrube) {
        this.tecrube = tecrube;
    }

    public String getEkbilgi() {
        return ekbilgi;
    }

    public void setEkbilgi(String ekbilgi) {
        this.ekbilgi = ekbilgi;
    }

    public String getDil() {
        return dil;
    }

    public void setDil(String dil) {
        this.dil = dil;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }


}
