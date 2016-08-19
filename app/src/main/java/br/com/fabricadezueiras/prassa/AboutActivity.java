package br.com.fabricadezueiras.prassa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setTitle("Sobre");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ads
        AdView adView = (AdView) findViewById(R.id.adViewAbout);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        // ads
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
