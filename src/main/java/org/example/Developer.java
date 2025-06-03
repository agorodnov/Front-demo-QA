package org.example;

public class Developer extends Employee {
    public Developer(String name, float salay) {
        super(name, salay);
    }
        public void work() {
            System.out.println(name + "Работает над задачами по программированию. " + salary + " Получает конкретное бабло конкретно");
       }
    }