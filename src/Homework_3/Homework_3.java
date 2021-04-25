package Homework_3;

import java.util.*;

public class Homework_3 {
    public static void main(String[] args) {
        task1();

        task2();
    }

    public static void task1() {
        String[] words = {"Раз", "Два", "Три", "Четыре", "Пять", "Один", "Два", "Три", "Четыре", "Пять", "Три", "Четыре", "Пять", "Четыре", "Пять", "Пять"};

        System.out.println("Задание 1");
        System.out.println(Arrays.toString(words));
        System.out.println("Множество уникальных слов:");
        Set<String> wordSet = new TreeSet<>(Arrays.asList(words));

        for(String s: wordSet) {
            System.out.println(s);
        }

        System.out.println("Количество уникальных слов:");
        Map<String, Integer> wordsMap = new TreeMap<>();

        for(String s: words) {
            int count = 0;

            if (wordsMap.containsKey(s))
                count = wordsMap.get(s);

            wordsMap.put(s, ++count);
        }

        for (Map.Entry<String, Integer> pair : wordsMap.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }

        System.out.println();
    }

    public static void task2() {
        PhoneBook phoneBook = new PhoneBook();

        System.out.println("Задание 2");

        phoneBook.add("Петров", "1-11-11");
        phoneBook.add("Петров", "2-21-21");
        phoneBook.add("Иванов", "3-33-33");

        System.out.println("Телефонные номера: ");
        phoneBook.printPhoneBook();
        System.out.println();

        String name = "Петров";
        phoneBook.printNumbers(name);
        System.out.println();

        name = "Синицин";
        phoneBook.printNumbers(name);
        System.out.println();

        name = "Иванов";
        phoneBook.printNumbers(name);
    }
}
