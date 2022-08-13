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
                new Vector(new double[]{4, 2, -1, 2}),
                new Vector(new double[]{3, 0, 4, -2}),
                new Vector(new double[]{2, 3, 3, 5})
        };

        Vector[] vectors4 = {
                new Vector(new double[]{2, 2, -1, 10, 5}),
                new Vector(new double[]{3, 2, 4, 4, 4}),
                new Vector(new double[]{3, 4, 4, 2, 2}),
                new Vector(new double[]{6, 7, 5, 6, 2}),
                new Vector(new double[]{2, 3, 3, 3, 5})
        };

        Vector[] vectors5 = {
                new Vector(new double[]{2, 2}),
                new Vector(new double[]{3, 2})
        };

        Vector vector = new Vector(new double[]{-1, 2, 1, 3});
        Matrix matrix1 = new Matrix(5, 5);
        Matrix matrix2 = new Matrix(matrix1);
        Matrix matrix3 = new Matrix(components);
        Matrix matrix4 = new Matrix(vectors1);
        Matrix matrix5 = new Matrix(vectors1);
        Matrix matrix6 = new Matrix(vectors1);
        Matrix matrix7 = new Matrix(vectors2);
        Matrix matrix8 = new Matrix(vectors3);
        Matrix matrix9 = new Matrix(vectors4);
        Matrix matrix10 = new Matrix(vectors5);

        matrix2.setRow(3, new Vector(new double[]{1, 2, 3, 4, 5}));
        System.out.println("Вектор-строка по заданному индексу: " + matrix2.getRow(3));

        System.out.printf("Количество строк матрицы: %d, столбцов: %d%n", matrix3.getRowsCount(), matrix3.getColumnsCount());
        System.out.println("Столбец-вектор по указанному индексу: " + matrix4.getColumn(0));
        System.out.println("Исходная матрица, до транспонирования: " + matrix5);
        System.out.println("Транспонированная матрица: " + matrix5.transpose());
        System.out.println("Сумма матриц 5 и 3: " + matrix5.transpose().add(matrix3));
        System.out.println("Разность матриц 5 и 3: " + matrix5.subtract(matrix3.multiplyByScalar(4)));
        System.out.println("Произведение матрицы 8 и вектора: " + matrix8.multiplyByVector(vector));
        System.out.println("Статический метод определения суммы матриц: " + Matrix.getSum(matrix3, matrix5));
        System.out.println("Статический метод определения разности матриц: " + Matrix.getDifference(matrix5, matrix3));
        System.out.println("Произведение матриц 6 и 7: " + Matrix.getProduct(matrix6, matrix7));
        System.out.println("Определитель матрицы 9: " +  matrix9.getDeterminant());
        System.out.println("Определитель матрицы 10: " +  matrix10.getDeterminant());
    }
}
