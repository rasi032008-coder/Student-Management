package com.example.studentmanager.Repository.signin;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EntriesRegister {

     //writing in Files the various types of entries
     static <T>void invalidEntry(T id,String password){
        try(PrintWriter pw = new PrintWriter(
                new FileWriter("InvalidSignIns.txt",true)
        )){
            pw.println(id + "," + password);
        }catch (Exception e){
            System.out.println(e);
        }
    }

     static <T>void validEntry(T id,String password){
        try(PrintWriter pw = new PrintWriter(
                new FileWriter("ValidSignIns.txt",true)
        )){
            System.out.println("Wrirint in valid enrty");
            pw.println(id + "," + password);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Error in pw");
        }
    }


    static <T>void invalidEntry(T password){
        try(PrintWriter pw = new PrintWriter(
                new FileWriter("InvalidSignIns.txt",true)
        )){
            pw.println("Management" + "," + password);
        }catch (Exception e){
            System.out.println(e);
        }
    }

     static <T>void validEntry(T password){
        try(PrintWriter pw = new PrintWriter(
                new FileWriter("ValidSignIns.txt",true)
        )){
            System.out.println("Wrirint in valid enrty");
            pw.println("Management" + "," + password);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Error in pw");
        }
    }


}
