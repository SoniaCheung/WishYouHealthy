package wyh.wishyouhealthy;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import static wyh.wishyouhealthy.R.id.Btn_Back_Main;
import static wyh.wishyouhealthy.R.id.imBtn_Appset;
import static wyh.wishyouhealthy.R.id.imBtn_noti;
import static wyh.wishyouhealthy.R.id.imBtn_fb;
import static wyh.wishyouhealthy.R.id.imBtn_ht;

public class Setting extends Activity{

    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.setting_main);
        initUI();

    }

    private void initUI() {

        Button Back = (Button) findViewById(Btn_Back_Main);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Schedule.class);
                startActivity(i);
            }
        });

        ImageButton appset = (ImageButton) findViewById(imBtn_Appset);
        appset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),Appset.class);
                startActivity(i);
            }
        });

        ImageButton noti = (ImageButton) findViewById (imBtn_noti);
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),Notification.class);
                startActivity(i);
            }
        });

        ImageButton ht = (ImageButton) findViewById (imBtn_ht);
        ht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),HealthTips.class);
                startActivity(i);
            }
        });

        ImageButton fb = (ImageButton) findViewById(imBtn_fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),Feedback.class);
                startActivity(i);
            }
        });

    }

}
