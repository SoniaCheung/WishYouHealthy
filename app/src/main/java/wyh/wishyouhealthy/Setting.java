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

<<<<<<< HEAD
public class Setting extends Activity{
=======
public class Setting extends Fragment {
>>>>>>> origin/master

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

<<<<<<< HEAD
        ImageButton appset = (ImageButton) findViewById(imBtn_Appset);
        appset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),Appset.class);
=======
        ImageButton appset = (ImageButton) foo.findViewById
                (imBtn_Appset);
        appset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent
                        (getActivity()
                                .getApplicationContext(),
                                Appset.class);
>>>>>>> origin/master
                startActivity(i);
            }
        });

<<<<<<< HEAD
        ImageButton noti = (ImageButton) findViewById (imBtn_noti);
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),Notification.class);
=======
        ImageButton noti = (ImageButton) foo.findViewById
                (imBtn_noti);
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent
                        (getActivity()
                                .getApplicationContext(),
                                Notification.class);
>>>>>>> origin/master
                startActivity(i);
            }
        });

<<<<<<< HEAD
        ImageButton ht = (ImageButton) findViewById (imBtn_ht);
        ht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),HealthTips.class);
=======
        ImageButton ht = (ImageButton) foo.findViewById
                (imBtn_ht);
        ht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent
                        (getActivity()
                                .getApplicationContext(),
                                HealthTips.class);
>>>>>>> origin/master
                startActivity(i);
            }
        });

<<<<<<< HEAD
        ImageButton fb = (ImageButton) findViewById(imBtn_fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),Feedback.class);
=======
        ImageButton fb = (ImageButton) foo.findViewById
                (imBtn_fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent
                        (getActivity()
                                .getApplicationContext(),
                                Feedback.class);
>>>>>>> origin/master
                startActivity(i);
            }
        });

    }

}
