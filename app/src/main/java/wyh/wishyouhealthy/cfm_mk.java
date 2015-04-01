package wyh.wishyouhealthy;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import static wyh.wishyouhealthy.R.id.Btn_cfm_ok_mk;

public class cfm_mk extends ActionBarActivity{

    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.cfm_mk_main);

        initUI();
    }

    private void initUI(){

        Button cfm_ok = (Button) findViewById(Btn_cfm_ok_mk);
        cfm_ok.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), cfm_mk.class);
                startActivity(i);
            }
        });
    }



}
