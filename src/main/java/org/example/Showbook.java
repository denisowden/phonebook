package org.example;

import org.example.util.ConnectionManager;

import java.sql.SQLException;
import java.sql.Statement;

public class Showbook {
    private static String sql = """
                select Name, Surname, Number
                from book;
                """;

    public static void showbook(){
        try {
            Statement statement = ConnectionManager.open().createStatement();
            var executeresulte = statement.executeQuery(sql);
            while (executeresulte.next()){
                Book book = new Book();
                book.setName(executeresulte.getString("Name"));
                book.setSurname(executeresulte.getString("Surname"));
                book.setNumber(executeresulte.getLong("Number"));

                System.out.println(book);
            }
        } catch (SQLException e) {
            System.err.println("Неудалось загрузить класс драйвера");
        }
    }


}
