package com.javarush.task.task30.task3008;

import java.io.*;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        
        String string = null;
        while (true)
        try {
            string = bufferedReader.readLine();
            if (bufferedReader != null){
                return string;
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
        }
      
    }

    public static int readInt() {
        int num = 0;
        while (true)
        try {
            num = Integer.parseInt(readString().trim());
            return num;
        } catch (NumberFormatException e) {
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
        }
       
    }

}
