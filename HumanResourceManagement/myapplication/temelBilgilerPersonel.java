package com.example.pc.myapplication;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class temelBilgilerPersonel extends ActionBarActivity {

    DatabaseHelper mydb;
    LinearLayout lh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temel_bilgiler_personel);

        mydb = new DatabaseHelper(this);

        ArrayList<personelClass> personelBilgileri = (ArrayList<personelClass>) mydb.getPersonelBilgiler();

        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearVertical);


        int i, sayi;
        for (i = 0; i < personelBilgileri.size(); i++) {


            lh = new LinearLayout(this);

            lh.setOrientation(LinearLayout.HORIZONTAL);


            TextView textView1 = new TextView(this);
            textView1.setText(personelBilgileri.get(i).getSicil().toString());

            textView1.setBackgroundColor(Color.parseColor("#6D7F8B"));

            TextView textView2 = new TextView(this);
                textView2.setText(personelBilgileri.get(i).getAd().toString());


            TextView textView3 = new TextView(this);
            textView3.setText(personelBilgileri.get(i).getSoyad().toString());



            TextView textView4 = new TextView(this);
            textView4.setText(personelBilgileri.get(i).getDogumYeri().toString());

            TextView textView5 = new TextView(this);
            textView5.setText(personelBilgileri.get(i).getDogumTarih().toString());

            TextView textView6 = new TextView(this);
            textView6.setText(personelBilgileri.get(i).getMedeniDurum().toString());


            LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            btn_yerlesim.setMargins(5, 5, 5, 5);
            lh.addView(textView1, btn_yerlesim);
            lh.addView(textView2, btn_yerlesim);
            lh.addView(textView3, btn_yerlesim);
            lh.addView(textView4, btn_yerlesim);
            lh.addView(textView5, btn_yerlesim);
            lh.addView(textView6, btn_yerlesim);


            LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lh_yerlesim.setMargins(10, 10, 0, 0);
            linearLayout2.addView(lh, lh_yerlesim);

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temel_bilgiler_personel, menu);
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
