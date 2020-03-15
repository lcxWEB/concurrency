package com.example.concurrency.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lichunxia on 2020-03-11 11:38
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(99);
            while (true) {
                Socket server = serverSocket.accept();
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我：" + serverSocket.getLocalSocketAddress() + "\nGoodbye!");
                server.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
