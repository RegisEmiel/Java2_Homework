package Homework_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> map;

    public PhoneBook() {
        this.map = new HashMap<>();
    }

    public void printPhoneBook() {
        for (Map.Entry<String, String> entry : map.entrySet())
            System.out.println(entry.getValue() + " - " + entry.getKey());
    }

    public void add(String name, String number) {
        //Ключем будет номер телефона, так как он уникальный
        map.put(number, name);
    }

    public List<String> get(String name) {
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, String> entry : map.entrySet())
            if (name.equalsIgnoreCase(entry.getValue()))
                result.add(entry.getKey());

        return result;
    }

    public void printNumbers(String name) {

        List<String> result = get(name);
        System.out.printf("Номера абонентов с фамилией %s:%n", name);

        if (result.size() == 0)
            System.out.println("Нет такого абонента");

        for (String st: result)
            System.out.println(st);
    }
}
