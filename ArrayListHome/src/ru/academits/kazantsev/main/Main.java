package ru.academits.kazantsev.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("textFile");
        Scanner scanner = new Scanner(fileReader);

        ArrayList<String> strings = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String p = scanner.nextLine();

            strings.add(String.valueOf(p));
        }

        System.out.println(strings);

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 4, 2, 6, 2, 8, 9, 10, 10, 12));
        Iterator<Integer> numberIterator = numbers.iterator();

        while (numberIterator.hasNext()) {
            if (numberIterator.next() % 2 == 0) {
                numberIterator.remove();
            }
        }

        System.out.println(numbers);

        numbers = new ArrayList<>(Arrays.asList(2, 2, 4, 1, 5, 9, 9, 9, 10));
        ArrayList<Integer> numbersWithoutRepeat = new ArrayList<>();

        for (Integer number : numbers) {
            if (!numbersWithoutRepeat.contains(number)) {
                numbersWithoutRepeat.add(number);
            }
        }

        System.out.println(numbersWithoutRepeat);
    }
}
