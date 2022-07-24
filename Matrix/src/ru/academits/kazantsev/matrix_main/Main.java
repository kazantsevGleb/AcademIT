package ru.academits.kazantsev.matrix_main;

import ru.academits.kazantsev.matrix.Matrix;
import ru.academits.kazantsev.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[][] components = {{1, 2, 3}, {2, 5}, {3}};

        Vector[] vectors = {
                new Vector(new double[]{1, 2, 4, 5}),
                new Vector(new double[]{3, 5, 2, 3, 9}),
                new Vector(new double[]{1, 1, 2}),
                new Vector(new double[]{3}),
                new Vector(new double[]{3, 50, 21, 3, 9, 5, 1, 2, 0}),
                new Vector(new double[]{3, 5}),
        };

        Matrix matrix1 = new Matrix(5, 5);
        Matrix matrix2 = new Matrix(matrix1);
        Matrix matrix3 = new Matrix(components);
        Matrix matrix4 = new Matrix(vectors);

        matrix2.setComponent(3, new Vector(new double[]{1, 2, 3, 4, 5}));
        System.out.println(matrix2.getComponent(3));

//        System.out.println(matrix1);
//        System.out.println();
//        System.out.println(matrix2);
//        System.out.println();
        System.out.println(matrix4);
        System.out.println();
//        System.out.println(matrix2);
//        System.out.println();
//        System.out.println(matrix1);
//        System.out.println();
        System.out.println(matrix3);

    }
}
