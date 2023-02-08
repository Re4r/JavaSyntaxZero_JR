package com.javarush.task.pro.task10.task1021;

public class Artifact {
    private int number;
    private String culture;
    private int centure;

    public Artifact(int number) {
        this.number = number;
    }
    public Artifact(int number, String culture) {
        this.number = number;
        this.culture = culture;
    }
    public Artifact(int number, String culture, int centure) {
        this.number = number;
        this.culture = culture;
        this.centure = centure;
    }

    public static void main(String[] args) {
        Artifact artifact1 = new Artifact(212121);
        Artifact artifact2 = new Artifact(212121, "Aztec");
        Artifact artifact3 = new Artifact(232323, "Aztec", 14);
    }
}
