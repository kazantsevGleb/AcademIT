package ru.academits.kazantsev.shapes_main;

import ru.academits.kazantsev.circle.Circle;
import ru.academits.kazantsev.rectangle.Rectangle;

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle1 = new Rectangle(56, 45);
        Circle circle1 = new Circle(33);

        Double areaRectangle1 = rectangle1.getArea();
        Double areaCircle1 = circle1.getArea();

        System.out.println(areaRectangle1);
        System.out.println(areaCircle1);
    }

}
