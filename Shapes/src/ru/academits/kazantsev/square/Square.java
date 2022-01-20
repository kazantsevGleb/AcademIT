package ru.academits.kazantsev.square;

import ru.academits.kazantsev.shapes.Shapes;

public class Square implements Shapes {
    private double side;

    public Square (double side) {
        this.side = side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}
