package com.example.pc.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class inceleActivity extends ActionBarActivity {


    Button tiklayiniz,ilanlaradon;
    yeniilanClass yi;
    DatabaseHelper myDb;
    TextView bastarih,bitistarih,departman,cinsiyet,yas1,yas2,egitim,tecrube,ek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incele);

        myDb = new DatabaseHelper(this);
        bastarih= (TextView) findViewById(R.id.basTarih);
        bitistarih= (TextView) findViewById(R.id.bitisTarih);
        departman= (TextView) findViewById(R.id.departmanText);
        cinsiyet= (TextView) findViewById(R.id.cinsiyet);
        yas1= (TextView) findViewById(R.id.minyas);
        yas2= (TextView) findViewById(R.id.maxyas);
        egitim= (TextView) findViewById(R.id.egitim);
        tecrube= (TextView) findViewById(R.id.tecrube);
        ilanlaradon= (Button) findViewById(R.id.ilanlaradonButonu);
        ek= (TextView) findViewById(R.id.ek);
        yi=new yeniilanClass();

        Intent intent=getIntent();
        final int gelenVeri=intent.getIntExtra("numara", -1);



        final int gelenKimlik = intent.getIntExtra("isveren", -1);


        final int gelenPersonel=intent.getIntExtra("basvuran",-1);


        ilanlaradon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inceleActivity.this, ilanlarActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);
                finish();
            }
        });







       // myDb.closeDB();

        yi.setYeniilanClass(myDb.getIlanBilgibyId(gelenVeri).getBaslangicTarih(),
                myDb.getIlanBilgibyId(gelenVeri).getBitisTarih(), myDb.getIlanBilgibyId(gelenVeri).getKisiSayi(),
                myDb.getIlanBilgibyId(gelenVeri).getDepartman(), myDb.getIlanBilgibyId(gelenVeri).getMinYas(),
                myDb.getIlanBilgibyId(gelenVeri).getMaxYas(), myDb.getIlanBilgibyId(gelenVeri).getCinsiyet(),
                myDb.getIlanBilgibyId(gelenVeri).getEgitim(), myDb.getIlanBilgibyId(gelenVeri).getTecrube(),
                myDb.getIlanBilgibyId(gelenVeri).getDil(), myDb.getIlanBilgibyId(gelenVeri).getEkbilgi(),
                myDb.getIlanBilgibyId(gelenVeri).getAktiflik());

      //  myDb.closeDB();




       bastarih.setText(yi.getBaslangicTarih().toString());
        bitistarih.setText(yi.getBitisTarih().toString());
        departman.setText(yi.getDepartman().toString());
        cinsiyet.setText("Cinsiyeti  " + yi.getCinsiyet().toString());
        yas1.setText(yi.getMinYas().toString());
        yas2.setText(yi.getMaxYas().toString());
        egitim.setText(yi.getEgitim().toString());
        tecrube.setText(yi.getTecrube().toString());
        ek.setText(yi.getEkbilgi().toString());






        tiklayiniz= (Button) findViewById(R.id.tiklayinizButonu);

        tiklayiniz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<basvuru_ilanClass> bilgi = (ArrayList<basvuru_ilanClass>) myDb.getbasvuru_ilanbyId(gelenVeri, gelenPersonel);

                if (bilgi.size() == 0) {

                    Intent intent = new Intent(inceleActivity.this, bilgiler.class);
                    intent.putExtra("numara", gelenVeri);
                    intent.putExtra("isveren", gelenKimlik);
                    intent.putExtra("basvuran", gelenPersonel);
                    startActivity(intent);
                    finish();
                }

                else {


                    LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearincele);

                    TextView textView1 = new TextView(inceleActivity.this);
                    textView1.setText("BU ILANA ONCEDEN BASVURDUNUZ");


                    LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                 lh_yerlesim.setMargins(7,7,7,7);
                    linearLayout2.addView(textView1, lh_yerlesim);


                }

            }

        });


        if(gelenKimlik!=0) {


            LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.linearincele);
            linearLayout4.removeAllViews();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_incele, menu);
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
