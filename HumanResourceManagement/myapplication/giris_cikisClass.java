package com.example.pc.myapplication;

/**
 * Created by pc on 13.3.2016.
 */
public class giris_cikisClass {

    private Integer id;
    private Integer sicilNo;
    private String tarih;
    private String saat;
    private String tur;


    public giris_cikisClass(Integer sicilNo, String tarih, String saat, String tur) {
        this.sicilNo = sicilNo;
        this.tarih = tarih;
        this.saat = saat;
        this.tur = tur;
    }


    public void setgiris_cikisClass(Integer sicilNo, String tarih, String saat, String tur) {
        this.sicilNo = sicilNo;
        this.tarih = tarih;
        this.saat = saat;
        this.tur = tur;
    }


    public giris_cikisClass() {
        this.sicilNo = -1;
        this.tarih = " ";
        this.saat = " ";
        this.tur = " ";
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(Integer sicilNo) {
        this.sicilNo = sicilNo;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }
}
