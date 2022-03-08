package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();


    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Чат сервера запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }

        } catch (Exception e) {
            ConsoleHelper.writeMessage("Произошла ошибка при запуске или работе сервара.");
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (String string : connectionMap.keySet())
            try {
                connectionMap.get(string).send(message);
            }catch (IOException e){
                System.out.println("Сообщение не отправлено");
            }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }


    public void run() {

    }


}
