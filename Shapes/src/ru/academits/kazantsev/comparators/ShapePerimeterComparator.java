package ru.academits.kazantsev.comparators;

import ru.academits.kazantsev.shapes.Shapes;

import java.util.Comparator;

public class ShapePerimeterComparator implements Comparator<Shapes> {
    public int compare(Shapes o1, Shapes o2) {
        return Double.compare(o1.getPerimeter(), o2.getPerimeter());
    }
}
