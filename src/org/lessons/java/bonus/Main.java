package org.lessons.java.bonus;



import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List <Wish> christmasList = new ArrayList<>();

        System.out.print("Inserisci il tuo nome? ");
        String userName = scan.nextLine();

        System.out.print("Inserisci il tuo indirizzo: ");
        String userAddress = scan.nextLine();

        boolean stopCounter = false;

        while (!stopCounter){
            System.out.println("Aggiungi un desiderio alla lista");
            String wish = scan.nextLine();

            System.out.println("Aggiungi un destinatario");
            String receiver = scan.nextLine();

            try {
                Wish wishObj = new Wish(receiver, wish);
                christmasList.add(wishObj);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }


            System.out.println("I desideri aggiunti sono " + christmasList.size() + ": " + christmasList);

            System.out.println("Vuoi fermarti? 1 - Si | 2 - No");
            String userChoice = scan.nextLine();

            if(userChoice.equals("1")){
                stopCounter = true;
            }
        }

        System.out.println(countDuplicates(christmasList));
        System.out.println(uniqueWishes(christmasList));
        System.out.println(countWishPerReceiver(christmasList));

        /*Collections.sort(christmasList);*/

        System.out.println("I tuoi desideri sono: " + christmasList);

        try{
            ChristmasLetter christmasLetter = new ChristmasLetter(userName, userAddress, christmasList);
            christmasLetter.send();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        scan.close();
    }

    public static Map<String, Integer> countDuplicates(List<Wish> array){
        Map<String, Integer> duplicatesCounter = new HashMap<>();

        for (int i = 0; i < array.size(); i++) {
           duplicatesCounter.merge(array.get(i).getWish(), 1, Integer::sum);
        }

        return duplicatesCounter;
    }

    public static Set<String> uniqueWishes(List<Wish> array){
        Set<String> uniqueWishes = new HashSet<>();

        for (int i = 0; i < array.size(); i++) {
            uniqueWishes.add(array.get(i).getWish());
        }

        return uniqueWishes;
    }

    public static Map<String, Integer> countWishPerReceiver(List<Wish> array){
        Map<String, Integer> wishPerReceiver = new HashMap<>();

        for (int i = 0; i < array.size(); i++) {
            wishPerReceiver.merge(array.get(i).getReceiver(), 1, Integer::sum);
        }

        return wishPerReceiver;
    }
}
