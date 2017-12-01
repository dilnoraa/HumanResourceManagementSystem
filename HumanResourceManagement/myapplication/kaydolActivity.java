package com.example.pc.myapplication;

import android.content.Intent;
import android.graphics.Color;
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


public class kaydolActivity extends ActionBarActivity {

    EditText adU, soyadU, kullanici_ad, sifre, sifre2, posta;
    Button kaydol;
    DatabaseHelper mydb;
    uyeClass yeni_uye;
    int durum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);

        mydb = new DatabaseHelper(this);
        adU = (EditText) findViewById(R.id.adUye);
        soyadU = (EditText) findViewById(R.id.soyadUye);
        kullanici_ad = (EditText) findViewById(R.id.kullaniciUye);
        sifre = (EditText) findViewById(R.id.sifreUye);
        sifre2 = (EditText) findViewById(R.id.sifreUyeTekrar);
        posta = (EditText) findViewById(R.id.postaUye);
        kaydol = (Button) findViewById(R.id.kaydetUye);



        kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linear = (LinearLayout) findViewById(R.id.linearKaydolbitti);
                LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                linear.removeAllViews();

                if(durum==0) {
                    if (sifre.getText().toString().trim().equals(sifre2.getText().toString().trim())) {
                        yeni_uye = new uyeClass();

                        if (adU.getText().length() != 0 && soyadU.getText().length() != 0 && kullanici_ad.getText().length() != 0 && sifre.getText().length() != 0 && posta.getText().length() != 0) {
                            yeni_uye.setAd(adU.getText().toString());
                            durum = 1;

                            yeni_uye.setSoyad(soyadU.getText().toString());
                            yeni_uye.setKullanici_ad(kullanici_ad.getText().toString().trim());
                            yeni_uye.setSifre(sifre.getText().toString().trim());
                            yeni_uye.setPosta(posta.getText().toString());
                            mydb.informationPutUye(mydb, yeni_uye);


                            TextView tv1 = new TextView(kaydolActivity.this);
                            tv1.setText("   Basari ile kaydoldunuz");
                            Toast.makeText(getApplication(), "Basari ile kaydoldunuz ", Toast.LENGTH_SHORT).show();
                            tv1.setTextSize(20);
                            tv1.setPadding(10, 10, 10, 10);

                            linear.addView(tv1, lh_yerlesim);
                            lh_yerlesim.setMargins(10, 10, 10, 10);
                            Button bt = new Button(kaydolActivity.this);
                            bt.setText(" Giris yapmak icin tiklayiniz ");
                            bt.setBackgroundColor(Color.parseColor("#305A66"));
                            bt.setTextColor(Color.parseColor("#F4F2FA"));
                            linear.addView(bt, lh_yerlesim);


                            bt.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {


                                    Intent intent = new Intent(kaydolActivity.this, uye_girisActivity.class);

                                    startActivity(intent);
                                    finish();


                                }
                            });


                        } else
                            Toast.makeText(getApplication(), "Lutfen  bos alanlari doldurunuz", Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(getApplication(), "Sifreler ayni degil,tekrar deneyiniz", Toast.LENGTH_SHORT).show();

                        TextView tv2 = new TextView(kaydolActivity.this);
                        tv2.setText("  Sifreler ayni degil, tekrar deneyiniz");
                        tv2.setTextSize(18);
                        tv2.setPadding(10, 10, 10, 10);
                        linear.addView(tv2, lh_yerlesim);
                    }
                }
                else {
                    Toast.makeText(getApplication(), " Zaten uye oldunuz ", Toast.LENGTH_SHORT).show();
                }


            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kaydol, menu);
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
