package wyh.wishyouhealthy;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by An on 4/4/2015.
 */
public class PatientClient extends AsyncTask<Void, Void, Void> {
    static final int PORT = 8080;
    static final String IP = "192.168.0.10";
    Socket patientSocket;
    InputStream inFromServer;
    BufferedReader reader;
    OutputStream outToServer;
    DataOutputStream writer;

    JSONObject json;
    String dataFromServer;
    Bubble bubble = new Bubble("an", "hello");
    ArrayList<Bubble> bubbles = new ArrayList<Bubble>();
    boolean isNewMessage = true;


    public PatientClient() {

        bubbles.add(new Bubble("an", "hello"));

    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            patientSocket = new Socket(IP, PORT);
            inFromServer = patientSocket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inFromServer));
            outToServer = patientSocket.getOutputStream();
            writer = new DataOutputStream(outToServer);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        dataFromServer = reader.readLine();
                        json = new JSONObject(dataFromServer);
                        bubble = new Bubble(json.getString("name"), json.getString("content"));
                        if (!bubbles.get(bubbles.size() - 1).getName().equals(bubble.getName())
                                || !bubbles.get(bubbles.size() - 1).getContent().equals(bubble.getContent())) {
                            bubbles.add(new Bubble(bubble.getName(), bubble.getContent()));
                            isNewMessage = true;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        return null;
    }

    public void sendToServer(Bubble bubble) {
        try {
            json.put("name", bubble.getName());
            json.put("content", bubble.getContent());
            writer.writeBytes(json.toString() + "\n");
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public ArrayList<Bubble> getBubbles() {
        return bubbles;
    }

    public void messageUpdated() {
        isNewMessage = false;
    }

    public boolean isNewMessage() {
        return isNewMessage;
    }
}
