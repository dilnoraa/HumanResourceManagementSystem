package com.example.pc.myapplication;

/**
 * Created by pc on 6.3.2016.
 */
public class gorusmeClass {


    private Integer gorusmeId;
    private Integer basvuranId;
    private Integer ilanId;
    private Integer hesapNoId;
    private String tarih;
    private String saat;
    private String durum;


    public gorusmeClass(Integer gorusmeId, Integer basvuranId, Integer ilanId, Integer hesapNoId,String tarih, String saat, String durum) {
        this.gorusmeId = gorusmeId;
        this.basvuranId = basvuranId;
        this.ilanId = ilanId;
        this.hesapNoId=hesapNoId;
        this.tarih = tarih;
        this.saat = saat;
        this.durum = durum;
    }

    public void setgorusmeClass(Integer gorusmeId, Integer basvuranId, Integer ilanId, Integer hesapNoId,String tarih, String saat, String durum) {
        this.gorusmeId = gorusmeId;
        this.basvuranId = basvuranId;
        this.ilanId = ilanId;
        this.hesapNoId=hesapNoId;
        this.tarih = tarih;
        this.saat = saat;
        this.durum = durum;
    }


    public gorusmeClass() {
        gorusmeId = -1;
        basvuranId =-1;
        ilanId = -1;
        hesapNoId=-1;
        tarih = " ";
        saat =" ";
        durum = " ";
    }

    public Integer getHesapNoId() {
        return hesapNoId;
    }

    public void setHesapNoId(Integer hesapNoId) {
        this.hesapNoId = hesapNoId;
    }

    public Integer getGorusmeId() {
        return gorusmeId;
    }

    public void setGorusmeId(Integer gorusmeId) {
        this.gorusmeId = gorusmeId;
    }

    public Integer getBasvuranId() {
        return basvuranId;
    }

    public void setBasvuranId(Integer basvuranId) {
        this.basvuranId = basvuranId;
    }

    public Integer getIlanId() {
        return ilanId;
    }

    public void setIlanId(Integer ilanId) {
        this.ilanId = ilanId;
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

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
}
