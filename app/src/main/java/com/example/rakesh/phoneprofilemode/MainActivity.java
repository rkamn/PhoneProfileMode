package com.example.rakesh.phoneprofilemode;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rbgeneral,rbsilent,rbvibration;
    RadioGroup profilemode;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profilemode = (RadioGroup) findViewById(R.id.profilemode);
        
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);


        profilemode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton)findViewById(checkedId);
                switch(radioButton.getId()){
                    case R.id.rbgeneral:
                        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        Toast.makeText(MainActivity.this,"You are in General mode",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rbvibration:
                        audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        Toast.makeText(MainActivity.this,"You are in Vibration mode",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbsilent:
                        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                        Toast.makeText(MainActivity.this,"You are in Silent mode",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
