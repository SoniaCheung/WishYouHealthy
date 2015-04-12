package wyh.wishyouhealthy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

/**
 * Created by ccpizzadaisuki on 2015/4/10.
 */
public class MyDialogFragment extends DialogFragment {

    private AppointmentData data;

    public static MyDialogFragment newInstance(int title) {
        MyDialogFragment frag = new MyDialogFragment();
        Bundle args = new Bundle();
        args.putInt("title", title);
        frag.setArguments(args);
        return frag;
    }

    public void setPosition(int position){
        data = new AppointmentData(getActivity().getApplicationContext(), "appmt"+(position+1));
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                //.setIcon(R.drawable.alert_dialog_icon)
                //.setTitle(title)
                .setPositiveButton(R.string
                                .appointment_change,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // we can define code here
                                // for linking to the
                                // database.
                            }
                        }
                )
                .setNegativeButton(R.string.appointment_delete,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                data.setAvailable(true);
                            }
                        }
                )
                .create();
    }
}