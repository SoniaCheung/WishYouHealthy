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

    public static MyDialogFragment newInstance(int title) {
        MyDialogFragment frag = new MyDialogFragment();
        Bundle args = new Bundle();
        args.putInt("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //int title = getArguments().getInt("title");
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
                .setNegativeButton(R.string
                                .appointment_delete,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                            }
                        }
                )
                .create();
    }
}