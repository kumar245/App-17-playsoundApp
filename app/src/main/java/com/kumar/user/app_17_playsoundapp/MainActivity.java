package com.kumar.user.app_17_playsoundapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button playMusic;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=new MediaPlayer();
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.game_field);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
            int intDuration=mediaPlayer.getDuration();
                String StringDuration=String.valueOf(intDuration);
                Toast.makeText(MainActivity.this, "Duration : " + StringDuration, Toast.LENGTH_SHORT).show();
            }
        });
        playMusic= (Button) findViewById(R.id.button);
        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (mediaPlayer.isPlaying()){
                   pauseMusic();
               }
               else {
                   startMusic();
               }
            }
        });
    }

    private void pauseMusic() {
        if (mediaPlayer!=null){
            mediaPlayer.pause();
            playMusic.setText("PLAY");
        }
    }
    private void startMusic(){
        if (mediaPlayer!=null){
            mediaPlayer.start();
            playMusic.setText("PAUSE");
        }
    }
}
