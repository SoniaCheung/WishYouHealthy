package wyh.wishyouhealthy;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import static wyh.wishyouhealthy.R.id.Btn_Logout;
import static wyh.wishyouhealthy.R.id.Btn_mk;
import static wyh.wishyouhealthy.R.id.Btn_ch;
import static wyh.wishyouhealthy.R.id.Btn_can;

public class Schedule extends ActionBarActivity  {

    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.schedule_main);
        initUI();

    }

    private void initUI(){

        Button Logout = (Button) findViewById(Btn_Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        Button MakeAppoint = (Button) findViewById(Btn_mk);
        MakeAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Mk_appoint.class);
                startActivity(i);
            }
        });

        Button ChAppoint = (Button) findViewById(Btn_ch);
        ChAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Ch_appoint.class);
                startActivity(i);
            }
        });

        Button CanAppoint = (Button) findViewById(Btn_can);
        CanAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Can_appoint.class);
                startActivity(i);
            }
        });
    }

}