package wyh.wishyouhealthy;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import static wyh.wishyouhealthy.R.id.imBtn_set;

/**
 * Created by An on 4/4/2015.
 */
public class ChatWithDoctor extends android.support.v4.app.Fragment {

    PatientClient patientClient;
    EditText newMessage;
    Button sendButton;
    ListView listView;
    ChatAdapter adapter;
    ArrayList<Bubble> bubbles = new ArrayList<Bubble>();


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        View foo = inflater.inflate(R.layout.chat_with_doctor,
                container, false);

        ImageButton setting = (ImageButton)foo.findViewById(imBtn_set);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Setting.class);
                startActivity(i);
            }
        });

        newMessage = (EditText) foo.findViewById(R.id
                .newmsg);
        sendButton = (Button) foo.findViewById(R.id
                .sendButton);
        listView = (ListView) foo.findViewById(android.R.id
                .list);
        adapter = new ChatAdapter(bubbles,
                this.getActivity().getApplicationContext());
        listView.setAdapter(adapter);



        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bubbles.add(new Bubble("Xing Zhenchang", newMessage.getText().toString()));
                patientClient.sendToServer(new Bubble("Xing Zhenchang", newMessage.getText().toString()));
                patientClient.addBubbles(new Bubble("Xing Zhenchang", newMessage.getText().toString()));
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
                        getActivity().runOnUiThread(new Runnable() {
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
        return foo;
    }
}