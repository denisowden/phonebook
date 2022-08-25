package org.example;

import org.example.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteContact {
    private static String sql = """
                delete from book
                where Name=? AND Surname=? AND Number=?;
                """;

    public static void remove(){
        try (PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(sql)){
                System.out.println("Enter name");
                preparedStatement.setString(1, new Scanner(System.in).nextLine());
                System.out.println("Enter surname");
                preparedStatement.setString(2, new Scanner(System.in).nextLine());
                System.out.println("Enter number");
                preparedStatement.setLong(3, new Scanner(System.in).nextLong());
                preparedStatement.execute();
                System.out.println("Contact was deleted");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Не удалось загрузить класс драйвера");
            }
    }

//    public static void main(String[] args) {
//        String sql = """
//                delete from book
//                where Name=? AND Surname=? AND Number=?;
//                """;
//
//            try (PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(sql)){
//                System.out.println("Enter name");
//                preparedStatement.setString(1, new Scanner(System.in).nextLine());
//                System.out.println("Enter surname");
//                preparedStatement.setString(2, new Scanner(System.in).nextLine());
//                System.out.println("Enter number");
//                preparedStatement.setLong(3, new Scanner(System.in).nextLong());
//                preparedStatement.execute();
//                System.out.println("deleted");
//            } catch (SQLException e) {
//                e.printStackTrace();
//                System.err.println("Не удалось загрузить класс драйвера");
//            }
//        }
}
