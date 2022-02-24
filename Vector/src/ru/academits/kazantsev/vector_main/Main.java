package ru.academits.kazantsev.vector_main;

import ru.academits.kazantsev.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new int[] {1, 2, 3, 4, 5});
        Vector vector2 = new Vector(new int[] {3, 4, 5, 6, 7});
        Vector vector3 = new Vector(vector1);
        Vector vector4 = new Vector(4, new int[] {1, 1, 1, 1, 1, 1});
        Vector vector5 = new Vector(10);

        System.out.println(vector4);

        vector4.sumVectors(vector5);
        System.out.println(vector4);

        vector5.subtractionVectors(vector4);
        System.out.println(vector5);

        System.out.println(vector1.equals(vector2));
        System.out.printf("Длина вектора 3 - %.2f%n", vector3.getLengthVector());
        System.out.println("Компонент вектора 3 - " + vector3.getComponent(2));

        vector3.reversVector();
        System.out.println("Перевернутый вектор 3 - " + vector3);
        vector3.reversVector();

        System.out.println(vector1);
        System.out.println(vector2);

        Vector vector6 = Vector.getAddition(vector1, vector2);
        System.out.println(vector6);

        System.out.println(vector5);

        Vector vector7 = Vector.getSubtraction(vector2,vector5);
        System.out.println(vector7);

        vector1 = new Vector(new int[] {1, 2, 3, 4, 5});

        System.out.println(Vector.scalarMultiplicationVectors(vector1, vector2));
    }
}
