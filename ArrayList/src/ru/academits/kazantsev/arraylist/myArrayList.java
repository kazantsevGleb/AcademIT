package ru.academits.kazantsev.arraylist;

import java.util.*;
import java.util.function.UnaryOperator;

public class myArrayList<T> implements List<T> {
    private T[] innerArray;
    private int size;

    @SuppressWarnings("unchecked")
    public myArrayList() {
        innerArray = (T[]) new Object[7];
    }

    @SuppressWarnings("unchecked")
    public myArrayList(int capacity){
        if (capacity < 0 ) {
            throw new IllegalArgumentException("Ошибка создания списка, размер списка не может быть меньше 0");
        }

        innerArray = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(innerArray, innerArray.length);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T1> T1[] toArray(T1[] a) {
        return (T1[])Arrays.copyOf(innerArray, innerArray.length);
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super T> c) {
        List.super.sort(c);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        innerArray = (T[])new Object[0];
    }

    @Override
    public T get(int index) {
        validate(index);

        return innerArray[index];
    }

    @Override
    public T set(int index, T element) {
        validate(index);

        T previousElement = innerArray[index];
        innerArray[index] = element;

        return previousElement;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void validate(int index) {
        if (index < 0 || index >= innerArray.length) {
            throw new IllegalArgumentException(String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", innerArray.length - 1, index));
        }
    }
}
