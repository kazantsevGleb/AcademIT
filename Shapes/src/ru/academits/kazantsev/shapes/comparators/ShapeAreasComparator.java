package ru.academits.kazantsev.shapes.comparators;

import ru.academits.kazantsev.shapes.Shape;

import java.util.Comparator;

public class ShapeAreasComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getArea(), shape2.getArea());
    }
}

