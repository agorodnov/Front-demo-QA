package org.example;

import java.util.*;

class BoxCollection {
    private ArrayList<Box> boxes;
    private ArrayList<Box> largeBoxes;

    public BoxCollection() {
        boxes = new ArrayList<>();
        largeBoxes = new ArrayList<>();
    }

    public void addBox(Box box) {
        boxes.add(box);
    }

    public void filterLargeBoxes() {
        Iterator<Box> iterator = boxes.iterator();
        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (box.getWidth() > 30) {
                largeBoxes.add(box);
                iterator.remove(); // Удаление из оригинального списка
            }
        }
    }

    public void displayBoxes() {
        System.out.println("Ширина коробок меньше или = 30 см");
        for (Box box : boxes) {
            System.out.println(box);
        }
        System.out.println("\nКоробки шириной более 30 см");
        for (Box box : largeBoxes) {
            System.out.println(box);
        }
    }
}


