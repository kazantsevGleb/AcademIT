package ru.academits.kazantsev.range_main;

import ru.academits.kazantsev.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(1, 19);
        Range range1 = new Range(5, 15);

        System.out.println(range.isInside(6));

        System.out.println(range1.getLength());

        System.out.println(range.getIntersectionRanges(range1));
        System.out.println(Arrays.toString(range.getAdditionRanges(range1)));
        System.out.println(Arrays.toString(range.getSubtractionRanges(range1)));
    }
}