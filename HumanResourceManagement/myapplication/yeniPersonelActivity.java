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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class yeniPersonelActivity extends ActionBarActivity {

    Button bitti,dogumTarih;
    DatabaseHelper mydb;
    EditText sicil,ad, soyad, dogumYer, evNo, cepNo, adres, email,egitimSeviye,departman,pozisyon,maas,site;
    RadioButton erkek, bayan, var, yok, girilmedi, evli, bekar;
    Spinner okulsayi,sirketSayi;
    LinearLayout lh,lh2, lht, lh2t;
    EditText edit1,edit2,edit3,edit4;
    EditText edit1t,edit2t,edit3t,edit4t;
    okulSinif okul_s;
    TecrubeSinif tecrube_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_personel);

        bitti= (Button) findViewById(R.id.bittibutton);

        sicil= (EditText) findViewById(R.id.sicilEdit);
        ad= (EditText) findViewById(R.id.adEdittextp);
        soyad= (EditText) findViewById(R.id.soyadEditp);
        dogumYer= (EditText) findViewById(R.id.yerEditp);
        dogumTarih= (Button) findViewById(R.id.dogumtarihButtonPers);
        cepNo= (EditText) findViewById(R.id.cepnoEditp);
        evNo= (EditText) findViewById(R.id.evnoEditp);
        adres= (EditText) findViewById(R.id.adresEditp);
        email= (EditText) findViewById(R.id.postaEditp);
        egitimSeviye= (EditText) findViewById(R.id.egitimEditp);
        departman= (EditText) findViewById(R.id.departmanEditp);
        pozisyon= (EditText) findViewById(R.id.pozisyonEditp);
        maas= (EditText) findViewById(R.id.maasEditp);
        site= (EditText) findViewById(R.id.siteEditp);

        erkek= (RadioButton) findViewById(R.id.erkekRadiop);
        bayan= (RadioButton) findViewById(R.id.bayanRadiop);
        var= (RadioButton) findViewById(R.id.varEditp);
        yok= (RadioButton) findViewById(R.id.yokEditp);
        girilmedi= (RadioButton) findViewById(R.id.girilmemisEditp);
        evli= (RadioButton) findViewById(R.id.evliEditp);
        bekar= (RadioButton) findViewById(R.id.bekarEditp);

        okulsayi= (Spinner) findViewById(R.id.yersayiSpinner_yenipersonel);
        sirketSayi= (Spinner) findViewById(R.id.yersayiSpinner_tecrubePersonel);

        final List<EditText> editTextList1 = new ArrayList<EditText>();
        final List<EditText> editTextList2 = new ArrayList<EditText>();
        final List<EditText> editTextList3 = new ArrayList<EditText>();
        final List<EditText> editTextList4 = new ArrayList<EditText>();

        final List<EditText> editTextList1t = new ArrayList<EditText>();
        final List<EditText> editTextList2t = new ArrayList<EditText>();
        final List<EditText> editTextList3t = new ArrayList<EditText>();
        final List<EditText> editTextList4t = new ArrayList<EditText>();


        dogumTarih.setOnClickListener(new View.OnClickListener() {//tarihButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {

                Calendar mcurrentTime = Calendar.getInstance();
                int year = mcurrentTime.get(Calendar.YEAR);
                int month = mcurrentTime.get(Calendar.MONTH);
                int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(yeniPersonelActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        dogumTarih.setText(dayOfMonth + "/" + monthOfYear + "/" + year);

                    }
                }, year, month, day);
                datePicker.setTitle("Tarih Seciniz");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Iptal", datePicker);

                datePicker.show();

            }
        });




        mydb=new DatabaseHelper(this);

        ArrayAdapter adapter= ArrayAdapter.createFromResource(this,R.array.yersayi,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        okulsayi.setAdapter(adapter);


        ArrayAdapter adapter2= ArrayAdapter.createFromResource(this,R.array.yersayi,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sirketSayi.setAdapter(adapter2);


        okulsayi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {


                if (position == 0)
                    Toast.makeText(getApplication(), "okul yok...", Toast.LENGTH_SHORT).show();
                else {



                    LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearLayoutOkul_yenipersonel);

                    lh = new LinearLayout(yeniPersonelActivity.this);
                    lh.setOrientation(LinearLayout.HORIZONTAL);


                    TextView tv1 = new TextView(yeniPersonelActivity.this);
                    tv1.setText("  Okul adi: ");
                    tv1.setTextSize(15);

                    TextView tv2 = new TextView(yeniPersonelActivity.this);
                    tv2.setText("Derece: ");
                    tv2.setTextSize(15);


                    TextView tv3 = new TextView(yeniPersonelActivity.this);
                    tv3.setText("Baslama Tarihi: ");
                    tv3.setTextSize(15);


                    TextView tv4 = new TextView(yeniPersonelActivity.this);
                    tv4.setText("Bitis Tarihi: ");
                    tv4.setTextSize(15);


                    LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    btn_yerlesim.setMargins(5, 5, 5, 5);

                    lh.addView(tv1, btn_yerlesim);
                    lh.addView(tv2, btn_yerlesim);
                    lh.addView(tv3, btn_yerlesim);
                    lh.addView(tv4, btn_yerlesim);

                    LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    linearLayout2.addView(lh, lh_yerlesim);

                    for (int i = 0; i < position; i++) {


                        lh2 = new LinearLayout(yeniPersonelActivity.this);
                        lh2.setOrientation(LinearLayout.HORIZONTAL);

                        edit1 = new EditText(yeniPersonelActivity.this);
                        edit1.setHint("okul adini yaz");
                        edit1.setBackgroundColor(Color.parseColor("#305A66"));

                        edit1.setTextSize(10);
                        edit1.setId(position);

                        edit2 = new EditText(yeniPersonelActivity.this);
                        edit2.setHint("derece gir");
                        edit2.setBackgroundColor(Color.parseColor("#305A66"));

                        edit2.setTextSize(10);

                        edit3 = new EditText(yeniPersonelActivity.this);
                        edit3.setHint("tarih gir");
                        edit3.setBackgroundColor(Color.parseColor("#305A66"));


                        edit3.setTextSize(10);


                        edit4 = new EditText(yeniPersonelActivity.this);
                        edit4.setText("tarih gir:");
                        edit4.setBackgroundColor(Color.parseColor("#305A66"));


                        edit4.setTextSize(10);





                        lh2.addView(edit1, btn_yerlesim);
                        lh2.addView(edit2, btn_yerlesim);
                        lh2.addView(edit3, btn_yerlesim);
                        lh2.addView(edit4, btn_yerlesim);


                        linearLayout2.addView(lh2, lh_yerlesim);


                        editTextList1.add(edit1);
                        editTextList2.add(edit2);
                        editTextList3.add(edit3);
                        editTextList4.add(edit4);


                    }


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        sirketSayi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {


                if (position == 0)
                    Toast.makeText(getApplication(), "sirket yok...", Toast.LENGTH_SHORT).show();
                else {



                    LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.linearLayoutTecrube_yenipersonel);

                    lht = new LinearLayout(yeniPersonelActivity.this);
                    lht.setOrientation(LinearLayout.HORIZONTAL);


                    TextView tv1 = new TextView(yeniPersonelActivity.this);
                    tv1.setText(" Sirket adi: ");
                    tv1.setTextSize(15);

                    TextView tv2 = new TextView(yeniPersonelActivity.this);
                    tv2.setText(" Pozisyon: ");
                    tv2.setTextSize(15);


                    TextView tv3 = new TextView(yeniPersonelActivity.this);
                    tv3.setText(" Baslama Tarihi: ");
                    tv3.setTextSize(15);


                    TextView tv4 = new TextView(yeniPersonelActivity.this);
                    tv4.setText(" Bitis Tarihi: ");
                    tv4.setTextSize(15);


                    LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    btn_yerlesim.setMargins(5, 5, 5, 5);

                    lht.addView(tv1, btn_yerlesim);
                    lht.addView(tv2, btn_yerlesim);
                    lht.addView(tv3, btn_yerlesim);
                    lht.addView(tv4, btn_yerlesim);

                    LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    linearLayout3.addView(lht, lh_yerlesim);

                    for (int i = 0; i < position; i++) {


                        lh2t = new LinearLayout(yeniPersonelActivity.this);
                        lh2t.setOrientation(LinearLayout.HORIZONTAL);

                        edit1t = new EditText(yeniPersonelActivity.this);
                        edit1t.setHint("sirket gir");
                        edit1t.setTextSize(10);
                        edit1t.setBackgroundColor(Color.parseColor("#305A66"));
                        edit1t.setId(position);

                        edit2t = new EditText(yeniPersonelActivity.this);
                        edit2t.setHint("pozisyon gir");
                        edit2t.setBackgroundColor(Color.parseColor("#305A66"));
                        edit2t.setTextSize(10);

                        edit3t = new EditText(yeniPersonelActivity.this);
                        edit3t.setHint(" tarih gir ");
                        edit3t.setBackgroundColor(Color.parseColor("#305A66"));
                        edit3t.setTextSize(10);


                        edit4t = new EditText(yeniPersonelActivity.this);
                        edit4t.setHint(" tarih gir ");
                        edit4t.setBackgroundColor(Color.parseColor("#305A66"));
                        edit4t.setTextSize(10);





                        lh2t.addView(edit1t, btn_yerlesim);
                        lh2t.addView(edit2t, btn_yerlesim);
                        lh2t.addView(edit3t, btn_yerlesim);
                        lh2t.addView(edit4t, btn_yerlesim);


                        linearLayout3.addView(lh2t, lh_yerlesim);


                        editTextList1t.add(edit1t);
                        editTextList2t.add(edit2t);
                        editTextList3t.add(edit3t);
                        editTextList4t.add(edit4t);


                    }


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        bitti.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {

                              personelClass pc = new personelClass();

                              LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearBittiPersonel);
                              linearLayout2.removeAllViews();
                              if (sicil.getText().toString().trim().length() == 0 || ad.getText().toString().trim().length()==0  || soyad.getText().toString().trim().length() == 0 || egitimSeviye.getText().toString().trim().length() == 0 || departman.getText().toString().trim().length() == 0 || pozisyon.getText().toString().trim().length() == 0 || cepNo.getText().toString().trim().length() == 0 || email.getText().toString().trim().length() == 0) {

                                  TextView tv=new TextView(yeniPersonelActivity.this);
                                  tv.setText("Lutfen yukardaki bos alanlari doldurunuz ");
                                      LinearLayout.LayoutParams lh_yerlesim=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                                  linearLayout2.addView(tv, lh_yerlesim);


                              }
                              else {
                                  pc.setSicil(Integer.valueOf(sicil.getText().toString()));
                                  pc.setAd(ad.getText().toString());
                                  pc.setSoyad(soyad.getText().toString());

                                  String cinsiyet, belge, medeni, durum;

                                  if (erkek.isChecked())
                                      cinsiyet = "ERKEK";
                                  else
                                      cinsiyet = "KADIN";

                                  if (var.isChecked())
                                      belge = "VAR";
                                  else if (yok.isChecked())
                                      belge = "YOK";
                                  else belge = "GIRILMEDI";

                                  if (evli.isChecked())
                                      medeni = "EVLI";
                                  else medeni = "BEKAR";

                                  pc.setCinsiyet(cinsiyet);
                                  pc.setDogumYeri(dogumYer.getText().toString());
                                  pc.setDogumTarih(dogumTarih.getText().toString());
                                  pc.setSurucuBelgesi(belge);
                                  pc.setMedeniDurum(medeni);
                                  pc.setEgitimSeviye(egitimSeviye.getText().toString());
                                  pc.setDepartman(departman.getText().toString());
                                  pc.setPozisyon(pozisyon.getText().toString());
                                  pc.setMaas(maas.getText().toString());
                                  pc.setCepNumarasi(cepNo.getText().toString());
                                  pc.setEvNumarasi(evNo.getText().toString());
                                  pc.setAdres(adres.getText().toString());
                                  pc.setEmail(email.getText().toString());
                                  pc.setWebSite(site.getText().toString());

                                  mydb.informationPutPersonel(mydb, pc);


                                  for (int j = 0; j < editTextList1.size(); j++) {


                                      okul_s = new okulSinif();
                                      okul_s.setId(Integer.valueOf(sicil.getText().toString()));
                                      okul_s.setOkulAdi(editTextList1.get(j).getText().toString());
                                      okul_s.setDerece(editTextList2.get(j).getText().toString());
                                      okul_s.setBaslamatarih(editTextList3.get(j).getText().toString());
                                      okul_s.setBitistarih(editTextList4.get(j).getText().toString());
                                      mydb.informationPutOkulPersonel(mydb, okul_s);
                                  }


                                  for (int j = 0; j < editTextList1t.size(); j++) {


                                      tecrube_s = new TecrubeSinif();
                                      tecrube_s.setId(Integer.valueOf(sicil.getText().toString()));
                                      tecrube_s.setSirketAdi(editTextList1t.get(j).getText().toString());
                                      tecrube_s.setPozisyon(editTextList2t.get(j).getText().toString());
                                      tecrube_s.setBaslamatarih(editTextList3t.get(j).getText().toString());
                                      tecrube_s.setBitistarih(editTextList4t.get(j).getText().toString());
                                      mydb.informationPutTecrubePersonel(mydb, tecrube_s);
                                  }

                                  TextView tv2=new TextView(yeniPersonelActivity.this);
                                  tv2.setText( "Yeni personeli basari ile eklediniz ");
                                  LinearLayout.LayoutParams lh_yerlesim=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                                  linearLayout2.addView(tv2, lh_yerlesim);

                              }
                          }
                      });
                  }

                  @Override
                  public boolean onCreateOptionsMenu (Menu menu){
                      // Inflate the menu; this adds items to the action bar if it is present.
                      getMenuInflater().inflate(R.menu.menu_yeni_personel, menu);
                      return true;
                  }

                  @Override
                  public boolean onOptionsItemSelected (MenuItem item){
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
