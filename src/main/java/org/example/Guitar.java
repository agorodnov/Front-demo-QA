package org.example;

public class Guitar implements Playable {
    public void play (int stringCount){
        System.out.println("Играет гитара:\n"+"Количество струн - " + stringCount);
    }
}
