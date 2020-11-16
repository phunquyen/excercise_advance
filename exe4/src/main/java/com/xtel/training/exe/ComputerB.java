package com.xtel.training.exe;
import java.net.*;
import java.io.*;

public class ComputerB {
    public static void main(String args[]) throws Exception {
        ServerSocket serverSocket = new ServerSocket(3333);
        Socket socket = serverSocket.accept();
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("stop")) {
            str = din.readUTF();
            System.out.println("client says: " + str);
            str2 = br.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        socket.close();
        serverSocket.close();
    }
}