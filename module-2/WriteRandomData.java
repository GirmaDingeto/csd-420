/*
 Write a program that stores:
 An array of five random integers.
 An array of five random double values.
 Write the data in a file titled [yourname] datafile.dat.
 If there is no file, the file will be created.
 If there is a file, the data will be appended.
 Write a second program that will read the file and display the data.
 Test the code to ensure the code functions correctly. 
 */

/**
 *CSD 420 Module 2.2 Assignment
 *Girma Dingeto
 * Program 1
 */

import java.io.File;
import  java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Random;

public class WriteRandomData {
    public static void main(String[] args) {
        String fileName = "Girma_datafile.dat";
        Random random = new Random();

        // Generate 5 random integers and doubles
        int[] intData = new int[5];
        double[] doubleData = new double[5];

        for (int i= 0; i<5; i++) {
            intData[i] = random.nextInt(100); //Random integer between 0 and 99
            doubleData[i] = random.nextDouble()*100;// Random double between 0.0 and 100.0
        }
        System.out.println("Generated Integers:" + Arrays.toString(intData));
        System.out.println("Generated Doubles: " + Arrays.toString(doubleData));

        // Write/Append the data to file
        File file = new File(fileName);
         try (RandomAccessFile raf = new RandomAccessFile(file, "rw")){
             // Move the file pointer to the end of the file for appending
             raf.seek(raf.length());

             // Write integers
             for (int value : intData){
                 raf.writeInt(value);
             }
             // Write doubles
             for (double value : doubleData){
                 raf.writeDouble(value);
             }
             System.out.println("Data successfully appended to "+ fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
         }
    }
}

