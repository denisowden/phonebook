package org.example;


import lombok.Setter;

@Setter
public class User {
    private String name;
    private String surname;
    private long number;

    @Override
    public String toString() {
        return "Имя: " + name + "\n" +
                "Фамилия: " + surname + "\n" +
                "Номер: " + number + "\n" +
                " ";
    }
}
