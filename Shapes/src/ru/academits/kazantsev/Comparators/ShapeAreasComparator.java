package ru.academits.kazantsev.Comparators;

import ru.academits.kazantsev.shapes.Shapes;
import java.util.Comparator;

public class ShapeAreasComparator implements Comparator<Shapes> {
    public int compare(Shapes o1, Shapes o2) {
        return Double.compare(o1.getArea(), o2.getArea());
    }
}

