package com.example.pc.myapplication;

/**
 * Created by pc on 13.3.2016.
 */
public class mesaiClass {

    private Integer id;
    private Integer sicilNo;
    private String mesai;
    private String bastarih;
    private String bitisTarih;
    private Integer ucret;
    private String tip;


    public mesaiClass(Integer id, Integer sicilNo, String mesai, String bastarih, String bitisTarih, Integer ucret, String tip) {
        this.id = id;
        this.sicilNo = sicilNo;
        this.mesai = mesai;
        this.bastarih = bastarih;
        this.bitisTarih = bitisTarih;
        this.ucret = ucret;
        this.tip = tip;
    }


    public void setmesaiClass( Integer sicilNo, String mesai, String bastarih, String bitisTarih, Integer ucret, String tip) {

        this.sicilNo = sicilNo;
        this.mesai = mesai;
        this.bastarih = bastarih;
        this.bitisTarih = bitisTarih;
        this.ucret = ucret;
        this.tip = tip;
    }


    public mesaiClass() {
        this.id = -1;
        this.sicilNo = -1;
        this.mesai = " ";
        this.bastarih = " ";
        this.bitisTarih = " ";
        this.ucret = -1;
        this.tip = " ";
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

    public String getMesai() {
        return mesai;
    }

    public void setMesai(String mesai) {
        this.mesai = mesai;
    }

    public String getBastarih() {
        return bastarih;
    }

    public void setBastarih(String bastarih) {
        this.bastarih = bastarih;
    }

    public String getBitisTarih() {
        return bitisTarih;
    }

    public void setBitisTarih(String bitisTarih) {
        this.bitisTarih = bitisTarih;
    }

    public Integer getUcret() {
        return ucret;
    }

    public void setUcret(Integer ucret) {
        this.ucret = ucret;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
