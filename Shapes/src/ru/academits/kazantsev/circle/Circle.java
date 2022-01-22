package ru.academits.kazantsev.circle;

import ru.academits.kazantsev.shapes.Shapes;

public class Circle implements Shapes {
    private final String NAME;
    private final double RADIUS;
    private final double DIAMETER;
    private double area;
    private double perimeter;

    public Circle(String name, double radius) {
        this.NAME = name;
        this.RADIUS = radius;
        DIAMETER = 2 * RADIUS;
        getArea();
        getPerimeter();
    }

    @Override
    public double getWidth() {
        return DIAMETER;
    }

    @Override
    public double getHeight() {
        return DIAMETER;
    }

    @Override
    public double getArea() {
        area = Math.PI * Math.pow(RADIUS, 2);
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = 2 * Math.PI * RADIUS;
        return perimeter;
    }

    public String toString() {
        return "Фигура - " + NAME + ", " +
                "Ширина и высота - " + DIAMETER + ", " +
                "Площадь - " + area + ", " +
                "Периметр - " + perimeter;
    }
}
