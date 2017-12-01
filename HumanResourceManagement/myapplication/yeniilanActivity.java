package com.example.pc.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class yeniilanActivity extends ActionBarActivity {

    DatabaseHelper mydb;
    EditText departman, kisiSayi, minYas, maxYas, egitim, tecrube, dil, ek;
    RadioButton aktif, erkek, bayan, aktifdegil, farketmez;
    Button bitti, goster, ilanagit;
    yeniilanClass yeniIlan;
    Button baslangicTarih, bitisTarih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeniilan);

        mydb = new DatabaseHelper(this);
        yeniIlan = new yeniilanClass();

        baslangicTarih = (Button) findViewById(R.id.baslangictarihButton);
        bitisTarih = (Button) findViewById(R.id.bitistarihButtonYeni);

        departman = (EditText) findViewById(R.id.departmanEdit);
        kisiSayi = (EditText) findViewById(R.id.kisiEdit);
        minYas = (EditText) findViewById(R.id.minyasEdit);
        maxYas = (EditText) findViewById(R.id.maxyasEdit);
        egitim = (EditText) findViewById(R.id.egitimEdit);
        tecrube = (EditText) findViewById(R.id.tecrubeEdit);
        dil = (EditText) findViewById(R.id.dilEdit);
        ek = (EditText) findViewById(R.id.ekEdit);
        bitti = (Button) findViewById(R.id.bitti);
        goster = (Button) findViewById(R.id.goster);
        erkek = (RadioButton) findViewById(R.id.erkekRadio);
        bayan = (RadioButton) findViewById(R.id.bayanRadio);
        farketmez = (RadioButton) findViewById(R.id.farketmezRadio);
        aktif = (RadioButton) findViewById(R.id.aktifRadio);
        aktifdegil = (RadioButton) findViewById(R.id.aktifdegilRadio);

        ilanagit = (Button) findViewById(R.id.ilanaGec);


        Intent intent = getIntent();
        final int gelenKimlik = intent.getIntExtra("isveren", -1);

        final int gelenPersonel = intent.getIntExtra("basvuran", -1);


        ilanagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(yeniilanActivity.this, ilanlarActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);
                finish();

            }
        });


        baslangicTarih.setOnClickListener(new View.OnClickListener() {//tarihButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {

                Calendar mcurrentTime = Calendar.getInstance();
                int year = mcurrentTime.get(Calendar.YEAR);
                int month = mcurrentTime.get(Calendar.MONTH);
                int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(yeniilanActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        baslangicTarih.setText(dayOfMonth + "/" + monthOfYear + "/" + year);

                    }
                }, year, month, day);
                datePicker.setTitle("Tarih Seciniz");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Iptal", datePicker);

                datePicker.show();

            }
        });


        bitisTarih.setOnClickListener(new View.OnClickListener() {//tarihButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {

                Calendar mcurrentTime = Calendar.getInstance();
                int year = mcurrentTime.get(Calendar.YEAR);
                int month = mcurrentTime.get(Calendar.MONTH);
                int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(yeniilanActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        bitisTarih.setText(dayOfMonth + "/" + monthOfYear + "/" + year);

                    }
                }, year, month, day);
                datePicker.setTitle("Tarih Seciniz");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Iptal", datePicker);

                datePicker.show();

            }
        });


        AddData();

    }


    public void AddData() {

        bitti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cinsiyet, aktiflik;

                if (erkek.isChecked())
                    cinsiyet = "ERKEK";
                else if (bayan.isChecked())
                    cinsiyet = "KADIN";
                else cinsiyet = " farketmez ";


                if (aktifdegil.isChecked())
                    aktiflik = "AKTIF DEGIL";
                else aktiflik = "AKTIF";


                if (kisiSayi.getText().length() != 0 && departman.getText().length() != 0 && minYas.getText().length() != 0 && egitim.getText().length() != 0) {
                    yeniIlan.setYeniilanClass(baslangicTarih.getText().toString(), bitisTarih.getText().toString(), kisiSayi.getText().toString(), departman.getText().toString(), minYas.getText().toString(), maxYas.getText().toString(), cinsiyet, egitim.getText().toString(), tecrube.getText().toString(), dil.getText().toString(), ek.getText().toString(), aktiflik);

                    mydb.informationPutYeniilan(mydb, yeniIlan);
                    Toast.makeText(getApplication(), " Yeni ilan basari ile olusturdunuz  " + yeniIlan.getAktiflik().toString(), Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplication(), "Yukardaki bos alanlari doldurunuz " + yeniIlan.getAktiflik().toString(), Toast.LENGTH_SHORT).show();





            }
        });
    }




    public void showmessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yeniilan, menu);
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
