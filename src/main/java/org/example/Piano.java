package org.example;

public class Piano implements Playable {
    public void play (int stringCount){
        System.out.println("Играет пианино:\n"+"Количество струн - "+stringCount);
    }
}
