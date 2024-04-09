/**
 * Someone has written some really smelly code!
 * In the file below, we are reading the data from data.csv, and printing it in a human readable format
 * (IE each line in the csv printed like this: "email : thisemail@fake.com")
 * There are many bad practices here, and a few bugs.
 *
 * Your job is to modify code so that it works, and is up to your standards.
 * Feel free to run the program, run the unit tests and change anything you see fit.
 *
 * Good luck!
 */

package com.testing.myapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{

    // com.testing.myapp.Main method

    public static void main(String[] args) {

        String path = "data.csv";
        // 1. Read data from file
        String Data_From_File = ReadFromFile(path);
        var aaray = Arrays.stream(Data_From_File.split("\n")).toList();
        displayData(aaray);
        // We want to use this data in our program
    }
    /////////////////////////// Helper method ///////////////////////////
    public static String ReadFromFile(String s) {
        try {File file = new File(s);
            var scanner = new Scanner(file);
            String data = "";
            data += scanner.nextLine() + "\n";
            scanner.close();
            return data; } catch (Exception e) {
            System.out.println("An error occurred.");
            return "";
        }
    }
    public static HashMap Process_UserData(List<String> userData)
    {
        HashMap<String, String> processedData = new HashMap<>();
        var data = userData.get(1);
        var headers = userData.get(0);

        List<String> parts = Arrays.stream(headers.split(",")).toList();
        for (int i = 0; i < parts.size(); i++) {
            List<String> dataParts = Arrays.stream(data.split(",")).toList();
            processedData.put(parts.get(i),dataParts.get(i));
        }
        //processedData.put(parts.get(0), parts.get(1));

        return processedData;
    }

    public static void displayData(List<String> userData) {
        Map<String, String> data = Process_UserData(userData);

        // Display the data that we can use everywhere in our program

        for (String key : data.keySet()) {
            System.out.println(key + " : " + data.get(key));
        }
    }}