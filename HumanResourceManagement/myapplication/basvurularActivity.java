package com.example.pc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class basvurularActivity extends ActionBarActivity {


    DatabaseHelper mydb;
    basvuranBilgileri basvBilgileri;
    yeniilanClass ilanBilgileri;
    LinearLayout lh;
    Button incele,filtrele;
    Button anasayfa,ilanlar,personel,gorusmeler,giris_cikis;


    RadioButton incelenen,incelenmeyen,tum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basvurular);


        anasayfa= (Button) findViewById(R.id.anasayfaButonuBasvuru);
        ilanlar= (Button) findViewById(R.id.ilanlarButonuBasvuru);
        personel= (Button) findViewById(R.id.personelButonuBasvuru);
        gorusmeler= (Button) findViewById(R.id.gorusmelerButonuBasvuru);
        giris_cikis= (Button) findViewById(R.id.giriscikisButonuBasvuru);


        Intent intent = getIntent();
        final int gelenKimlik = intent.getIntExtra("isveren", -1);
        final int gelenPersonel=intent.getIntExtra("basvuran",-1);



        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(basvurularActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


        gorusmeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(basvurularActivity.this, gorusmelerActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);

            }
        });

        giris_cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(basvurularActivity.this, giris_cikisActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);

            }
        });



        personel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(basvurularActivity.this, personelActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);

            }
        });


        ilanlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(basvurularActivity.this, ilanlarActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);

            }
        });



        mydb=new DatabaseHelper(this);
        incelenen= (RadioButton) findViewById(R.id.incelenenRadio);
        incelenmeyen= (RadioButton) findViewById(R.id.incelenmeyenRadio);
        tum= (RadioButton) findViewById(R.id.tumuRadio);
        filtrele= (Button) findViewById(R.id.filtrele);


               final ArrayList<Integer> listIdilan=new ArrayList<>();
        final ArrayList<Integer> listIdcalisan=new ArrayList<>();
        final ArrayList<String> listuygunluk=new ArrayList<>();
        final ArrayList<Integer> listIdhesap=new ArrayList<>();






                Cursor cursor=mydb.getbasvuruilanBilgi(mydb);




                if (cursor.moveToFirst()) {

                    do {
                        listIdilan.add(cursor.getInt(0));
                        listIdcalisan.add(cursor.getInt(1));
                        listuygunluk.add(cursor.getString(2));
                        listIdhesap.add(cursor.getInt(3));
                    } while (cursor.moveToNext());
                }


        if(listIdilan.size()==0) {
            Toast.makeText(getApplication(), "yok...", Toast.LENGTH_SHORT).show();
            LinearLayout linearLayout6= (LinearLayout) findViewById(R.id.LinearLayoutdikey);
            linearLayout6.removeAllViews();

            TextView text=new TextView(this);

            text.setText(" Basvuru bulunmamaktadir ");
            text.setTextSize(25);
            LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout6.addView(text, lh_yerlesim);
        }
        else {



            filtrele.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int durum = 0;


                    if (incelenen.isChecked())
                        durum=1;
                    else if (incelenmeyen.isChecked())
                        durum=2;
                    else if (tum.isChecked())
                        durum=3;



                    LinearLayout linearLayout2= (LinearLayout) findViewById(R.id.LinearLayoutdikey);
                    if(listIdcalisan.size()!=0) {



                        linearLayout2.removeAllViews();


                        lh = new LinearLayout(basvurularActivity.this);

                        lh.setOrientation(LinearLayout.HORIZONTAL);

                        TextView text1 = new TextView(basvurularActivity.this);
                        text1.setText("CV      ");
                        text1.setTextSize(11);
                        text1.setBackgroundColor(Color.parseColor("#296588"));
                        text1.setTextColor(Color.parseColor("#F4F2FA"));

                        TextView text2 = new TextView(basvurularActivity.this);
                        text2.setText("       AD  ");
                        text2.setTextSize(11);
                        text2.setBackgroundColor(Color.parseColor("#296588"));
                        text2.setTextColor(Color.parseColor("#F4F2FA"));

                        TextView text3 = new TextView(basvurularActivity.this);
                        text3.setText("        SOYAD  ");
                        text3.setTextSize(11);
                        text3.setBackgroundColor(Color.parseColor("#296588"));
                        text3.setTextColor(Color.parseColor("#F4F2FA"));

                        TextView text4 = new TextView(basvurularActivity.this);
                        text4.setText("         EGITIM  ");
                        text4.setTextSize(11);
                        text4.setBackgroundColor(Color.parseColor("#296588"));
                        text4.setTextColor(Color.parseColor("#F4F2FA"));


                        TextView text5 = new TextView(basvurularActivity.this);
                        text5.setText("          EMAIL  ");
                        text5.setTextSize(11);
                        text5.setBackgroundColor(Color.parseColor("#296588"));
                        text5.setTextColor(Color.parseColor("#F4F2FA"));


                        TextView text6 = new TextView(basvurularActivity.this);
                        text6.setText("          ILAN  ");
                        text6.setTextSize(11);
                        text6.setBackgroundColor(Color.parseColor("#296588"));
                        text6.setTextColor(Color.parseColor("#F4F2FA"));

                        TextView text7 = new TextView(basvurularActivity.this);
                        text7.setText("           UYGUNLUK");
                        text7.setTextSize(11);
                        text7.setBackgroundColor(Color.parseColor("#296588"));
                        text7.setTextColor(Color.parseColor("#F4F2FA"));


                        LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                        lh.addView(text1, btn_yerlesim);
                        lh.addView(text2, btn_yerlesim);
                        lh.addView(text3, btn_yerlesim);
                        lh.addView(text4, btn_yerlesim);
                        lh.addView(text5, btn_yerlesim);
                        lh.addView(text6, btn_yerlesim);
                        lh.addView(text7, btn_yerlesim);


                        LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        linearLayout2.addView(lh, lh_yerlesim);




                    }





      //      LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.LinearLayoutdikey);

            if (durum==1 ) {

                linearLayout2.removeAllViews();
                lh = new LinearLayout(basvurularActivity.this);

                lh.setOrientation(LinearLayout.HORIZONTAL);

                TextView text1 = new TextView(basvurularActivity.this);
                text1.setText("    CV     ");
                text1.setTextSize(11);
                text1.setBackgroundColor(Color.parseColor("#296588"));
                text1.setTextColor(Color.parseColor("#F4F2FA"));

                TextView text2 = new TextView(basvurularActivity.this);
                text2.setText("       AD  ");
                text2.setTextSize(11);
                text2.setBackgroundColor(Color.parseColor("#296588"));
                text2.setTextColor(Color.parseColor("#F4F2FA"));

                TextView text3 = new TextView(basvurularActivity.this);
                text3.setText("        SOYAD  ");
                text3.setTextSize(11);
                text3.setBackgroundColor(Color.parseColor("#296588"));
                text3.setTextColor(Color.parseColor("#F4F2FA"));

                TextView text4 = new TextView(basvurularActivity.this);
                text4.setText("         EGITIM  ");
                text4.setTextSize(11);
                text4.setBackgroundColor(Color.parseColor("#296588"));
                text4.setTextColor(Color.parseColor("#F4F2FA"));


                TextView text5 = new TextView(basvurularActivity.this);
                text5.setText("          EMAIL  ");
                text5.setTextSize(11);
                text5.setBackgroundColor(Color.parseColor("#296588"));
                text5.setTextColor(Color.parseColor("#F4F2FA"));


                TextView text6 = new TextView(basvurularActivity.this);
                text6.setText("          ILAN  ");
                text6.setTextSize(11);
                text6.setBackgroundColor(Color.parseColor("#296588"));
                text6.setTextColor(Color.parseColor("#F4F2FA"));

                TextView text7 = new TextView(basvurularActivity.this);
                text7.setText("           UYGUNLUK");
                text7.setTextSize(11);
                text7.setBackgroundColor(Color.parseColor("#296588"));
                text7.setTextColor(Color.parseColor("#F4F2FA"));


                LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                lh.addView(text1, btn_yerlesim);
                lh.addView(text2, btn_yerlesim);
                lh.addView(text3, btn_yerlesim);
                lh.addView(text4, btn_yerlesim);
                lh.addView(text5, btn_yerlesim);
                lh.addView(text6, btn_yerlesim);
                lh.addView(text7, btn_yerlesim);


                LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                linearLayout2.addView(lh, lh_yerlesim);

                for (int i = 0; i < listIdcalisan.size(); i++) {

                    if (listuygunluk.get(i).toString().equals("UYGUN") || listuygunluk.get(i).toString().equals("UYGUN DEGIL")) {

                        lh = new LinearLayout(basvurularActivity.this);
                        lh.setOrientation(LinearLayout.HORIZONTAL);


                        incele = new Button(basvurularActivity.this);

                        basvBilgileri = new basvuranBilgileri();
                        ilanBilgileri = new yeniilanClass();
                        final int positionIdbasvuran = listIdcalisan.get(i);
                        basvBilgileri = mydb.getcalisanBilgiById(positionIdbasvuran);
                        final int positionIdilan = listIdilan.get(i);
                        ilanBilgileri = mydb.getIlanBilgibyId(positionIdilan);

                        final int positionIdhesap = listIdhesap.get(i);

                        incele.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                fonksiyon(positionIdilan, positionIdhesap, positionIdbasvuran, gelenKimlik,gelenPersonel);
                            }
                        });


                        TextView textView1 = new TextView(basvurularActivity.this);
                        textView1.setText(basvBilgileri.getAd().toString()+"  ");
                        textView1.setBackgroundColor(Color.parseColor("#6D7F8B"));

                        TextView textView2 = new TextView(basvurularActivity.this);
                        textView2.setText(basvBilgileri.getSoyad().toString()+"  ");
                        textView2.setBackgroundColor(Color.parseColor("#6D7F8B"));

                        TextView textView3 = new TextView(basvurularActivity.this);
                        textView3.setText(basvBilgileri.getEgitimSeviye().toString()+"  ");
                        textView3.setBackgroundColor(Color.parseColor("#6D7F8B"));

                        TextView textView4 = new TextView(basvurularActivity.this);
                        textView4.setText(basvBilgileri.getEmail().toString()+"  ");
                        textView4.setBackgroundColor(Color.parseColor("#6D7F8B"));

                        TextView textView5 = new TextView(basvurularActivity.this);
                        textView5.setText(ilanBilgileri.getAktiflik().toString()+"  ");
                        textView5.setBackgroundColor(Color.parseColor("#6D7F8B"));
                        TextView textView6 = new TextView(basvurularActivity.this);
                        textView6.setText(listuygunluk.get(i).toString());
                        textView6.setBackgroundColor(Color.parseColor("#6D7F8B"));


                        textView1.setTextSize(10);
                        textView2.setTextSize(10);
                        textView3.setTextSize(10);
                        textView4.setTextSize(10);
                        textView5.setTextSize(10);
                        textView6.setTextSize(10);

                        incele.setText("incele");

                        incele.setBackgroundColor(Color.parseColor("#296588"));
                        incele.setTextColor(Color.parseColor("#F4F2FA"));
                        incele.setTextSize(10);
                        lh_yerlesim.setMargins(10, 10, 0, 0);



                        lh.addView(incele, btn_yerlesim);
                        lh.addView(textView1, btn_yerlesim);
                        lh.addView(textView2, btn_yerlesim);
                        lh.addView(textView3, btn_yerlesim);
                        lh.addView(textView4, btn_yerlesim);
                        lh.addView(textView5, btn_yerlesim);
                        lh.addView(textView6, btn_yerlesim);


                        linearLayout2.addView(lh, lh_yerlesim);


                    }


                }


            } else if (durum==2 ) {

                linearLayout2.removeAllViews();
                lh = new LinearLayout(basvurularActivity.this);

                lh.setOrientation(LinearLayout.HORIZONTAL);

                TextView text1 = new TextView(basvurularActivity.this);
                text1.setText("    CV     ");
                text1.setTextSize(11);
                text1.setBackgroundColor(Color.parseColor("#296588"));
                text1.setTextColor(Color.parseColor("#F4F2FA"));

                TextView text2 = new TextView(basvurularActivity.this);
                text2.setText("       AD  ");
                text2.setTextSize(11);
                text2.setBackgroundColor(Color.parseColor("#296588"));
                text2.setTextColor(Color.parseColor("#F4F2FA"));

                TextView text3 = new TextView(basvurularActivity.this);
                text3.setText("        SOYAD  ");
                text3.setTextSize(11);
                text3.setBackgroundColor(Color.parseColor("#296588"));
                text3.setTextColor(Color.parseColor("#F4F2FA"));

                TextView text4 = new TextView(basvurularActivity.this);
                text4.setText("         EGITIM  ");
                text4.setTextSize(11);
                text4.setBackgroundColor(Color.parseColor("#296588"));
                text4.setTextColor(Color.parseColor("#F4F2FA"));


                TextView text5 = new TextView(basvurularActivity.this);
                text5.setText("          EMAIL  ");
                text5.setTextSize(11);
                text5.setBackgroundColor(Color.parseColor("#296588"));
                text5.setTextColor(Color.parseColor("#F4F2FA"));


                TextView text6 = new TextView(basvurularActivity.this);
                text6.setText("          ILAN  ");
                text6.setTextSize(11);
                text6.setBackgroundColor(Color.parseColor("#296588"));
                text6.setTextColor(Color.parseColor("#F4F2FA"));

                TextView text7 = new TextView(basvurularActivity.this);
                text7.setText("           UYGUNLUK");
                text7.setTextSize(11);
                text7.setBackgroundColor(Color.parseColor("#296588"));
                text7.setTextColor(Color.parseColor("#F4F2FA"));


                LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                lh.addView(text1, btn_yerlesim);
                lh.addView(text2, btn_yerlesim);
                lh.addView(text3, btn_yerlesim);
                lh.addView(text4, btn_yerlesim);
                lh.addView(text5, btn_yerlesim);
                lh.addView(text6, btn_yerlesim);
                lh.addView(text7, btn_yerlesim);


                LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                linearLayout2.addView(lh, lh_yerlesim);
                for (int i = 0; i < listIdcalisan.size(); i++) {

                    if (listuygunluk.get(i).toString().equals("BELIRSIZ")) {

                        lh = new LinearLayout(basvurularActivity.this);
                        lh.setOrientation(LinearLayout.HORIZONTAL);


                        incele = new Button(basvurularActivity.this);

                        basvBilgileri = new basvuranBilgileri();
                        ilanBilgileri = new yeniilanClass();
                        final int positionIdbasvuran = listIdcalisan.get(i);
                        basvBilgileri = mydb.getcalisanBilgiById(positionIdbasvuran);
                        final int positionIdilan = listIdilan.get(i);
                        ilanBilgileri = mydb.getIlanBilgibyId(positionIdilan);

                        final int positionIdhesap = listIdhesap.get(i);

                        incele.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                fonksiyon(positionIdilan, positionIdhesap,positionIdbasvuran,gelenKimlik, gelenPersonel );
                            }
                        });

                        TextView textView1 = new TextView(basvurularActivity.this);
                        textView1.setText(basvBilgileri.getAd().toString()+"  ");
                        textView1.setBackgroundColor(Color.parseColor("#6D7F8B"));

                        TextView textView2 = new TextView(basvurularActivity.this);
                        textView2.setText(basvBilgileri.getSoyad().toString()+"  ");
                        textView2.setBackgroundColor(Color.parseColor("#6D7F8B"));

                        TextView textView3 = new TextView(basvurularActivity.this);
                        textView3.setText(basvBilgileri.getEgitimSeviye().toString()+"  ");
                        textView3.setBackgroundColor(Color.parseColor("#6D7F8B"));

                        TextView textView4 = new TextView(basvurularActivity.this);
                        textView4.setText(basvBilgileri.getEmail().toString()+"  ");
                        textView4.setBackgroundColor(Color.parseColor("#6D7F8B"));

                        TextView textView5 = new TextView(basvurularActivity.this);
                        textView5.setText(ilanBilgileri.getAktiflik().toString()+"  ");
                        textView5.setBackgroundColor(Color.parseColor("#6D7F8B"));

                        TextView textView6 = new TextView(basvurularActivity.this);
                        textView6.setText(listuygunluk.get(i).toString());
                        textView6.setBackgroundColor(Color.parseColor("#6D7F8B"));


                        textView1.setTextSize(10);
                        textView2.setTextSize(10);
                        textView3.setTextSize(10);
                        textView4.setTextSize(10);
                        textView5.setTextSize(10);
                        textView6.setTextSize(10);

                        incele.setText("incele");
                        incele.setTextSize(6);
                        incele.setBackgroundColor(Color.parseColor("#296588"));
                        incele.setTextColor(Color.parseColor("#F4F2FA"));
                        incele.setTextSize(10);
                        lh_yerlesim.setMargins(10,10,0,0);



                        lh.addView(incele, btn_yerlesim);
                        lh.addView(textView1, btn_yerlesim);
                        lh.addView(textView2, btn_yerlesim);
                        lh.addView(textView3, btn_yerlesim);
                        lh.addView(textView4, btn_yerlesim);
                        lh.addView(textView5, btn_yerlesim);
                        lh.addView(textView6, btn_yerlesim);


                        linearLayout2.addView(lh, lh_yerlesim);



                    }
                }
            } else if (durum==3) {

                linearLayout2.removeAllViews();
                lh = new LinearLayout(basvurularActivity.this);

                lh.setOrientation(LinearLayout.HORIZONTAL);

                TextView text1 = new TextView(basvurularActivity.this);
                text1.setText("    CV     ");
                text1.setTextSize(11);
                text1.setBackgroundColor(Color.parseColor("#296588"));
                text1.setTextColor(Color.parseColor("#F4F2FA"));

                TextView text2 = new TextView(basvurularActivity.this);
                text2.setText("       AD  ");
                text2.setTextSize(11);
                text2.setBackgroundColor(Color.parseColor("#296588"));
                text2.setTextColor(Color.parseColor("#F4F2FA"));

                TextView text3 = new TextView(basvurularActivity.this);
                text3.setText("        SOYAD  ");
                text3.setTextSize(11);
                text3.setBackgroundColor(Color.parseColor("#296588"));
                text3.setTextColor(Color.parseColor("#F4F2FA"));

                TextView text4 = new TextView(basvurularActivity.this);
                text4.setText("         EGITIM  ");
                text4.setTextSize(11);
                text4.setBackgroundColor(Color.parseColor("#296588"));
                text4.setTextColor(Color.parseColor("#F4F2FA"));


                TextView text5 = new TextView(basvurularActivity.this);
                text5.setText("          EMAIL  ");
                text5.setTextSize(11);
                text5.setBackgroundColor(Color.parseColor("#296588"));
                text5.setTextColor(Color.parseColor("#F4F2FA"));


                TextView text6 = new TextView(basvurularActivity.this);
                text6.setText("          ILAN  ");
                text6.setTextSize(11);
                text6.setBackgroundColor(Color.parseColor("#296588"));
                text6.setTextColor(Color.parseColor("#F4F2FA"));

                TextView text7 = new TextView(basvurularActivity.this);
                text7.setText("           UYGUNLUK");
                text7.setTextSize(11);
                text7.setBackgroundColor(Color.parseColor("#296588"));
                text7.setTextColor(Color.parseColor("#F4F2FA"));


                LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                lh.addView(text1, btn_yerlesim);
                lh.addView(text2, btn_yerlesim);
                lh.addView(text3, btn_yerlesim);
                lh.addView(text4, btn_yerlesim);
                lh.addView(text5, btn_yerlesim);
                lh.addView(text6, btn_yerlesim);
                lh.addView(text7, btn_yerlesim);


                LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                linearLayout2.addView(lh, lh_yerlesim);

                for (int i = 0; i < listIdcalisan.size(); i++) {

                    lh = new LinearLayout(basvurularActivity.this);
                    lh.setOrientation(LinearLayout.HORIZONTAL);


                    incele = new Button(basvurularActivity.this);

                    basvBilgileri = new basvuranBilgileri();
                    ilanBilgileri = new yeniilanClass();
                    final int positionIdbasvuran = listIdcalisan.get(i);
                    basvBilgileri = mydb.getcalisanBilgiById(positionIdbasvuran);
                    final int positionIdilan = listIdilan.get(i);

                    ilanBilgileri = mydb.getIlanBilgibyId(positionIdilan);

                    final int positionIdhesap = listIdhesap.get(i);

                    incele.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            fonksiyon(positionIdilan, positionIdhesap, positionIdbasvuran, gelenKimlik,gelenPersonel);
                        }
                    });


                    TextView textView1 = new TextView(basvurularActivity.this);
                    textView1.setText(basvBilgileri.getAd().toString()+"  ");
                    textView1.setBackgroundColor(Color.parseColor("#6D7F8B"));

                    TextView textView2 = new TextView(basvurularActivity.this);
                    textView2.setText(basvBilgileri.getSoyad().toString()+"  ");
                    textView2.setBackgroundColor(Color.parseColor("#6D7F8B"));

                    TextView textView3 = new TextView(basvurularActivity.this);
                    textView3.setText(basvBilgileri.getEgitimSeviye().toString()+"  ");
                    textView3.setBackgroundColor(Color.parseColor("#6D7F8B"));

                    TextView textView4 = new TextView(basvurularActivity.this);
                    textView4.setText(basvBilgileri.getEmail().toString()+"  ");

                    textView4.setBackgroundColor(Color.parseColor("#6D7F8B"));

                    TextView textView5 = new TextView(basvurularActivity.this);
                    textView5.setText(ilanBilgileri.getAktiflik().toString()+"  ");
                    textView5.setBackgroundColor(Color.parseColor("#6D7F8B"));

                    TextView textView6 = new TextView(basvurularActivity.this);
                    textView6.setText(listuygunluk.get(i).toString());
                    textView6.setBackgroundColor(Color.parseColor("#6D7F8B"));


                    textView1.setTextSize(10);
                    textView2.setTextSize(10);
                    textView3.setTextSize(10);
                    textView4.setTextSize(10);
                    textView5.setTextSize(10);
                    textView6.setTextSize(10);

                    incele.setText("incele");


                    incele.setBackgroundColor(Color.parseColor("#296588"));
                    incele.setTextColor(Color.parseColor("#F4F2FA"));
                    incele.setTextSize(10);
                    lh_yerlesim.setMargins(10,10,0,0);


                    lh.addView(incele, btn_yerlesim);
                    lh.addView(textView1, btn_yerlesim);
                    lh.addView(textView2, btn_yerlesim);
                    lh.addView(textView3, btn_yerlesim);
                    lh.addView(textView4, btn_yerlesim);
                    lh.addView(textView5, btn_yerlesim);
                    lh.addView(textView6, btn_yerlesim);


                    linearLayout2.addView(lh, lh_yerlesim);


                }


            }




                }
            });


        }
    }




    public void  fonksiyon(int ilanId, int hesapId, int basvuranId, int gelenKimlik, int gelenPersonel){

        //Toast.makeText(getApplication(), "......."+sayi,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(basvurularActivity.this, cvActivity.class);
        intent.putExtra("ilan", ilanId);
        intent.putExtra("hesap", hesapId);
        intent.putExtra("basvuran", basvuranId);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_basvurular, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
