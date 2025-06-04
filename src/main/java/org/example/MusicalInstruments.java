package org.example;

public class MusicalInstruments {
    //"Вложенный класс Enum который принимает количество струн"//
    public enum Instruments {
        GUITAR(6),
        PIANO(230);
        private final int stringCount;
        // конструктор который передает значения по гитаре и пианино //
        Instruments(int stringCount) {
            this.stringCount = stringCount;
        }
        //Метод для получения количества струн//
        public int getStringCount(){
            return stringCount;
        }
    }
    }
