package ru.academits.kazantsev.matrix;

import ru.academits.kazantsev.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private final Vector[] components;

    public Matrix(int n, int m) {
        if (n <= 0) {
            throw new IllegalArgumentException(
                    String.format("Ошибка создания матрицы с количеством строк = %d, количество строк в матрице должно быть больше 0", n)
            );
        }

        if (m <= 0) {
            throw new IllegalArgumentException(
                    String.format("Ошибка создания матрицы с количеством столбцов = %d, количество столбцов в матрице должно быть больше 0", m)
            );
        }

        Vector[] vectors = new Vector[n];

        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector(m);
        }

        this.components = Arrays.copyOf(vectors, vectors.length);
    }

    public Matrix(Matrix matrix) {
        components = matrix.components;
    }

    public Matrix(double[][] matrix) {
        components = new Vector[matrix.length];
        int vectorLength = 0;

        for (double[] vector : matrix) {
            if (vector.length > vectorLength) {
                vectorLength = vector.length;
            }
        }

        for (int i = 0; i < matrix.length; i++){
            components[i] = new Vector(vectorLength, matrix[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        components = new Vector[vectors.length];
        int vectorLength = 0;

        for (Vector vector : vectors) {
            vectorLength = Math.max(vectorLength, vector.getSize());
        }

        for (int i = 0; i < vectors.length; i++) {
            components[i] = new Vector(vectorLength, vectors[i]);
        }
    }

    public Vector getComponent(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", components.length - 1, index));
        }

        return components[index];
    }

    public void setComponent(int index, Vector vector) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", components.length - 1, index));
        }

        components[index] = vector;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("{");

        for (Vector component : components) {
            stringBuilder.append(component).append(", ").append("\n");
        }

        stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length()).append("}");

        return String.valueOf(stringBuilder);
    }
}
