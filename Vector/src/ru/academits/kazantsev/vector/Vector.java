package ru.academits.kazantsev.vector;

import java.util.Arrays;

public class Vector {
    private int[] components;

    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0");
        }

        components = new int[dimension];
    }

    public int getDimension() {
        return components.length;
    }

    public int[] getComponents() {
        return components;
    }

    public void setComponents(int[] components) {
        this.components = components;
    }

    public Vector(Vector copyVector) {
        components = copyVector.components;
    }

    public Vector(int[] components) {
        this.components = components;
    }

    public Vector(int dimension, int[] components) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0");
        }

        this.components = new int[dimension];

        for (int i = 0; i < this.components.length; i++) {
            if (i < components.length) {
                this.components[i] = components[i];
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder vector = new StringBuilder();

        for (int component : components) {
            vector.append(component).append(", ");
        }

        return String.format("{%s}", vector.deleteCharAt(vector.length() - 1).deleteCharAt(vector.length() - 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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

    public void sumVectors(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < components.length; i++) {
            if (i < vector.components.length) {
                components[i] += vector.components[i];
            }
        }
    }

    public void subtractionVectors(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < components.length; i++) {
            if (i < vector.components.length) {
                components[i] -= vector.components[i];
            }
        }
    }

    public void scalarMultiplication(int scalarMultiplier) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalarMultiplier;
        }
    }

    public void reversVector() {
        this.scalarMultiplication(-1);
    }

    public double getLengthVector() {
        int lengthVector = 0;

        for (int component : components) {
            lengthVector += Math.pow(component,2);
        }

        return Math.sqrt(lengthVector);
    }

    public int getComponent(int index) {
        if (index < 0 || index > components.length) {
            throw new IllegalArgumentException(
                    String.format("Необходимо выбрать значение индекса в диапазоне от 0 до %d", components.length - 1));
        }

        return components[index];
    }

    public void setComponent(int index, int component) {
        if (index < 0 || index > components.length) {
            throw new IllegalArgumentException(
                    String.format("Необходимо выбрать значение индекса в диапазоне от 0 до %d", components.length - 1));
        }

        components[index] = component;
    }

    public static Vector getAddition(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector (vector1);
        resultVector.sumVectors(vector2);

        return resultVector;
    }

    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector (vector1);
        resultVector.subtractionVectors(vector2);

        return resultVector;
    }

    public static int scalarMultiplicationVectors(Vector vector1, Vector vector2) {
        int scalarMultiplicationResult = 0;

        for (int i = 0; i < vector1.components.length; i++) {
            if (i < vector2.components.length) {
                scalarMultiplicationResult = vector1.components[i] * vector2.components[i];
            }
        }

        return scalarMultiplicationResult;
    }
}

