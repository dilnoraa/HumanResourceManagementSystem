package com.example.pc.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class izinGosterActivity extends ActionBarActivity {

    DatabaseHelper mydb;
    LinearLayout lh;
    personelClass personel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izin_goster);
        mydb=new DatabaseHelper(this);

        ArrayList<izinlerClass> izinBilgileri = (ArrayList<izinlerClass>) mydb.getizinlerBilgiler();

        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearVerticalizinGoster);

        int i,sayi;
        for (i = 0; i < izinBilgileri.size(); i++) {


            lh = new LinearLayout(this);

            lh.setOrientation(LinearLayout.HORIZONTAL);


            TextView textView1 = new TextView(this);

            textView1.setText(izinBilgileri.get(i).getCalisan_id().toString());


            TextView textView2 = new TextView(this);
            textView2.setText(izinBilgileri.get(i).getBas_tarih().toString());


            TextView textView3 = new TextView(this);
            textView3.setText(izinBilgileri.get(i).getBitis_tarih().toString());


            personel=new personelClass();
            personel= mydb.getpersonelBilgiById(izinBilgileri.get(i).getCalisan_id());


            TextView textView4 = new TextView(this);
            textView4.setText(personel.getAd().toString());


            TextView textView5 = new TextView(this);
            textView5.setText(personel.getSoyad().toString());






            LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            btn_yerlesim.setMargins(5, 5, 5, 5);

            lh.addView(textView1, btn_yerlesim);
            lh.addView(textView4, btn_yerlesim);
            lh.addView(textView5, btn_yerlesim);
            lh.addView(textView2, btn_yerlesim);
            lh.addView(textView3, btn_yerlesim);


            LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lh_yerlesim.setMargins(10, 10, 0, 0);
            linearLayout2.addView(lh, lh_yerlesim);

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_izin_goster, menu);
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
