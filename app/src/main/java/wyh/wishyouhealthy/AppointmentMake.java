package wyh.wishyouhealthy;

/**
 * Created by ccpizzadaisuki on 2015/4/5.
 * Applied and modified code from mkyong's on:
 * http://www.mkyong
 * .com/android/android-date-picker-example/.
 */

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class AppointmentMake extends Fragment {

    private ArrayAdapter<CharSequence> adapterFoo;
    private TextView tvDisplayDate;
    private Button buttonChangeDateStart;
    private Button buttonChangeTimeStart;
    private Button buttonChangeDateEnd;
    private Button buttonChangeTimeEnd;
    private Button buttonConfirm;

    private int year;
    private int month;
    private int day;
    static final int DATE_DIALOG_ID = 999;

    //private static final String[] m={"A","B","O","AB","others"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View foo = inflater.inflate(R.layout.mk_appoint_main, container, false);
        ((TextView)foo.findViewById(R.id.textMakeAppointment)).setText("Make appoint");

        Spinner spinnerFoo = (Spinner) foo.findViewById(R
                .id.spinner_doctor);
        // link the content to the adapter
        adapterFoo = ArrayAdapter.createFromResource
                (getActivity().getApplicationContext(), R.array.array_doctor, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapterFoo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerFoo.setAdapter(adapterFoo);

        buttonChangeDateStart = (Button) foo.findViewById
                (R.id.pick_date_start);
        buttonChangeTimeStart = (Button) foo.findViewById(R.id
                .pick_time_start);
        buttonChangeDateEnd = (Button) foo.findViewById(R.id
                .pick_date_end);
        buttonChangeTimeEnd = (Button) foo.findViewById(R.id
                .pick_time_end);
        buttonConfirm = (Button) foo.findViewById(R.id
                .confirm);
        // button register.

        // set onclick listers for those buttons.
        buttonChangeDateStart.setOnClickListener(new Button
                .OnClickListener() {
            public void onClick (View v) {
                DialogFragment newFragment = new
                        DatePickerFragment();
                newFragment.show
                        (getActivity().getFragmentManager(),
                                "datePicker");
            }
        });
        buttonChangeTimeStart.setOnClickListener(new Button
                .OnClickListener() {
            public void onClick (View v) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show
                        (getActivity().getFragmentManager(),
                                "timePicker");
            }
        });
        buttonChangeDateEnd.setOnClickListener(new Button
                .OnClickListener() {
            public void onClick (View v) {
                DialogFragment newFragment = new
                        DatePickerFragment();
                newFragment.show
                        (getActivity().getFragmentManager(),
                                "datePicker");
            }
        });
        buttonChangeTimeEnd.setOnClickListener(new Button
                .OnClickListener() {
            public void onClick (View v) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show
                        (getActivity().getFragmentManager(),
                                "timePicker");
            }
        });
        /*buttonChangeDateStart.setOnClickListener(new
        Button
                .OnClickListener() {
            // code needed for further implements.
        });*/

        return foo;
    }
}

