package ru.academits.kazantsev.hashtable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HashTable<T> implements Collection<T> {
    private int size;
    private final int DEFAULT_SIZE = 16;
    private final List<T>[] lists;

    public HashTable() {
        lists = new ArrayList[DEFAULT_SIZE];
    }

    public HashTable(int size) {
        lists = new ArrayList[size];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    private class HashTableIterator implements Iterator {
        private int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < lists.length;
        }

        @Override
        public T next() {
            return null;
        }
    }
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
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
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
