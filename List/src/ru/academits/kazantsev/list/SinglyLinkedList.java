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

    public T getFirstNodeValue() {
        return head.getData();
    }

    public void increaseSize() {
        size++;
    }

    public void reduceSize() {
        size--;
    }

    public void addFirstNode(T data) {
        head = new ListNode<>(data, head);
        increaseSize();
    }

    public T getNodeValue(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", size - 1, index));
        }

        int current = 0;
        T searchedNode = null;

        for (ListNode<T> currentNode = head; currentNode != null; currentNode = currentNode.getNext()) {
            if (current == index) {
                searchedNode = currentNode.getData();

                break;
            }

            current++;
        }

        return searchedNode;
    }

    public T setNodeValue(T data, int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", size - 1, index));
        }

        int current = 0;
        T previousValue = null;

        for (ListNode<T> currentNode = head; currentNode != null; currentNode = currentNode.getNext()) {
            if (current == index) {
                previousValue = currentNode.getData();
                currentNode.setData(data);

                break;
            }

            current++;
        }

        return previousValue;

    }

    public void deleteFirstNode() {
        if (head.getNext() == null) {
            throw new NoSuchElementException("В списке единственный элемент");
        }

        head = head.getNext();
        reduceSize();
    }

    public T deleteNode(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", size - 1, index));
        }

        int current = 0;
        T value = null;

        for (ListNode<T> currentNode = head, previousNode = null; currentNode != null; previousNode = currentNode, currentNode = currentNode.getNext()) {
            if (current == index && previousNode != null) {
                value = currentNode.getData();
                previousNode.setNext(currentNode.getNext());

                break;
            }

            current++;
        }

        reduceSize();
        return value;
    }

    public boolean isDeleteNodeOfValue(T data) {
        boolean isDeleted = false;


        for (ListNode<T> currentNode = head, previousNode = null; currentNode != null; previousNode = currentNode, currentNode = currentNode.getNext()) {
            if (currentNode.getData() == data && previousNode != null) {
                previousNode.setNext(currentNode.getNext());

                isDeleted = true;

                break;
            }
        }

        reduceSize();
        return isDeleted;
    }

    public void addNode(T data, int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", size - 1, index));
        }

        int current = 0;

        ListNode<T> addedNode;

        for (ListNode<T> currentNode = head, previousNode = null; currentNode != null;
             previousNode = currentNode, currentNode = currentNode.getNext()) {
            if (current == index && previousNode != null) {
                addedNode = new ListNode<>(data, currentNode);

                previousNode.setNext(addedNode);

                break;
            }

            current++;
        }

        increaseSize();
    }

    public SinglyLinkedList<T> copy(SinglyLinkedList<T> copiedList) {
        head = copiedList.head;
        size = copiedList.size;

        return copiedList;
    }

    public SinglyLinkedList<T> getReverse() {
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
}
