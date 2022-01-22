package ru.academits.kazantsev.square;

import ru.academits.kazantsev.shapes.Shapes;

public class Square implements Shapes {
    private final String name;
    private final double sideLength;
    private double area;
    private double perimeter;

    public Square (String name, double sideLength) {
        this.name = name;
        this.sideLength = sideLength;
        getArea();
        getPerimeter();
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        area = sideLength * sideLength;
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = 4 * sideLength;
        return perimeter;
    }

    @Override
    public String toString() {
        return "Фигура - " + name + ", " +
                "Площадь - " + area + ", " +
                "Периметр - " + perimeter;
    }
}
