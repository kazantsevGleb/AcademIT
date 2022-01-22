package ru.academits.kazantsev.circle;

import ru.academits.kazantsev.shapes.Shapes;

public class Circle implements Shapes {
    private final String name;
    private final double radius;
    private final double diameter;
    private double area;
    private double perimeter;

    public Circle(String name, double radius) {
        this.name = name;
        this.radius = radius;
        diameter = 2 * radius;
        getArea();
        getPerimeter();
    }

    @Override
    public double getWidth() {
        return diameter;
    }

    @Override
    public double getHeight() {
        return diameter;
    }

    @Override
    public double getArea() {
        area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

    public String toString() {
        return "Фигура - " + name + ", " +
                "Ширина и высота - " + diameter + ", " +
                "Площадь - " + String.format("%.1f", area) + ", " +
                "Периметр - " + String.format("%.1f", perimeter);
    }
}
