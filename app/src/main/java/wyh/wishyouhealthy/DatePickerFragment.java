package wyh.wishyouhealthy;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by ccpizzadaisuki on 2015/4/9.
 * Applied and modified from android dev doc.
 */
public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {
    int yearByUser, monthByUser, dayByUser;
    int year, day, month;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        yearByUser = year;
        monthByUser = month;
        dayByUser = day;
    }

    public int getYear(){
        return yearByUser;
    }

    public int getMonth(){
        return monthByUser;
    }

    public int getDay(){
        return dayByUser;
    }
}