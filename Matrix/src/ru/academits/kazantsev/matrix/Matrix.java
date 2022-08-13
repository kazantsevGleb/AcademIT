package ru.academits.kazantsev.matrix;

import ru.academits.kazantsev.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException(
                    String.format("Ошибка создания матрицы размерностью %d X %d, количество строк и столбцов в матрице должно быть больше 0", rowsCount, columnsCount)
            );
        }

        Vector[] rows = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(columnsCount);
        }

        this.rows = rows;
    }

    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.rows.length];

        for (int i = 0; i < matrix.rows.length; i++) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public Matrix(double[][] matrixCoefficients) {
        if (matrixCoefficients.length == 0) {
            throw new IllegalArgumentException("Размерность матрицы не может быть равна 0");
        }

        rows = new Vector[matrixCoefficients.length];
        int vectorSize = 0;

        for (double[] vector : matrixCoefficients) {
            if (vector.length > vectorSize) {
                vectorSize = vector.length;
            }
        }

        for (int i = 0; i < matrixCoefficients.length; i++) {
            rows[i] = new Vector(vectorSize, matrixCoefficients[i]);
        }
    }

    public Matrix(Vector[] rows) {
        if (rows.length == 0) {
            throw new IllegalArgumentException("Размерность матрицы не может быть равна 0");
        }

        this.rows = new Vector[rows.length];
        int vectorSize = 0;

        for (Vector vector : rows) {
            vectorSize = Math.max(vectorSize, vector.getSize());
        }

        for (int i = 0; i < rows.length; i++) {
            this.rows[i] = new Vector(vectorSize, rows[i]);
        }
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    public Vector getRow(int index) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", rows.length - 1, index));
        }

        return new Vector(rows[index]);
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= rows[0].getSize()) {
            throw new IndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", rows[0].getSize(), index));
        }

        Vector column = new Vector(rows.length);

        for (int i = 0; i < rows.length; i++) {
            column.setComponent(i, rows[i].getComponent(index));
        }

        return column;
    }

    public void setRow(int index, Vector vector) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", rows.length - 1, index));
        }

        if (vector.getSize() > rows[0].getSize()) {
            throw new IllegalArgumentException(
                    String.format("Ошибка изменения строки, длина строки должна быть не больше: %d, длина устанавливаемой строки: %d ", rows[0].getSize(), vector.getSize())
            );
        }

        rows[index] = new Vector(vector);
    }

    public Matrix transpose() {
        Vector[] transposedRows = new Vector[rows[0].getSize()];
        for (int i = 0; i < transposedRows.length; i++) {
            transposedRows[i] = getColumn(i);
        }

        rows = transposedRows;

        return this;
    }

    public Matrix multiplyByScalar(double scalar) {
        for (Vector row : rows) {
            row.getMultiply(scalar);
        }

        return this;
    }

    public double getDeterminant() {
        if (getRowsCount() != getColumnsCount()) {
            throw new ArithmeticException("Определитель можно вычислить только у квадратной матрицы");
        }

        Matrix matrix = new Matrix(rows);
        double size = matrix.rows.length;
        double determinant = 1;

        if (size == 1) {
            determinant = matrix.rows[0].getComponent(0);
            return determinant;
        }

        if (size == 2) {
            determinant = matrix.rows[0].getComponent(0) * matrix.rows[1].getComponent(1) -
                    matrix.rows[1].getComponent(0) * matrix.rows[0].getComponent(1);
            return determinant;
        }

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++ ){
                double multiplier = matrix.rows[j].getComponent(i)/matrix.rows[i].getComponent(i);

                matrix.setRow(j, Vector.getDifference(matrix.rows[j], new Vector(matrix.rows[i]).getMultiply(multiplier)));
            }

            determinant *= matrix.rows[i].getComponent(i);
        }

        return Math.round(determinant);
    }

    public Vector multiplyByVector(Vector vector) {
        int vectorSize = vector.getSize();

        if (getColumnsCount() != vectorSize) {
            throw new IllegalArgumentException(String.format("Произведение не определено, размер вектора должен быть равен количеству столбцов матрицы, " +
                    "текущий размер вектора: %d", vectorSize));
        }

        Vector resultVector = new Vector(rows.length);

        for (int i = 0; i < resultVector.getSize(); i++) {
            resultVector.setComponent(i, Vector.getScalarProduct(rows[i], vector));
        }

        return resultVector;
    }

    public Matrix add(Matrix matrix) {
        if (getColumnsCount() != matrix.getColumnsCount() || getRowsCount() != matrix.getRowsCount()) {
            throw new IllegalArgumentException(String.format("Разность не определена, матрицы должны быть одинаковой размерности, " +
                    "Матрица 1 - %d x %d, Матрица 2 - %d x %d", getRowsCount(), getColumnsCount(), matrix.getRowsCount(), matrix.getColumnsCount()));
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].add(matrix.rows[i]);
        }

        return new Matrix(rows);
    }

    public Matrix subtract(Matrix matrix) {
        if (getColumnsCount() != matrix.getColumnsCount() || getRowsCount() != matrix.getRowsCount()) {
            throw new IllegalArgumentException(String.format("Разность не определена, матрицы должны быть одинаковой размерности, " +
                    "Матрица 1 - %d x %d, Матрица 2 - %d x %d", getRowsCount(), getColumnsCount(), matrix.getRowsCount(), matrix.getColumnsCount()));
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].subtract(matrix.rows[i]);
        }

        return this;
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() || matrix1.getRowsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException(String.format("Сумма не определена, матрицы должны быть одинаковой размерности, " +
                    "Матрица 1 - %d x %d, Матрица 2 - %d x %d", matrix1.getRowsCount(), matrix1.getColumnsCount(), matrix2.getRowsCount(), matrix2.getColumnsCount()));
        }

        return new Matrix(matrix1).add(matrix2);
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() || matrix1.getRowsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException(String.format("Разность не определена, матрицы должны быть одинаковой размерности, " +
                    "Матрица 1 - %d x %d, Матрица 2 - %d x %d", matrix1.getRowsCount(), matrix1.getColumnsCount(), matrix2.getRowsCount(), matrix2.getColumnsCount()));
        }

        return new Matrix(matrix1).subtract(matrix2);
    }

    public static Matrix getProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException(String.format("Произведение не определено, количество столбцов первой матрицы - %d не равно количеству строк второй матрицы - %d",
                    matrix1.getColumnsCount(), matrix2.getRowsCount()));
        }

        Matrix resultMatrix = new Matrix(matrix1.getRowsCount(), matrix2.getColumnsCount());

        for (int i = 0; i < resultMatrix.rows.length; i++) {
            for (int j = 0; j < matrix2.getColumnsCount(); j++) {
                resultMatrix.rows[i].setComponent(j, Vector.getScalarProduct(matrix1.rows[i], matrix2.getColumn(j)));
            }
        }

        return resultMatrix;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("{");

        for (Vector component : rows) {
            stringBuilder.append(component).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("}");

        return stringBuilder.toString();
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
        return Arrays.equals(rows, matrix.rows);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rows);
    }
}
