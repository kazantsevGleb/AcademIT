package ru.academits.kazantsev.matrix;

import ru.academits.kazantsev.vector.Vector;

public class Matrix {
    private Vector[] components;

    public Matrix(int n, int m) {
        Vector[] components = new Vector[n];


        for (int i = 0; i < n; i++) {
            components[i] = new Vector (m);
        }

        this.components = components;
    }

    public Matrix(Matrix copyMatrix) {
        components = copyMatrix.components;
    }

    public Matrix(int[][] components) {

        Vector[] vectors = new Vector[components.length];


    }

    public Matrix(Vector[] vectors) {
        components = new Vector[vectors.length];

        for (int i = 0; i < vectors.length; i++) {

        }
    }

    public Vector[] getComponents() {
        return components;
    }

    @Override
    public String toString() {
        StringBuilder matrix = new StringBuilder();

        for (Vector component : components) {
            StringBuilder matrixComponent = new StringBuilder().append("{");

            matrixComponent.deleteCharAt(matrixComponent.length() - 1)
                    .deleteCharAt(matrixComponent.length() - 1)
                    .append("}");
            matrix.append(matrixComponent).append(", ");
        }

        return String.format("{%s}", matrix.deleteCharAt(matrix.length() - 1).deleteCharAt(matrix.length() - 1));
    }





}
