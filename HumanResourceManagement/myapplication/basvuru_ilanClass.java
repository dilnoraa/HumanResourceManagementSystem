package com.example.pc.myapplication;

/**
 * Created by pc on 19.3.2016.
 */
public class basvuru_ilanClass {

    private Integer id_ilan;
    private Integer id_basvuran;
    private String uygunluk;
    private Integer id_hesap;

    public basvuru_ilanClass(Integer id_ilan, Integer id_basvuran, String uygunluk, Integer id_hesap) {
        this.id_ilan = id_ilan;
        this.id_basvuran = id_basvuran;
        this.uygunluk = uygunluk;
        this.id_hesap = id_hesap;
    }

    public void  setbasvuru_ilanClass(Integer id_ilan, Integer id_basvuran, String uygunluk, Integer id_hesap) {
        this.id_ilan = id_ilan;
        this.id_basvuran = id_basvuran;
        this.uygunluk = uygunluk;
        this.id_hesap = id_hesap;
    }


    public basvuru_ilanClass( ) {
        this.id_ilan = -1;
        this.id_basvuran = -1;
        this.uygunluk = " ";
        this.id_hesap = -1;
    }


    public Integer getId_ilan() {
        return id_ilan;
    }

    public void setId_ilan(Integer id_ilan) {
        this.id_ilan = id_ilan;
    }

    public Integer getId_basvuran() {
        return id_basvuran;
    }

    public void setId_basvuran(Integer id_basvuran) {
        this.id_basvuran = id_basvuran;
    }

    public String getUygunluk() {
        return uygunluk;
    }

    public void setUygunluk(String uygunluk) {
        this.uygunluk = uygunluk;
    }

    public Integer getId_hesap() {
        return id_hesap;
    }

    public void setId_hesap(Integer id_hesap) {
        this.id_hesap = id_hesap;
    }
}
