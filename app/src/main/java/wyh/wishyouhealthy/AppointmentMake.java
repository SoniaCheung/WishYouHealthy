package wyh.wishyouhealthy;

/**
 * Created by ccpizzadaisuki on 2015/4/5.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AppointmentMake extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View android = inflater.inflate(R.layout.mk_appoint_main, container, false);
        ((TextView)android.findViewById(R.id.textView)).setText("Make appoint");
        return android;
    }

}