package com.example.pc.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class bilgiler extends ActionBarActivity {

    DatabaseHelper myDb;
    EditText ad, soyad, dogumYer, evNo, cepNo, adres, email, okulAdi1, yil1, yilB1, okulAdi2, yil2, yilB2, okulAdi3, yil3, yilB3;
    RadioButton erkek, bayan, var, yok, girilmedi, evli, bekar;
    EditText dil1, dil2, dil3, egitimSeviye, hobi, site;
    RadioButton dilRadio1iyi, dilRadio1orta, dilRadio1kotu, dilRadio2iyi, dilRadio2orta, dilRadio2kotu, dilRadio3iyi, dilRadio3orta, dilRadio3kotu;
    Button ekle, goster, ilanagit, dogumTarih;
    TextView t;
    Spinner yerSayi;
    LinearLayout lh, lh2;

    basvuranBilgileri bilgi;
    egitimSinif egitimB1, egitimB2, egitimB3;
    dillerSinifi dilSinif1, dilSinif2, dilSinif3;
    TecrubeSinif ts;
    EditText edit1, edit2, edit3, edit4;
    TextView tv1;
    TextView durumTv;
    RadioButton calisRadio, calismaRadio;
    int dtarih = 0;

    int eklendi = 0;


    final List<EditText> editTextList1 = new ArrayList<EditText>();
    final List<EditText> editTextList2 = new ArrayList<EditText>();
    final List<EditText> editTextList3 = new ArrayList<EditText>();
    final List<EditText> editTextList4 = new ArrayList<EditText>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgiler);


        Intent intent = getIntent();
        final int gelenVeri = intent.getIntExtra("numara", -1);


        final int gelenKimlik = intent.getIntExtra("isveren", -1);

        final int gelenPersonel = intent.getIntExtra("basvuran", -1);


        Toast.makeText(getApplication(), "kmlk:" + gelenKimlik, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplication(), "persnl:" + gelenPersonel, Toast.LENGTH_SHORT).show();


        myDb = new DatabaseHelper(this);
        ad = (EditText) findViewById(R.id.adEdittext);
        soyad = (EditText) findViewById(R.id.soyadEdit);
        dogumYer = (EditText) findViewById(R.id.yerEdit);
        dogumTarih = (Button) findViewById(R.id.dogumtarihButton);
        evNo = (EditText) findViewById(R.id.evnoEdit);
        cepNo = (EditText) findViewById(R.id.cepnoEdit);
        adres = (EditText) findViewById(R.id.adresEdit);
        email = (EditText) findViewById(R.id.postaEdit);
        erkek = (RadioButton) findViewById(R.id.erkekRadio);
        bayan = (RadioButton) findViewById(R.id.bayanRadio);
        var = (RadioButton) findViewById(R.id.varEdit);
        yok = (RadioButton) findViewById(R.id.yokEdit);
        girilmedi = (RadioButton) findViewById(R.id.girilmemisEdit);
        evli = (RadioButton) findViewById(R.id.evliEdit);
        bekar = (RadioButton) findViewById(R.id.bekarEdit);
        hobi = (EditText) findViewById(R.id.hobiEdit);
        site = (EditText) findViewById(R.id.siteEdit);
        ekle = (Button) findViewById(R.id.bitti);
        goster = (Button) findViewById(R.id.goster);
        ilanagit = (Button) findViewById(R.id.ilanlaraGit);

        durumTv = (TextView) findViewById(R.id.durumText);

        calisRadio = (RadioButton) findViewById(R.id.calisiyorRadio);
        calismaRadio = (RadioButton) findViewById(R.id.calismiyorRadio);

        egitimSeviye = (EditText) findViewById(R.id.egitimEdit);
        okulAdi1 = (EditText) findViewById(R.id.okulEdit1);
        yil1 = (EditText) findViewById(R.id.okulTarihEdit1);
        yilB1 = (EditText) findViewById(R.id.okulTarihEditB1);

        okulAdi2 = (EditText) findViewById(R.id.okulEdit2);
        yil2 = (EditText) findViewById(R.id.okulTarihEdit2);
        yilB2 = (EditText) findViewById(R.id.okulTarihEditB2);

        okulAdi3 = (EditText) findViewById(R.id.okulEdit3);
        yil3 = (EditText) findViewById(R.id.okulTarihEdit3);
        yilB3 = (EditText) findViewById(R.id.okulTarihEditB3);

        dil1 = (EditText) findViewById(R.id.dilEdit1);
        dil2 = (EditText) findViewById(R.id.dilEdit2);
        dil3 = (EditText) findViewById(R.id.dilEdit3);

        dilRadio1iyi = (RadioButton) findViewById(R.id.iyiRadio1);
        dilRadio1orta = (RadioButton) findViewById(R.id.ortaRadio1);
        dilRadio1kotu = (RadioButton) findViewById(R.id.kotuRadio1);


        dilRadio2iyi = (RadioButton) findViewById(R.id.iyiRadio2);
        dilRadio2orta = (RadioButton) findViewById(R.id.ortaRadio2);
        dilRadio2kotu = (RadioButton) findViewById(R.id.kotuRadio2);

        dilRadio3iyi = (RadioButton) findViewById(R.id.iyiRadio3);
        dilRadio3orta = (RadioButton) findViewById(R.id.ortaRadio3);
        dilRadio3kotu = (RadioButton) findViewById(R.id.kotuRadio3);

        yerSayi = (Spinner) findViewById(R.id.yersayiSpinner);


        dogumTarih.setOnClickListener(new View.OnClickListener() {//tarihButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {

                Calendar mcurrentTime = Calendar.getInstance();
                int year = mcurrentTime.get(Calendar.YEAR);
                int month = mcurrentTime.get(Calendar.MONTH);
                int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(bilgiler.this, new DatePickerDialog.OnDateSetListener() {

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
                dtarih = 1;

            }
        });


        t = (TextView) findViewById(R.id.adText);
        bilgi = new basvuranBilgileri();

        final ArrayList<TecrubeSinif> tecrubeList = new ArrayList<TecrubeSinif>();


        ilanagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(bilgiler.this, ilanlarActivity.class);
                intent.putExtra("isveren", gelenKimlik);
                intent.putExtra("basvuran", gelenPersonel);
                startActivity(intent);
                finish();
            }
        });


        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.yersayi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yerSayi.setAdapter(adapter);


        yerSayi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {


                if (position == 0)
                    Toast.makeText(getApplication(), "Tecrube yok...", Toast.LENGTH_SHORT).show();
                else {



                    LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearLayoutTecrube);

                    lh = new LinearLayout(bilgiler.this);
                    lh.setOrientation(LinearLayout.HORIZONTAL);


                    tv1 = new TextView(bilgiler.this);

                    tv1.setText("Sirket adi: ");
                    tv1.setTextSize(15);


                    final TextView tv2 = new TextView(bilgiler.this);
                    tv2.setText("Pozisyon: ");
                    tv2.setTextSize(15);


                    TextView tv3 = new TextView(bilgiler.this);
                    tv3.setText("Baslama Tarihi: ");
                    tv3.setTextSize(15);


                    TextView tv4 = new TextView(bilgiler.this);
                    tv4.setText("Bitis Tarihi: ");
                    tv4.setTextSize(15);


                    LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                    btn_yerlesim.setMargins(5, 5, 5, 5);
                    lh.addView(tv1, btn_yerlesim);
                    lh.addView(tv2, btn_yerlesim);
                    lh.addView(tv3, btn_yerlesim);
                    lh.addView(tv4, btn_yerlesim);

                    LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    lh_yerlesim.setMargins(5, 5, 5, 5);
                    linearLayout2.addView(lh, lh_yerlesim);

                    for (int i = 0; i < position; i++) {


                        lh2 = new LinearLayout(bilgiler.this);
                        lh2.setOrientation(LinearLayout.HORIZONTAL);

                        edit1 = new EditText(bilgiler.this);
                        edit1.setHint("Sirket gir");

                        edit1.setBackgroundColor(Color.parseColor("#305A66"));
                        edit1.setTextSize(11);
                        edit1.setId(position);

                        edit2 = new EditText(bilgiler.this);
                        edit2.setHint("pozisyn gir");
                        edit2.setBackgroundColor(Color.parseColor("#305A66"));
                        edit2.setTextSize(11);

                        edit3 = new EditText(bilgiler.this);
                        edit3.setHint("tarih giriniz");
                        edit3.setBackgroundColor(Color.parseColor("#305A66"));
                        edit3.setTextSize(11);


                        edit4 = new EditText(bilgiler.this);
                        edit4.setHint("tarih giriniz");
                        edit4.setBackgroundColor(Color.parseColor("#305A66"));
                        edit4.setTextSize(11);


                        btn_yerlesim.setMargins(5, 0, 5, 0);

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






        AddData(gelenVeri, gelenPersonel);


    }

    public void AddData(final int gelenVeri, final int gelenHesap) {


        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.bilgilerLinearL);

                if (ad.getText().toString().trim().length() != 0 && soyad.getText().toString().trim().length() != 0 && dogumYer.getText().toString().trim().length() != 0 && dtarih == 1 && cepNo.getText().toString().trim().length() != 0 && email.getText().toString().trim().length() != 0 && egitimSeviye.getText().toString().trim().length() != 0) {
                    if (eklendi == 0) {
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


                        if (calisRadio.isChecked())
                            durum = "CALISIYOR";
                        else durum = "CALISMIYOR";




                        bilgi.setBasvuranBilgileri(ad.getText().toString(), soyad.getText().toString(), cinsiyet, dogumYer.getText().toString(), dogumTarih.getText().toString(), belge, medeni, evNo.getText().toString(), cepNo.getText().toString(), adres.getText().toString(), email.getText().toString(), egitimSeviye.getText().toString(), hobi.getText().toString(), site.getText().toString(), durum);

                        myDb.informationPut(myDb, bilgi);



                        ArrayList<Integer> idler = new ArrayList<Integer>();
                        Cursor cursor = myDb.getIdbasvurBilgi(myDb);


                        if (cursor.moveToFirst()) {

                            do {
                                idler.add(cursor.getInt(0));
                            } while (cursor.moveToNext());
                        }




                        int olusanId = idler.size();


                        if (olusanId != 0) {
                            egitimB1 = new egitimSinif();

                            egitimB1.setegitimSinif(olusanId, okulAdi1.getText().toString(), yil1.getText().toString(), yilB1.getText().toString());

                            myDb.informationPutEgitimB(myDb, egitimB1);



                            egitimB2 = new egitimSinif();

                            egitimB2.setegitimSinif(olusanId, okulAdi2.getText().toString(), yil2.getText().toString(), yilB2.getText().toString());

                            myDb.informationPutEgitimB(myDb, egitimB2);
                            // myDb.closeDB();


                            egitimB3 = new egitimSinif();

                            egitimB3.setegitimSinif(olusanId, okulAdi3.getText().toString(), yil3.getText().toString(), yilB3.getText().toString());

                            myDb.informationPutEgitimB(myDb, egitimB3);
                            //  myDb.closeDB();


                            for (int j = 0; j < editTextList1.size(); j++) {


                                ts = new TecrubeSinif();
                                ts.setId(olusanId);
                                ts.setSirketAdi(editTextList1.get(j).getText().toString());
                                ts.setPozisyon(editTextList2.get(j).getText().toString());
                                ts.setBaslamatarih(editTextList3.get(j).getText().toString());
                                ts.setBitistarih(editTextList4.get(j).getText().toString());
                                myDb.informationPutTecrube(myDb, ts);


                            }


                            String derece1, derece2, derece3;

                            if (dilRadio1iyi.isChecked())
                                derece1 = "iyi";
                            else if (dilRadio1orta.isChecked())
                                derece1 = "orta";
                            else
                                derece1 = "kotu";


                            dilSinif1 = new dillerSinifi();
                            dilSinif1.setdillerSinifi(olusanId, dil1.getText().toString(), derece1);
                            myDb.informationPutDilBilgi(myDb, dilSinif1);



                            if (dilRadio2iyi.isChecked())
                                derece2 = "iyi";
                            else if (dilRadio2orta.isChecked())
                                derece2 = "orta";
                            else
                                derece2 = "kotu";


                            dilSinif2 = new dillerSinifi();
                            dilSinif2.setdillerSinifi(olusanId, dil2.getText().toString(), derece2);
                            myDb.informationPutDilBilgi(myDb, dilSinif2);


                            if (dilRadio3iyi.isChecked())
                                derece3 = "iyi";
                            else if (dilRadio3orta.isChecked())
                                derece3 = "orta";
                            else
                                derece3 = "kotu";


                            dilSinif3 = new dillerSinifi();
                            dilSinif3.setdillerSinifi(olusanId, dil3.getText().toString(), derece3);
                            myDb.informationPutDilBilgi(myDb, dilSinif3);


                            int ilan_id = gelenVeri;
                            myDb.informationPutBasvuru(myDb, ilan_id, olusanId, gelenHesap);





                        }


                        eklendi = 1;



                        TextView textt = new TextView(bilgiler.this);
                        textt.setText(" CV BASARI ILE OLUSTURDUNUZ ");
                        textt.setTextSize(16);

                        LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        lh_yerlesim.setMargins(7, 7, 7, 7);
                        linearLayout5.addView(textt, lh_yerlesim);

                    } else {


                        TextView text = new TextView(bilgiler.this);
                        text.setText("Bu bilgileri artik zaten eklediniz");
                        text.setTextSize(16);
                        LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        linearLayout5.addView(text, lh_yerlesim);


                    }
                }

                else{

                    TextView textH = new TextView(bilgiler.this);
                    textH.setText("Lutfen bos alanlari doldurunuz");
                    textH.setTextSize(16);
                    LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    linearLayout5.addView(textH, lh_yerlesim);



                }

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
        getMenuInflater().inflate(R.menu.menu_bilgiler, menu);
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
