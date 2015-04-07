package wyh.wishyouhealthy;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by An on 4/4/2015.
 */
public class ChatWithDoctor extends ListActivity {

    //TextView doctorMassage;
    PatientClient patientClient;
    String doctorMessage = "nothing";
    EditText newMessage;
    Button sendButton;
    ListView listView;
    ArrayAdapter<String> adapter;
    List<String> messages;
    boolean isLocked = false;
    boolean isNewMessage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_with_doctor);

        messages = new ArrayList<String>();
        messages.add("an");
        messages.add("ba");
        messages.add("cu");
        newMessage = (EditText) findViewById(R.id.newmsg);
        sendButton = (Button) findViewById(R.id.sendButton);
        listView = (ListView) findViewById(android.R.id.list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, messages);
        listView.setAdapter(adapter);

        patientClient = new PatientClient();
        patientClient.execute();

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        if (!doctorMessage.equals(patientClient.getMessage())) {
                            isNewMessage = true;
                            doctorMessage = patientClient.getMessage();
                        };
                    } catch (Exception e) {

                    }
                    if (isNewMessage) {
                        isNewMessage = false;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.add(doctorMessage);
                            }
                        });
                    }
                }
            }
        });
        thread.start();

        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                adapter.add(newMessage.getText().toString());
            }
        });
    }
}