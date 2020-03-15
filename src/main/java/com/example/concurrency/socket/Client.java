package com.example.concurrency.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by lichunxia on 2020-03-11 11:33
 */
public class Client {


    public static void main(String[] args) {
        Socket client = new Socket();
        try {
            client.connect(new InetSocketAddress("127.0.0.1", 99));
            OutputStream outputStream = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outputStream);
            out.writeUTF("hello from client");
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
