package project.cz2006.wishyouhealthy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import static project.cz2006.wishyouhealthy.R.id.Btn_Back;

public class Mk_appoint extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.mk_appoint_layout);

        initUI();
    }

    private void initUI(){

        Button Back = (Button) findViewById(Btn_Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Schedule.class);
                startActivity(i);
            }
        });
    }
}
