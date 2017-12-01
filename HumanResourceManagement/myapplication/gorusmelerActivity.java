package com.example.pc.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
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


public class gorusmelerActivity extends ActionBarActivity {


    Button saatButton, tarihButton, kisi, durum, ekle, goruntule;
    TextView saatTextView, tarihTextView;
    DatabaseHelper mydb;
    Spinner sp2;
    LinearLayout lh,l_h;
    int idbasvuran, idilan,idhesap;
    String drm = "belirsiz";
    int flag=0;
    int tarihsayac=0,kisiTiklandi=0,durumSecildi=0;

    Button anasayfa,ilanlar,personelButton,giris_cikis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorusmeler);


        saatButton = (Button) findViewById(R.id.button1);
        tarihButton = (Button) findViewById(R.id.button2);
        saatTextView = (TextView) findViewById(R.id.textView1);
        tarihTextView = (TextView) findViewById(R.id.textView2);
        kisi = (Button) findViewById(R.id.kisiButton);
        sp2 = (Spinner) findViewById(R.id.spinner);
        durum = (Button) findViewById(R.id.durumButton);
        ekle = (Button) findViewById(R.id.ekleButton);
        goruntule = (Button) findViewById(R.id.goruntuleButton);

        anasayfa= (Button) findViewById(R.id.anasayfaButonugorusme);
        ilanlar= (Button) findViewById(R.id.ilanlarButonugorusme);
        personelButton= (Button) findViewById(R.id.personelButonugorusme);
        giris_cikis= (Button) findViewById(R.id.giriscikisButonugorusme);



        Intent intent = getIntent();
        final int gelenKimlik = intent.getIntExtra("isveren", -1);

        final int gelenPersonel=intent.getIntExtra("basvuran",-1);



        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gorusmelerActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });




        giris_cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gorusmelerActivity.this, giris_cikisActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);
                finish();

            }
        });



        personelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gorusmelerActivity.this, personelActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);
                finish();

            }
        });


        ilanlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gorusmelerActivity.this, ilanlarActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);
                finish();

            }
        });




        mydb = new DatabaseHelper(this);

        saatButton.setOnClickListener(new View.OnClickListener() {//saatButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {

                Calendar mcurrentTime = Calendar.getInstance();//
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog timePicker;


                timePicker = new TimePickerDialog(gorusmelerActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        saatTextView.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                timePicker.setTitle("Saat Seciniz");
                timePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", timePicker);
                timePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "ıptal", timePicker);

                timePicker.show();
                tarihsayac++;
            }
        });


        tarihButton.setOnClickListener(new View.OnClickListener() {//tarihButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {

                Calendar mcurrentTime = Calendar.getInstance();
                int year = mcurrentTime.get(Calendar.YEAR);
                int month = mcurrentTime.get(Calendar.MONTH);
                int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(gorusmelerActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        tarihTextView.setText(dayOfMonth + "/" + monthOfYear + "/" + year);

                    }
                }, year, month, day);
                datePicker.setTitle("Tarih Seciniz");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Iptal", datePicker);

                datePicker.show();
                tarihsayac++;

            }
        });


        kisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag == 0) {

                    flag = 1;

                    LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.llyatay);
                    Spinner sp = new Spinner(gorusmelerActivity.this);

                      sp.setBackgroundColor(Color.rgb( 136, 136, 140));



                    Cursor cursor = mydb.getbasvuruilanBilgi(mydb);


                    final ArrayList<Integer> listIdilan = new ArrayList<>();
                    final ArrayList<Integer> listIdcalisan = new ArrayList<>();
                    final ArrayList<String> listuygunluk = new ArrayList<>();
                    final ArrayList<Integer> listIdhesap = new ArrayList<>();


                    if (cursor.moveToFirst()) {

                        do {
                            listIdilan.add(cursor.getInt(0));
                            listIdcalisan.add(cursor.getInt(1));
                            listuygunluk.add(cursor.getString(2));
                            listIdhesap.add(cursor.getInt(3));
                        } while (cursor.moveToNext());
                    }


                    if (listIdilan.size() == 0) {

                    } else {


                        ArrayList<String> list = new ArrayList<String>();
                        final ArrayList<Integer> listid = new ArrayList<Integer>();
                        final ArrayList<Integer> listilan = new ArrayList<Integer>();
                        final ArrayList<Integer> listhesap = new ArrayList<Integer>();

                        for (int i = 0; i < listIdcalisan.size(); i++) {

                            if (listuygunluk.get(i).toString().equals("UYGUN")) {


                                int id, ilan, hesapNo;
                                id = listIdcalisan.get(i);
                                ilan = listIdilan.get(i);
                                hesapNo = listIdhesap.get(i);

                                basvuranBilgileri bb = new basvuranBilgileri();

                                bb = mydb.getcalisanBilgiById(id);


                                list.add(bb.getAd() + " " + bb.getSoyad());
                                listid.add(id);
                                listilan.add(ilan);
                                listhesap.add(hesapNo);



                            }


                        }


                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, list);
                        sp.setAdapter(adapter);


                        LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                        linearLayout2.addView(sp, lh_yerlesim);


                        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                                idbasvuran = listid.get(position);
                                idilan = listilan.get(position);
                                idhesap = listhesap.get(position);


                                kisiTiklandi=1;


                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });


                    }


                }
            }
        });


        durum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayAdapter adapter2 = ArrayAdapter.createFromResource(gorusmelerActivity.this, R.array.durumlar, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp2.setAdapter(adapter2);

                sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                        if (position == 0)
                            drm = "uygun";
                        else if (position == 1)
                            drm = "uygun degil";
                        else
                            drm = "belirsiz";
                        durumSecildi=1;


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


            }
        });


        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                gorusmeClass bir_gorusme = new gorusmeClass();
                if (idbasvuran == 0 || idilan == 0 || durumSecildi==0 || tarihsayac<2 || kisiTiklandi==0)
                    Toast.makeText(getApplication(), "LUTFEN ALANLARI DOLDURUNUZ", Toast.LENGTH_SHORT).show();
                else {
                    bir_gorusme.setBasvuranId(idbasvuran);
                    bir_gorusme.setIlanId(idilan);
                    bir_gorusme.setHesapNoId(idhesap);
                    bir_gorusme.setTarih(tarihTextView.getText().toString());
                    bir_gorusme.setSaat(saatTextView.getText().toString());
                    bir_gorusme.setDurum(drm);

                    mydb.informationPutGorusme(mydb, bir_gorusme);

                    Toast.makeText(getApplication(), "Gorusmeyi basari ile kaydettiniz", Toast.LENGTH_SHORT).show();
                    ArrayList<gorusmeClass> liste = (ArrayList<gorusmeClass>) mydb.getAllgorusmeBilgiler();


                    if (liste.size() == 0)
                        Toast.makeText(getApplication(), "Gorusme listesi bulunmamaktadir", Toast.LENGTH_SHORT).show();
                    else {



                    }
                }


            }
        });


        goruntule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.LinearLayoutdikeygorusme);

                ArrayList<gorusmeClass> liste = (ArrayList<gorusmeClass>) mydb.getAllgorusmeBilgiler();


                if (liste.size() == 0) {

                linearLayout2.removeAllViews();}
                else {

                    linearLayout2.removeAllViews();






                    l_h=new LinearLayout(gorusmelerActivity.this);
                    l_h.setOrientation(LinearLayout.HORIZONTAL);




                   TextView tv1=new TextView(gorusmelerActivity.this);
                    tv1.setText("            AD:  ");
                    tv1.setTextSize(10);
                    tv1.setBackgroundColor(Color.parseColor("#296588"));
                    tv1.setTextColor(Color.parseColor("#F4F2FA"));


                    final TextView tv2=new TextView(gorusmelerActivity.this);
                    tv2.setText(" SOYAD:  ");
                    tv2.setTextSize(10);
                    tv2.setBackgroundColor(Color.parseColor("#296588"));
                    tv2.setTextColor(Color.parseColor("#F4F2FA"));



                    TextView tv3=new TextView(gorusmelerActivity.this);
                    tv3.setText(" TARIH:  ");
                    tv3.setTextSize(10);
                    tv3.setBackgroundColor(Color.parseColor("#296588"));
                    tv3.setTextColor(Color.parseColor("#F4F2FA"));



                    TextView tv4=new TextView(gorusmelerActivity.this);
                    tv4.setText(" SAAT:  ");
                    tv4.setTextSize(10);
                    tv4.setBackgroundColor(Color.parseColor("#296588"));
                    tv4.setTextColor(Color.parseColor("#F4F2FA"));



                    TextView tv5=new TextView(gorusmelerActivity.this);
                    tv5.setText(" DURUM:  ");
                    tv5.setTextSize(10);
                    tv5.setBackgroundColor(Color.parseColor("#296588"));
                    tv5.setTextColor(Color.parseColor("#F4F2FA"));



                    TextView tv6=new TextView(gorusmelerActivity.this);
                    tv6.setText(" POSTA:  ");
                    tv6.setTextSize(10);
                    tv6.setBackgroundColor(Color.parseColor("#296588"));
                    tv6.setTextColor(Color.parseColor("#F4F2FA"));




                    LinearLayout.LayoutParams btn_yerlesim=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

                    btn_yerlesim.setMargins(5,5,5,5);
                    l_h.addView(tv1, btn_yerlesim);
                    l_h.addView(tv2, btn_yerlesim);
                    l_h.addView(tv3, btn_yerlesim);
                    l_h.addView(tv4, btn_yerlesim);
                    l_h.addView(tv5, btn_yerlesim);
                    l_h.addView(tv6, btn_yerlesim);

                    LinearLayout.LayoutParams lh_yerlesim=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                    linearLayout2.addView(l_h, lh_yerlesim);




                    for (int  i = 0; i < liste.size(); i++) {


                        lh = new LinearLayout(gorusmelerActivity.this);
                        lh.setOrientation(LinearLayout.HORIZONTAL);
                        basvuranBilgileri bb = new basvuranBilgileri();
                        bb = mydb.getcalisanBilgiById(liste.get(i).getBasvuranId());


                        Button bt=new Button(gorusmelerActivity.this);
                        bt.setText("sil");

                        bt.setId(i);
                        final int finalI = liste.get(i).getGorusmeId();
                        final int finalI1 = i;
                        bt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                fonksiyon(finalI);
                                linearLayout2.removeViewAt(finalI1 + 1);
                            }
                        });


                        TextView textView1 = new TextView(gorusmelerActivity.this);
                        textView1.setText(bb.getAd().toString());


                        TextView textView2 = new TextView(gorusmelerActivity.this);
                        textView2.setText(bb.getSoyad().toString());


                        TextView textView3 = new TextView(gorusmelerActivity.this);
                        textView3.setText(liste.get(i).getTarih().toString());


                        TextView textView4 = new TextView(gorusmelerActivity.this);
                        textView4.setText(liste.get(i).getSaat().toString());


                        TextView textView5 = new TextView(gorusmelerActivity.this);
                        textView5.setText(liste.get(i).getDurum().toString());



                        TextView textView6 = new TextView(gorusmelerActivity.this);
                        textView6.setText(bb.getEmail().toString());


                        textView1.setTextSize(11);
                        textView2.setTextSize(11);
                        textView3.setTextSize(11);
                        textView4.setTextSize(11);
                        textView5.setTextSize(11);
                        textView6.setTextSize(11);
                        bt.setTextSize(11);





                        lh.addView(bt,btn_yerlesim);
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
        });

    }



    public void  fonksiyon(int sayi) {


        mydb.deleteGorusmebyid(mydb, String.valueOf(sayi));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gorusmeler, menu);
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
