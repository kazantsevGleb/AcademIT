package ru.academits.kazantsev.shapes_main;

import ru.academits.kazantsev.comparators.ShapeAreasComparator;
import ru.academits.kazantsev.comparators.ShapePerimeterComparator;
import ru.academits.kazantsev.circle.Circle;
import ru.academits.kazantsev.rectangle.Rectangle;
import ru.academits.kazantsev.shapes.Shapes;
import ru.academits.kazantsev.square.Square;
import ru.academits.kazantsev.triangle.Triangle;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle("Круг",9);
        Rectangle rectangle1 = new Rectangle("Прямоугольник",51, 15);
        Square square1 = new Square("Квадрат",18);
        Triangle triangle1 = new Triangle("Треугольник",5, 0.2, 10.5, 7, -3, 8);
        Circle circle2 = new Circle("Круг",990);
        Rectangle rectangle2 = new Rectangle("Прямоугольник",3, 150);
        Square square2 = new Square("Квадрат", 5);
        Triangle triangle2 = new Triangle("Треугольник",40, 512.2, 125, 217.2, 500, 33);
        Square square3 = new Square("Квадрат", 15);
        Rectangle rectangle3 = new Rectangle("Прямоугольник",300, 30);

        Shapes[] shapes = new Shapes[10];

        shapes[0] = circle1;
        shapes[1] = rectangle1;
        shapes[2] = square1;
        shapes[3] = square2;
        shapes[4] = square3;
        shapes[5] = rectangle2;
        shapes[6] = rectangle3;
        shapes[7] = triangle1;
        shapes[8] = triangle2;
        shapes[9] = circle2;

        sort(shapes);
    }

    public static void sort (Shapes[] shapes) {
        ShapeAreasComparator areasComparator = new ShapeAreasComparator();
        ShapePerimeterComparator perimeterComparator = new ShapePerimeterComparator();

        Arrays.sort(shapes, areasComparator);
        System.out.println("Параметры фигуры с наибольшей площадью - " + shapes[shapes.length-1]);

        Arrays.sort(shapes, perimeterComparator);
        System.out.println("Параметры фигуры с предмаксимальным периметром - " + shapes[shapes.length-2]);
    }
}
