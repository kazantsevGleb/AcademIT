package ru.academits.kazantsev.triangle;

import ru.academits.kazantsev.shapes.Shapes;

public class Triangle implements Shapes {
    private final String NAME;
    private final double X1;
    private final double Y1;
    private final double X2;
    private final double Y2;
    private final double X3;
    private final double Y3;
    private final double AB;
    private final double AC;
    private final double BC;
    private double width;
    private double height;
    private double area;
    private double perimeter;

    public Triangle(String name, double x1, double y1, double x2, double y2, double x3, double y3) {
        this.NAME = name;
        this.X1 = x1;
        this.Y1 = y1;
        this.X2 = x2;
        this.Y2 = y2;
        this.X3 = x3;
        this.Y3 = y3;
        AB = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
        AC = Math.sqrt(Math.pow((x3-x2),2)+Math.pow((y3-y2),2));
        BC = Math.sqrt(Math.pow((x3-x1),2)+Math.pow((y3-y1),2));
        getArea();
        getPerimeter();
    }

    @Override
    public double getWidth() {
        width = Math.max(Math.max(X1, X2), X3) - Math.min(Math.min(X1, X2), X3);
        return width;
    }

    @Override
    public double getHeight() {
        height = Math.max(Math.max(Y1, Y2), Y3) - Math.min(Math.min(Y1, Y2), Y3);
        return height;
    }

    @Override
    public double getArea() {
        area = 0.5 * Math.abs((X2 - X1) * (Y3 - Y1) - (X3 - X1) * (Y2 - Y1));
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = AB + AC + BC;
        return perimeter;
    }

    public String toString() {
        return "Фигура - " + NAME + ", " +
                "Ширина - " + width + ", " +
                "Высота - " + height + ", " +
                "Площадь - " + area + ", " +
                "Периметр - " + perimeter;
    }
}
