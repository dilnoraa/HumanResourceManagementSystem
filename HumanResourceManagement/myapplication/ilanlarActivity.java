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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class ilanlarActivity extends ActionBarActivity {

    Button anasayfaButon, incele, personel, gorusmeler, giriscikis;

    DatabaseHelper mydb;
    yeniilanClass yeniIlan;

    LinearLayout lh, lv,lhText;
    Button goster1, goster2;


    ilanGoster ilangoster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilanlar);

        anasayfaButon = (Button) findViewById(R.id.anasayfaButonu);

        personel = (Button) findViewById(R.id.personelButonu);

        gorusmeler = (Button) findViewById(R.id.gorusmelerButonu);
        giriscikis = (Button) findViewById(R.id.giriscikisButonu);

        mydb = new DatabaseHelper(this);

        yeniIlan = new yeniilanClass();
        ilangoster = new ilanGoster();


        Intent intent = getIntent();
        final int gelenKimlik = intent.getIntExtra("isveren", -1);


        final int gelenPersonel = intent.getIntExtra("basvuran", -1);





        ArrayList<Integer> list = new ArrayList<>();

        Cursor cursor = mydb.getIdbilgi(mydb);


        if (cursor.moveToFirst()) {

            do {
                list.add(cursor.getInt(0));
            } while (cursor.moveToNext());
        }


        ArrayList<ilanGoster> ilanBilgileri = (ArrayList<ilanGoster>) mydb.getSomeyeniilanBilgiler();


        if (ilanBilgileri.size() == 0) {


            LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.linearBilgi);
            linearLayout4.removeAllViews();
            TextView text = new TextView(this);

            text.setText(" ILAN BULUNMAMAKTADIR ");
            text.setBackgroundColor(Color.parseColor("#315F95"));
            text.setTextSize(20);
            LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
          lh_yerlesim.setMargins(10,10,10,10);
            linearLayout4.addView(text, lh_yerlesim);

        } else {


            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearLayV);

            lhText = new LinearLayout(this);

            lhText.setOrientation(LinearLayout.HORIZONTAL);


            TextView text1 = new TextView(this);
            text1.setText("    GOSTER ");
            text1.setTextSize(9);
            text1.setBackgroundColor(Color.parseColor("#296588"));
            text1.setTextColor(Color.parseColor("#F4F2FA"));

            TextView text2 = new TextView(this);
            text2.setText("    BASLAMA-BITIS TARIH ");
            text2.setTextSize(9);
            text2.setBackgroundColor(Color.parseColor("#296588"));
            text2.setTextColor(Color.parseColor("#F4F2FA"));


            TextView text3 = new TextView(this);
            text3.setText("    KISI SAYISI ");
            text3.setTextSize(9);
            text3.setBackgroundColor(Color.parseColor("#296588"));
            text3.setTextColor(Color.parseColor("#F4F2FA"));


            TextView text4 = new TextView(this);
            text4.setText("    EGITIM ");
            text4.setTextSize(9);
            text4.setBackgroundColor(Color.parseColor("#296588"));
            text4.setTextColor(Color.parseColor("#F4F2FA"));



            TextView text5 = new TextView(this);
            text5.setText("    DEPARTMAN");
            text5.setTextSize(9);
            text5.setBackgroundColor(Color.parseColor("#296588"));
            text5.setTextColor(Color.parseColor("#F4F2FA"));



            LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            lhText.addView(text1, btn_yerlesim);
            lhText.addView(text2, btn_yerlesim);
            lhText.addView(text3, btn_yerlesim);
            lhText.addView(text4, btn_yerlesim);
            lhText.addView(text5, btn_yerlesim);

            LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout2.addView(lhText, lh_yerlesim);


            int i, sayi;
            for (i = 0; i < ilanBilgileri.size(); i++) {


                lh = new LinearLayout(this);

                lh.setOrientation(LinearLayout.HORIZONTAL);


                goster1 = new Button(this);
                goster1.setId(i);
                final int finalI = i;
                goster1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        fonksiyon(finalI, gelenKimlik, gelenPersonel);
                    }
                });


                TextView textView1 = new TextView(this);
                textView1.setText(" "+ ilanBilgileri.get(i).getBaslangcTarih().toString() + " - ");
                textView1.setTextSize(10);
                textView1.setBackgroundColor(Color.parseColor("#6D7F8B"));


                TextView textView2 = new TextView(this);
                textView2.setText(ilanBilgileri.get(i).getBitisTarih().toString() + " ");
                textView2.setTextSize(10);
                textView2.setBackgroundColor(Color.parseColor("#6D7F8B"));

                TextView textView3 = new TextView(this);
                textView3.setText("     " + ilanBilgileri.get(i).getKisiSay().toString() + "          ");
                textView3.setTextSize(11);
                textView3.setBackgroundColor(Color.parseColor("#6D7F8B"));


                TextView textView4 = new TextView(this);

                textView4.setText(ilanBilgileri.get(i).getEgitim().toString() + "  ");
                textView4.setTextSize(11);
                textView4.setBackgroundColor(Color.parseColor("#6D7F8B"));


                TextView textView5 = new TextView(this);
                textView5.setText(ilanBilgileri.get(i).getDepartman().toString());
                textView5.setTextSize(11);
                textView5.setBackgroundColor(Color.parseColor("#6D7F8B"));



                goster1.setText("incele");


              goster1.setBackgroundColor(Color.parseColor("#296588"));
                goster1.setTextColor(Color.parseColor("#F4F2FA"));

                lh_yerlesim.setMargins(10,10,0,0);

                lh.addView(goster1, btn_yerlesim);

                lh.addView(textView1, btn_yerlesim);
                lh.addView(textView2, btn_yerlesim);
                lh.addView(textView3, btn_yerlesim);
                lh.addView(textView4, btn_yerlesim);
                lh.addView(textView5, btn_yerlesim);



                linearLayout2.addView(lh, lh_yerlesim);




            }


        }

        if (gelenKimlik > 0) {
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.LinearYeniilan);
            Button yeniilan = new Button(ilanlarActivity.this);
            Button basvurular = new Button(ilanlarActivity.this);
            yeniilan.setText("Yeni ilan olustur");

            yeniilan.setBackgroundColor(Color.parseColor("#305A66"));
            yeniilan.setTextColor(Color.parseColor("#F4F2FA"));
            basvurular.setText("Basvurular");

            basvurular.setBackgroundColor(Color.parseColor("#305A66"));
            basvurular.setTextColor(Color.parseColor("#F4F2FA"));
            LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lh_yerlesim.setMargins(10, 10, 10, 10);
            linearLayout2.addView(yeniilan, lh_yerlesim);
            linearLayout2.addView(basvurular, lh_yerlesim);

            yeniilan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent = new Intent(ilanlarActivity.this, yeniilanActivity.class);
                    intent.putExtra("isveren", gelenKimlik);
                    intent.putExtra("basvuran", gelenPersonel);
                    startActivity(intent);
                    finish();

                }
            });


            basvurular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ilanlarActivity.this, basvurularActivity.class);
                    intent.putExtra("isveren", gelenKimlik);
                    intent.putExtra("basvuran", gelenPersonel);
                    startActivity(intent);
                    finish();
                }
            });


        } else if (gelenKimlik == 0 && gelenPersonel == 0) {

            LinearLayout layout = (LinearLayout) findViewById(R.id.linearilanlarGizle);
            layout.removeAllViews();


        }


        if (gelenPersonel > 0) {


            LinearLayout layout3 = (LinearLayout) findViewById(R.id.linearilanlarGizle2);
            layout3.removeAllViews();

        }


        anasayfaButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ilanlarActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        gorusmeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ilanlarActivity.this, gorusmelerActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);
                finish();
            }
        });

        giriscikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ilanlarActivity.this, giris_cikisActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);
                finish();
            }
        });


        personel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ilanlarActivity.this, personelActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);

                startActivity(intent);
                finish();
            }
        });


    }


    public void fonksiyon(int sayi, int gelenKimlik, int gelenPersonel) {


        if (gelenKimlik == 0 && gelenPersonel == 0) {

            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.LinearYeniilan);
            linearLayout2.removeAllViews();
            Button giris = new Button(ilanlarActivity.this);
            giris.setText("GIRIS YAP");
            giris.setBackgroundColor(Color.parseColor("#305A66"));
            giris.setTextColor(Color.parseColor("#F4F2FA"));
            LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout2.addView(giris, lh_yerlesim);


            giris.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ilanlarActivity.this, anasayfaActivity.class);

                    startActivity(intent);
                    finish();
                }
            });


        } else if (gelenPersonel != 0) {
            Intent intent = new Intent(ilanlarActivity.this, inceleActivity.class);
            intent.putExtra("numara", sayi + 1);
            intent.putExtra("isveren", gelenKimlik);
            intent.putExtra("basvuran", gelenPersonel);
            startActivity(intent);
        } else if (gelenKimlik != 0) {

            Intent intent = new Intent(ilanlarActivity.this, inceleActivity.class);
            intent.putExtra("numara", sayi + 1);
            intent.putExtra("isveren", gelenKimlik);
            intent.putExtra("basvuran", gelenPersonel);
            startActivity(intent);


        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ilanlar, menu);
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
