package ru.academits.kazantsev.shapes;

public class Circle implements Shape {
    private double radius;
    private final double diameter;

    public Circle(double radius) {
        this.radius = radius;
        diameter = 2 * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
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
        final int number = 24;
        int hash = 1;

        hash = number * hash + (Double.hashCode(radius));

        return hash;
    }
}