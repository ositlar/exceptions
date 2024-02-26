package org.example.model;

public class Toy {
    private int id;
    private String name;
    private int count;
    private int freq;

    public Toy(int id, String name, int count, int freq) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.freq = freq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "Toy{" +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", freq=" + freq +
                '}';
    }
}
