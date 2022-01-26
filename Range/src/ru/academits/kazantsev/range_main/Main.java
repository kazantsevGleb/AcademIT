package ru.academits.kazantsev.range_main;

import ru.academits.kazantsev.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(-5, 19);
        range1.setFrom(0);
        range1.setTo(11);
        System.out.println(range1.getTo());

        Range range2 = new Range(-13, -3);
        range2.setFrom(1);
        range2.setTo(9);
        System.out.println(range2.getFrom());

        System.out.println(range1.isInside(6));

        System.out.println("Length of range - " + range2.getLength());

        System.out.println(range1.getIntersection(range2));
        System.out.println(Arrays.toString(range1.getUnion(range2)));
        System.out.println(Arrays.toString(range1.getDifference(range2)));
    }
}