package org.lessons.java.bonus;

public class Wish {
    private String receiver;
    private String wish;

    //CONSTRUCTOR
    public Wish(String receiver, String wish) {
        checkString(receiver, "Destinatario");
        checkString(wish, "Desiderio");
        this.receiver = receiver;
        this.wish = wish;
    }

    //GETTER
    public String getReceiver() {
        return receiver;
    }

    public String getWish() {
        return wish;
    }

    //SETTER
    public void setReceiver(String receiver) {
        checkString(receiver, "Destinatario");
        this.receiver = receiver;
    }

    public void setWish(String wish) {
        checkString(wish, "Desiderio");
        this.wish = wish;
    }

    //METHODS

    @Override
    public String toString() {
        return "Wish{" +
                "receiver='" + receiver + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wish wish1 = (Wish) o;

        if (getReceiver() != null ? !getReceiver().equals(wish1.getReceiver()) : wish1.getReceiver() != null)
            return false;
        return getWish() != null ? getWish().equals(wish1.getWish()) : wish1.getWish() == null;
    }

    @Override
    public int hashCode() {
        int result = getReceiver() != null ? getReceiver().hashCode() : 0;
        result = 31 * result + (getWish() != null ? getWish().hashCode() : 0);
        return result;
    }

    public void checkString(String s, String name){
        if(s.trim().isEmpty()){
            throw new IllegalArgumentException(name + " non può essere vuoto");
        }
    }


}
