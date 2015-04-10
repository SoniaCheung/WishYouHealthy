package wyh.wishyouhealthy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static wyh.wishyouhealthy.R.id.Btn_Back_Set_4_3;

public class HealthTips3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View android = inflater.inflate(R.layout.healthtips_3, container, false);
        Button setting = (Button)android.findViewById(Btn_Back_Set_4_3);
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