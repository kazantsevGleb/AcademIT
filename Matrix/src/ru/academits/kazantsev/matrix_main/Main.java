package ru.academits.kazantsev.matrix_main;

import ru.academits.kazantsev.matrix.Matrix;
import ru.academits.kazantsev.vector.Vector;

public class Main {
    public static void main(String[] args) {
        int[][] components = {{1, 2, 3}, {2, 3, 5}, {3, 5, 6}};

        Vector[] vectors = {
                new Vector(new int[]{1, 2, 3, 4, 5}),
                new Vector(new int[]{3, 5, 2, 3, 9}),
                new Vector(new int[]{1, 1, 2, 3, 2})
        };

        Matrix matrix1 = new Matrix(5, 5);
        Matrix matrix2 = new Matrix(matrix1);
        Matrix matrix3 = new Matrix(components);
        Matrix matrix4 = new Matrix(vectors);

        System.out.println(matrix2);
        System.out.println(matrix3);
        System.out.println(matrix4);
    }
}
