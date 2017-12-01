package com.example.pc.myapplication;

/**
 * Created by pc on 12.3.2016.
 */
public class izinlerClass {


    private Integer id;
    private Integer calisan_id;
    private String bas_tarih;
    private String bitis_tarih;

    public izinlerClass(Integer id, Integer calisan_id, String bas_tarih, String bitis_tarih) {
        this.id = id;
        this.calisan_id = calisan_id;
        this.bas_tarih = bas_tarih;
        this.bitis_tarih = bitis_tarih;
    }

    public void setizinlerClass(Integer id, Integer calisan_id, String bas_tarih, String bitis_tarih) {
        this.id = id;
        this.calisan_id = calisan_id;
        this.bas_tarih = bas_tarih;
        this.bitis_tarih = bitis_tarih;
    }


    public izinlerClass() {
        this.id = -1;
        this.calisan_id = -1;
        this.bas_tarih = " ";
        this.bitis_tarih = " ";
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCalisan_id() {
        return calisan_id;
    }

    public void setCalisan_id(Integer calisan_id) {
        this.calisan_id = calisan_id;
    }

    public String getBas_tarih() {
        return bas_tarih;
    }

    public void setBas_tarih(String bas_tarih) {
        this.bas_tarih = bas_tarih;
    }

    public String getBitis_tarih() {
        return bitis_tarih;
    }

    public void setBitis_tarih(String bitis_tarih) {
        this.bitis_tarih = bitis_tarih;
    }
}
