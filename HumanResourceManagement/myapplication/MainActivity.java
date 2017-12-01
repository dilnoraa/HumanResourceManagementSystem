package com.example.pc.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    Button ilanButon, anasayfa, cikis;
    DatabaseHelper mydb;
    isverenClass isveren;
    static int gelen = 0, gelen2 = 0;
    static int sabitle, sabitle2;
    TextView tv1;
    int cikisOldu = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DatabaseHelper(this);

        ilanButon = (Button) findViewById(R.id.ilanlarButonu);
        cikis = (Button) findViewById(R.id.cikisyapButonu);
        anasayfa = (Button) findViewById(R.id.anasayfaButonu);

        Intent intent = getIntent();
        final int gelenVeri = intent.getIntExtra("numara", -1);

        Intent intent2 = getIntent();
        final int gelenVeri2 = intent2.getIntExtra("numara2", -1);

        Intent intent3 = getIntent();
        final int gelenVeri3 = intent3.getIntExtra("cikis", -1);


        if (gelenVeri3 == 1) {

            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.mainLinear);

            tv1 = new TextView(this);
            tv1.setText("SISTEMDEN CIKTINIZ");

            LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.lineargiris_cikis);
            linearLayout3.removeAllViews();

            LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout2.addView(tv1, lh_yerlesim);

        }


        mydb.deleteAll();

        isveren = new isverenClass();
        isveren.setId(1);
        isveren.setKullanici_ad("isveren");
        isveren.setSifre("123");
        isveren.setAd("Dilnora");
        isveren.setSoyad("Matniyazova");

        mydb.informationPutIsveren(mydb, isveren);
        mydb.closeDB();


        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, anasayfaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ilanButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ilanlarActivity.class);

                intent.putExtra("isveren", sabitle);
                intent.putExtra("basvuran", sabitle2);

                startActivity(intent);
                finish();
            }
        });


        LinearLayout linearLayoutGiris = (LinearLayout) findViewById(R.id.linearGirisKaldir);


        if (gelenVeri != -1 || gelen != 0) {


            linearLayoutGiris.removeAllViews();

            gelen++;
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.mainLinear);

            if (gelenVeri != -1) {
                sabitle = gelenVeri;
                ArrayList<isverenClass> isverenBilgileri = (ArrayList<isverenClass>) mydb.getisverenBilgilerbyId(gelenVeri);

                tv1 = new TextView(this);
                tv1.setText("Hosgeldiniz " + isverenBilgileri.get(0).getAd() + " " + isverenBilgileri.get(0).getSoyad());

                LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                linearLayout2.addView(tv1, lh_yerlesim);
            } else if (gelen != 0) {


                ArrayList<isverenClass> isverenBilgileri = (ArrayList<isverenClass>) mydb.getisverenBilgilerbyId(sabitle);


                tv1 = new TextView(this);
                tv1.setText("Hosgeldiniz " + isverenBilgileri.get(0).getAd() + " " + isverenBilgileri.get(0).getSoyad());

                LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                linearLayout2.addView(tv1, lh_yerlesim);
            }


            TextView tv1 = new TextView(this);


            LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
               lh_yerlesim.setMargins(0,10,0,0);
            linearLayout2.addView(tv1, lh_yerlesim);


            LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.lineargiris_cikis);

            Button giris_cikis = new Button(MainActivity.this);
            giris_cikis.setText("GIRIS/CIKIS");

            Button personelButon = new Button(MainActivity.this);
            personelButon.setText("PERSONEL");

            Button gorusmeler = new Button(MainActivity.this);
            gorusmeler.setText("GORUSMELER");
           personelButon.setBackgroundColor(Color.parseColor("#305A66"));

            personelButon.setTextColor(Color.parseColor("#F4F2FA"));
            gorusmeler.setBackgroundColor(Color.parseColor("#305A66"));
            gorusmeler.setTextColor(Color.parseColor("#F4F2FA"));
            giris_cikis.setBackgroundColor(Color.parseColor("#305A66"));
            giris_cikis.setTextColor(Color.parseColor("#F4F2FA"));
            linearLayout3.addView(gorusmeler, lh_yerlesim);
            linearLayout3.addView(personelButon, lh_yerlesim);
            linearLayout3.addView(giris_cikis, lh_yerlesim);


            giris_cikis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent2 = new Intent(MainActivity.this, giris_cikisActivity.class);
                    intent2.putExtra("isveren", sabitle);
                    intent2.putExtra("basvuran", sabitle2);
                    startActivity(intent2);
                    finish();
                }
            });


            personelButon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2 = new Intent(MainActivity.this, personelActivity.class);
                    intent2.putExtra("isveren", sabitle);
                    intent2.putExtra("basvuran", sabitle2);

                    startActivity(intent2);
                    finish();
                }
            });


            gorusmeler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2 = new Intent(MainActivity.this, gorusmelerActivity.class);
                    intent2.putExtra("isveren", sabitle);
                    intent2.putExtra("basvuran", sabitle2);
                    startActivity(intent2);
                    finish();
                }
            });


        }


        if (gelenVeri2 != -1 || gelen2 != 0) {

            linearLayoutGiris.removeAllViews();

            gelen2++;
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.mainLinear);

            if (gelenVeri2 != -1) {
                sabitle2 = gelenVeri2;
                ArrayList<uyeClass> uyeBilgileri = (ArrayList<uyeClass>) mydb.getuyeBilgilerbyId(gelenVeri2);

                tv1 = new TextView(this);
                tv1.setText("Hosgeldiniz " + uyeBilgileri.get(0).getAd() + " " + uyeBilgileri.get(0).getSoyad());

                LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                linearLayout2.addView(tv1, lh_yerlesim);
            } else if (gelen2 != 0) {


                ArrayList<uyeClass> uyeBilgileri = (ArrayList<uyeClass>) mydb.getuyeBilgilerbyId(sabitle2);

                tv1 = new TextView(this);
                tv1.setText("Hosgeldiniz " + uyeBilgileri.get(0).getAd() + " " + uyeBilgileri.get(0).getSoyad());

                LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                linearLayout2.addView(tv1, lh_yerlesim);


            }


            TextView tv1 = new TextView(this);


            LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout2.addView(tv1, lh_yerlesim);


            LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.lineargiris_cikis);
            Button personelButon = new Button(MainActivity.this);
            personelButon.setText("PERSONEL");
            personelButon.setBackgroundColor(Color.parseColor("#305A66"));

            personelButon.setTextColor(Color.parseColor("#F4F2FA"));
            lh_yerlesim.setMargins(0, 10, 0, 0);
            linearLayout3.addView(personelButon, lh_yerlesim);

            personelButon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2 = new Intent(MainActivity.this, personelActivity.class);

                    intent2.putExtra("isveren", sabitle);
                    intent2.putExtra("basvuran", sabitle2);
                    startActivity(intent2);
                    finish();
                }
            });

        }


        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (gelen != 0) {

                    gelen = 0;
                    sabitle = 0;
                    sabitle2 = 0;

                    cikisOldu = 1;
                    Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
                    intent2.putExtra("cikis", cikisOldu);
                    startActivity(intent2);
                    finish();


                    Toast.makeText(getApplication(), "SISTEMDEN CIKTINIZ", Toast.LENGTH_SHORT).show();


                }


                if (gelen2 != 0) {

                    gelen2 = 0;
                    sabitle = 0;
                    sabitle2 = 0;


                    cikisOldu = 1;
                    Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
                    intent2.putExtra("cikis", cikisOldu);
                    startActivity(intent2);
                    finish();

                    Toast.makeText(getApplication(), "SISTEMDEN CIKTINIZ", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
