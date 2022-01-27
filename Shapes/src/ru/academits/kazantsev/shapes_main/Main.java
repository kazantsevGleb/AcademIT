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
                new Circle(99),
                new Rectangle(51, 15),
                new Square(18),
                new Triangle(5, 0.2, 10.5, 7, -3, 8),
                new Circle(990),
                new Rectangle(30, 50),
                new Square(55),
                new Triangle(400, 551.2, 315, 217.2, 950, 673),
                new Square(15),
                new Rectangle(300, 300)
        };

        Arrays.sort(shapes, new ShapeAreasComparator());
        System.out.println("Параметры фигуры с наибольшей площадью - " + shapes[shapes.length - 1]);

        Arrays.sort(shapes, new ShapePerimeterComparator());
        System.out.println("Параметры фигуры с предмаксимальным периметром - " + shapes[shapes.length - 2]);
    }
}
