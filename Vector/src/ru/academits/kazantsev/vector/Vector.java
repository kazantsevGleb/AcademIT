package ru.academits.kazantsev.vector;

public class Vector {
    private int dimension;
    private double[] components;

    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0");
        }

        components = new double[dimension];
    }

    public int getDimension() {
        return components.length;
    }

    public double[] getComponents() {
        return components;
    }

    public void setComponents(double[] components) {
        this.components = components;
    }

    public Vector(Vector copyVector) {
        dimension = copyVector.dimension;
        components = copyVector.components;
    }

    public Vector(double[] componentsVector) {
        this.components = componentsVector;
    }

    public Vector(int dimension, double[] componentsVector) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0");
        }

        this.dimension = dimension;
        components = new double[dimension];

        int i = 0;
        for (double component : componentsVector) {
            if (i <= components.length - 1) {
                components[i] = component;
                i++;
            }
        }
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder vector = new StringBuilder();

        for (double component : components) {
            vector.append(component).append(", ");
        }

        return String.format("{%s}", vector.deleteCharAt(vector.length() - 1).deleteCharAt(vector.length() - 1));
    }
}
