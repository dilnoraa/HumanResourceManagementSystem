package com.example.pc.myapplication;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class izinlerActivity extends ActionBarActivity {

    Spinner sicilSp;
    DatabaseHelper mydb;
    TextView isim, basText, bitisText;
    Button baslama, bitis, ayarla;
    personelClass pc;

    int durum = 0;
    int secildi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izinler);
        sicilSp = (Spinner) findViewById(R.id.spinnerizinler);
        isim = (TextView) findViewById(R.id.isimText);
        mydb = new DatabaseHelper(this);
        baslama = (Button) findViewById(R.id.buttonBaslamaizin);
        bitis = (Button) findViewById(R.id.buttonBitisizin);
        basText = (TextView) findViewById(R.id.basText);
        bitisText = (TextView) findViewById(R.id.bitisText);
        ayarla = (Button) findViewById(R.id.izniAyarla);


        ArrayList<personelClass> personelBilgileri = (ArrayList<personelClass>) mydb.getPersonelBilgiler();
        ArrayList<Integer> personelSicil = new ArrayList<Integer>();
        personelSicil.add(0);
        for (int i = 0; i < personelBilgileri.size(); i++)
            personelSicil.add(personelBilgileri.get(i).getSicil());


        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, personelSicil);
        sicilSp.setAdapter(adapter);


        sicilSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ArrayList<personelClass> personelBilgileri = (ArrayList<personelClass>) mydb.getPersonelBilgiler();
                pc = new personelClass();
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.llayout);
                if (position != 0) {
                    pc = personelBilgileri.get(position - 1);



                        linearLayout2.removeAllViews();

                        TextView tv1 = new TextView(izinlerActivity.this);
                        tv1.setText(" Ad Soyad: ");
                        tv1.setBackgroundColor(Color.parseColor("#296588"));
                        tv1.setTextColor(Color.parseColor("#F4F2FA"));


                        LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        lh_yerlesim.setMargins(7, 7, 7, 7);
                        linearLayout2.addView(tv1, lh_yerlesim);
                        isim.setText(pc.getAd() + " " + pc.getSoyad());



                    durum = 1;
                }

                else  {


                    isim.setText(" - ");
                    durum=0;




                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        baslama.setOnClickListener(new View.OnClickListener() {//tarihButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {

                Calendar mcurrentTime = Calendar.getInstance();
                int year = mcurrentTime.get(Calendar.YEAR);
                int month = mcurrentTime.get(Calendar.MONTH);
                int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker;//Datepicker objemiz
                datePicker = new DatePickerDialog(izinlerActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        basText.setText(dayOfMonth + "/" + monthOfYear + "/" + year);//Ayarla butonu týklandýðýnda textview'a yazdýrýyoruz
                        secildi++;
                    }
                }, year, month, day);
                datePicker.setTitle("Tarih Seciniz");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Iptal", datePicker);

                datePicker.show();

            }
        });


        bitis.setOnClickListener(new View.OnClickListener() {//tarihButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {

                Calendar mcurrentTime = Calendar.getInstance();
                int year = mcurrentTime.get(Calendar.YEAR);
                int month = mcurrentTime.get(Calendar.MONTH);
                int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(izinlerActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        bitisText.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                        secildi++;
                    }
                }, year, month, day);
                datePicker.setTitle("Tarih Seciniz");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Iptal", datePicker);

                datePicker.show();

            }
        });

        ayarla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (secildi >= 2 && durum==1 ) {
                    mydb.informationPutIzinler(mydb, pc.getSicil(), basText.getText().toString(), bitisText.getText().toString());
                    LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.linearbasarili);
                    TextView tvb = new TextView(izinlerActivity.this);
                    tvb.setText("   Izni basari ile kaydettiniz  ");
                    tvb.setBackgroundColor(Color.parseColor("#296588"));
                    tvb.setTextColor(Color.parseColor("#F4F2FA"));
                    LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    lh_yerlesim.setMargins(10, 10, 10, 10);
                    linearLayout3.addView(tvb, lh_yerlesim);
                }
                else
                    Toast.makeText(getApplication(), "lutfen alanlari doldurunuz", Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_izinler, menu);
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
