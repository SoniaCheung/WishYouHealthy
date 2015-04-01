package wyh.wishyouhealthy;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import static wyh.wishyouhealthy.R.id.Btn_bk2sch;

public class Can_appoint extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.can_appoint_main);

        initUI();
    }

    private void initUI(){

        Button Back = (Button) findViewById(Btn_bk2sch);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Schedule.class);
                startActivity(i);
            }
        });
    }

}
