package ru.academits.kazantsev.list;

public class SinglyLinkedList<T> {
    private ListNode<T> head;
    private int size;

    public SinglyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public T getFirstData() {
        isEmpty(this);

        return head.getData();
    }

    public void addFirst(T data) {
        head = new ListNode<>(data, head);
        size++;
    }

    public T get(int index) {
        validateSize(this, index);

        return getNodeDataBy(index).getData();
    }

    public T set(int index, T data) {
        validateSize(this, index);

        ListNode<T> currentNode = getNodeDataBy(index);
        T oldData = getNodeDataBy(index - 1).getData();
        currentNode.setData(data);

        return oldData;
    }

    private ListNode<T> getNodeDataBy(int index) {
        validateSize(this, index);

        int i = 0;

        for (ListNode<T> currentNode = head; currentNode != null; currentNode = currentNode.getNext()) {
            if (i == index) {
                return currentNode;
            }

            i++;
        }

        return new ListNode<>(null);
    }

    public void deleteFirst() {
        isEmpty(this);

        head = head.getNext();
        size--;
    }

    public T deleteBy(int index) {
        validateSize(this, index);

        if (index == 0) {
            deleteFirst();
        }

        int current = 0;
        T deletedData = null;

        for (ListNode<T> currentNode = head, previousNode = null; currentNode != null; previousNode = currentNode, currentNode = currentNode.getNext()) {
            if (current == index && previousNode != null) {
                deletedData = currentNode.getData();
                previousNode.setNext(currentNode.getNext());

                break;
            }

            current++;
        }

        size--;
        return deletedData;
    }

    public boolean deleteBy(T data) {
        if (head.getData() == data) {
            deleteFirst();
        }

        for (ListNode<T> currentNode = head, previousNode = null; currentNode != null;
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
        validateSize(this, index);

        if (index == 0) {
            addFirst(data);
        }

        int i = 0;

        for (ListNode<T> currentNode = head, previousNode = null; currentNode != null;
             previousNode = currentNode, currentNode = currentNode.getNext()) {
            if (i == index && previousNode != null) {
                if (currentNode.getNext() == null) {
                    currentNode.setNext(new ListNode<>(data, null));

                    break;
                }

                previousNode.setNext(new ListNode<>(data, currentNode));

                break;
            }

            i++;
        }

        size++;
    }

    public SinglyLinkedList<T> copy() {
        if (size == 0) {
            return new SinglyLinkedList<>();
        }

        SinglyLinkedList<T> copiedList = new SinglyLinkedList<>();
        copiedList.head = new ListNode<>(getFirstData());

        for (ListNode<T> currentNode = head; currentNode.getNext() != null; ) {
            ListNode<T> nextNode = currentNode.getNext();
            copiedList.addFirst(nextNode.getData());
            currentNode = nextNode;
        }

        return copiedList.reverse();
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

    public void validateSize(SinglyLinkedList<T> list, int index) {
        if (index < 0 || index >= list.getSize()) {
            throw new IndexOutOfBoundsException(
                    String.format("Необходимо ввести значение индекса в диапазоне от 0 до %d, передано %d", list.getSize() - 1, index));
        }
    }

    public void isEmpty(SinglyLinkedList<T> list) {
        if (list.getSize() == 0) {
            throw new IllegalArgumentException("Список пуст");
        }
    }
}
