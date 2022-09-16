package ru.academits.kazantsev.lambdas_main;

import ru.academits.kazantsev.person.Person;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Ivan", 33),
                new Person("Mihail", 3),
                new Person("Olga", 18),
                new Person("Stas", 51),
                new Person("Evgeniy", 45),
                new Person("Anna", 20),
                new Person("Rebeca", 16),
                new Person("Ivan", 26),
                new Person("Evgeniy", 5)
        );

        String uniquePersons = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.printf("Имена: %s. %n", uniquePersons);

        String youngPersonsNames = persons.stream()
                .filter(p -> p.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.joining(", "));

        double youngPersonsAverageAge = persons.stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.averagingInt(Person::getAge));

        System.out.printf("Список людей младше 18 лет: %s. Cредний возраст: %s%n", youngPersonsNames, youngPersonsAverageAge);

        Map<String, Double> personsGroupByName = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));

        System.out.printf("Сгруппированный список людей в формате имя, средний возраст: %s%n", personsGroupByName);

        System.out.println("Имена людей в возрасте от 20 до 45 лет, в порядке убывания возраста: ");
        persons.stream()
                .filter(person -> person.getAge() >= 20 && person.getAge() <= 45)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .forEach(System.out::println);


        Scanner scanner = new Scanner(System.in);

        System.out.println("Укажите количество чисел для вычисления квадратных корней: ");
        int numberCalculations = scanner.nextInt();

        if (numberCalculations < 0) {
            throw new IllegalArgumentException("Ошибка вычисления квадратных корней, количество вычислений должно быть положительным числом");
        }

        DoubleStream numberSquareRoots = DoubleStream
                .iterate(10, Math::sqrt)
                .limit(numberCalculations);
        numberSquareRoots
                .forEach(System.out::println);
    }
}
