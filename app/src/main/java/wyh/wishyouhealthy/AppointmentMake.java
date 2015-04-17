package wyh.wishyouhealthy;

/**
 * Created by ccpizzadaisuki on 2015/4/5.
 * Applied and modified code from mkyong's on:
 * http://www.mkyong
 * .com/android/android-date-picker-example/.
 */


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import static wyh.wishyouhealthy.R.id.imBtn_set;

public class AppointmentMake extends Fragment {

    private ArrayAdapter<String> adapterFoo;
    private Button buttonConfirm;
    private TextView textConfirm;
    private Spinner spinnerFoo;

    private String doctor;
    private int yearStart, yearEnd;
    private int monthStart, monthEnd;
    private int dayStart, dayEnd;
    private int hourStart, hourEnd;
    private int minStart, minEnd;
    static final int DATE_DIALOG_ID = 999;
    private String[] doctorList= {"Terry", "Micheal", "Henry", "Jone"};

    DatePicker dateStart, dateEnd;
    TimePicker timeStart, timeEnd;
    private AppointmentData data1, data2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //
        data1 = new AppointmentData(getActivity().getApplicationContext(), "appmt1");
        data2 = new AppointmentData(getActivity().getApplicationContext(), "appmt2");
        //
        View foo = inflater.inflate(R.layout.mk_appoint_main, container, false);

        ImageButton setting = (ImageButton)foo.findViewById(imBtn_set);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Setting.class);
                startActivity(i);
            }
        });
        //

        spinnerFoo = (Spinner) foo.findViewById(R.id.spinner_doctor);
        // link the content to the adapter
        adapterFoo = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.spinner_item, doctorList);
               // = ArrayAdapter.createFromResource
                //(getActivity().getApplicationContext(), R.array.array_doctor, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        ///adapterFoo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerFoo.setAdapter(adapterFoo);

        dateStart = (DatePicker) foo.findViewById(R.id.date_start);
        dateEnd = (DatePicker) foo.findViewById(R.id.date_end);
        timeStart = (TimePicker) foo.findViewById(R.id.time_start);
        timeEnd = (TimePicker) foo.findViewById(R.id.time_end);
        buttonConfirm = (Button) foo.findViewById(R.id
                .confirm);


        buttonConfirm.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                //
                yearStart = dateStart.getYear();
                monthStart = dateStart.getMonth() + 1;
                dayStart = dateStart.getDayOfMonth();
                hourStart = timeStart.getCurrentHour();
                minStart = timeStart.getCurrentMinute();
                //
                yearEnd = dateEnd.getYear();
                monthEnd = dateEnd.getMonth() + 1;
                dayEnd = dateEnd.getDayOfMonth();
                hourEnd = timeEnd.getCurrentHour();
                minEnd = timeEnd.getCurrentMinute();
                //
                doctor = spinnerFoo.getSelectedItem().toString();
                //
                if(data1.checkAvailable()) {
                    data1.addAppointment(doctor, yearStart, monthStart, dayStart, hourStart, minStart,
                            yearEnd, monthEnd, dayEnd, hourEnd, minEnd);
                } else if(data2.checkAvailable()){
                    data2.addAppointment(doctor, yearStart, monthStart, dayStart, hourStart, minStart,
                            yearEnd, monthEnd, dayEnd, hourEnd, minEnd);
                }
            }
        });

        return foo;
    }
}

