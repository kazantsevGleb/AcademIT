package ru.academits.kazantsev.vector_main;

import ru.academits.kazantsev.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new double[]{1, 2, 3, 4, 5});
        Vector vector2 = new Vector(new double[]{3.1, 4.2, 5.7, 6, 77.2});
        Vector vector3 = new Vector(new double[]{1, 2, 3, 4, 5});
        Vector vector4 = new Vector(10, new double[]{1, 1, 1, 1, 1, 1});
        Vector vector5 = new Vector(6);

        vector3.add(vector4);
        System.out.println("Прибавление вектора 4 к вектору 3 - " + vector3);

        vector5.subtract(vector4);
        System.out.println("Вычитание вектора 4 из вектора 5 - " + vector5);

        vector3.reversal();
        System.out.println("Развернутый вектор 3 - " + vector3);

        System.out.printf("Длина вектора 3 - %.2f%n", vector3.getLength());

        System.out.println("Размерность вектора 3 - " + vector3.getSize());

        System.out.println("Компонент вектора 3 - " + vector3.getComponent(4));

        vector3.setComponent(4, 100);
        System.out.println("Измененный компонент вектора 3 - " + vector3.getComponent(4));

        System.out.println("Проверка равности векторов 1 и 2 - " + vector1.equals(vector2));

        System.out.println("Сумма векторов 1 и 2 - " + Vector.getSum(vector1, vector2));

        System.out.println("Разность векторов 2 и 3 - " + Vector.getSubtract(vector2, vector3));

        System.out.println("Скалярное умножение векторов 1 и 2 - " + Vector.getMultiplyScalar(vector1, vector2));

        vector1.multiply(3);
        System.out.println("Умножение вектора 1 на скаляр - " + vector1);
    }
}
