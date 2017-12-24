/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Hikaro
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static final String alphabet="abcdefghijklmnopqrstuvwxyz";
    public static final String alphabetReversed="zyxwvutsrqponmlkjihgfedcba";
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            System.out.println("If you want to ciphre, type C, if you want to deciphre, type D");
            Scanner chose= new Scanner(System.in);
            String ch = chose.nextLine();            
            if(ch.equals("D")){                
                deCipher();
            }
            else{
                if(ch.equals("C")){
                    cipher();
                }
                else{
                    System.out.println("Incorrecrt");
                }
            }
        }
        catch(Exception e){
            System.out.println("Error"+"\n"+e);
      }

    }

    public static void deCipher(){
        Scanner ksc= new Scanner(System.in);
        System.out.println("Insert Key");
        int key=ksc.nextInt();
        Scanner sc= new Scanner(System.in);
        System.out.println("Insert Secret Message");
        String message = sc.nextLine().toLowerCase();
        LinkedList<Character> b = new LinkedList();
        for (int i=0; i<message.length(); i++){
            if(message.charAt(i)==' '){
                       char d = ' ';
                       b.add(d);
                    }
            else{
                for (int j=0; j<alphabet.length(); j++){
                    if((message.charAt(i)==alphabet.charAt(j))||(message.charAt(i)==' ')){
                        if (((j+key)%26)<=25){
                           char d = alphabet.charAt((j+key)%26);
                           b.add(d);
                        }
                        else{

                            int c = ((j+key)%26);
                            if (c<0){
                                    c=c*(-1);
                                    char d = alphabetReversed.charAt(c-1);
                                    b.add(d);
                                }
                            else{
                                char d = alphabet.charAt(c);
                                b.add(d);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Your ciphred message is:");
        for(int i=0; i<b.size(); i++){
            System.out.print(b.get(i));
        }
        System.out.print("\n");
    }

    public static void cipher(){
        Scanner ksc= new Scanner(System.in);
        System.out.println("Insert Key");
        int key=ksc.nextInt();
        Scanner sc= new Scanner(System.in);
        System.out.println("Insert Secret Message");
        String message = sc.nextLine().toLowerCase();
        LinkedList<Character> b = new LinkedList();
        for (int i=0; i<message.length(); i++){
            if(message.charAt(i)==' '){
                char d = ' ';
                b.add(d);
            }
            else{
                for (int j=0; j<alphabet.length(); j++){
                    if((message.charAt(i)==alphabet.charAt(j))||(message.charAt(i)==' ')){
                        if (((j-key)%26)>=0){
                           char d = alphabet.charAt((j-key)%26);
                           b.add(d);
                        }
                        else{
                            int c = ((j-key)%26);
                            if (c<0){
                                c=c*(-1);
                                char d = alphabetReversed.charAt(c-1);
                                b.add(d);
                            }
                            else{
                                char d = alphabet.charAt(c);
                                b.add(d);
                            }               
                        }
                    }
                }
            }
        }
        System.out.println("Your message is:");
        for(int i=0; i<b.size(); i++){
            System.out.print(b.get(i));
        }
        System.out.print("\n");
    }
}
    

