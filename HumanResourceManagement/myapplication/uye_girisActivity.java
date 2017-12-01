package com.example.pc.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class uye_girisActivity extends ActionBarActivity {

    Button kaydol,gir,iptal;
    EditText kul_ad,sifre;
    DatabaseHelper mydb;
    TextView tv;
    int durum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_giris);

        kaydol= (Button) findViewById(R.id.kaydolB);
        kul_ad= (EditText) findViewById(R.id.kullanici_adUye2);
        sifre= (EditText) findViewById(R.id.sifreUye2);
        gir= (Button) findViewById(R.id.girButton);
        iptal= (Button) findViewById(R.id.iptalButton);
        mydb=new DatabaseHelper(this);

        kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(uye_girisActivity.this, kaydolActivity.class);
                startActivity(intent);

            }
        });


        iptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(uye_girisActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });


        gir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayList<uyeClass> uyeBilgileri = (ArrayList<uyeClass>) mydb.getAlluyeBilgiler();

                for(int i=0; i<uyeBilgileri.size();i++) {


                    if(uyeBilgileri.get(i).getSifre().toString().trim().equals(sifre.getText().toString().trim())&& uyeBilgileri.get(i).getKullanici_ad().toString().trim().equals(kul_ad.getText().toString().trim())) {


                        if(durum==2)
                            tv.setText("  ");

                        Toast.makeText(getApplication(), "Hos Geldiniz" , Toast.LENGTH_SHORT).show();

                        durum=1;

                        Intent intent = new Intent(uye_girisActivity.this, MainActivity.class);
                        startActivity(intent);
                        int sayi=uyeBilgileri.get(i).getId();

                        intent.putExtra("numara2", sayi);
                        startActivity(intent);

                        finish();


                    }


                }

                if(durum==0) {

                    LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.LinearuyeGris);

                    tv=new TextView(uye_girisActivity.this);
                    tv.setText(" Malesef sifre veya kullanici adinizi  yanlis girdiniz, tekrar deneyiniz");
                    tv.setTextSize(15);
                    tv.setPadding(10,10,10,10);
                    LinearLayout.LayoutParams lh_yerlesim=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                    linearLayout2.addView(tv, lh_yerlesim);

                    kul_ad.setText("  ");
                    sifre.setText("   ");

                     durum=2;
                }


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_uye_giris, menu);
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
