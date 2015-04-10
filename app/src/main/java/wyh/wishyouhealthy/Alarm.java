package wyh.wishyouhealthy;

import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class Alarm extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);

        OnClickListener setClickListener = new OnClickListener() {

            @Override
            public void onClick(View v) {
                /** This intent invokes the activity DemoActivity, which in turn opens the AlertDialog window */
                Intent i = new Intent("in.wptrafficanalyzer.servicealarmdemo.demoactivity");

                /** Creating a Pending Intent */
               // PendingIntent operation = PendingIntent.getActivity(getBaseContext(), 0, i, Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent operation = PendingIntent.getActivity(getBaseContext(), 0, i,PendingIntent.FLAG_ONE_SHOT);

                /** Getting a reference to the System Service ALARM_SERVICE */
                AlarmManager alarmManager = (AlarmManager) getBaseContext().getSystemService(ALARM_SERVICE);

                /** Getting a reference to DatePicker object available in the MainActivity */
                DatePicker dpDate = (DatePicker) findViewById(R.id.dp_date);

                /** Getting a reference to TimePicker object available in the MainActivity */
                TimePicker tpTime = (TimePicker) findViewById(R.id.tp_time);

                int year = dpDate.getYear();
                int month = dpDate.getMonth();
                int day = dpDate.getDayOfMonth();
                int hour = tpTime.getCurrentHour();
                int minute = tpTime.getCurrentMinute();

                /** Creating a calendar object corresponding to the date and time set by the user */
                GregorianCalendar calendar = new GregorianCalendar(year,month,day, hour, minute);

                /** Converting the date and time in to milliseconds elapsed since epoch */
                long alarm_time = calendar.getTimeInMillis();

                /** Setting an alarm, which invokes the operation at alart_time */
                alarmManager.set(AlarmManager.RTC_WAKEUP  , alarm_time , operation);

                /** Alert is set successfully */
                Toast.makeText(getBaseContext(), "Alarm is set successfully",Toast.LENGTH_SHORT).show();
            }
        };

        OnClickListener quitClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        };

        Button btnSetAlarm = ( Button ) findViewById(R.id.btn_set_alarm);
        btnSetAlarm.setOnClickListener(setClickListener);

        Button btnQuitAlarm = ( Button ) findViewById(R.id.btn_quit_alarm);
        btnQuitAlarm.setOnClickListener(quitClickListener);

    }

}
