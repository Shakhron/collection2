package com.company;


import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.*;

class Capital implements Comparable<Capital>{
    String countr;
    String cap;
    public int compareTo(Capital o) {
        return countr.compareTo(o.countr);
    }
    public void printT(){
        System.out.println(countr + ", " + cap);
    }
}

public class Main {

    public static void main(String[] args) {
        String path = "a.csv";
        String line = "";
        LinkedList<Capital> list = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null){
                String[] values = line.split(" ");
                Capital ex = new Capital();
                ex.countr = values[0];
                ex.cap = values[1];
                list.add(ex);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        Collections.sort(list,Capital::compareTo);

        for (Capital s: list){
            System.out.print("Государство: " + s.countr + ", ");
            System.out.println("Столица: " + s.cap);
        }
    }
}