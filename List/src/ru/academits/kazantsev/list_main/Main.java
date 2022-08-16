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
        System.out.println("Удаление третьего имени из списка: " + names.deleteNode(3));

        names.addNode("Dima", 4);
        names.addNode("Kristi", 4);

        System.out.println("Элемент с именем \"Anna\" удален: " + names.isDeleteNodeOfValue("Anna"));
        System.out.println("Копия списка имен: " + names1.copy(names));

        names.addFirstNode("Inna");

        System.out.println("Исходный список: " + names);
        System.out.println("Развернутый список: " + names.getReverse());


    }
}
