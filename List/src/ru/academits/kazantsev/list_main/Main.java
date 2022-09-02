package ru.academits.kazantsev.list_main;

import ru.academits.kazantsev.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> names1 = new SinglyLinkedList<>();

        names1.addFirst("May");
        names1.addFirst("Anna");
        names1.addFirst("Mike");
        names1.addFirst("Jim");
        names1.addFirst("Rebeca");
        names1.addFirst("Jon");

        System.out.println(names1);
        System.out.println("Размер списка имен: " + names1.getSize());
        System.out.println("Первое имя в списке: " + names1.getFirstData());
        System.out.println("Третье имя в списке: " + names1.get(5));
        System.out.println("Удаление третьего имени из списка: " + names1.deleteBy(3));

        System.out.println(names1);
        names1.add(4,"Dima");
        names1.add(4,"Kristi");
        System.out.println(names1);
        System.out.println("Элемент с именем \"Anna\" удален: " + names1.deleteBy("Anna"));

        System.out.println("Копия списка имен: " + names1.copy());

        names1.addFirst("Inna");

        System.out.println("Исходный список: " + names1);
        System.out.println("Развернутый список: " + names1.reverse());
    }
}
