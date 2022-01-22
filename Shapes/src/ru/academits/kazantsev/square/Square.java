package ru.academits.kazantsev.square;

import ru.academits.kazantsev.shapes.Shapes;

public class Square implements Shapes {
    private final String NAME;
    private final double SIDE_LENGTH;
    private double area;
    private double perimeter;

    public Square (String name, double sideLength) {
        this.NAME = name;
        this.SIDE_LENGTH = sideLength;
        getArea();
        getPerimeter();
    }

    @Override
    public double getWidth() {
        return SIDE_LENGTH;
    }

    @Override
    public double getHeight() {
        return SIDE_LENGTH;
    }

    @Override
    public double getArea() {
        area = SIDE_LENGTH * SIDE_LENGTH;
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = 4 * SIDE_LENGTH;
        return perimeter;
    }

    public String toString() {
        return "Фигура - " + NAME + ", " +
                "Площадь - " + area + ", " +
                "Периметр - " + perimeter;
    }
}
