package com.example.pc.myapplication;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class mesaiActivity extends ActionBarActivity {


    Spinner sicilNosp, mesaiSecsp, tipSpinner;
    DatabaseHelper mydb;
    personelClass pc;
    TextView ad;
    Button tarih1, tarih2, kaydet;
    int secildi = 0;
    int sicilNotut;
    TextView tarih1Text, tarih2Text;
    EditText ucret;
    String mesaiTut, tipTut;
    int durumMesai=1,durumTip=1, tarihsayac=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesai);

        sicilNosp = (Spinner) findViewById(R.id.spinnerSicilM);
        mydb = new DatabaseHelper(this);
        ad = (TextView) findViewById(R.id.mesaiAdText);
        mesaiSecsp = (Spinner) findViewById(R.id.spinnerMesaiSec);
        tarih1 = (Button) findViewById(R.id.basTarihButton);
        tarih2 = (Button) findViewById(R.id.bitisTarihButton);
        tarih1Text = (TextView) findViewById(R.id.tarih1text);
        tarih2Text = (TextView) findViewById(R.id.tarih2Text);
        ucret = (EditText) findViewById(R.id.saatUcretedit);
        tipSpinner = (Spinner) findViewById(R.id.spinnerTipSec);
        kaydet = (Button) findViewById(R.id.kaydetB);


        ArrayList<personelClass> personelBilgileri = (ArrayList<personelClass>) mydb.getPersonelBilgiler();
        ArrayList<Integer> personelSicil = new ArrayList<Integer>();
        for (int i = 0; i < personelBilgileri.size(); i++)
            personelSicil.add(personelBilgileri.get(i).getSicil());

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, personelSicil);
        sicilNosp.setAdapter(adapter);


        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.mesai, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mesaiSecsp.setAdapter(adapter2);

        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.tip, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipSpinner.setAdapter(adapter3);


        sicilNosp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ArrayList<personelClass> personelBilgileri = (ArrayList<personelClass>) mydb.getPersonelBilgiler();
                pc = new personelClass();
                pc = personelBilgileri.get(position);

                ad.setText(pc.getAd() + " " + pc.getSoyad());
                sicilNotut = pc.getSicil();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        mesaiSecsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position == 1) {
                    mesaiTut = "tam zamanli";
                    durumMesai = 1;
                }
                else if (position == 2) {
                    mesaiTut = "yarý zamanlý";
                    durumMesai = 1;
                }
                else {
                    mesaiTut = "girilmedi";
                    durumMesai=0;
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        tipSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position == 1) {
                    tipTut = "vardiya";
                    durumTip=1;
                }
                else if (position == 2) {
                    tipTut = "ekstra";
                    durumTip=1;
                }
                else {
                    tipTut = "girilmedi";
                    durumTip=0;
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        tarih1.setOnClickListener(new View.OnClickListener() {//tarihButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {

                Calendar mcurrentTime = Calendar.getInstance();
                int year = mcurrentTime.get(Calendar.YEAR);
                int month = mcurrentTime.get(Calendar.MONTH);
                int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(mesaiActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        tarih1Text.setText(dayOfMonth + "/" + monthOfYear + "/" + year);//Ayarla butonu týklandýðýnda textview'a yazdýrýyoruz
                        secildi++;
                    }
                }, year, month, day);
                datePicker.setTitle("Tarih Seciniz");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Iptal", datePicker);

                datePicker.show();
                tarihsayac++;

            }
        });


        tarih2.setOnClickListener(new View.OnClickListener() {//tarihButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {

                Calendar mcurrentTime = Calendar.getInstance();
                int year = mcurrentTime.get(Calendar.YEAR);
                int month = mcurrentTime.get(Calendar.MONTH);
                int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(mesaiActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        tarih2Text.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                        secildi++;
                    }
                }, year, month, day);
                datePicker.setTitle("Tarih Seciniz");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Iptal", datePicker);

                datePicker.show();
                tarihsayac++;

            }
        });


        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mesaiClass bir_mesai = new mesaiClass();
                if (ucret.getText().toString().trim().length() == 0 || durumMesai==0 || durumTip==0 || tarihsayac<2)
                    Toast.makeText(getApplicationContext(), "Lutfen bos alanlari giriniz ", Toast.LENGTH_SHORT).show();
                else {

                    int sayi = Integer.parseInt(ucret.getText().toString());
                    bir_mesai.setmesaiClass(sicilNotut, mesaiTut, tarih1Text.getText().toString(), tarih2Text.getText().toString(), sayi, tipTut);

                    mydb.informationPutMesai(mydb, bir_mesai);
                    Toast.makeText(getApplicationContext(), " Mesai bilgisi basari ile kaydettiniz  ", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mesai, menu);
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
