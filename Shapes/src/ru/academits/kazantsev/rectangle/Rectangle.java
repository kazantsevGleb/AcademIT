package ru.academits.kazantsev.rectangle;

import ru.academits.kazantsev.shapes.Shapes;

public class Rectangle implements Shapes {
    private final String NAME;
    private final double WIDTH;
    private final double LENGTH;
    private double area;
    private double perimeter;

    public Rectangle(String name, double width, double LENGTH) {
        this.NAME = name;
        this.WIDTH = width;
        this.LENGTH = LENGTH;
        getArea();
        getPerimeter();
    }

    @Override
    public double getWidth() {
        return WIDTH;
    }

    @Override
    public double getHeight() {
        return LENGTH;
    }

    @Override
    public double getArea() {
        area = WIDTH * LENGTH;
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = 2 * (WIDTH + LENGTH);
        return perimeter;
    }

    public String toString(){
        return "Фигура - " + NAME + ", " +
                "Площадь - " + area + ", " +
                "Периметр - " + perimeter;
    }
}
