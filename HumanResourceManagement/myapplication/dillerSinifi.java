package com.example.pc.myapplication;

/**
 * Created by pc on 28.2.2016.
 */
public class dillerSinifi {


    private Integer id;
    private String dilAdi;
    private String derece;


    public dillerSinifi(Integer id, String dilAdi, String derece) {
        this.id = id;
        this.dilAdi = dilAdi;
        this.derece = derece;
    }




    public void setdillerSinifi(Integer id, String dilAdi, String derece) {
        this.id = id;
        this.dilAdi = dilAdi;
        this.derece = derece;
    }



    public dillerSinifi() {
        this.id = -1;
        this.dilAdi = " ";
        this.derece = " ";
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDilAdi() {
        return dilAdi;
    }

    public void setDilAdi(String dilAdi) {
        this.dilAdi = dilAdi;
    }

    public String getDerece() {
        return derece;
    }

    public void setDerece(String derece) {
        this.derece = derece;
    }
}
