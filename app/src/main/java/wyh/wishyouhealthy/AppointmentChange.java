package wyh.wishyouhealthy;

/**
 * Created by ccpizzadaisuki on 2015/4/5.
 *
 * Applied and modified androidexample's code on
 * http://androidexample
 * .com/Create_A_Simple_Listview_-_Android_Example/index.php?view=article_discription&aid=65&aaid=90
 *
 * Some bugs are fixed applying velsorange's code on
 * http://stackoverflow.com/questions/14292731/exception-in-listfragment-the-specified-child-already-has-a-parent
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static wyh.wishyouhealthy.R.id.imBtn_set;

public class AppointmentChange extends Fragment {

    private AppointmentData data1, data2;
    Button refreshButton, deleteButton_1, deleteButton_2;
    TextView appmt1, appmt2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //
        data1 = new AppointmentData(getActivity().getApplicationContext(), "appmt1");
        data2 = new AppointmentData(getActivity().getApplicationContext(), "appmt2");
        View foo = inflater.inflate(R.layout.ch_appoint_main, null);

        ImageButton setting = (ImageButton)foo.findViewById(imBtn_set);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Setting.class);
                startActivity(i);
            }
        });
        return foo;
    }

    @Override
    public void onStart() {
        super.onStart();
        refreshButton = (Button) getView().findViewById(R.id.refresh);
        refreshButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        appmt1 = (TextView) getView().findViewById(R.id.appointment1);
        appmt2 = (TextView) getView().findViewById(R.id.appointment2);

        deleteButton_1 = (Button) getView().findViewById(R.id.delete_1);
        deleteButton_2 = (Button) getView().findViewById(R.id.delete_2);

        deleteButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data1.setAvailable(true);
                update();
            }
        });
        deleteButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data2.setAvailable(true);
                update();
            }
        });
        update();
    }

    private void update() {
        if (!data1.checkAvailable()) {
            appmt1.setText("Appointment 1:\n" + data1.getStartTime() + "\n To \n" + data1.getEndTime() + "\n with " + data1.getDoctor());
        } else {
            appmt1.setText("Not set yet!");
        }
        if (!data2.checkAvailable()) {
            appmt2.setText("Appointment 1:\n" + data2.getStartTime() + "\n To \n" + data2.getEndTime() + "\n with " + data2.getDoctor());
        } else {
            appmt2.setText("Not set yet!");
        }
    }

}