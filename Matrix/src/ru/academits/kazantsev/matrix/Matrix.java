package ru.academits.kazantsev.matrix;

import ru.academits.kazantsev.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private final Vector[] components;

    public Matrix(int lineCount, int columnCount) {
        if (lineCount <= 0) {
            throw new IllegalArgumentException(
                    String.format("Ошибка создания матрицы с количеством строк = %d, количество строк в матрице должно быть больше 0", lineCount)
            );
        }

        if (columnCount <= 0) {
            throw new IllegalArgumentException(
                    String.format("Ошибка создания матрицы с количеством столбцов = %d, количество столбцов в матрице должно быть больше 0", columnCount)
            );
        }

        Vector[] vectors = new Vector[lineCount];

        for (int i = 0; i < lineCount; i++) {
            vectors[i] = new Vector(columnCount);
        }

        this.components = Arrays.copyOf(vectors, vectors.length);
    }

    public Matrix(Matrix matrix) {
        components = Arrays.copyOf(matrix.components, matrix.components.length);
    }

    public Matrix(double[][] matrix) {
        components = new Vector[matrix.length];
        int vectorLength = 0;

        for (double[] vector : matrix) {
            if (vector.length > vectorLength) {
                vectorLength = vector.length;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
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

    public int getLineCount() {
        return components.length;
    }

    public int getColumnCount() {
        return components[0].getSize();
    }

    public Vector getLineVector(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", components.length - 1, index));
        }

        return components[index];
    }

    public Vector getColumnVector(int index) {
        Vector columnVector = new Vector(components.length);

        for (int i = 0; i < components.length; i++) {
            columnVector.setComponent(i, components[i].getComponent(index));
        }

        return columnVector;
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

    public Matrix transpose() {
        Matrix transposedMatrix = new Matrix(getColumnCount(), getLineCount());
        for (int i = 0; i < transposedMatrix.components.length; i++) {
            transposedMatrix.components[i] = getColumnVector(i);
        }

        return transposedMatrix;
    }

    public Matrix getProduct(double scalar) {
        for (Vector component : components) {
            component.multiply(scalar);
        }

        return new Matrix(components);
    }

    public double getDeterminant(Matrix matrix) {

        return 0;
    }

    public Matrix multiplyByVector(Vector vector) {
        int vectorSize = vector.getSize();
        int matrixColumnCount = getColumnCount();
        Vector columnVector = getColumnVector(0);

        if (matrixColumnCount != 1) {
            throw new ArithmeticException(String.format("Произведение не определено, количество столбцов матрицы (передано %d) должно быть равно размерности вектора: 1",
                    matrixColumnCount));
        }

        Matrix resultMatrix = new Matrix(getLineCount(), vectorSize);

        for (int i = 0; i < resultMatrix.components.length; i++) {
            for (int j = 0; j < vectorSize; j++) {
                resultMatrix.components[i].setComponent(j, columnVector.getComponent(i) * vector.getComponent(j));
            }
        }

        return resultMatrix;
    }

    public Matrix getSum(Matrix matrix) {
        if (getColumnCount() != matrix.getColumnCount() || getLineCount() != matrix.getLineCount()) {
            throw new ArithmeticException(String.format("Сумма не определена, размерность матриц должна быть равна, " +
                    "Матрица 1 - %d x %d, Матрица 2 - %d x %d", getLineCount(), getColumnCount(), matrix.getLineCount(), matrix.getColumnCount()));
        }

        for (int i = 0; i < components.length; i++) {
            components[i].add(matrix.components[i]);
        }

        return new Matrix(components);
    }

    public Matrix getDifference(Matrix matrix) {
        if (getColumnCount() != matrix.getColumnCount() || getLineCount() != matrix.getLineCount()) {
            throw new ArithmeticException(String.format("Разность не определена, размерность матриц должна быть равна, " +
                    "Матрица 1 - %d x %d, Матрица 2 - %d x %d", getLineCount(), getColumnCount(), matrix.getLineCount(), matrix.getColumnCount()));
        }

        for (int i = 0; i < components.length; i++) {
            components[i].subtract(matrix.components[i]);
        }

        return new Matrix(components);
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        return new Matrix(matrix1.getSum(matrix2));
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        return new Matrix(matrix1.getDifference(matrix2));
    }

    public static Matrix getProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnCount() != matrix2.getLineCount()) {
            throw new ArithmeticException(String.format("Произведение не определено, количество столбцов первой матрицы - %d не равно количеству строк второй матрицы - %d",
                    matrix1.getColumnCount(), matrix2.getLineCount()));
        }

        Matrix resultMatrix = new Matrix(matrix1.getLineCount(), matrix2.getColumnCount());

        for (int i = 0; i < resultMatrix.components.length; i++) {
            for (int j = 0; j < matrix2.getColumnCount(); j++) {
                resultMatrix.components[i].setComponent(j, Vector.getScalarProduct(matrix1.components[i], matrix2.getColumnVector(j)));
            }
        }

        return resultMatrix;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("{");

        for (Vector component : components) {
            stringBuilder.append(component).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("}");

        return String.valueOf(stringBuilder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Matrix matrix = (Matrix) o;
        return Arrays.equals(components, matrix.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }
}
