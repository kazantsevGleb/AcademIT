package ru.academits.kazantsev.list;

import java.util.Objects;

public class ListNode<T> {
    private T data;
    private ListNode<T> next;

    public ListNode(T data) {
        this.setData(data);
    }
    public ListNode(T data, ListNode<T> next) {
        this.setData(data);
        this.setNext(next);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode<?> listNode = (ListNode<?>) o;
        return Objects.equals(data, listNode.data) && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }
}
