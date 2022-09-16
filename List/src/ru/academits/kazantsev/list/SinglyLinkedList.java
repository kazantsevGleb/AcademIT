package ru.academits.kazantsev.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListNode<T> head;
    private int size;

    public SinglyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public T getFirst() {
        checkEmpty();

        return head.getData();
    }

    public void addFirst(T data) {
        head = new ListNode<>(data, head);
        size++;
    }

    public T get(int index) {
        validateIndex(index);

        return getNode(index).getData();
    }

    public T set(int index, T data) {
        validateIndex(index);

        ListNode<T> currentNode = getNode(index);
        T oldData = currentNode.getData();
        currentNode.setData(data);

        return oldData;
    }

    private ListNode<T> getNode(int index) {
        validateIndex(index);
        ListNode<T> currentNode = head;

        for (int i = 0; currentNode != null; currentNode = currentNode.getNext(), i++) {
            if (i == index) {
                break;
            }
        }

        return currentNode;
    }

    public T deleteFirst() {
        checkEmpty();

        T oldData = head.getData();
        head = head.getNext();

        size--;

        return oldData;
    }

    public T delete(int index) {
        validateIndex(index);

        if (index == 0) {
            return deleteFirst();
        }

        ListNode<T> currentNode = getNode(index - 1);
        T deletedData = currentNode.getNext().getData();
        currentNode.setNext(currentNode.getNext().getNext());
        size--;

        return deletedData;
    }

    public boolean delete(T data) {
        if (head.getData().equals(data)) {
            deleteFirst();

            return true;
        }

        for (ListNode<T> currentNode = head.getNext(), previousNode = null; currentNode != null;
             previousNode = currentNode, currentNode = currentNode.getNext()) {
            if (currentNode.getData().equals(data) && previousNode != null) {
                previousNode.setNext(currentNode.getNext());

                size--;
                return true;
            }
        }

        return false;
    }

    public void add(int index, T data) {
        validateIndex(index);

        if (index == 0) {
            addFirst(data);
        } else {
            ListNode<T> addedNode = new ListNode<>(data);
            ListNode<T> temp = getNode(index - 1);
            addedNode.setNext(temp.getNext());
            temp.setNext(addedNode);

            size++;
        }
    }

    public SinglyLinkedList<T> copy() {
        if (size == 0) {
            return new SinglyLinkedList<>();
        }

        SinglyLinkedList<T> copiedList = new SinglyLinkedList<>();
        copiedList.addFirst(head.getData());

        for (ListNode<T> currentNode = head.getNext(), copiedNode = copiedList.head;
             currentNode != null;
             currentNode = currentNode.getNext(), copiedNode = copiedNode.getNext()) {
            copiedNode.setNext(new ListNode<>(currentNode.getData()));
        }

        return copiedList;
    }

    public SinglyLinkedList<T> reverse() {
        ListNode<T> previousNode = null;

        for (ListNode<T> currentNode = head; currentNode != null; ) {
            ListNode<T> nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        head = previousNode;

        return this;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder().append("[");

        for (ListNode<T> currentNode = head; currentNode != null; currentNode = currentNode.getNext()) {
            stringBuilder.append(currentNode.getData()).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length())
                .append("]");

        return stringBuilder.toString();
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", size - 1, index));
        }
    }

    private void checkEmpty() {
        if (size == 0) {
            throw new NoSuchElementException("Список пуст");
        }
    }
}
