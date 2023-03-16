package org.lessons.java.christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List <String> christmasList = new ArrayList<>();
        boolean stopCounter = false;

        while (!stopCounter){
            System.out.println("Aggiungi un desiderio alla lista");
            christmasList.add(scan.nextLine());

            System.out.println("I desideri aggiunti sono " + christmasList.size() + ": " + christmasList);

            System.out.println("Vuoi fermarti? 1 - Si | 2 - No");
            String userChoice = scan.nextLine();

            if(userChoice.equals("1")){
                stopCounter = true;
            }
        }

        System.out.println("I tuoi desideri sono: " + christmasList);

        scan.close();
    }
}
