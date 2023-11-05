package ru.netology;

import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket clientSocket = new Socket("netology.homework", Server.PORT);
            PrintWriter in = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader out = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
        ) {
            System.out.println("Connected to server");
            System.out.println(out.readLine());
            System.out.println(out.readLine());
            in.println(scanner.nextLine());
            System.out.println(out.readLine());
            in.println(scanner.nextLine());
            System.out.println(out.readLine());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
