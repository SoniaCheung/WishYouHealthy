package wyh.wishyouhealthy;

import android.os.AsyncTask;

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

/**
 * Created by An on 4/4/2015.
 */
public class PatientClient extends AsyncTask<Void, Void, Void> {
    static final int PORT = 8080;


    static final String IP = "10.27.90.71";
    Socket patientSocket;
    InputStream inFromServer;
    BufferedReader reader;
    JSONObject json;
    String dataFromServer, doctorMessage = "waiting for doctor...";


    public PatientClient() {

    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            patientSocket = new Socket("192.168.0.9", PORT);
            inFromServer = patientSocket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inFromServer));
        } catch (UnknownHostException e) {

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
                        doctorMessage = json.getString("doctorMessage");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        return null;
    }

    public String getMessage() {
        return doctorMessage;
    }
}
