package com.example.pc.myapplication;

/**
 * Created by pc on 3.3.2016.
 */
public class TecrubeSinif {

    private Integer id;
    private String sirketAdi;
    private String pozisyon;
    private String baslamatarih;
    private String bitistarih;

    public TecrubeSinif(Integer id, String sirketAdi, String pozisyon, String baslamatarih, String bitistarih) {
        this.id = id;
        this.sirketAdi = sirketAdi;
        this.pozisyon = pozisyon;
        this.baslamatarih = baslamatarih;
        this.bitistarih = bitistarih;
    }


    public void setTecrubeSinif(Integer id, String sirketAdi, String pozisyon, String baslamatarih, String bitistarih) {
        this.id = id;
        this.sirketAdi = sirketAdi;
        this.pozisyon = pozisyon;
        this.baslamatarih = baslamatarih;
        this.bitistarih = bitistarih;
    }



    public TecrubeSinif() {
        this.id = -1;
        this.sirketAdi = " ";
        this.pozisyon =" ";
        this.baslamatarih = " ";
        this.bitistarih = " ";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSirketAdi() {
        return sirketAdi;
    }

    public void setSirketAdi(String sirketAdi) {
        this.sirketAdi = sirketAdi;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }

    public String getBaslamatarih() {
        return baslamatarih;
    }

    public void setBaslamatarih(String baslamatarih) {
        this.baslamatarih = baslamatarih;
    }

    public String getBitistarih() {
        return bitistarih;
    }

    public void setBitistarih(String bitistarih) {
        this.bitistarih = bitistarih;
    }
}
