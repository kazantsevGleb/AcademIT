package ru.academits.kazantsev.triangle;

import ru.academits.kazantsev.shapes.Shapes;

public class Triangle implements Shapes {
    private final String name;
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;
    private final double sideLengthAB;
    private final double sideLengthAC;
    private final double sideLengthBC;
    private double width;
    private double height;
    private double area;
    private double perimeter;

    public Triangle(String name, double x1, double y1, double x2, double y2, double x3, double y3) {
        this.name = name;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        sideLengthAB = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
        sideLengthAC = Math.sqrt(Math.pow((x3-x2),2)+Math.pow((y3-y2),2));
        sideLengthBC = Math.sqrt(Math.pow((x3-x1),2)+Math.pow((y3-y1),2));
        getWidth();
        getHeight();
        getArea();
        getPerimeter();
    }

    @Override
    public double getWidth() {
        width = Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
        return width;
    }

    @Override
    public double getHeight() {
        height = Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
        return height;
    }

    @Override
    public double getArea() {
        area = 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = sideLengthAB + sideLengthAC + sideLengthBC;
        return perimeter;
    }

    public String toString() {
        return "Фигура - " + name + ", " +
                "Ширина - " + String.format("%.1f", width) + ", " +
                "Высота - " + String.format("%.1f", height) + ", " +
                "Площадь - " + String.format("%.1f", area) + ", " +
                "Периметр - " + String.format("%.1f", perimeter);
    }
}
