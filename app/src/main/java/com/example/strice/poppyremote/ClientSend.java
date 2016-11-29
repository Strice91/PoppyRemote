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
    private String ip = "";
    private boolean doSend = false;
    private String msgToSend = "";

    @Override
    protected String doInBackground(String[] params) {
        // do above Server call here

        ip = params[0];
        while(!isCancelled())
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(doSend){
                try {
                    DatagramSocket udpSocket = new DatagramSocket(port);
                    InetAddress serverAddr = InetAddress.getByName(ip);
                    byte[] buf = (msgToSend).getBytes();
                    DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddr, port);
                    udpSocket.send(packet);
                    udpSocket.close();
                } catch (SocketException e) {
                    Log.e("Udp:", "Socket Error:", e);
                } catch (IOException e) {
                    Log.e("Udp Send:", "IO Error:", e);
                }
                doSend = false;
            }
        }
        return "Bla";
    }

    public void setPort(int p){
        port = p;
    }

    public void setIp(String addr){
        ip = addr;
    }

    public void sendMessage(String msg){
        msgToSend = msg;
        doSend = true;
    }
}
