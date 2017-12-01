package com.example.pc.myapplication;

import java.util.Date;

/**
 * Created by pc on 26.2.2016.
 */
public class egitimSinif {

    private Integer id;
    private String okulAdi;
    private String baslamaTarihi;
    private String bitisTarihi;


    public egitimSinif(Integer id, String okulAdi, String baslamaTarihi, String bitisTarihi) {
        this.id = id;
        this.okulAdi = okulAdi;
        this.baslamaTarihi = baslamaTarihi;
        this.bitisTarihi = bitisTarihi;
    }

    public void setegitimSinif(Integer id, String okulAdi, String baslamaTarihi, String bitisTarihi) {
        this.id = id;
        this.okulAdi = okulAdi;
        this.baslamaTarihi = baslamaTarihi;
        this.bitisTarihi = bitisTarihi;
    }



    public egitimSinif() {
        id = -1;
        okulAdi = " ";
        baslamaTarihi = " ";
        bitisTarihi = " ";

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

    public String getBaslamaTarihi() {
        return baslamaTarihi;
    }

    public void setBaslamaTarihi(String baslamaTarihi) {
        this.baslamaTarihi = baslamaTarihi;
    }

    public String getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(String bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }
}
