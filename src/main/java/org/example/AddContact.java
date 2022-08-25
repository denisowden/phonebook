package org.example;

import org.example.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddContact {
    private static String sql = """
                insert into book (Name, Surname, Number)
                    values (?,?,?);
                """;

    public static void add(){
        try (PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(sql)){
            System.out.println("Enter name");
            preparedStatement.setString(1, new Scanner(System.in).nextLine());
            System.out.println("Enter surname");
            preparedStatement.setString(2, new Scanner(System.in).nextLine());
            System.out.println("Enter number");
            preparedStatement.setLong(3, new Scanner(System.in).nextLong());
            preparedStatement.execute();
            System.out.println("Contact was added");
        } catch (SQLException e) {
            System.err.println("Не удалось загрузить класс драйвера");
        }
    }

//    public static void main(String[] args) {
//        String sql = """
//                insert into book (Name, Surname, Number)
//                    values (?,?,?);
//                """;
//        try (PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(sql)){
//            System.out.println("Enter name");
//            preparedStatement.setString(1, new Scanner(System.in).nextLine());
//            System.out.println("Enter surname");
//            preparedStatement.setString(2, new Scanner(System.in).nextLine());
//            System.out.println("Enter number");
//            preparedStatement.setLong(3, new Scanner(System.in).nextLong());
//            preparedStatement.execute();
//            System.out.println("Contact was added");
//        } catch (SQLException e) {
//            System.err.println("Не удалось загрузить класс драйвера");
//        }
//
//    }
}
