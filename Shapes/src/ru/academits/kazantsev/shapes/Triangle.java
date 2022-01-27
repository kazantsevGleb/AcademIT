package ru.academits.kazantsev.shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    private static double getSideLength(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    @Override
    public double getPerimeter() {
        return getSideLength(x1, x2, y1, y2) + getSideLength(x2, x3, y2, y3) + getSideLength(x1, x3, y1, y3);
    }

    @Override
    public String toString() {
        return String.format("Треугольник: Координаты вершин - (%.1f; %.1f), (%.1f; %.1f), (%.1f; %.1f); " +
                "Площадь - %.1f; Периметр - %.1f", x1, y1, x2, y2, x3, y3, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) o;

        return triangle.x1 == x1 &&
                triangle.y1 == y1 &&
                triangle.x2 == x2 &&
                triangle.y2 == y2 &&
                triangle.x3 == x3 &&
                triangle.y3 == y3;
    }

    @Override
    public int hashCode() {
        final int number = 24;
        int hash = 1;

        for (double element : new double[]{x1, y1, x2, y2, x3, y3}) {
            hash = number * hash + (Double.hashCode(element));
        }

        return hash;
    }
}
