package ru.academits.kazantsev.range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(4.1, 8.2);

        System.out.println(range.isInside(3));
        System.out.println(range.isInside(6));
        System.out.println(range.getLength());
    }
}