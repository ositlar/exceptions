package org.example.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {
    List<Toy> toys = new ArrayList<>();
    List<Toy> prizes = new ArrayList<>();

    public void addToy(Toy newToy) {
        toys.add(newToy);
    }
    public Toy selectPrizeToy() {
        int totalFrequency = toys.stream().mapToInt(Toy::getFreq).sum();
        Random random = new Random();
        int randNum = random.nextInt(totalFrequency) + 1;
        int cumulativeFrequency = 0;

        for (Toy toy : toys) {
            cumulativeFrequency += toy.getFreq();
            if (randNum <= cumulativeFrequency) {
                toy.setCount(toy.getCount() - 1);
                prizes.add(toy);
                toys.remove(toy);
                return toy;
            }
        }

        return null;
    }

    public Toy getPrizeToy() {
        if (!prizes.isEmpty()) {
            Toy prizeToy = prizes.remove(0);
            try (FileWriter fileWriter = new FileWriter("prize_toys.txt", true)) {
                fileWriter.write("ID: " + prizeToy.getId() + ", Name: " + prizeToy.getName() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return prizeToy;
        } else {
            return null;
        }
    }
}
