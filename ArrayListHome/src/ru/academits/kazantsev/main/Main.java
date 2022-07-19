package ru.academits.kazantsev.main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("textFile"))) {
            ArrayList<String> lines = new ArrayList<>();

            while (reader.ready()) {
                lines.add(reader.readLine());
            }

            System.out.println("Список с текстом - " + lines);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла, убедитесь в его наличии!");
        }

        ArrayList<Integer> numbers1 = new ArrayList<>(
                Arrays.asList(1, 2, 2, 4, 2, 6, 2, 8, 9, 10, 10, 12, 100, 200, 500, 333));

        for (int i = 0; i < numbers1.size(); i++) {
            if (numbers1.get(i) % 2 == 0) {
                numbers1.remove(i);
                i--;
            }
        }

        System.out.println("Список нечетных чисел - " + numbers1);

        ArrayList<Integer> numbers2 = new ArrayList<>(
                Arrays.asList(2, 2, 4, 1, 5, 9, 9, 9, 10));

        ArrayList<Integer> numbersWithoutRepeat = new ArrayList<>(numbers2.size());

        for (int number : numbers2) {
            if (!numbersWithoutRepeat.contains(number)) {
                numbersWithoutRepeat.add(number);
            }
        }

        System.out.println("Список неповторяющихся чисел - " + numbersWithoutRepeat);
    }
}
