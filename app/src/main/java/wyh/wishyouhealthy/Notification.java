package wyh.wishyouhealthy;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.media.AudioManager;

import static wyh.wishyouhealthy.R.id.Btn_Back_Set_2;
import static wyh.wishyouhealthy.R.id.Btn_set_alarm;

public class Notification extends ActionBarActivity {

    private Switch muteSwitch; private Switch smsSwitch; private Switch emailSwitch;
    private AudioManager AudioManager;

    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.noti_main);
        AudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        initUI();

    }

    private void initUI() {

        Button Back = (Button) findViewById(Btn_Back_Set_2);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Setting.class);
                startActivity(i);
            }
        });

        muteSwitch = (Switch) findViewById(R.id.muteswitch);
        smsSwitch = (Switch) findViewById(R.id.smsswitch);
        emailSwitch = (Switch) findViewById(R.id.emailswitch);

        muteSwitch.setChecked(false);
        smsSwitch.setChecked(true);
        emailSwitch.setChecked(true);

        muteSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
             if(isChecked){
                 AudioManager.setMode(AudioManager.MODE_IN_CALL);
                 AudioManager.setStreamSolo(AudioManager.STREAM_VOICE_CALL, true);
             } else {
                 AudioManager.setMode(AudioManager.MODE_NORMAL );
                 AudioManager.setStreamSolo(AudioManager.STREAM_VOICE_CALL, false);
             }
            }
        });

        ImageButton alarm = (ImageButton)findViewById(Btn_set_alarm);
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Alarm.class);
                startActivity(i);
            }
        });
    }
}