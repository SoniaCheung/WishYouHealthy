package wyh.wishyouhealthy;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import static wyh.wishyouhealthy.R.id.Btn_AA;
import static wyh.wishyouhealthy.R.id.Btn_Back_Set_1;
import static wyh.wishyouhealthy.R.id.Btn_Help;
import static wyh.wishyouhealthy.R.id.Btn_TOU;
import static wyh.wishyouhealthy.R.id.imBtn_Appset;

public class Appset extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.appset_main);
        initUI();

    }

    private void initUI() {

       Button Back = (Button) findViewById(Btn_Back_Set_1);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Setting.class);
                startActivity(i);
            }
        });

        Button AboutApp = (Button) findViewById(Btn_AA);
        AboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AppsetAA.class);
                startActivity(i);
            }
        });

        Button Help = (Button) findViewById(Btn_Help);
        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AppsetHelp.class);
                startActivity(i);
            }
        });

        Button TOU = (Button) findViewById(Btn_TOU);
        TOU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AppsetTOU.class);
                startActivity(i);
            }
        });
    }
}