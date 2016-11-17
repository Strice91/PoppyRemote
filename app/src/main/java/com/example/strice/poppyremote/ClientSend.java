package com.example.strice.poppyremote;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by Strice on 16.11.2016.
 */

public class ClientSend extends AsyncTask<String, Void, String> {

    private int port = 5005;
    private String ip = "192.168.2.103";
    DatagramSocket udpSocket;
    InetAddress serverAddr;

    @Override
    protected String doInBackground(String[] params) {
        // do above Server call here
        try {
            DatagramSocket udpSocket = new DatagramSocket(port);
            InetAddress serverAddr = InetAddress.getByName(ip);
            byte[] buf = ("bla").getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddr, port);
            udpSocket.send(packet);
            udpSocket.disconnect();
        } catch (SocketException e) {
            Log.e("Udp:", "Socket Error:", e);
        } catch (IOException e) {
            Log.e("Udp Send:", "IO Error:", e);
        }

        return "some message";
    }

    public void setPort(int p){
        port = p;
    }

    public void setIp(String addr){
        ip = addr;
    }
}
