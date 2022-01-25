package ru.academits.kazantsev.shapes;

import java.util.Objects;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        getArea();
        getPerimeter();
    }

    @Override
    public double getWidth() {
        return width;
    }

    public void setWidth (double width) {
        this.width = width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setHeight (double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Прямоугольник: " +
                "Площадь - " + getArea() + ", " +
                "Периметр - " + getPerimeter();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;

        return rectangle.width == width && rectangle.height == height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
