package org.lessons.java.christmas;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List <String> christmasList = new ArrayList<>();

        System.out.print("Inserisci il tuo nome? ");
        String userName = scan.nextLine();

        System.out.print("Inserisci il tuo indirizzo: ");
        String userAddress = scan.nextLine();

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

        Collections.sort(christmasList);

        System.out.println("I tuoi desideri sono: " + christmasList);

        try{
            ChristmasLetter christmasLetter = new ChristmasLetter(userName, userAddress, christmasList);
            christmasLetter.send();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        scan.close();
    }
}
