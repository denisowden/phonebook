package org.example;

public class Book {
    private static String name;
    private static String surname;
    private static long number;

    public static void setName(String name) {
        Book.name = name;
    }

    public static void setSurname(String surname) {
        Book.surname = surname;
    }

    public static void setNumber(long number) {
        Book.number = number;
    }

    @Override
    public String toString() {
        return "Имя: " + name + "\n" +
                "Фамилия: " + surname + "\n" +
                "Номер: " + number + "\n" +
                " ";
    }
}
