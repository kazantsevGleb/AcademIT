package ru.academits.kazantsev.lambdas_main;

import ru.academits.kazantsev.person.Person;

import java.util.*;
import java.util.stream.*;

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

        String uniquePersons = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("Список уникальных имен: " + uniquePersons);

        String youngPersons = persons.stream()
                .filter(p -> p.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.joining(","));

        double averageAgeOfYoungPersons = persons.stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.averagingInt(Person::getAge));

        System.out.printf("Список людей младше 18 лет: %s. Cредний возраст: %s%n", youngPersons, averageAgeOfYoungPersons);

        Map<String, List<Person>> personsByName = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getName));

        System.out.println("Сгруппированный список людей в формате имя, средний возраст: ");
        personsByName.forEach((name, age) -> System.out.printf("%s, %s%n", name,
                age.stream().collect(Collectors.averagingInt(Person::getAge))));

        System.out.println("Имена людей в возрасте от 20 до 45 лет, в порядке убывания возраста: ");
        persons.stream()
                .filter(person -> person.getAge() > 20 && person.getAge() < 45)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .forEach(System.out::println);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Укажите количество чисел для вычисления квадратных корней: ");
            int iterates = scanner.nextInt();

            DoubleStream numberSquareRoot = IntStream.iterate(1000, x -> 2 * x).limit(iterates).mapToDouble(Math::sqrt);
            numberSquareRoot.forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println("Для вычисления квадратных корней необходимо передать целое, положительное число");
        } catch (Exception e) {
            System.out.println("Ошибка вычисления квадратных корней");
        }
    }
}
