package org.example;

public class Manager extends Employee {
    public Manager(String name, float salary) {
        super(name, salary);
    }
        public void work() {
            System.out.println(name + "Работает над задачами по управлению персоналом. " + salary + " Получает зп просто не о чем "  );
        }
    }
