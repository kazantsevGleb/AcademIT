package ru.academits.kazantsev.person;

import java.util.Objects;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(String.format("Возраст должен быть больше нуля, передано: %d", age));
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
