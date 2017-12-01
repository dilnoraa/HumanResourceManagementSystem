package com.example.pc.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class cvActivity extends ActionBarActivity {

    TextView ad, soyad, dogumTarih, cinsiyet, dogumyer, surucuBelg, medeniDurum, evNo, adres, email, egitim, hobi;
    basvuranBilgileri basvuranBilg;

    Button site, kaydet, geriyeB;
    DatabaseHelper mydb;
    LinearLayout lh, lh2, lht, lhtec;
    TextView durum;
    RadioButton uygun, uygundegil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv);

        mydb = new DatabaseHelper(this);
        basvuranBilg = new basvuranBilgileri();


        ad = (TextView) findViewById(R.id.adText);
        soyad = (TextView) findViewById(R.id.soyadText);
        dogumTarih = (TextView) findViewById(R.id.dogumtarihText);
        cinsiyet = (TextView) findViewById(R.id.cinsiyet);
        dogumyer = (TextView) findViewById(R.id.dogumyerText);
        surucuBelg = (TextView) findViewById(R.id.surucuText);
        medeniDurum = (TextView) findViewById(R.id.medeniText);
        evNo = (TextView) findViewById(R.id.evNoText);
        adres = (TextView) findViewById(R.id.adresText);
        email = (TextView) findViewById(R.id.emailText);
        egitim = (TextView) findViewById(R.id.egitimText);
        hobi = (TextView) findViewById(R.id.hobiText);
        site = (Button) findViewById(R.id.siteButton);
        uygun = (RadioButton) findViewById(R.id.uygunRadio);
        uygundegil = (RadioButton) findViewById(R.id.uygundegilRadio);
        kaydet = (Button) findViewById(R.id.kaydet);
        geriyeB = (Button) findViewById(R.id.geriyeButton);
        durum = (TextView) findViewById(R.id.durumCv);
        Intent intent = getIntent();
        final int ilanId = intent.getIntExtra("ilan", -1);// ilan Id
        final int hesapId = intent.getIntExtra("hesap", -1); // hesap Id
        final int basvuranId = intent.getIntExtra("basvuran", -1);// basvuran Id



        basvuranBilg = mydb.getcalisanBilgiById(basvuranId);


        ad.setText(basvuranBilg.getAd());
        soyad.setText(basvuranBilg.getSoyad());
        dogumTarih.setText(basvuranBilg.getDogumTarih());
        cinsiyet.setText(basvuranBilg.getCinsiyet());
        dogumyer.setText(basvuranBilg.getDogumYeri());
        surucuBelg.setText(basvuranBilg.getSurucuBelgesi());
        medeniDurum.setText(basvuranBilg.getMedeniDurum());
        evNo.setText(basvuranBilg.getEvNumarasi());
        adres.setText(basvuranBilg.getAdres());
        email.setText(basvuranBilg.getEmail());
        egitim.setText(basvuranBilg.getEgitimSeviye());
        hobi.setText(basvuranBilg.getHobi());
        durum.setText(basvuranBilg.getDurum());

        ArrayList<egitimSinif> egitimb = (ArrayList<egitimSinif>) mydb.getAllegitimBilgilerbyId(basvuranId);

        if (egitimb.size() == 0)
            Toast.makeText(getApplication(), "Egitim bilgisi bulunmamaktadir", Toast.LENGTH_SHORT).show();
        else {

            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearLayoutdikeyCv);

            for (int i = 0; i < egitimb.size(); i++) {


                lh = new LinearLayout(this);
                lh.setOrientation(LinearLayout.HORIZONTAL);

                TextView textView1 = new TextView(this);
                textView1.setText(egitimb.get(i).getOkulAdi().toString());
                textView1.setBackgroundColor(Color.parseColor("#6D7F8B"));

                TextView textView2 = new TextView(this);
                textView2.setText("    " + egitimb.get(i).getBaslamaTarihi().toString());
                textView2.setBackgroundColor(Color.parseColor("#6D7F8B"));

                TextView textView3 = new TextView(this);
                textView3.setText("    " + egitimb.get(i).getBitisTarihi().toString());
                textView3.setBackgroundColor(Color.parseColor("#6D7F8B"));


                LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                btn_yerlesim.setMargins(20, 0, 20, 0);
                lh.addView(textView1, btn_yerlesim);
                lh.addView(textView2, btn_yerlesim);
                lh.addView(textView3, btn_yerlesim);

                LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lh_yerlesim.setMargins(10, 10, 0, 0);
                linearLayout2.addView(lh, lh_yerlesim);


            }


        }


        ArrayList<TecrubeSinif> tecrubeb = (ArrayList<TecrubeSinif>) mydb.getAlltecrubebyId(basvuranId);
        if (tecrubeb.size() == 0)
            Toast.makeText(getApplication(), "Tecrube bilgisi bulunmamaktadir ", Toast.LENGTH_SHORT).show();
        else {

            LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.linearLayouttecrube);

            lhtec = new LinearLayout(this);
            lhtec.setOrientation(LinearLayout.HORIZONTAL);


            TextView tvt1 = new TextView(this);
            tvt1.setText(" Sirket adi: ");
            tvt1.setTextSize(16);

            final TextView tvt2 = new TextView(this);
            tvt2.setText(" Pozisyon: ");
            tvt2.setTextSize(16);


            TextView tvt3 = new TextView(this);
            tvt3.setText(" Baslama Tarihi: ");
            tvt3.setTextSize(16);


            TextView tvt4 = new TextView(this);
            tvt4.setText(" Bitis Tarihi:");
            tvt4.setTextSize(16);


            LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);


            lhtec.addView(tvt1, btn_yerlesim);
            lhtec.addView(tvt2, btn_yerlesim);
            lhtec.addView(tvt3, btn_yerlesim);
            lhtec.addView(tvt4, btn_yerlesim);

            LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            linearLayout4.addView(lhtec, lh_yerlesim);


            for (int i = 0; i < tecrubeb.size(); i++) {

                lht = new LinearLayout(this);
                lht.setOrientation(LinearLayout.HORIZONTAL);

                TextView textViewt1 = new TextView(this);
                textViewt1.setText(tecrubeb.get(i).getSirketAdi().toString());
                textViewt1.setBackgroundColor(Color.parseColor("#6D7F8B"));

                TextView textViewt2 = new TextView(this);
                textViewt2.setText(tecrubeb.get(i).getPozisyon().toString());
                textViewt2.setBackgroundColor(Color.parseColor("#6D7F8B"));

                TextView textViewt3 = new TextView(this);
                textViewt3.setText(tecrubeb.get(i).getBaslamatarih().toString());
                textViewt3.setBackgroundColor(Color.parseColor("#6D7F8B"));

                TextView textViewt4 = new TextView(this);
                textViewt4.setText(tecrubeb.get(i).getBitistarih().toString());
                textViewt4.setBackgroundColor(Color.parseColor("#6D7F8B"));
                btn_yerlesim.setMargins(7, 0, 7, 2);
                lht.addView(textViewt1, btn_yerlesim);
                lht.addView(textViewt2, btn_yerlesim);
                lht.addView(textViewt3, btn_yerlesim);
                lht.addView(textViewt4, btn_yerlesim);
                lh_yerlesim.setMargins(0, 10, 0, 10);
                linearLayout4.addView(lht, lh_yerlesim);


            }


        }


        ArrayList<dillerSinifi> dillerb = (ArrayList<dillerSinifi>) mydb.getAlldilBilgilerbyId(basvuranId);
        if (dillerb.size() == 0)
            Toast.makeText(getApplication(), "diller yok", Toast.LENGTH_SHORT).show();
        else {

            LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.linearLayoutdikeyCv2);

            for (int i = 0; i < egitimb.size(); i++) {


                lh2 = new LinearLayout(this);
                lh2.setOrientation(LinearLayout.HORIZONTAL);

                TextView textView4 = new TextView(this);
                textView4.setText(dillerb.get(i).getDilAdi().toString());
                textView4.setBackgroundColor(Color.parseColor("#6D7F8B"));

                TextView textView5 = new TextView(this);
                textView5.setText(dillerb.get(i).getDerece().toString());
                textView5.setBackgroundColor(Color.parseColor("#6D7F8B"));

                LinearLayout.LayoutParams btn_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                btn_yerlesim.setMargins(20, 0, 20, 0);

                lh2.addView(textView4, btn_yerlesim);
                lh2.addView(textView5, btn_yerlesim);


                LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lh_yerlesim.setMargins(10, 10, 0, 0);
                linearLayout3.addView(lh2, lh_yerlesim);


            }
        }





        site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = basvuranBilg.getWebSite().toString();
                Intent intent = new Intent(cvActivity.this, LinkActivity.class);
                intent.putExtra("veri", link);
                startActivity(intent);

            }
        });


        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int flag = 0;
                String uygunluk;
                if (uygun.isChecked())
                    uygunluk = "UYGUN";
                else if (uygundegil.isChecked())
                    uygunluk = "UYGUN DEGIL";
                else {
                    flag = 1;
                    uygunluk = "belirsiz";
                }

                LinearLayout linearLayouthaber = (LinearLayout) findViewById(R.id.linearHaber);
                linearLayouthaber.removeAllViews();
                TextView textViewH = new TextView(cvActivity.this);
                LinearLayout.LayoutParams lh_yerlesim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lh_yerlesim.setMargins(10, 10, 0, 0);


                if (flag == 0) {
                    mydb.updateBasvuruBilgisi(mydb, uygunluk, ilanId, hesapId);

                    textViewH.setText(" Basvuruyu degerlendirdiniz ");
                    textViewH.setTextSize(20);

                    linearLayouthaber.addView(textViewH, lh_yerlesim);
                }


                else  {

                    textViewH.setText(" Basvuruyu henuz degerlendirmediniz ");
                    textViewH.setTextSize(20);

                    linearLayouthaber.addView(textViewH, lh_yerlesim);

                }






            }
        });

        geriyeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(cvActivity.this, basvurularActivity.class);

                startActivity(intent2);
                finish();


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cv, menu);
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
