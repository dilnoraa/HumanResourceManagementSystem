package com.example.pc.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by pc on 13.2.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "INSANKAYNAKLARI";
    public static final String TABLE_NAME = "CALISANLARTABLE";
    public static final String COLUMN0 = "ID";
    public static final String COLUMN1 = "NAME";
    public static final String COLUMN2 = "SURNAME";
    public static final String COLUMN3 = "CINSIYET";
    public static final String COLUMN4 = "DOGUMYER";
    public static final String COLUMN5 = "DOGUMTARIH";
    public static final String COLUMN6 = "SURUCUBELGESI";
    public static final String COLUMN7 = "MEDENIDURUM";
    public static final String COLUMN8 = "EVNO";
    public static final String COLUMN9 = "CEPNO";
    public static final String COLUMN10 = "ADRES";
    public static final String COLUMN11 = "EMAIL";
    public static final String COLUMN11E = "EGITIM";
    public static final String COLUMN11H = "HOBI";
    public static final String COLUMN11W = "SITE";
    public static final String COLUMN11D = "DURUM";


    public static final String TABLE_NAME_PERSONEL = "PERSONELTABLE";
    public static final String COLUMN_PERSONEL0 = "IDP";
    public static final String COLUMN_PERSONEL1 = "NAMEP";
    public static final String COLUMN_PERSONEL2 = "SURNAMEP";
    public static final String COLUMN_PERSONEL3 = "CINSIYETP";
    public static final String COLUMN_PERSONEL4 = "DOGUMYERP";
    public static final String COLUMN_PERSONEL5 = "DOGUMTARIHP";
    public static final String COLUMN_PERSONEL6 = "SURUCUBELGESIP";
    public static final String COLUMN_PERSONEL7 = "MEDENIDURUMP";
    public static final String COLUMN_PERSONEL8 = "EGITIMSEVIYEP";
    public static final String COLUMN_PERSONEL9 = "DEPARTMANP";
    public static final String COLUMN_PERSONEL10 = "POZISYONP";
    public static final String COLUMN_PERSONEL11 = "MAASP";
    public static final String COLUMN_PERSONEL12 = "CEPNOP";
    public static final String COLUMN_PERSONEL13 = "EVNOP";
    public static final String COLUMN_PERSONEL14 = "ADRESP";
    public static final String COLUMN_PERSONEL15 = "EMAILP";
    public static final String COLUMN_PERSONEL16 = "SITEP";


    public static final String TABLE_NAME_OKUL_PERSONEL = "PERSONELOKULTABLE";
    public static final String COLUMN_PERSONEL_OKUL0 = "ID_P_OKUL";
    public static final String COLUMN_PERSONEL_OKUL1 = "OKULADI";
    public static final String COLUMN_PERSONEL_OKUL2 = "DERECE";
    public static final String COLUMN_PERSONEL_OKUL3 = "BASLAMATARIH_OKUL";
    public static final String COLUMN_PERSONEL_OKUL4 = "BITISTARIH_OKUL";

    public static final String TABLE_NAME_IZINLER = "IZINLERTABLE";
    public static final String COLUMN_IZINLER0 = "IDIZIN";
    public static final String COLUMN_IZINLER1 = "IDPERSON";
    public static final String COLUMN_IZINLER2 = "BASLAMAIZIN";
    public static final String COLUMN_IZINLER3 = "BITISIZIN";


    public static final String TABLE_NAME_BASVURU = "CALISAN_ILANBASVURU";
    public static final String COLUMN_BASVURU1 = "ID_ILAN";
    public static final String COLUMN_BASVURU2 = "ID_CALISAN";
    public static final String COLUMN_BASVURU3 = "UYGUNLUK";
    public static final String COLUMN_BASVURU4 = "HESAP_ID";



    public static final String TABLE_NAME_EGITIM = "CALISANLAREGITIMTABLE";
    public static final String COLUMN_0 = "IDE";
    public static final String COLUMN_1 = "OKULNAME";
    public static final String COLUMN_2 = "BASLAMATARIH";
    public static final String COLUMN_3 = "BITISTARIH";


    public static final String TABLE_NAME_TECRUBE = "TECRUBETABLE";
    public static final String COLUMN_TECRUBE0 = "IDT";
    public static final String COLUMN_TECRUBE1 = "SIRKETADI";
    public static final String COLUMN_TECRUBE2 = "POZISYON";
    public static final String COLUMN_TECRUBE3 = "BASLAMATARIH";
    public static final String COLUMN_TECRUBE4 = "BITISTARIH";


    public static final String TABLE_NAME_DILLER = "DILLERTABLE";
    public static final String COLUMN_DIL_ID = "IDDIL";
    public static final String COLUMN_DIL_ADI = "DILADI";
    public static final String COLUMN_DIL_DERECE = "DILDERECE";


    public static final String TABLE_NAME2 = "ILANLARTABLE";
    public static final String COLUMN12 = "IDI";
    public static final String COLUMN13 = "ILANBASLAMA";
    public static final String COLUMN14 = "ILANBITIS";
    public static final String COLUMN15 = "KISISAYISI";
    public static final String COLUMN16 = "DEPARTMAN";
    public static final String COLUMN17 = "MINYAS";
    public static final String COLUMN18 = "MAXYAS";
    public static final String COLUMN19 = "CINSIYET";
    public static final String COLUMN20 = "EGITIM";
    public static final String COLUMN21 = "TECRUBE";
    public static final String COLUMN22 = "DILBILGISI";
    public static final String COLUMN23 = "EKBILGI";
    public static final String COLUMN24 = "AKTIFLIK";


    public static final String TABLE_NAME_GORUSME = "GORUSMETABLE";
    public static final String COLUMN_GORUSME0 = "IDG";
    public static final String COLUMN_GORUSME1 = "IDBASVURAN";
    public static final String COLUMN_GORUSME2 = "IDILAN";
    public static final String COLUMN_GORUSME2H = "IDHESAP";
    public static final String COLUMN_GORUSME3 = "TARIH";
    public static final String COLUMN_GORUSME4 = "SAAT";
    public static final String COLUMN_GORUSME5 = "DURUMG";

    public static final String TABLE_NAME_TECRUBE_PERSONEL = "TECRUBE_PERSONELTABLE";
    public static final String COLUMN_TECRUBE_PERSONEL0 = "IDT_P";
    public static final String COLUMN_TECRUBE_PERSONEL1 = "SIRKETADI_P";
    public static final String COLUMN_TECRUBE_PERSONEL2 = "POZISYON_P";
    public static final String COLUMN_TECRUBE_PERSONEL3 = "BASLAMATARIH_P";
    public static final String COLUMN_TECRUBE_PERSONEL4 = "BITISTARIH_P";

    public static final String TABLE_NAME_MESAI = "MESAITABLE";
    public static final String COLUMN_MESAI0 = "IDM";
    public static final String COLUMN_MESAI1 = "SICILNO";
    public static final String COLUMN_MESAI2 = "MESAI";
    public static final String COLUMN_MESAI3 = "BASTARIH";
    public static final String COLUMN_MESAI4 = "BITISTARIH";
    public static final String COLUMN_MESAI5 = "UCRET";
    public static final String COLUMN_MESAI6 = "TIP";


    public static final String TABLE_NAME_GIRISCIKIS = "GIRIS_CIKISTABLE";
    public static final String COLUMN_GIRISCIKIS0 = "IDGC";
    public static final String COLUMN_GIRISCIKIS1 = "SICILNO_GC";
    public static final String COLUMN_GIRISCIKIS2 = "TARIH_GC";
    public static final String COLUMN_GIRISCIKIS3 = "SAAT_GC";
    public static final String COLUMN_GIRISCIKIS4 = "TUR";


    public static final String TABLE_NAME_ISVEREN = "ISVERENTABLE";
    public static final String COLUMN_ISVEREN0 = "ID_ISVEREN";
    public static final String COLUMN_ISVEREN1 = "KULLANICI_ADISVEREN";
    public static final String COLUMN_ISVEREN2 = "SIFRE_ISVEREN";
    public static final String COLUMN_ISVEREN3 = "AD_ISVEREN";
    public static final String COLUMN_ISVEREN4 = "SOYAD_ISVEREN";

    public static final String TABLE_NAME_UYE = "UYETABLE";
    public static final String COLUMN_UYE0 = "ID_UYE";
    public static final String COLUMN_UYE1 = "KULLANICI_ADUYE";
    public static final String COLUMN_UYE2 = "SIFRE_UYE";
    public static final String COLUMN_UYE3 = "AD_UYE";
    public static final String COLUMN_UYE4 = "SOYAD_UYE";
    public static final String COLUMN_UYE5 = "POSTA_UYE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db=this.getWritableDatabase();
        Log.d("veritabani", " yaratildi");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        // db.execSQL("create table " + TABLE_NAME_EGITIM + " (ID INTEGER PRIMARY KEY autoincrement,NAME TEXT,SURNAME TEXT);");
        db.execSQL("create table CALISANLARTABLE (ID INTEGER PRIMARY KEY autoincrement,NAME TEXT,SURNAME TEXT,CINSIYET TEXT,DOGUMYER TEXT,DOGUMTARIH TEXT,SURUCUBELGESI TEXT,MEDENIDURUM TEXT,EVNO TEXT,CEPNO TEXT,ADRES TEXT,EMAIL TEXT,EGITIM TEXT,HOBI TEXT, SITE TEXT, DURUM TEXT);");
        db.execSQL("create table ILANLARTABLE (IDI INTEGER PRIMARY KEY autoincrement,ILANBASLAMA TEXT,ILANBITIS TEXT,KISISAYISI TEXT,DEPARTMAN TEXT,MINYAS TEXT,MAXYAS TEXT,CINSIYET TEXT,EGITIM TEXT,TECRUBE TEXT,DILBILGISI TEXT,EKBILGI TEXT,AKTIFLIK TEXT);");
        db.execSQL("create table CALISANLAREGITIMTABLE (IDE INTEGER,OKULNAME TEXT,BASLAMATARIH TEXT,BITISTARIH TEXT,PRIMARY KEY (IDE, OKULNAME))");
        db.execSQL("create table DILLERTABLE (IDDIL INTEGER,DILADI TEXT,DILDERECE TEXT,PRIMARY KEY (IDDIL, DILADI))");
        db.execSQL("create table CALISAN_ILANBASVURU (ID_ILAN INTEGER,ID_CALISAN INTEGER,UYGUNLUK TEXT DEFAULT 'BELIRSIZ',HESAP_ID INTEGER,PRIMARY KEY (ID_ILAN, HESAP_ID))");
        db.execSQL("create table TECRUBETABLE (IDT INTEGER,SIRKETADI TEXT,POZISYON TEXT,BASLAMATARIH TEXT,BITISTARIH TEXT,PRIMARY KEY (IDT, SIRKETADI))");
        db.execSQL("create table GORUSMETABLE (IDG INTEGER PRIMARY KEY autoincrement,IDBASVURAN INTEGER,IDILAN INTEGER,IDHESAP INTEGER,TARIH TEXT,SAAT TEXT,DURUMG TEXT);");
        db.execSQL("create table PERSONELTABLE (IDP INTEGER PRIMARY KEY,NAMEP TEXT,SURNAMEP TEXT,CINSIYETP TEXT,DOGUMYERP TEXT,DOGUMTARIHP TEXT,SURUCUBELGESIP TEXT,MEDENIDURUMP TEXT,EGITIMSEVIYEP TEXT,DEPARTMANP TEXT,POZISYONP TEXT,MAASP TEXT,CEPNOP TEXT,EVNOP TEXT,ADRESP TEXT,EMAILP TEXT,SITEP TEXT);");
        db.execSQL("create table IZINLERTABLE (IDIZIN INTEGER PRIMARY KEY autoincrement,IDPERSON INTEGER,BASLAMAIZIN TEXT,BITISIZIN TEXT);");
        db.execSQL("create table PERSONELOKULTABLE (ID_P_OKUL INTEGER,OKULADI TEXT,DERECE TEXT,BASLAMATARIH_OKUL TEXT,BITISTARIH_OKUL TEXT,PRIMARY KEY (ID_P_OKUL, OKULADI))");

        db.execSQL("create table TECRUBE_PERSONELTABLE (IDT_P INTEGER,SIRKETADI_P TEXT,POZISYON_P TEXT,BASLAMATARIH_P TEXT,BITISTARIH_P TEXT,PRIMARY KEY (IDT_P, SIRKETADI_P))");

        db.execSQL("create table MESAITABLE (IDM INTEGER PRIMARY KEY autoincrement,SICILNO INTEGER,MESAI TEXT,BASTARIH TEXT,BITISTARIH TEXT,UCRET INTEGER,TIP TEXT);");


        db.execSQL("create table GIRIS_CIKISTABLE (IDGC INTEGER PRIMARY KEY autoincrement,SICILNO_GC INTEGER,TARIH_GC TEXT,SAAT_GC TEXT,TUR TEXT);");

        db.execSQL("create table ISVERENTABLE (ID_ISVEREN INTEGER PRIMARY KEY,KULLANICI_ADISVEREN TEXT,SIFRE_ISVEREN TEXT,AD_ISVEREN TEXT,SOYAD_ISVEREN TEXT);");



        db.execSQL("create table UYETABLE (ID_UYE INTEGER PRIMARY KEY autoincrement,KULLANICI_ADUYE TEXT,SIFRE_UYE TEXT,AD_UYE TEXT,SOYAD_UYE TEXT,POSTA_UYE TEXT);");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_EGITIM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_DILLER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_BASVURU);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_TECRUBE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_GORUSME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PERSONEL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_IZINLER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_OKUL_PERSONEL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_TECRUBE_PERSONEL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MESAI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_GIRISCIKIS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ISVEREN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_UYE);


        onCreate(db);

    }


    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME_ISVEREN, null, null);

        db.close();
    }



    public ArrayList<uyeClass> getuyeBilgilerbyId(int position) {
        ArrayList<uyeClass> BilgilerList = new ArrayList<uyeClass>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.query(TABLE_NAME_UYE, new String[]{COLUMN_UYE0, COLUMN_UYE1, COLUMN_UYE2, COLUMN_UYE3, COLUMN_UYE4, COLUMN_UYE5}, COLUMN_UYE0 + "=?",
                new String[]{String.valueOf(position)}, null, null, null, null);

        if (cr.moveToFirst()) {
            do {

                uyeClass uyeBil = new uyeClass();
                uyeBil.setuyeClass(cr.getInt(cr.getColumnIndex(COLUMN_UYE0)), cr.getString(cr.getColumnIndex(COLUMN_UYE1)), cr.getString(cr.getColumnIndex(COLUMN_UYE2)), cr.getString(cr.getColumnIndex(COLUMN_UYE3)), cr.getString(cr.getColumnIndex(COLUMN_UYE4)),cr.getString(cr.getColumnIndex(COLUMN_UYE5)));

                BilgilerList.add(uyeBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }



    public ArrayList<uyeClass> getAlluyeBilgiler() {
        ArrayList<uyeClass> BilgilerList = new ArrayList<uyeClass>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME_UYE, null);

        if (cr.moveToFirst()) {
            do {
                uyeClass uyeBil = new uyeClass();
                uyeBil.setuyeClass(cr.getInt(cr.getColumnIndex(COLUMN_UYE0)), cr.getString(cr.getColumnIndex(COLUMN_UYE1)), cr.getString(cr.getColumnIndex(COLUMN_UYE2)), cr.getString(cr.getColumnIndex(COLUMN_UYE3)), cr.getString(cr.getColumnIndex(COLUMN_UYE4)),cr.getString(cr.getColumnIndex(COLUMN_UYE5)));

                BilgilerList.add(uyeBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }

    public void informationPutUye(DatabaseHelper database, uyeClass gelen_bilgiler) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put(COLUMN_UYE1, gelen_bilgiler.getKullanici_ad());
        cv.put(COLUMN_UYE2, gelen_bilgiler.getSifre());
        cv.put(COLUMN_UYE3, gelen_bilgiler.getAd());
        cv.put(COLUMN_UYE4, gelen_bilgiler.getSoyad());
        cv.put(COLUMN_UYE5, gelen_bilgiler.getPosta());


        long k = db.insert(TABLE_NAME_UYE, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }



    public ArrayList<isverenClass> getisverenBilgilerbyId(int position) {
        ArrayList<isverenClass> BilgilerList = new ArrayList<isverenClass>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.query(TABLE_NAME_ISVEREN, new String[]{COLUMN_ISVEREN0, COLUMN_ISVEREN1, COLUMN_ISVEREN2, COLUMN_ISVEREN3, COLUMN_ISVEREN4}, COLUMN_ISVEREN0 + "=?",
                new String[]{String.valueOf(position)}, null, null, null, null);

        if (cr.moveToFirst()) {
            do {

                isverenClass isverenBil = new isverenClass();
                isverenBil.setisverenClass(cr.getInt(cr.getColumnIndex(COLUMN_ISVEREN0)),cr.getString(cr.getColumnIndex(COLUMN_ISVEREN1)),cr.getString(cr.getColumnIndex(COLUMN_ISVEREN2)),cr.getString(cr.getColumnIndex(COLUMN_ISVEREN3)),cr.getString(cr.getColumnIndex(COLUMN_ISVEREN4)));
                BilgilerList.add(isverenBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }


    public void informationPutGirisCikis(DatabaseHelper database, giris_cikisClass gelen_bilgiler) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_GIRISCIKIS1, gelen_bilgiler.getSicilNo());
        cv.put(COLUMN_GIRISCIKIS2, gelen_bilgiler.getTarih());
        cv.put(COLUMN_GIRISCIKIS3, gelen_bilgiler.getSaat());
        cv.put(COLUMN_GIRISCIKIS4, gelen_bilgiler.getTur());


        long k = db.insert(TABLE_NAME_GIRISCIKIS, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }


      public void informationPutIsveren(DatabaseHelper database, isverenClass gelen_bilgiler) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ISVEREN0, gelen_bilgiler.getId());
        cv.put(COLUMN_ISVEREN1, gelen_bilgiler.getKullanici_ad());
        cv.put(COLUMN_ISVEREN2, gelen_bilgiler.getSifre());
        cv.put(COLUMN_ISVEREN3, gelen_bilgiler.getAd());
        cv.put(COLUMN_ISVEREN4, gelen_bilgiler.getSoyad());


        long k = db.insert(TABLE_NAME_ISVEREN, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }


    public ArrayList<isverenClass> getAllisverenBilgiler() {
        ArrayList<isverenClass> BilgilerList = new ArrayList<isverenClass>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME_ISVEREN, null);

        if (cr.moveToFirst()) {
            do {
                isverenClass isverenBil = new isverenClass();
                isverenBil.setisverenClass(cr.getInt(cr.getColumnIndex(COLUMN_ISVEREN0)), cr.getString(cr.getColumnIndex(COLUMN_ISVEREN1)), cr.getString(cr.getColumnIndex(COLUMN_ISVEREN2)), cr.getString(cr.getColumnIndex(COLUMN_ISVEREN3)), cr.getString(cr.getColumnIndex(COLUMN_ISVEREN4)));
                BilgilerList.add(isverenBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }


    public ArrayList<giris_cikisClass> getAllgiris_cikisBilgiler() {
        ArrayList<giris_cikisClass> BilgilerList = new ArrayList<giris_cikisClass>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME_GIRISCIKIS, null);

        if (cr.moveToFirst()) {
            do {
                giris_cikisClass gcBil = new giris_cikisClass();
                gcBil.setgiris_cikisClass(cr.getInt(cr.getColumnIndex(COLUMN_GIRISCIKIS1)), cr.getString(cr.getColumnIndex(COLUMN_GIRISCIKIS2)), cr.getString(cr.getColumnIndex(COLUMN_GIRISCIKIS3)), cr.getString(cr.getColumnIndex(COLUMN_GIRISCIKIS4)));
                BilgilerList.add(gcBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }


    public ArrayList<mesaiClass> getAllmesaiBilgiler() {
        ArrayList<mesaiClass> BilgilerList = new ArrayList<mesaiClass>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME_MESAI, null);

        if (cr.moveToFirst()) {
            do {
                mesaiClass mBil = new mesaiClass();
                mBil.setmesaiClass(cr.getInt(cr.getColumnIndex(COLUMN_MESAI1)), cr.getString(cr.getColumnIndex(COLUMN_MESAI2)), cr.getString(cr.getColumnIndex(COLUMN_MESAI3)), cr.getString(cr.getColumnIndex(COLUMN_MESAI4)), cr.getInt(cr.getColumnIndex(COLUMN_MESAI5)), cr.getString(cr.getColumnIndex(COLUMN_MESAI6)));
                BilgilerList.add(mBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }


    public void informationPutMesai(DatabaseHelper database, mesaiClass gelen_bilgiler) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_MESAI1, gelen_bilgiler.getSicilNo());
        cv.put(COLUMN_MESAI2, gelen_bilgiler.getMesai());
        cv.put(COLUMN_MESAI3, gelen_bilgiler.getBastarih());
        cv.put(COLUMN_MESAI4, gelen_bilgiler.getBitisTarih());
        cv.put(COLUMN_MESAI5, gelen_bilgiler.getUcret());
        cv.put(COLUMN_MESAI6, gelen_bilgiler.getTip());

        long k = db.insert(TABLE_NAME_MESAI, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }


    public ArrayList<okulSinif> getpersonelOkulbyId(int position) {

        ArrayList<okulSinif> BilgilerList = new ArrayList<okulSinif>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.query(TABLE_NAME_OKUL_PERSONEL, new String[]{COLUMN_PERSONEL_OKUL0, COLUMN_PERSONEL_OKUL1, COLUMN_PERSONEL_OKUL2, COLUMN_PERSONEL_OKUL3, COLUMN_PERSONEL_OKUL4}, COLUMN_PERSONEL_OKUL0 + "=?",
                new String[]{String.valueOf(position)}, null, null, null, null);

        if (cr.moveToFirst()) {
            do {
                okulSinif okulBil = new okulSinif();
                okulBil.setokulSinif(cr.getInt(cr.getColumnIndex(COLUMN_PERSONEL_OKUL0)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL_OKUL1)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL_OKUL2)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL_OKUL3)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL_OKUL4)));
                BilgilerList.add(okulBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }



    public ArrayList<basvuru_ilanClass> getbasvuru_ilanbyId(int position1,int position2) {

        ArrayList<basvuru_ilanClass> BilgilerList = new ArrayList<basvuru_ilanClass>();

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQ = "SELECT  * FROM " + TABLE_NAME_BASVURU + " WHERE "
                + COLUMN_BASVURU1 + "=" + String.valueOf(position1) + " AND " + COLUMN_BASVURU4 + "=" + String.valueOf(position2) + ";";

        Cursor cr = db.rawQuery(selectQ, null);

        if (cr.moveToFirst()) {
            do {
                basvuru_ilanClass Bil = new basvuru_ilanClass();
                Bil.setbasvuru_ilanClass(cr.getInt(cr.getColumnIndex(COLUMN_BASVURU1)),cr.getInt(cr.getColumnIndex(COLUMN_BASVURU2)),cr.getString(cr.getColumnIndex(COLUMN_BASVURU3)),cr.getInt(cr.getColumnIndex(COLUMN_BASVURU4)));
                ;
                BilgilerList.add(Bil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }




    public void informationPutOkulPersonel(DatabaseHelper database, okulSinif gelen_bilgiler) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PERSONEL_OKUL0, gelen_bilgiler.getId());
        cv.put(COLUMN_PERSONEL_OKUL1, gelen_bilgiler.getOkulAdi());
        cv.put(COLUMN_PERSONEL_OKUL2, gelen_bilgiler.getDerece());
        cv.put(COLUMN_PERSONEL_OKUL3, gelen_bilgiler.getBaslamatarih());
        cv.put(COLUMN_PERSONEL_OKUL4, gelen_bilgiler.getBitistarih());

        long k = db.insert(TABLE_NAME_OKUL_PERSONEL, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }


    public ArrayList<personelClass> getPersonelBilgiler() {
        ArrayList<personelClass> BilgilerList = new ArrayList<personelClass>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME_PERSONEL, null);

        if (cr.moveToFirst()) {
            do {
                personelClass pBil = new personelClass();
                pBil.setpersonelClass(cr.getInt(cr.getColumnIndex(COLUMN_PERSONEL0)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL1)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL2)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL3)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL4)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL5)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL6)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL7)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL8)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL9)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL10)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL11)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL12)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL13)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL14)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL15)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL16)));
                BilgilerList.add(pBil);
            } while (cr.moveToNext());
        }


        return BilgilerList;


    }


    public ArrayList<izinlerClass> getizinlerBilgiler() {
        ArrayList<izinlerClass> BilgilerList = new ArrayList<izinlerClass>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME_IZINLER, null);

        if (cr.moveToFirst()) {
            do {
                izinlerClass izinBil = new izinlerClass();
                izinBil.setizinlerClass(cr.getInt(cr.getColumnIndex(COLUMN_IZINLER0)), cr.getInt(cr.getColumnIndex(COLUMN_IZINLER1)), cr.getString(cr.getColumnIndex(COLUMN_IZINLER2)), cr.getString(cr.getColumnIndex(COLUMN_IZINLER2)));
                BilgilerList.add(izinBil);
            } while (cr.moveToNext());
        }


        return BilgilerList;


    }


    personelClass getpersonelBilgiById(int position) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME_PERSONEL, new String[]{COLUMN_PERSONEL0, COLUMN_PERSONEL1, COLUMN_PERSONEL2, COLUMN_PERSONEL3, COLUMN_PERSONEL4, COLUMN_PERSONEL5, COLUMN_PERSONEL6, COLUMN_PERSONEL7, COLUMN_PERSONEL8, COLUMN_PERSONEL9, COLUMN_PERSONEL10,
                        COLUMN_PERSONEL11, COLUMN_PERSONEL12, COLUMN_PERSONEL13, COLUMN_PERSONEL14, COLUMN_PERSONEL15, COLUMN_PERSONEL16}, COLUMN_PERSONEL0 + "=?",
                new String[]{String.valueOf(position)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        personelClass calisanB = new personelClass();

        calisanB.setpersonelClass(cursor.getInt(cursor.getColumnIndex(COLUMN_PERSONEL0)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL1)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL2)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL3)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL4)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL5)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL6)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL7)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL8)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL9)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL10)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL11)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL12)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL13)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL14)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL15)), cursor.getString(cursor.getColumnIndex(COLUMN_PERSONEL16)));

        // closeDB();
        return calisanB;
    }


    public void informationPutIzinler(DatabaseHelper database, Integer id, String baslangic, String bitis) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_IZINLER1, id);
        cv.put(COLUMN_IZINLER2, baslangic);
        cv.put(COLUMN_IZINLER3, bitis);


        long k = db.insert(TABLE_NAME_IZINLER, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }

    public void deleteGorusmebyid(DatabaseHelper database, String gelen_id) {


        SQLiteDatabase db = database.getWritableDatabase();
        db.delete(TABLE_NAME_GORUSME, "IDG = ?", new String[]{gelen_id});
        closeDB();
        //  database.close();

    }


    public void informationPutGorusme(DatabaseHelper database, gorusmeClass gelen_bilgiler) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_GORUSME1, gelen_bilgiler.getBasvuranId());
        cv.put(COLUMN_GORUSME2, gelen_bilgiler.getIlanId());
        cv.put(COLUMN_GORUSME2H, gelen_bilgiler.getHesapNoId());
        cv.put(COLUMN_GORUSME3, gelen_bilgiler.getTarih());
        cv.put(COLUMN_GORUSME4, gelen_bilgiler.getSaat());
        cv.put(COLUMN_GORUSME5, gelen_bilgiler.getDurum());

        long k = db.insert(TABLE_NAME_GORUSME, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }


    public ArrayList<gorusmeClass> getAllgorusmeBilgiler() {
        ArrayList<gorusmeClass> BilgilerList = new ArrayList<gorusmeClass>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME_GORUSME, null);

        if (cr.moveToFirst()) {
            do {
                gorusmeClass gBil = new gorusmeClass();
                gBil.setgorusmeClass(cr.getInt(cr.getColumnIndex(COLUMN_GORUSME0)), cr.getInt(cr.getColumnIndex(COLUMN_GORUSME1)), cr.getInt(cr.getColumnIndex(COLUMN_GORUSME2)),cr.getInt(cr.getColumnIndex(COLUMN_GORUSME2H)), cr.getString(cr.getColumnIndex(COLUMN_GORUSME3)), cr.getString(cr.getColumnIndex(COLUMN_GORUSME4)), cr.getString(cr.getColumnIndex(COLUMN_GORUSME5)));
                BilgilerList.add(gBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }


    public void informationPutBasvuru(DatabaseHelper database, Integer gelen_idilan, Integer gelen_idcalisan, Integer gelen_hesap) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_BASVURU1, gelen_idilan);
        cv.put(COLUMN_BASVURU2, gelen_idcalisan);
        cv.put(COLUMN_BASVURU4, gelen_hesap);
        long k = db.insert(TABLE_NAME_BASVURU, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }


    public void updateBasvuruBilgisi(DatabaseHelper database, String uygunluk, int ilanid, int hesapNo) {

        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put(COLUMN_BASVURU3, uygunluk);


        long k = db.update(TABLE_NAME_BASVURU, cv, COLUMN_BASVURU1 + "=" + ilanid + " and " + COLUMN_BASVURU4 + "=" + hesapNo, null);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
    }









    public Cursor getbasvuruilanBilgi(DatabaseHelper db) {
        SQLiteDatabase database = db.getReadableDatabase();
        String columns[] = {COLUMN_BASVURU1, COLUMN_BASVURU2, COLUMN_BASVURU3, COLUMN_BASVURU4};
        Cursor cr = database.query(TABLE_NAME_BASVURU, columns, null, null, null, null, null);
        // closeDB();
        return cr;
    }

    public void informationPutYeniilan(DatabaseHelper database, yeniilanClass gelen_bilgiler) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN13, gelen_bilgiler.getBaslangicTarih());
        cv.put(COLUMN14, gelen_bilgiler.getBitisTarih());
        cv.put(COLUMN15, gelen_bilgiler.getKisiSayi());
        cv.put(COLUMN16, gelen_bilgiler.getDepartman());
        cv.put(COLUMN17, gelen_bilgiler.getMinYas());
        cv.put(COLUMN18, gelen_bilgiler.getMaxYas());
        cv.put(COLUMN19, gelen_bilgiler.getCinsiyet());
        cv.put(COLUMN20, gelen_bilgiler.getEgitim());
        cv.put(COLUMN21, gelen_bilgiler.getTecrube());
        cv.put(COLUMN22, gelen_bilgiler.getDil());
        cv.put(COLUMN23, gelen_bilgiler.getEkbilgi());
        cv.put(COLUMN24, gelen_bilgiler.getAktiflik());
        long k = db.insert(TABLE_NAME2, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }


    public void informationPutPersonel(DatabaseHelper database, personelClass gelen_bilgiler) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PERSONEL0, gelen_bilgiler.getSicil());
        cv.put(COLUMN_PERSONEL1, gelen_bilgiler.getAd());
        cv.put(COLUMN_PERSONEL2, gelen_bilgiler.getSoyad());
        cv.put(COLUMN_PERSONEL3, gelen_bilgiler.getCinsiyet());
        cv.put(COLUMN_PERSONEL4, gelen_bilgiler.getDogumYeri());
        cv.put(COLUMN_PERSONEL5, gelen_bilgiler.getDogumTarih());
        cv.put(COLUMN_PERSONEL6, gelen_bilgiler.getSurucuBelgesi());
        cv.put(COLUMN_PERSONEL7, gelen_bilgiler.getMedeniDurum());
        cv.put(COLUMN_PERSONEL8, gelen_bilgiler.getEgitimSeviye());
        cv.put(COLUMN_PERSONEL9, gelen_bilgiler.getDepartman());
        cv.put(COLUMN_PERSONEL10, gelen_bilgiler.getPozisyon());
        cv.put(COLUMN_PERSONEL11, gelen_bilgiler.getMaas());
        cv.put(COLUMN_PERSONEL12, gelen_bilgiler.getCepNumarasi());
        cv.put(COLUMN_PERSONEL13, gelen_bilgiler.getEvNumarasi());
        cv.put(COLUMN_PERSONEL14, gelen_bilgiler.getAdres());
        cv.put(COLUMN_PERSONEL15, gelen_bilgiler.getEmail());
        cv.put(COLUMN_PERSONEL16, gelen_bilgiler.getWebSite());

        long k = db.insert(TABLE_NAME_PERSONEL, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }


    public Cursor getIdbilgi(DatabaseHelper db) {

        SQLiteDatabase database = db.getReadableDatabase();

        String columns[] = {COLUMN12};
        Cursor cr = database.query(TABLE_NAME2, columns, null, null, null, null, null);
        //  cr.close();
        // closeDB();
        return cr;
    }

    public ArrayList<ilanGoster> getSomeyeniilanBilgiler() {
        ArrayList<ilanGoster> BilgilerList = new ArrayList<ilanGoster>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select ILANBASLAMA,ILANBITIS,KISISAYISI,EGITIM,DEPARTMAN,AKTIFLIK from " + TABLE_NAME2, null);

        if (cr.moveToFirst()) {
            do {
                ilanGoster ilanBil = new ilanGoster();
                ilanBil.setilanGoster(cr.getString(cr.getColumnIndex(COLUMN13)), cr.getString(cr.getColumnIndex(COLUMN14)), cr.getString(cr.getColumnIndex(COLUMN15)), cr.getString(cr.getColumnIndex(COLUMN20)), cr.getString(cr.getColumnIndex(COLUMN16)), cr.getString(cr.getColumnIndex(COLUMN24)));
                BilgilerList.add(ilanBil);
            } while (cr.moveToNext());
        }


        return BilgilerList;


    }


    basvuranBilgileri getcalisanBilgiById(int position) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN1, COLUMN2, COLUMN3, COLUMN4, COLUMN5, COLUMN6, COLUMN7, COLUMN8, COLUMN9, COLUMN10,
                        COLUMN11, COLUMN11E, COLUMN11H, COLUMN11W, COLUMN11D}, COLUMN0 + "=?",
                new String[]{String.valueOf(position)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        basvuranBilgileri calisanB = new basvuranBilgileri();

        calisanB.setBasvuranBilgileri(cursor.getString(cursor.getColumnIndex(COLUMN1)), cursor.getString(cursor.getColumnIndex(COLUMN2)), cursor.getString(cursor.getColumnIndex(COLUMN3)), cursor.getString(cursor.getColumnIndex(COLUMN4)), cursor.getString(cursor.getColumnIndex(COLUMN5)), cursor.getString(cursor.getColumnIndex(COLUMN6)), cursor.getString(cursor.getColumnIndex(COLUMN7)), cursor.getString(cursor.getColumnIndex(COLUMN8)), cursor.getString(cursor.getColumnIndex(COLUMN9)), cursor.getString(cursor.getColumnIndex(COLUMN10)), cursor.getString(cursor.getColumnIndex(COLUMN11)), cursor.getString(cursor.getColumnIndex(COLUMN11E)), cursor.getString(cursor.getColumnIndex(COLUMN11H)), cursor.getString(cursor.getColumnIndex(COLUMN11W)), cursor.getString(cursor.getColumnIndex(COLUMN11D)));

        // closeDB();
        return calisanB;
    }


    public ArrayList<egitimSinif> getAllegitimBilgilerbyId(int position) {
        ArrayList<egitimSinif> BilgilerList = new ArrayList<egitimSinif>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.query(TABLE_NAME_EGITIM, new String[]{COLUMN_0, COLUMN_1, COLUMN_2, COLUMN_3}, COLUMN_0 + "=?",
                new String[]{String.valueOf(position)}, null, null, null, null);

        if (cr.moveToFirst()) {
            do {
                egitimSinif eBil = new egitimSinif();
                eBil.setegitimSinif(cr.getInt(cr.getColumnIndex(COLUMN_0)), cr.getString(cr.getColumnIndex(COLUMN_1)), cr.getString(cr.getColumnIndex(COLUMN_2)), cr.getString(cr.getColumnIndex(COLUMN_3)));
                BilgilerList.add(eBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }


    public ArrayList<dillerSinifi> getAlldilBilgilerbyId(int position) {
        ArrayList<dillerSinifi> BilgilerList = new ArrayList<dillerSinifi>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.query(TABLE_NAME_DILLER, new String[]{COLUMN_DIL_ID, COLUMN_DIL_ADI, COLUMN_DIL_DERECE}, COLUMN_DIL_ID + "=?",
                new String[]{String.valueOf(position)}, null, null, null, null);

        if (cr.moveToFirst()) {
            do {
                dillerSinifi dilBil = new dillerSinifi();
                dilBil.setdillerSinifi(cr.getInt(cr.getColumnIndex(COLUMN_DIL_ID)), cr.getString(cr.getColumnIndex(COLUMN_DIL_ADI)), cr.getString(cr.getColumnIndex(COLUMN_DIL_DERECE)));
                BilgilerList.add(dilBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }


    public ArrayList<TecrubeSinif> getAlltecrubebyId(int position) {
        ArrayList<TecrubeSinif> BilgilerList = new ArrayList<TecrubeSinif>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.query(TABLE_NAME_TECRUBE, new String[]{COLUMN_TECRUBE0, COLUMN_TECRUBE1, COLUMN_TECRUBE2, COLUMN_TECRUBE3, COLUMN_TECRUBE4}, COLUMN_TECRUBE0 + "=?",
                new String[]{String.valueOf(position)}, null, null, null, null);

        if (cr.moveToFirst()) {
            do {
                TecrubeSinif tecrubeBil = new TecrubeSinif();
                tecrubeBil.setTecrubeSinif(cr.getInt(cr.getColumnIndex(COLUMN_TECRUBE0)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE1)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE2)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE3)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE4)));
                BilgilerList.add(tecrubeBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }


    public ArrayList<TecrubeSinif> getAlltecrubePersonelbyId(int position) {
        ArrayList<TecrubeSinif> BilgilerList = new ArrayList<TecrubeSinif>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.query(TABLE_NAME_TECRUBE_PERSONEL, new String[]{COLUMN_TECRUBE_PERSONEL0, COLUMN_TECRUBE_PERSONEL1, COLUMN_TECRUBE_PERSONEL2, COLUMN_TECRUBE_PERSONEL3, COLUMN_TECRUBE_PERSONEL4}, COLUMN_TECRUBE_PERSONEL0 + "=?",
                new String[]{String.valueOf(position)}, null, null, null, null);

        if (cr.moveToFirst()) {
            do {
                TecrubeSinif tecrubeBil = new TecrubeSinif();
                tecrubeBil.setTecrubeSinif(cr.getInt(cr.getColumnIndex(COLUMN_TECRUBE_PERSONEL0)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE_PERSONEL1)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE_PERSONEL2)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE_PERSONEL3)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE_PERSONEL4)));
                BilgilerList.add(tecrubeBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;
    }


    public ArrayList<yeniilanClass> getAllyeniilanBilgiler() {
        ArrayList<yeniilanClass> BilgilerList = new ArrayList<yeniilanClass>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME2, null);

        if (cr.moveToFirst()) {
            do {
                yeniilanClass ilanBil = new yeniilanClass();
                ilanBil.setYeniilanClass(cr.getString(cr.getColumnIndex(COLUMN13)), cr.getString(cr.getColumnIndex(COLUMN14)), cr.getString(cr.getColumnIndex(COLUMN15)), cr.getString(cr.getColumnIndex(COLUMN16)), cr.getString(cr.getColumnIndex(COLUMN17)), cr.getString(cr.getColumnIndex(COLUMN18)), cr.getString(cr.getColumnIndex(COLUMN19)), cr.getString(cr.getColumnIndex(COLUMN20)), cr.getString(cr.getColumnIndex(COLUMN21)), cr.getString(cr.getColumnIndex(COLUMN22)), cr.getString(cr.getColumnIndex(COLUMN23)), cr.getString(cr.getColumnIndex(COLUMN24)));
                BilgilerList.add(ilanBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }

    yeniilanClass getIlanBilgibyId(int position) {

        SQLiteDatabase db = this.getReadableDatabase();
        // SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME2, new String[]{COLUMN12, COLUMN13, COLUMN14, COLUMN15, COLUMN16, COLUMN17, COLUMN18, COLUMN19, COLUMN20, COLUMN21,
                        COLUMN22, COLUMN23, COLUMN24}, COLUMN12 + "=?",
                new String[]{String.valueOf(position)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        yeniilanClass bir_nesne = new yeniilanClass();

        bir_nesne.setBaslangicTarih(cursor.getString(cursor.getColumnIndex(COLUMN13)));
        bir_nesne.setBitisTarih(cursor.getString(cursor.getColumnIndex(COLUMN14)));
        bir_nesne.setKisiSayi(cursor.getString(cursor.getColumnIndex(COLUMN15)));
        bir_nesne.setDepartman(cursor.getString(cursor.getColumnIndex(COLUMN16)));
        bir_nesne.setMinYas(cursor.getString(cursor.getColumnIndex(COLUMN17)));
        bir_nesne.setMaxYas(cursor.getString(cursor.getColumnIndex(COLUMN18)));
        bir_nesne.setCinsiyet(cursor.getString(cursor.getColumnIndex(COLUMN19)));
        bir_nesne.setEgitim(cursor.getString(cursor.getColumnIndex(COLUMN20)));
        bir_nesne.setTecrube(cursor.getString(cursor.getColumnIndex(COLUMN21)));
        bir_nesne.setDil(cursor.getString(cursor.getColumnIndex(COLUMN22)));
        bir_nesne.setEkbilgi(cursor.getString(cursor.getColumnIndex(COLUMN23)));
        bir_nesne.setAktiflik(cursor.getString(cursor.getColumnIndex(COLUMN24)));


        //  closeDB();
        return bir_nesne;

    }


    public void informationPut(DatabaseHelper database, basvuranBilgileri gelen_bilgiler) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put(COLUMN1, gelen_bilgiler.getAd());
        cv.put(COLUMN2, gelen_bilgiler.getSoyad());
        cv.put(COLUMN3, gelen_bilgiler.getCinsiyet());
        cv.put(COLUMN4, gelen_bilgiler.getDogumYeri());
        cv.put(COLUMN5, gelen_bilgiler.getDogumTarih());
        cv.put(COLUMN6, gelen_bilgiler.getSurucuBelgesi());
        cv.put(COLUMN7, gelen_bilgiler.getMedeniDurum());
        cv.put(COLUMN8, gelen_bilgiler.getEvNumarasi());
        cv.put(COLUMN9, gelen_bilgiler.getCepNumarasi());
        cv.put(COLUMN10, gelen_bilgiler.getAdres());
        cv.put(COLUMN11, gelen_bilgiler.getEmail());
        cv.put(COLUMN11E, gelen_bilgiler.getEgitimSeviye());
        cv.put(COLUMN11H, gelen_bilgiler.getHobi());
        cv.put(COLUMN11W, gelen_bilgiler.getWebSite());
        cv.put(COLUMN11D, gelen_bilgiler.getDurum());


        long k = db.insert(TABLE_NAME, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }

    public Cursor getIdbasvurBilgi(DatabaseHelper mydb) {

        SQLiteDatabase database = mydb.getReadableDatabase();

        String columns[] = {COLUMN0};
        Cursor cr = database.query(TABLE_NAME, columns, null, null, null, null, null);
        // closeDB();
        return cr;
    }


    public void informationPutEgitimB(DatabaseHelper database, egitimSinif gelen_bilgiler) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_0, gelen_bilgiler.getId());
        cv.put(COLUMN_1, gelen_bilgiler.getOkulAdi());
        cv.put(COLUMN_2, gelen_bilgiler.getBaslamaTarihi());
        cv.put(COLUMN_3, gelen_bilgiler.getBitisTarihi());

        long k = db.insert(TABLE_NAME_EGITIM, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }


    public void informationPutTecrube(DatabaseHelper database, TecrubeSinif gelen_bilgiler) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TECRUBE0, gelen_bilgiler.getId());
        cv.put(COLUMN_TECRUBE1, gelen_bilgiler.getSirketAdi());
        cv.put(COLUMN_TECRUBE2, gelen_bilgiler.getPozisyon());
        cv.put(COLUMN_TECRUBE3, gelen_bilgiler.getBaslamatarih());
        cv.put(COLUMN_TECRUBE4, gelen_bilgiler.getBitistarih());

        long k = db.insert(TABLE_NAME_TECRUBE, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }


    public void informationPutTecrubePersonel(DatabaseHelper database, TecrubeSinif gelen_bilgiler) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TECRUBE_PERSONEL0, gelen_bilgiler.getId());
        cv.put(COLUMN_TECRUBE_PERSONEL1, gelen_bilgiler.getSirketAdi());
        cv.put(COLUMN_TECRUBE_PERSONEL2, gelen_bilgiler.getPozisyon());
        cv.put(COLUMN_TECRUBE_PERSONEL3, gelen_bilgiler.getBaslamatarih());
        cv.put(COLUMN_TECRUBE_PERSONEL4, gelen_bilgiler.getBitistarih());

        long k = db.insert(TABLE_NAME_TECRUBE_PERSONEL, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }


    public ArrayList<basvuranBilgileri> getAllbasvuranBilgiler() {
        ArrayList<basvuranBilgileri> BilgilerList = new ArrayList<basvuranBilgileri>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME, null);

        if (cr.moveToFirst()) {
            do {
                basvuranBilgileri bBil = new basvuranBilgileri();
                bBil.setBasvuranBilgileri(cr.getString(cr.getColumnIndex(COLUMN1)), cr.getString(cr.getColumnIndex(COLUMN2)), cr.getString(cr.getColumnIndex(COLUMN3)), cr.getString(cr.getColumnIndex(COLUMN4)), cr.getString(cr.getColumnIndex(COLUMN5)), cr.getString(cr.getColumnIndex(COLUMN6)), cr.getString(cr.getColumnIndex(COLUMN7)), cr.getString(cr.getColumnIndex(COLUMN8)), cr.getString(cr.getColumnIndex(COLUMN9)), cr.getString(cr.getColumnIndex(COLUMN10)), cr.getString(cr.getColumnIndex(COLUMN11)), cr.getString(cr.getColumnIndex(COLUMN11E)), cr.getString(cr.getColumnIndex(COLUMN11H)), cr.getString(cr.getColumnIndex(COLUMN11W)), cr.getString(cr.getColumnIndex(COLUMN11D)));
                BilgilerList.add(bBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }


    public ArrayList<egitimSinif> getAllegitimBilgiler() {
        ArrayList<egitimSinif> BilgilerList = new ArrayList<egitimSinif>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME_EGITIM, null);

        if (cr.moveToFirst()) {
            do {
                egitimSinif eBil = new egitimSinif();
                eBil.setegitimSinif(cr.getInt(cr.getColumnIndex(COLUMN_0)), cr.getString(cr.getColumnIndex(COLUMN_1)), cr.getString(cr.getColumnIndex(COLUMN_2)), cr.getString(cr.getColumnIndex(COLUMN_3)));
                BilgilerList.add(eBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }


    public ArrayList<TecrubeSinif> getAlltecrubeBilgiler() {
        ArrayList<TecrubeSinif> BilgilerList = new ArrayList<TecrubeSinif>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME_TECRUBE, null);

        if (cr.moveToFirst()) {
            do {
                TecrubeSinif tBil = new TecrubeSinif();
                tBil.setTecrubeSinif(cr.getInt(cr.getColumnIndex(COLUMN_TECRUBE0)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE1)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE2)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE3)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE4)));
                BilgilerList.add(tBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }

    public ArrayList<TecrubeSinif> getAlltecrubePersonelBilgiler() {
        ArrayList<TecrubeSinif> BilgilerList = new ArrayList<TecrubeSinif>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME_TECRUBE_PERSONEL, null);

        if (cr.moveToFirst()) {
            do {
                TecrubeSinif tBil = new TecrubeSinif();
                tBil.setTecrubeSinif(cr.getInt(cr.getColumnIndex(COLUMN_TECRUBE_PERSONEL0)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE_PERSONEL1)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE_PERSONEL2)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE_PERSONEL3)), cr.getString(cr.getColumnIndex(COLUMN_TECRUBE_PERSONEL4)));
                BilgilerList.add(tBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }

    public ArrayList<okulSinif> getAllpersonelOkulBilgiler() {
        ArrayList<okulSinif> BilgilerList = new ArrayList<okulSinif>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME_OKUL_PERSONEL, null);

        if (cr.moveToFirst()) {
            do {
                okulSinif oBil = new okulSinif();
                oBil.setokulSinif(cr.getInt(cr.getColumnIndex(COLUMN_PERSONEL_OKUL0)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL_OKUL1)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL_OKUL2)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL_OKUL3)), cr.getString(cr.getColumnIndex(COLUMN_PERSONEL_OKUL4)));
                BilgilerList.add(oBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }


    public void informationPutDilBilgi(DatabaseHelper database, dillerSinifi gelen_bilgiler) {


        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DIL_ID, gelen_bilgiler.getId());
        cv.put(COLUMN_DIL_ADI, gelen_bilgiler.getDilAdi());
        cv.put(COLUMN_DIL_DERECE, gelen_bilgiler.getDerece());


        long k = db.insert(TABLE_NAME_DILLER, null, cv);
        Log.d("veritabanina", " ilk kayit girildi");
        closeDB();
        //  database.close();

    }


    public ArrayList<dillerSinifi> getAlldilBilgiler() {
        ArrayList<dillerSinifi> BilgilerList = new ArrayList<dillerSinifi>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_NAME_DILLER, null);

        if (cr.moveToFirst()) {
            do {
                dillerSinifi dBil = new dillerSinifi();
                dBil.setdillerSinifi(cr.getInt(cr.getColumnIndex(COLUMN_DIL_ID)), cr.getString(cr.getColumnIndex(COLUMN_DIL_ADI)), cr.getString(cr.getColumnIndex(COLUMN_DIL_DERECE)));
                BilgilerList.add(dBil);
            } while (cr.moveToNext());
        }

        return BilgilerList;


    }


}
