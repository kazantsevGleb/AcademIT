package ru.academits.kazantsev.lambdas_main;

import ru.academits.kazantsev.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Ivan", 33));
        persons.add(new Person("Mihail", 3));
        persons.add(new Person("Olga", 18));
        persons.add(new Person("Stas", 51));
        persons.add(new Person("Evgeniy", 30));
        persons.add(new Person("Anna", 26));
        persons.add(new Person("Rebeca", 16));
        persons.add(new Person("Ivan", 26));
        persons.add(new Person("Evgeniy", 5));

        System.out.println(persons);

        String uniquePersons = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("Список уникальных имен: " + uniquePersons);

        persons.stream()
                .filter(x -> x.getAge() < 18)
                .mapToInt(Person::getAge)
                .average()
                .ifPresent(x -> System.out.println("Средний возраст людей младше 18 лет: " + x));

        Map<String, List<Person>> personsByName = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getName));

        personsByName.forEach((name, age) -> System.out.printf("Имя: %s, возраст: %s%n", name,
                age.stream()
                        .mapToInt(Person::getAge)
                        .average()));
    }
}
