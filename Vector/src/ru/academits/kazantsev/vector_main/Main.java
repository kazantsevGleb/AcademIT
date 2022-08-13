package ru.academits.kazantsev.vector_main;

import ru.academits.kazantsev.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new double[]{2, 10, 70, 100});
        Vector vector2 = new Vector(new double[]{3.1, 4.2, 5.7, 6, 77.2});
        Vector vector3 = new Vector(new double[]{150, 2, 10, 70, 100, 2, 10, 70, 100});
        Vector vector4 = new Vector(8, new double[]{1, 1, 1, 1, 1, 1, 1, 1});
        Vector vector5 = new Vector(5);

        vector4.add(vector3);
        System.out.println("Прибавление вектора 3 к вектору 4: " + vector4);

        vector5.subtract(vector4);
        System.out.println("Вычитание вектора 4 из вектора 5: " + vector5);

        vector3.reverse();
        System.out.println("Развернутый вектор 3: " + vector3);

        System.out.printf("Длина вектора 3: %.2f%n", vector3.getLength());

        System.out.println("Размерность вектора 3: " + vector3.getSize());

        System.out.println("Компонент вектора 2: " + vector2.getComponent(4));

        vector2.setComponent(4, 150);
        System.out.println("Измененный компонент вектора 2: " + vector2.getComponent(4));

        System.out.println("Проверка равенства векторов 1 и 2: " + vector1.equals(vector2));

        System.out.println("Сумма векторов 1 и 2: " + Vector.getSum(vector1, vector2));

        System.out.println("Разность векторов 2 и 3: " + Vector.getDifference(vector2, vector3));

        System.out.println("Скалярное умножение векторов 1 и 2: " + Vector.getScalarProduct(vector1, vector2));

        System.out.println("Умножение вектора 1 на скаляр: " + vector1.getMultiply(3));
    }
}
