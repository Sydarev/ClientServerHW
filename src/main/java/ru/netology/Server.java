package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8080;

    public static void main(String[] args) {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(PORT);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ) {
                out.println("Welcome to server!\n" +
                        "What's your name?");
                String answer = in.readLine();
                out.println(String.format("How old are you, "+ answer+"?"));
                answer = in.readLine();
                if (Integer.parseInt(answer) < 18){
                    out.println("Welcome to the teen area, let's play!");
                } else {
                    out.println("Welcome to the adult zone");
                }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    }
}