package org.lessons.java.christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChristmasLetter {
    private String name;
    private String address;
    private List<String> wishList;

    //CONSTRUCTOR
    public ChristmasLetter(String name, String address, List<String> wishList) throws IllegalArgumentException{
        checkString(name, "Nome");
        checkString(address, "Indirizzo");
        checkList(wishList, "Lista");
        this.name = name;
        this.address = address;
        this.wishList = wishList;
    }

    //GETTERS
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getWishList() {
        return wishList;
    }

    //SETTERS
    public void setName(String name) {
        checkString(name, "Nome");
        this.name = name;
    }

    public void setAddress(String address) {
        checkString(name, "Indirizzo");
        this.address = address;
    }

    public void setWishList(List<String> wishList) {
        checkList(wishList, "Lista");
        this.wishList = wishList;
    }

    //METHODS
    @Override
    public String toString() {
        return "ChristmasLetter{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", wishList=" + wishList +
                '}';
    }

    public void checkString(String s, String name){
        if(s.trim().isEmpty()){
            throw new IllegalArgumentException(name + " non può essere vuoto");
        }
    }

    public void checkList(List<String> list, String name){
        if (list.isEmpty()){
            throw new IllegalArgumentException(name + " non può essere vuota");
        }
    }

    public void send(){
        if(wishList.size() > 5){
            throw new IllegalArgumentException("La lista non deve avere più di 5 elementi");
        }

        Random rand = new Random();

        List<Boolean> listOfBoolean = new ArrayList<>();
        listOfBoolean.add(true);
        listOfBoolean.add(false);

        if (!(listOfBoolean.get(rand.nextInt(listOfBoolean.size())))){
            throw new IllegalArgumentException("Sei stato cattivo non riceverai niente");
        }

        System.out.println(toString());
    }
}
