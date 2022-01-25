package ru.academits.kazantsev.shapes_main;

import ru.academits.kazantsev.shapes.comparators.ShapeAreasComparator;
import ru.academits.kazantsev.shapes.comparators.ShapePerimeterComparator;
import ru.academits.kazantsev.shapes.Circle;
import ru.academits.kazantsev.shapes.Rectangle;
import ru.academits.kazantsev.shapes.Shape;
import ru.academits.kazantsev.shapes.Square;
import ru.academits.kazantsev.shapes.Triangle;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(9),
                new Rectangle(51, 15),
                new Square(18),
                new Triangle(5, 0.2, 10.5, 7, -3, 8),
                new Circle(990),
                new Rectangle(3, 150),
                new Square(5),
                new Triangle( 40, 512.2, 125, 217.2, 500, 33),
                new Square(15),
                new Rectangle(300, 30)
        };

        ShapeAreasComparator areaComparator = new ShapeAreasComparator();
        ShapePerimeterComparator perimeterComparator = new ShapePerimeterComparator();

        Arrays.sort(shapes, areaComparator);
        System.out.println("Параметры фигуры с наибольшей площадью - " + shapes[shapes.length - 1]);

        Arrays.sort(shapes, perimeterComparator);
        System.out.println("Параметры фигуры с предмаксимальным периметром - " + shapes[shapes.length - 2]);
    }
}
