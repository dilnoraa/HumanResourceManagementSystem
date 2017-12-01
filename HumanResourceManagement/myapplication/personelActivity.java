package com.example.pc.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class personelActivity extends ActionBarActivity {


    Button anasayfa,ilanlar,ekle,temelB,iletisim,isBilgileri,izinEkle,izinlerGoster,tecrube,egitim,mesaiEkle, mesaiGoruntule;
    DatabaseHelper mydb;
    Button gorusmeler,giris_cikis;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personel);

        anasayfa= (Button) findViewById(R.id.anasayfaButonu);
        ilanlar= (Button) findViewById(R.id.ilanlarButonu);
        ekle= (Button) findViewById(R.id.ekleB);
        izinEkle= (Button) findViewById(R.id.ekleIzinB);
        temelB= (Button) findViewById(R.id.temelBilgiler);
        iletisim= (Button) findViewById(R.id.iletisimBbutton);
        isBilgileri= (Button) findViewById(R.id.isBilgi);
        izinlerGoster= (Button) findViewById(R.id.izinlerButton);
        tecrube= (Button) findViewById(R.id.tecrubeButton);
        egitim= (Button) findViewById(R.id.egitimButton);
        mesaiEkle= (Button) findViewById(R.id.mesaiEkleButton);
        mesaiGoruntule= (Button) findViewById(R.id.mesaiGoruntuleButton);
        gorusmeler= (Button) findViewById(R.id.gorusmelerButonuP);
        giris_cikis= (Button) findViewById(R.id.giriscikisButonuP);

        mydb=new DatabaseHelper(this);





        Intent intent = getIntent();
        final int gelenKimlik = intent.getIntExtra("isveren", -1);


        final int gelenPersonel=intent.getIntExtra("basvuran",-1);



        if(gelenPersonel>0) {

            LinearLayout layout = (LinearLayout) findViewById(R.id.linearPersonelekle);
            layout.removeAllViews();



        }


        if(gelenPersonel>0) {

            LinearLayout layout2 = (LinearLayout) findViewById(R.id.personelLinearKaldir);
            layout2.removeAllViews();

        }

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(personelActivity.this,yeniPersonelActivity.class);
                startActivity(intent);




            }
        });


        izinEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayList<personelClass> personelBilgileri = (ArrayList<personelClass>) mydb.getPersonelBilgiler();
                if (personelBilgileri.size() == 0)
                    Toast.makeText(getApplication(), "Personel olmadigi icin izinler eklenemez", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(personelActivity.this, izinlerActivity.class);
                    startActivity(intent);
                }

            }
        });

        izinlerGoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayList<izinlerClass> izinBilgileri = (ArrayList<izinlerClass>) mydb.getizinlerBilgiler();
                if (izinBilgileri.size() == 0)
                    Toast.makeText(getApplication(), "Izinler bilgisi yoktur", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(personelActivity.this, izinGosterActivity.class);
                    startActivity(intent);
                }

            }
        });



        temelB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<personelClass> personelBilgileri = (ArrayList<personelClass>) mydb.getPersonelBilgiler();
              if(personelBilgileri.size()==0)
                  Toast.makeText(getApplication(), "Personel olmadigi icin bilgilere erisilmez", Toast.LENGTH_SHORT).show();
                else {
                  Intent intent = new Intent(personelActivity.this, temelBilgilerPersonel.class);
                  startActivity(intent);
              }
                // finish();
            }
        });



        egitim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayList<okulSinif> okulBilgileri = (ArrayList<okulSinif>) mydb.getAllpersonelOkulBilgiler();
                if (okulBilgileri.size() == 0)
                    Toast.makeText(getApplication(), "Personelin egitim bilgisi bulunmamaktadir", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(personelActivity.this, okulPersonelActivity.class);
                    startActivity(intent);
                }

            }
        });



        tecrube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayList<TecrubeSinif> tecrubeBilgileri = (ArrayList<TecrubeSinif>) mydb.getAlltecrubePersonelBilgiler();
                if (tecrubeBilgileri.size() == 0)
                    Toast.makeText(getApplication(), " Personelin tecrube bilgisi bulunmamaktadir", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(personelActivity.this, tecrubePersonelActivity.class);
                    startActivity(intent);
                }

            }
        });


        iletisim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<personelClass> personelBilgileri = (ArrayList<personelClass>) mydb.getPersonelBilgiler();
                if(personelBilgileri.size()==0)
                    Toast.makeText(getApplication(), "Personelin iletisim bilgisi bulunmamaktadir", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(personelActivity.this, iletisimBilgActivity.class);
                    startActivity(intent);
                }

            }
        });




        isBilgileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<personelClass> personelBilgileri = (ArrayList<personelClass>) mydb.getPersonelBilgiler();
                if(personelBilgileri.size()==0)
                    Toast.makeText(getApplication(), "Personelin is bilgisi yoktur", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(personelActivity.this, isBilgileriActivity.class);
                    startActivity(intent);
                }

            }
        });



        mesaiEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<personelClass> personelBilgileri = (ArrayList<personelClass>) mydb.getPersonelBilgiler();
                if (personelBilgileri.size() == 0)
                    Toast.makeText(getApplication(), "Personel olmadigi icin mesai eklenemez", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(personelActivity.this, mesaiActivity.class);
                    startActivity(intent);
                }

            }
        });



        mesaiGoruntule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<mesaiClass> mesaiBilgileri = (ArrayList<mesaiClass>) mydb.getAllmesaiBilgiler();
                if (mesaiBilgileri.size() == 0)
                    Toast.makeText(getApplication(), "Personelin mesai bilgileri bulunmamaktadir", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(getApplication(), "..."+mesaiBilgileri.size(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(personelActivity.this, mesaiGoruntuleActivity.class);
                    startActivity(intent);
                }

            }
        });




        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(personelActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ilanlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(personelActivity.this,ilanlarActivity.class);
                intent2.putExtra("isveren", gelenKimlik);
                intent2.putExtra("basvuran", gelenPersonel);
                startActivity(intent2);
                finish();
            }
        });

        gorusmeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(personelActivity.this, gorusmelerActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);
                finish();
            }
        });


        giris_cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(personelActivity.this, giris_cikisActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);
                finish();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_personel, menu);
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
