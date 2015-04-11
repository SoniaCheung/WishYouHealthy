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

public class Setting extends Fragment {

    View foo;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        foo = inflater.inflate(R.layout.setting_main,
                container, false);

        initUI();
        return foo;
    }

    private void initUI() {

        Button Back = (Button) foo.findViewById(Btn_Back_Main);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(), Schedule.class);
                startActivity(i);
            }
        });

        ImageButton appset = (ImageButton) foo.findViewById
                (imBtn_Appset);
        appset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent
                        (getActivity()
                                .getApplicationContext(),
                                Appset.class);
                startActivity(i);
            }
        });

        ImageButton noti = (ImageButton) foo.findViewById
                (imBtn_noti);
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent
                        (getActivity()
                                .getApplicationContext(),
                                Notification.class);
                startActivity(i);
            }
        });

        ImageButton ht = (ImageButton) foo.findViewById
                (imBtn_ht);
        ht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent
                        (getActivity()
                                .getApplicationContext(),
                                HealthTips.class);
                startActivity(i);
            }
        });

        ImageButton fb = (ImageButton) foo.findViewById
                (imBtn_fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent
                        (getActivity()
                                .getApplicationContext(),
                                Feedback.class);
                startActivity(i);
            }
        });

    }

}
