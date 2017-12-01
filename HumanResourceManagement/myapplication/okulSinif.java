package com.example.pc.myapplication;

/**
 * Created by pc on 12.3.2016.
 */
public class okulSinif {

    private Integer id;
    private String okulAdi;
    private String derece;
    private String baslamatarih;
    private String bitistarih;


    public okulSinif(Integer id, String okulAdi, String derece, String baslamatarih, String bitistarih) {
        this.id = id;
        this.okulAdi = okulAdi;
        this.derece = derece;
        this.baslamatarih = baslamatarih;
        this.bitistarih = bitistarih;
    }

    public void setokulSinif(Integer id, String okulAdi, String derece, String baslamatarih, String bitistarih) {
        this.id = id;
        this.okulAdi = okulAdi;
        this.derece = derece;
        this.baslamatarih = baslamatarih;
        this.bitistarih = bitistarih;
    }


    public okulSinif() {
        this.id = -1;
        this.okulAdi =" ";
        this.derece = " ";
        this.baslamatarih = " ";
        this.bitistarih = " ";
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOkulAdi() {
        return okulAdi;
    }

    public void setOkulAdi(String okulAdi) {
        this.okulAdi = okulAdi;
    }

    public String getDerece() {
        return derece;
    }

    public void setDerece(String derece) {
        this.derece = derece;
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
