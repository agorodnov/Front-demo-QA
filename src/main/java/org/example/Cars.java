package org.example;

public class Cars {
    public String model;
    public int years;

    public Cars(String model, int years) {
        this.model = model;
        this.years = years;
    }
    //public static String color = "Grey";
    //public int speedMax;
    // public Cars(String model, int speed) {
    //    this.model = model;
    //   this.years = 2020;
    //}

    public void carsOptions() {
        System.out.println("Модель - " + model + "\nГод - " + years);
    }

    public void makeBeBe() {
        if (years >= 2020) {
            System.out.println(model + " : Сигналит громко");
        } else if (years <= 2010) {
            System.out.println(model + " : Сигналит тихо");
        } else {
            System.out.println(model + " : Электромобиль не имеет сигнала ");
        }
    }
}