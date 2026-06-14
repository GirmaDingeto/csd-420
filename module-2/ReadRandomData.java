/*
 * CSD 420 Module 2.2 Assignment
 */

/**
 *Girma Dingeto
 * Program 2
 */

import java.io.EOFException;
import java.io.File;
import  java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ReadRandomData {
    public static void main(String[] args) {
        String fileName = "Girma_datafile.dat";
        File file = new File(fileName);
        
        if (!file.exists()) {
            System.out.println("No data file found. Please run Program 1 first.");
            return;
        }
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<Double> doubleList = new ArrayList<>();
        
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")){
            // Read until the end of the file
            while (raf.getFilePointer() < raf.length()) {
                try {
                    intList.add(raf.readInt());
                    doubleList.add(raf.readDouble());
                } catch (EOFException e) {
                    break; //Reached end of file
                }
            }
            // Display results
            System.out.println("--- Data Read from " + fileName + "---");
            System.out.println("Integers read :" + intList);
            
            System.out.println("Doubles read:" + doubleList);
            
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}


