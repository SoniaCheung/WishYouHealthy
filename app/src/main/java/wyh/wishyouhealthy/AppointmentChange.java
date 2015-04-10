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
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AppointmentChange extends Fragment {

    private static final String[] nameFirst = new
            String[] {
            "frank",
            "gwok",
            "hanako",
            "itsuko",
            "judie",
            "kenny",
            "ling-hsiao"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View foo = inflater.inflate(R.layout
                .ch_appoint_main, null);
        return foo;
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        // create the list view.
        ListView foo = (ListView) getView()
                .findViewById(R
                        .id.list);
        // link the adapter to the list view.
        ArrayList<AppointmentDisplay> bar =
                GetSearchResults();
        AdapterAppointmentDisplay adapter = new
                AdapterAppointmentDisplay(getActivity(),
                bar);
        // set the adapter.
        foo.setAdapter(adapter);
        foo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //showDateTimeDialog();
                MyDialogFragment newFragment = new
                        MyDialogFragment();
                newFragment.show
                        (getActivity().getFragmentManager(),
                                "datePicker");
            }
        });
    }

    /*private void showDateTimeDialog() {
        // Create the dialog
        final Dialog mDateTimeDialog = new Dialog(getActivity());
        // Inflate the root layout
        final RelativeLayout mDateTimeDialogView = (RelativeLayout) getActivity().getLayoutInflater().inflate(R.layout
                .date_time_dialog, null);
        // Grab widget instance
        final DateTimePicker mDateTimePicker = (DateTimePicker) mDateTimeDialogView.findViewById(R.id.DateTimePicker);
        // Check is system is set to use 24h time (this doesn't seem to work as expected though)
        final String timeS = android.provider.Settings.System.getString(getActivity().getContentResolver(),
                android.provider.Settings.System.TIME_12_24);
        final boolean is24h = !(timeS == null || timeS.equals("12"));

        // Update demo TextViews when the "OK" button is clicked
        ((Button) mDateTimeDialogView.findViewById(R.id.SetDateTime)).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mDateTimePicker.clearFocus();
                // TODO Auto-generated method stub
                ((TextView) getView().findViewById(R.id
                        .Date))
                        .setText(mDateTimePicker.get(Calendar.YEAR) + "/" + (mDateTimePicker.get(Calendar.MONTH)+1) + "/"
                        + mDateTimePicker.get(Calendar.DAY_OF_MONTH));
                if (mDateTimePicker.is24HourView()) {
                    ((TextView) getView().findViewById(R.id.Time)).setText(mDateTimePicker.get(Calendar.HOUR_OF_DAY) + ":" + mDateTimePicker.get(Calendar.MINUTE));
                } else {
                    ((TextView) getView().findViewById(R.id.Time)).setText(mDateTimePicker.get(Calendar.HOUR) + ":" + mDateTimePicker.get(Calendar.MINUTE) + " "
                            + (mDateTimePicker.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM"));
                }
                mDateTimeDialog.dismiss();
            }
        });

        // Cancel the dialog when the "Cancel" button is clicked
        ((Button) mDateTimeDialogView.findViewById(R.id.CancelDialog)).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                mDateTimeDialog.cancel();
            }
        });

        // Reset Date and Time pickers when the "Reset" button is clicked
        ((Button) mDateTimeDialogView.findViewById(R.id.ResetDateTime)).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                mDateTimePicker.reset();
            }
        });

        // Setup TimePicker
        mDateTimePicker.setIs24HourView(is24h);
        // No title on the dialog window
        mDateTimeDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Set the dialog content view
        mDateTimeDialog.setContentView
                (mDateTimeDialogView);
        // Display the dialog
        mDateTimeDialog.show();
    }*/

    private ArrayList<AppointmentDisplay>
     GetSearchResults(){
        ArrayList<AppointmentDisplay> foo = new
                ArrayList<AppointmentDisplay>();
        // example for testing layout.
        // need db implementation.
        AppointmentDisplay bar = new AppointmentDisplay();
        bar.setNameDoctor("frank");
        bar.setTimestamp("2015-04-09 15:00 ~ 16:00");
        foo.add(bar);

        bar = new AppointmentDisplay();
        bar.setNameDoctor("gwok");
        bar.setTimestamp("2015-04-10 15:00 ~ 16:00");
        foo.add(bar);

        bar = new AppointmentDisplay();
        bar.setNameDoctor("hanako");
        bar.setTimestamp("2015-04-13 15:00 ~ 16:00");
        foo.add(bar);

        bar = new AppointmentDisplay();
        bar.setNameDoctor("itsuko");
        bar.setTimestamp("2015-04-14 15:00 ~ 16:00");
        foo.add(bar);

        return foo;
    }

}