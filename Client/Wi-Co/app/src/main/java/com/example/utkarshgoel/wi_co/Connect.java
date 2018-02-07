package com.example.utkarshgoel.wi_co;

/**
 * Created by Utkarsh Goel on 17-Nov-16.
 * ​Utkarsh Goel
 *ABV-Indian Institute of Information Technology & Management,
 *Gwalior-474 015, India
 */

/*Copyright Utkarsh Goel
*Copyright infringement is the use of works protected by copyright law
* without permission, infringing certain exclusive rights granted to the copyright holder,
* such as the right to reproduce, distribute, display or perform the protected work, or to make derivative works.
* It is a punishable offence under Copyright Act, 1957
 */


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Connect extends AppCompatActivity {

    EditText nine;
    EditText six;
    EditText seven;
    EditText one;
    EditText prt;
    Button connect;
    ImageButton help;
    Button exit;
    private boolean isConnected=false;
    private Socket socket;
    PrintWriter out;
    Context context;
    String IP = "";
    int port=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        context = this;

        nine = (EditText) findViewById(R.id.nine);
        six = (EditText) findViewById(R.id.six);
        seven = (EditText) findViewById(R.id.seven);
        one = (EditText) findViewById(R.id.one);
        prt = (EditText) findViewById(R.id.prt);
        connect=(Button)findViewById(R.id.connect);
        exit=(Button)findViewById(R.id.exit);
        help=(ImageButton)findViewById(R.id.help);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Help").setMessage("Enable PC's hotspot\nConnect to it\nStart Server\n" +
                        "Enter Server's IP and Port\nClick on Connect\nYou're ready to go !!")
                        .setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // TODO Auto-generated method stub

                                    }
                                }
                        )
                        .show();
            }
        });

        nine.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(nine.getText().toString().length()==3)     //size as per your requirement
                {
                    six.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });


        six.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(six.getText().toString().length()==3)     //size as per your requirement
                {
                    seven.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });


        seven.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(seven.getText().toString().length()==3)     //size as per your requirement
                {
                    one.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });
/**
 * Created by Utkarsh Goel on 17-Nov-16.
 * ​Utkarsh Goel
 *ABV-Indian Institute of Information Technology & Management,
 *Gwalior-474 015, India
 */

        one.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(one.getText().toString().length()==3)     //size as per your requirement
                {
                    prt.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });



            connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nine.getText().toString().isEmpty() || six.getText().toString().isEmpty() || seven.getText().toString().isEmpty() || one.getText().toString().isEmpty()
                        || prt.getText().toString().isEmpty())
                    Toast.makeText(context, "Required field(s) missing", Toast.LENGTH_LONG).show();
                else {

                    IP=nine.getText().toString() + "." + six.getText().toString() + "." + seven.getText().toString() + "."
                            + one.getText();
                //Toast.makeText(context,IP,Toast.LENGTH_LONG).show();
                    Constants.SERVER_IP = IP;

                    port = Integer.parseInt(prt.getText().toString());

                    Constants.SERVER_PORT = port;
                    Connect.ConnectPhoneTask connectPhoneTask = new Connect.ConnectPhoneTask();
                    connectPhoneTask.execute(IP);
                }
            }
        });
    }

        public class ConnectPhoneTask extends AsyncTask<String,Void,Boolean> {

            @Override
            protected Boolean doInBackground(String... params) {
                boolean result = true;
                try {
                    InetAddress serverAddr = InetAddress.getByName(params[0]);
                    socket = new Socket(serverAddr,port);//Open socket on server IP and port
                } catch (IOException e) {
                    Log.e("Wi-Co", "Error while connecting", e);
                    result = false;
                }
                return result;
            }

            @Override
            protected void onPostExecute(Boolean result)
            {
                isConnected = result;
                Toast.makeText(context,isConnected?"Connected to server!":"Error while connecting",Toast.LENGTH_LONG).show();
                try {
                    if(isConnected) {
                        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                                .getOutputStream())), true); //create output stream to send data to server
                        out.println("Connected to client");
                        ConnectionSingleton.setPrintWriter(out);
                        ConnectionSingleton.setSocket(socket);
                       startActivity(new Intent(context, Navigation_drawer.class));
                        finish();
                    }
                }catch (IOException e){
                    Log.e("Wi-Co", "Error while creating OutWriter", e);
                    Toast.makeText(context,"Error while connecting",Toast.LENGTH_LONG).show();
                }
            }
            /**
             * Created by Utkarsh Goel on 17-Nov-16.
             * ​Utkarsh Goel
             *ABV-Indian Institute of Information Technology & Management,
             *Gwalior-474 015, India
             */
        }
    }
