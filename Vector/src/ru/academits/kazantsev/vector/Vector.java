package ru.academits.kazantsev.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(
                    String.format("Ошибка создания вектора с размерностью %d, размерность вектора не может быть меньше 0", size));
        }

        components = new double[size];
    }

    public Vector(int size, double[] components) {
        if (size <= 0) {
            throw new IllegalArgumentException(
                    String.format("Ошибка создания вектора с размерностью %d, размерность вектора не может быть меньше 0", size));
        }

        this.components = Arrays.copyOf(components, size);
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) {
        if (components.length <= 0) {
            throw new IllegalArgumentException(
                    String.format("Ошибка создания вектора с размерностью %d, размерность вектора не может быть меньше 0", components.length));
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("{");

        for (double component : components) {
            stringBuilder.append(component).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length())
                .append("}");

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

        Vector vector = (Vector) o;
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public int getSize() {
        return components.length;
    }

    public void add(Vector vector) {
        components = Arrays.copyOf(components, Math.max(vector.getSize(), getSize()));

        for (int i = 0; i < Math.min(vector.getSize(), getSize()); i++) {
            components[i] += vector.components[i];
        }
    }

    public void subtract(Vector vector) {
        components = Arrays.copyOf(components, Math.max(vector.getSize(), getSize()));

        for (int i = 0; i < Math.min(vector.getSize(), getSize()); i++) {
            components[i] -= vector.components[i];
        }
    }

    public void multiply(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void getInverse() {
        multiply(-1);
    }

    public double getLength() {
        int sum = 0;

        for (double component : components) {
            sum += component * component;
        }

        return Math.sqrt(sum);
    }

    public double getComponent(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", components.length - 1, index));
        }

        return components[index];
    }

    public void setComponent(int index, double component) {
        if (index < 0 || index > components.length - 1) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", components.length - 1, index));
        }

        components[index] = component;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);
        resultVector.add(vector2);

        return resultVector;
    }

    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);
        resultVector.subtract(vector2);

        return resultVector;
    }

    public static double getScalarMultiplication(Vector vector1, Vector vector2) {
        double multiplicationResult = 0;

        for (int i = 0; i < Math.min(vector1.getSize(), vector2.getSize()); i++) {
            multiplicationResult += vector1.components[i] * vector2.components[i];
        }

        return multiplicationResult;
    }
}