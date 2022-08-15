package ru.academits.kazantsev.list_main;

import ru.academits.kazantsev.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> names = new SinglyLinkedList<>();
        SinglyLinkedList<String> names1 = new SinglyLinkedList<>();
        names.addFirstNode("May");
        names.addFirstNode("Anna");
        names.addFirstNode("Mike");
        names.addFirstNode("Jim");
        names.addFirstNode("Rebeca");
        names.addFirstNode("Jon");

        System.out.println("Размер списка имен: " + names.getSize());
        System.out.println("Первое имя в списке: " + names.getFirstNodeValue());
        System.out.println("Третье имя в списке: " + names.getNodeValue(2));
        System.out.println(names.deleteNode(3));
        names.addNode("Dima", 4);
        names.addNode("Kristi", 4);
        System.out.println(names.isDeleteNodeOfValue("Anna"));

        names1.copy(names);

        names.addFirstNode("Inna");
        System.out.println(names);

        System.out.println(names1);

    }
}
