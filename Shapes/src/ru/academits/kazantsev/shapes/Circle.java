package ru.academits.kazantsev.shapes;

import java.util.Objects;

public class Circle implements Shape {
    private double radius;
    private final double diameter;

    public Circle(double radius) {
        this.radius = radius;
        diameter = 2 * radius;
        getArea();
        getPerimeter();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius (double radius) {
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
        return "Круг: " +
                "Радиус - " + radius + ", " +
                "Площадь - " + String.format("%.1f", getArea()) + ", " +
                "Периметр - " + String.format("%.1f", getPerimeter());
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
        return Objects.hash(radius);
    }
}
