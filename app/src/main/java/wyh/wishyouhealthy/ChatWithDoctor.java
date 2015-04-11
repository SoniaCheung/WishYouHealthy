package wyh.wishyouhealthy;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by An on 4/4/2015.
 */
public class ChatWithDoctor extends ListActivity {

    PatientClient patientClient;
    EditText newMessage;
    Button sendButton;
    ListView listView;
    ChatAdapter adapter;
    ArrayList<Bubble> bubbles = new ArrayList<Bubble>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_with_doctor);

        newMessage = (EditText) findViewById(R.id.newmsg);
        sendButton = (Button) findViewById(R.id.sendButton);
        listView = (ListView) findViewById(android.R.id.list);
        adapter = new ChatAdapter(bubbles, this);
        listView.setAdapter(adapter);



        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bubbles.add(new Bubble("An", newMessage.getText().toString()));
                patientClient.sendToServer(new Bubble("An", newMessage.getText().toString()));
                adapter.notifyDataSetChanged();
                newMessage.getText().clear();
            }
        });

        patientClient = new PatientClient();
        patientClient.execute();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (patientClient.isNewMessage()) {
                        patientClient.messageUpdated();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.setBubbles(patientClient.getBubbles());
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                }
            }
        });
        thread.start();
    }
}