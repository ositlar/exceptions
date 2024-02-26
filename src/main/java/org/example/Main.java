package org.example;

import org.example.enums.Names;
import org.example.model.Store;
import org.example.model.Toy;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            String name = Names.values()[rnd.nextInt(Names.values().length - 1)].name();
            store.addToy(new Toy(i, name, rnd.nextInt(50), rnd.nextInt(40)));
        }
        for (int i = 0; i < 3; i++) {
            Toy prize = store.selectPrizeToy();
            if (prize != null) {
                System.out.println("Выбран приз: " + prize);
            } else {
                System.out.println("Больше нет игрушек для розыгрыша");
            }
            Toy toyToDelivery = store.getPrizeToy();
            if (toyToDelivery != null) {
                System.out.println("Выдан приз: " + toyToDelivery);
            } else {
                System.out.println("Больше нет игрушек для выдачи");
            }
        }
    }
}