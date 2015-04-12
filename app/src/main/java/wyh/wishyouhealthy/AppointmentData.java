package wyh.wishyouhealthy;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by An on 12/4/2015.
 */
public class AppointmentData {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    String str;

    public AppointmentData(Context context, String pass) {
        prefs = context.getSharedPreferences(pass, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void addAppointment(String doctor, int yearStart, int monthStart, int dayStart, int hourStart, int minStart,
                               int yearEnd, int monthEnd, int dayEnd, int hourEnd, int minEnd) {
        //
        str = hourStart + "h" + minStart + "m in " + dayStart + "/" + monthStart + "/" + yearStart;
        editor.putString("start", str);
        editor.commit();
        //
        str = hourEnd + "h" + minEnd + "m in " + dayEnd + "/" + monthEnd + "/" + yearEnd;
        editor.putString("end", str);
        editor.commit();
        //
        editor.putString("doctor", doctor);
        editor.commit();
        setAvailable(false);
    }

    public void setDoctor(String doctor){
    }

    public String getStartTime(){
        return prefs.getString("start", "DEFAULT");
    }

    public String getEndTime(){
        return prefs.getString("end", "DEFAULT");
    }

    public String getDoctor(){
        return prefs.getString("doctor", "DEFAULT");
    }

    //data is available means its "empty", can add new appointment
    public void setAvailable(boolean available){
        if(available) {
            editor.putString("available", "t");
            editor.commit();
        }else{
            editor.putString("available", "f");
            editor.commit();
        }
    }

    public boolean checkAvailable(){
        if(prefs.getString("available", "DEFAULT").equals("f")){
            return false;
        }else{
            return true;
        }
    }
}
