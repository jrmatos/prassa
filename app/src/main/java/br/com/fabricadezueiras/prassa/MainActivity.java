package br.com.fabricadezueiras.prassa;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private MediaPlayer seriousPlayer;
    private MediaPlayer laughingPlayer;
    private Button seriousButton;
    private Button laughingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ads
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        // ads

        // create players
        seriousPlayer = MediaPlayer.create(MainActivity.this, R.raw.prassa);
        laughingPlayer = MediaPlayer.create(MainActivity.this, R.raw.laugh);

        // get button references
        seriousButton = (Button) findViewById(R.id.seriousButton);
        laughingButton = (Button) findViewById(R.id.laughingButton);

        // change icon back to play when finished
        seriousPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                seriousButton.setBackgroundResource(R.drawable.cazalbe_serious_play);
            }
        });

        // change icon back to play when finished
        laughingPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                laughingButton.setBackgroundResource(R.drawable.cazalbe_laughing_play);
            }
        });
    }


    public void seriousClick(View v) throws IOException {

        // check serious player
        if (seriousPlayer.isPlaying()) {
            seriousButton.setBackgroundResource(R.drawable.cazalbe_serious_play);
            seriousPlayer.seekTo(0);
            seriousPlayer.pause();
        } else {

            // check laughing player
            if (laughingPlayer.isPlaying()) {
                laughingButton.setBackgroundResource(R.drawable.cazalbe_laughing_play);
                laughingPlayer.seekTo(0);
                laughingPlayer.pause();
            }

            // start playing
            seriousButton.setBackgroundResource(R.drawable.cazalbe_serious_stop);
            seriousPlayer.start();
        }

    }

    public void laughingClick(View v) throws IOException {

        // check laughing player
        if (laughingPlayer.isPlaying()) {
            laughingButton.setBackgroundResource(R.drawable.cazalbe_laughing_play);
            laughingPlayer.seekTo(0);
            laughingPlayer.pause();
        } else {

            // check serious player
            if (seriousPlayer.isPlaying()) {
                seriousButton.setBackgroundResource(R.drawable.cazalbe_serious_play);
                seriousPlayer.seekTo(0);
                seriousPlayer.pause();
            }

            // start playing
            laughingButton.setBackgroundResource(R.drawable.cazalbe_laughing_stop);
            laughingPlayer.start();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sobre:
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
