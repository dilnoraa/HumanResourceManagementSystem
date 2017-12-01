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


public class isveren_girisActivity extends ActionBarActivity {

    DatabaseHelper mydb;
    EditText kullaniciAd, sifre;
    Button giris,iptal;
    TextView tv;
    int durum=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isveren_giris);

        mydb=new DatabaseHelper(this);

        kullaniciAd= (EditText) findViewById(R.id.isveren_kullanici_ad);
        sifre= (EditText) findViewById(R.id.isveren_sifre);
        giris= (Button) findViewById(R.id.girisYapisveren);
        iptal= (Button) findViewById(R.id.iptalYapisveren);


        iptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(isveren_girisActivity.this, MainActivity.class);

                startActivity(intent);

                finish();






            }
        });





        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<isverenClass> isveren_listesi = (ArrayList<isverenClass>) mydb.getAllisverenBilgiler();




                for(int i=0;i<isveren_listesi.size();i++) {



                    if(isveren_listesi.get(i).getKullanici_ad().equals(kullaniciAd.getText().toString().trim()) && isveren_listesi.get(i).getSifre().equals(sifre.getText().toString().trim())) {

                      if(durum==2)
                          tv.setText("  ");

                        Intent intent = new Intent(isveren_girisActivity.this, MainActivity.class);

                        int sayi=isveren_listesi.get(i).getId();

                        intent.putExtra("numara", sayi);
                        startActivity(intent);

                        finish();

                        durum=1;


                    }



                }



                if(durum==0) {



                    LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearisveren_giris);


                    tv=new TextView(isveren_girisActivity.this);
                    tv.setText(" Malesef sifre veya kullanici adiniz yanlis girdiniz, tekrar deneyiniz.");
                    tv.setTextSize(16);
                    tv.setPadding(10,10,10,10);



                    LinearLayout.LayoutParams lh_yerlesim=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                    linearLayout2.addView(tv, lh_yerlesim);


                    kullaniciAd.setText("   ");
                    sifre.setText("   ");

                     durum=2;
                }




            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_isveren_giris, menu);
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
