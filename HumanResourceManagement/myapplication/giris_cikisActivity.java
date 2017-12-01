package com.example.pc.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
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
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class giris_cikisActivity extends ActionBarActivity {

    Spinner spSicil, spTur;
    DatabaseHelper mydb;
    personelClass pc;
    TextView isim;
    Button tarih, saat, kaydet;
    String turTut;
    int sicilNotut = -1, secildi = 0;
    Button goruntule;
    LinearLayout lh, l_h;
    personelClass personel;

    Button anasayfa, ilanlar, personelButton, gorusmeler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_cikis);

        spSicil = (Spinner) findViewById(R.id.spinnerSicilGirisCikis);
        mydb = new DatabaseHelper(this);
        isim = (TextView) findViewById(R.id.isimGC);
        tarih = (Button) findViewById(R.id.tarihGC);
        saat = (Button) findViewById(R.id.saatGC);
        spTur = (Spinner) findViewById(R.id.spinnerTurGirisCikis);
        kaydet = (Button) findViewById(R.id.kaydetGC);
        goruntule = (Button) findViewById(R.id.goruntuleGC);

        anasayfa = (Button) findViewById(R.id.anasayfaButonugiris);
        ilanlar = (Button) findViewById(R.id.ilanlarButonugiris);
        personelButton = (Button) findViewById(R.id.personelButonugiris);
        gorusmeler = (Button) findViewById(R.id.gorusmelerButonugiris);


        Intent intent = getIntent();
        final int gelenKimlik = intent.getIntExtra("isveren", -1);


        final int gelenPersonel = intent.getIntExtra("basvuran", -1);


        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(giris_cikisActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


        gorusmeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(giris_cikisActivity.this, gorusmelerActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);
                finish();

            }
        });


        personelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(giris_cikisActivity.this, personelActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);
                finish();

            }
        });


        ilanlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(giris_cikisActivity.this, ilanlarActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);
                finish();

            }
        });


        ArrayList<personelClass> personelBilgileri = (ArrayList<personelClass>) mydb.getPersonelBilgiler();
        ArrayList<Integer> personelSicil = new ArrayList<Integer>();

        for (int i = 0; i < personelBilgileri.size(); i++)
            personelSicil.add(personelBilgileri.get(i).getSicil());


        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, personelSicil);
        spSicil.setAdapter(adapter);


        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.tur, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTur.setAdapter(adapter2);


        spSicil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ArrayList<personelClass> personelBilgileri = (ArrayList<personelClass>) mydb.getPersonelBilgiler();
                pc = new personelClass();
                pc = personelBilgileri.get(position);

                isim.setText(pc.getAd() + " " + pc.getSoyad());


                sicilNotut = personelBilgileri.get(position).getSicil();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        tarih.setOnClickListener(new View.OnClickListener() {//tarihButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {

                Calendar mcurrentTime = Calendar.getInstance();
                int year = mcurrentTime.get(Calendar.YEAR);
                int month = mcurrentTime.get(Calendar.MONTH);
                int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(giris_cikisActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        tarih.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                        secildi++;
                    }
                }, year, month, day);
                datePicker.setTitle("Tarih Seçiniz");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Ýptal", datePicker);

                datePicker.show();

            }
        });


        saat.setOnClickListener(new View.OnClickListener() {//saatButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {

                Calendar mcurrentTime = Calendar.getInstance();//
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog timePicker;

                timePicker = new TimePickerDialog(giris_cikisActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        saat.setText(selectedHour + ":" + selectedMinute);
                        secildi++;
                    }
                }, hour, minute, true);
                timePicker.setTitle("Saat Seciniz");
                timePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", timePicker);
                timePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Iptal", timePicker);

                timePicker.show();
            }
        });


        spTur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position == 1)
                    turTut = "giris";
                else if (position == 2)
                    turTut = "çýkýs";
                else
                    turTut = "girilmedi";



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                giris_cikisClass bir_kayit = new giris_cikisClass();

                if (sicilNotut == -1 || tarih.equals("TARÝH GÝR") || saat.equals("SAAT GÝR") || turTut.equals("girilmedi"))
                    Toast.makeText(getApplicationContext(), "lutfen alanlar doldurun ", Toast.LENGTH_SHORT).show();
                else {

                    bir_kayit.setgiris_cikisClass(sicilNotut, tarih.getText().toString(), saat.getText().toString(), turTut);

                    mydb.informationPutGirisCikis(mydb, bir_kayit);
                }


            }
        });


        goruntule.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {





                                             ArrayList<giris_cikisClass> giris_cikisBilgileri = (ArrayList<giris_cikisClass>) mydb.getAllgiris_cikisBilgiler();

                                             //  mydb.closeDB();
                                             LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearVerticalGC);

                                             linearLayout2.removeAllViews();

                                             if (giris_cikisBilgileri.size() == 0) {



                                                 TextView textViewYok = new TextView(giris_cikisActivity.this);
                                                 textViewYok.setText("KAYIT BULUNMAMAKTADIR");
                                                 textViewYok.setTextSize(9);
                                                 textViewYok.setBackgroundColor(Color.parseColor("#296588"));
                                                 textViewYok.setTextColor(Color.parseColor("#F4F2FA"));
                                                 LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                                 linearLayout2.addView(textViewYok, lh_yerlesim);


                                             } else {


                                                 l_h = new LinearLayout(giris_cikisActivity.this);

                                                 l_h.setOrientation(LinearLayout.HORIZONTAL);

                                                 TextView tv1 = new TextView(giris_cikisActivity.this);
                                                 tv1.setText(" SICIL NO: ");
                                                 tv1.setTextSize(9);
                                                 tv1.setBackgroundColor(Color.parseColor("#296588"));
                                                 tv1.setTextColor(Color.parseColor("#F4F2FA"));

                                                 TextView tv2 = new TextView(giris_cikisActivity.this);
                                                 tv2.setText(" AD: ");
                                                 tv2.setTextSize(9);
                                                 tv2.setBackgroundColor(Color.parseColor("#296588"));
                                                 tv2.setTextColor(Color.parseColor("#F4F2FA"));

                                                 TextView tv3 = new TextView(giris_cikisActivity.this);
                                                 tv3.setText(" SOYAD: ");
                                                 tv3.setTextSize(9);
                                                 tv3.setBackgroundColor(Color.parseColor("#296588"));
                                                 tv3.setTextColor(Color.parseColor("#F4F2FA"));


                                                 TextView tv4 = new TextView(giris_cikisActivity.this);
                                                 tv4.setText(" TARIH: ");
                                                 tv4.setTextSize(9);
                                                 tv4.setBackgroundColor(Color.parseColor("#296588"));
                                                 tv4.setTextColor(Color.parseColor("#F4F2FA"));


                                                 TextView tv5 = new TextView(giris_cikisActivity.this);
                                                 tv5.setText(" SAAT: ");
                                                 tv5.setTextSize(9);
                                                 tv5.setBackgroundColor(Color.parseColor("#296588"));
                                                 tv5.setTextColor(Color.parseColor("#F4F2FA"));

                                                 TextView tv6 = new TextView(giris_cikisActivity.this);
                                                 tv6.setText(" TUR: ");
                                                 tv6.setTextSize(9);
                                                 tv6.setBackgroundColor(Color.parseColor("#296588"));
                                                 tv6.setTextColor(Color.parseColor("#F4F2FA"));

                                                 tv1.setTextSize(12);
                                                 tv2.setTextSize(12);
                                                 tv3.setTextSize(12);
                                                 tv4.setTextSize(12);
                                                 tv5.setTextSize(12);
                                                 tv6.setTextSize(12);

                                                 LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                                                 btn_yerlesim.setMargins(5, 5, 5, 5);
                                                 l_h.addView(tv1, btn_yerlesim);
                                                 l_h.addView(tv2, btn_yerlesim);
                                                 l_h.addView(tv3, btn_yerlesim);
                                                 l_h.addView(tv4, btn_yerlesim);
                                                 l_h.addView(tv5, btn_yerlesim);
                                                 l_h.addView(tv6, btn_yerlesim);


                                                 LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                                 linearLayout2.addView(l_h, lh_yerlesim);


                                                 int i, sayi;
                                                 for (i = 0; i < giris_cikisBilgileri.size(); i++) {


                                                     lh = new LinearLayout(giris_cikisActivity.this);

                                                     lh.setOrientation(LinearLayout.HORIZONTAL);


                                                     TextView textView1 = new TextView(giris_cikisActivity.this);
                                                     textView1.setText("    " + giris_cikisBilgileri.get(i).getSicilNo().toString() + "      ");


                                                     personel = new personelClass();
                                                     personel = mydb.getpersonelBilgiById(giris_cikisBilgileri.get(i).getSicilNo());


                                                     TextView textView2 = new TextView(giris_cikisActivity.this);
                                                     textView2.setText(personel.getAd().toString());


                                                     TextView textView3 = new TextView(giris_cikisActivity.this);
                                                     textView3.setText(personel.getSoyad().toString());


                                                     TextView textView4 = new TextView(giris_cikisActivity.this);
                                                     textView4.setText(giris_cikisBilgileri.get(i).getTarih().toString());


                                                     TextView textView5 = new TextView(giris_cikisActivity.this);
                                                     textView5.setText(giris_cikisBilgileri.get(i).getSaat().toString());


                                                     TextView textView6 = new TextView(giris_cikisActivity.this);
                                                     textView6.setText(giris_cikisBilgileri.get(i).getTur().toString());





                                                     lh.addView(textView1, btn_yerlesim);
                                                     lh.addView(textView2, btn_yerlesim);
                                                     lh.addView(textView3, btn_yerlesim);
                                                     lh.addView(textView4, btn_yerlesim);
                                                     lh.addView(textView5, btn_yerlesim);
                                                     lh.addView(textView6, btn_yerlesim);



                                                     linearLayout2.addView(lh, lh_yerlesim);




                                                 }


                                             }


                                         }
                                     }

        );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_giris_cikis, menu);
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
