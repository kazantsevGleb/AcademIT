package ru.academits.kazantsev.matrix_main;

import ru.academits.kazantsev.matrix.Matrix;
import ru.academits.kazantsev.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[][] components = {{2.0, 7.0}, {3.0, 1.0}, {3.0, 2.0}};

        Vector[] vectors1 = {
                new Vector(new double[]{2, 7}),
                new Vector(new double[]{3, 1}),
                new Vector(new double[]{3, 2})
        };

        Vector[] vectors2 = {
                new Vector(new double[]{3.1, 7, 8, -8, 1, 2, 4.5}),
                new Vector(new double[]{5, 8, 1, 12, 2, -1, -50})
        };

        Vector[] vectors3 = {
                new Vector(new double[]{3.1}),
                new Vector(new double[]{5}),
                new Vector(new double[]{20}),
                new Vector(new double[]{-17})
        };

        Vector vector = new Vector(new double[]{3.1, 1, 9, 22});
        Matrix matrix1 = new Matrix(5, 5);
        Matrix matrix2 = new Matrix(matrix1);
        Matrix matrix3 = new Matrix(components);
        Matrix matrix4 = new Matrix(vectors1);
        Matrix matrix5 = new Matrix(vectors1);
        Matrix matrix6 = new Matrix(vectors1);
        Matrix matrix7 = new Matrix(vectors2);
        Matrix matrix8 = new Matrix(vectors3);

        matrix2.setComponent(3, new Vector(new double[]{1, 2, 3, 4, 5}));
        System.out.println("Вектор-строка по заданному индексу: " + matrix2.getLineVector(3));

        System.out.printf("Количество строк матрицы: %d, столбцов: %d%n", matrix3.getLineCount(), matrix3.getColumnCount());
        System.out.println("Столбец-вектор по указанному индексу: " + matrix4.getColumnVector(0));
        System.out.println("Исходная матрица, до транспонирования: " + matrix5);
        System.out.println("Транспонированная матрица: " + matrix5.transpose());
        System.out.println("Сумма матриц 5 и 3: " + matrix5.getSum(matrix3));
        System.out.println("Разность матриц 5 и 3: " + matrix5.getDifference(matrix3.getProduct(4)));
        System.out.println("Произведение матрицы 8 и вектора: " + matrix8.multiplyByVector(vector));
        System.out.println("Статический метод определения суммы матриц: " + Matrix.getSum(matrix3, matrix5));
        System.out.println("Статический метод определения разности матриц: " + Matrix.getDifference(matrix5, matrix3));
        System.out.println("Произведение матриц 6 и 7: " + Matrix.getProduct(matrix6, matrix7));
    }
}
