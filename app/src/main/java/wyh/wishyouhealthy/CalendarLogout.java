package wyh.wishyouhealthy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
//import android.widget.TextView;

import static wyh.wishyouhealthy.R.id.imBtn_set;

public class CalendarLogout extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View android = inflater.inflate(R.layout.calendar_logout, container, false);
        //((TextView)android.findViewById(R.id.textView)).setText("calendar");

        ImageButton setting = (ImageButton)android.findViewById(imBtn_set);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Setting.class);
                startActivity(i);
            }
        });

        return android;
    }

}