package ru.academits.kazantsev.rectangle;

import ru.academits.kazantsev.shapes.Shapes;

public class Rectangle implements Shapes {
    private final String name;
    private final double width;
    private final double length;
    private double area;
    private double perimeter;

    public Rectangle(String name, double width, double length) {
        this.name = name;
        this.width = width;
        this.length = length;
        getArea();
        getPerimeter();
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return length;
    }

    @Override
    public double getArea() {
        area = width * length;
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = 2 * (width + length);
        return perimeter;
    }

    public String toString() {
        return "Фигура - " + name + ", " +
                "Площадь - " + area + ", " +
                "Периметр - " + perimeter;
    }
}
