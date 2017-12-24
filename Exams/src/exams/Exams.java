/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Hikaro
 */
public class Exams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        File questions;
        questions = new File("/home/japananimetime/Desktop/1.txt");
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(questions));
        String line = null;
        ArrayList<String> list = new ArrayList<String>();
        FileWriter fw = new FileWriter("/home/japananimetime/Desktop/2.txt", true);
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        Random rnd = new Random();
        for (int i = 1; i < 10; i++) {
            String FirstQuestion = list.get(rnd.nextInt(list.size() - 1));
            String SecondQuestion = list.get(rnd.nextInt(list.size() - 1));
            String ThirdQuestion = list.get(rnd.nextInt(list.size() - 1));
            if (FirstQuestion.equalsIgnoreCase(SecondQuestion) || FirstQuestion.equalsIgnoreCase(ThirdQuestion) || SecondQuestion.equalsIgnoreCase(ThirdQuestion)) {
                i = i - 1;
                continue;
            } else {
                fw.write("Paper #" + i + "\n" + FirstQuestion + "\n" + SecondQuestion + "\n" + ThirdQuestion + "\n"+"\n");
            fw.flush();
            }
        }
    }

}
