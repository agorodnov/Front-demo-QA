package org.example;

public class Main {
    public static void main(String[] args) {
        BoxCollection boxCollection = new BoxCollection();
        boxCollection.addBox(new Box(25, 10, 15));
        boxCollection.addBox(new Box(40, 10, 30));
        boxCollection.addBox(new Box(30, 5, 10));
        boxCollection.addBox(new Box(31, 20, 40));

        boxCollection.filterLargeBoxes();
        boxCollection.displayBoxes();
    }
}
