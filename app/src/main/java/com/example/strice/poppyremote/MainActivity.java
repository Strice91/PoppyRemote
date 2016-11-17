package com.example.strice.poppyremote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.example.strice.poppyremote.ClientSend;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageButton standBtn;
    ImageButton moveBtn;
    ImageButton helloBtn;
    ImageButton waveBtn;
    ImageButton shakeBtn;
    ImageButton yesBtn;
    ImageButton noBtn;
    ImageButton copyBtn;
    ImageButton danceBtn;

    private String ip;
    private int port;

    ClientSend udpClient = new ClientSend();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        udpClient.execute("bla");
        addListenerOnButton();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Bla Send", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                udpClient.sendMessage("h");
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addListenerOnButton() {

        standBtn = (ImageButton) findViewById(R.id.Stand);
        moveBtn = (ImageButton) findViewById(R.id.Move);
        helloBtn = (ImageButton) findViewById(R.id.Hello);
        waveBtn = (ImageButton) findViewById(R.id.Wave);
        shakeBtn = (ImageButton) findViewById(R.id.Shake);
        yesBtn = (ImageButton) findViewById(R.id.Yes);
        noBtn = (ImageButton) findViewById(R.id.No);
        copyBtn = (ImageButton) findViewById(R.id.Copy);
        danceBtn = (ImageButton) findViewById(R.id.Dance);

        standBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.w("myApp", "Stand Pressed");
                udpClient.sendMessage("s");
                Log.w("myApp", "Stand Command Sent");
            }
        });

        moveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.w("myApp", "Move Pressed");
                udpClient.sendMessage("m");
                Log.w("myApp", "Move Command Sent");
            }
        });

        helloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.w("myApp", "Hello Pressed");
                udpClient.sendMessage("h");
                Log.w("myApp", "Hello Command Sent");
            }
        });

        waveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.w("myApp", "Wave Pressed");
                udpClient.sendMessage("w");
                Log.w("myApp", "Wave Command Sent");
            }
        });

        shakeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.w("myApp", "Shake Pressed");
                udpClient.sendMessage("sh");
                Log.w("myApp", "Shake Command Sent");
            }
        });

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.w("myApp", "Yes Pressed");
                udpClient.sendMessage("y");
                Log.w("myApp", "Yes Command Sent");
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.w("myApp", "No Pressed");
                udpClient.sendMessage("n");
                Log.w("myApp", "No Command Sent");
            }
        });

        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.w("myApp", "Copy Pressed");
                udpClient.sendMessage("c");
                Log.w("myApp", "Copy Command Sent");
            }
        });

        danceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.w("myApp", "Dance Pressed");
                udpClient.sendMessage("d");
                Log.w("myApp", "Dance Command Sent");
            }
        });
    }
}
