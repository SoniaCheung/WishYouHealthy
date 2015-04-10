package wyh.wishyouhealthy;
/**
 * Created by ccpizzadaisuki on 2015/4/5.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.TextView;

public class CalendarLogout extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View android = inflater.inflate(R.layout.calendar_logout, container, false);
        //((TextView)android.findViewById(R.id.textView)).setText("calendar");
        return android;
    }

}