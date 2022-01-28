package ru.academits.kazantsev.shapes;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private static double getDiameter(double radius) {
        return 2 * radius;
    }

    @Override
    public double getWidth() {
        return getDiameter(radius);
    }

    @Override
    public double getHeight() {
        return getDiameter(radius);
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Круг: Радиус - %.1f; Площадь - %.1f; Периметр - %.1f", radius, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Circle circle = (Circle) o;

        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash = prime * hash + Double.hashCode(radius);

        return hash;
    }
}