package wyh.wishyouhealthy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import static wyh.wishyouhealthy.R.id.Btn_Back_Set_4;
import static wyh.wishyouhealthy.R.id.Btn_Submit_FB;

public class Feedback  extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_main);
        initUI();
    }

    private void initUI(){
        Button Back = (Button) findViewById(Btn_Back_Set_4);
        Back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Setting.class);
                startActivity(i);
            }
        });

        Button Submit_FB = (Button) findViewById(Btn_Submit_FB);
        Submit_FB.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Feedback is sent. Thank You for your opinions.", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
