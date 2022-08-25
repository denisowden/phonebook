package org.example;

import org.example.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;

public class ContactService {
    private final static String sql = """
                select Name, Surname, Number
                from book;
                """;
    private final static String sqlTwo = """
                delete from book
                where Name=? AND Surname=? AND Number=?;
                """;

    private final static String sqlThird = """
                insert into book (Name, Surname, Number)
                    values (?,?,?);
                """;

    public static void showbook(){
        try {
            Statement statement = ConnectionManager.open().createStatement();
            var executeresulte = statement.executeQuery(sql);
            while (executeresulte.next()){
                User user = new User();
                user.setName(executeresulte.getString("Name"));
                user.setSurname(executeresulte.getString("Surname"));
                user.setNumber(executeresulte.getLong("Number"));

                System.out.println(user);
            }
        } catch (SQLException e) {
            System.err.println("Error");
        }
    }
    public static void remove(){
        try (PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(sqlTwo)){
            System.out.println("Enter name");
            preparedStatement.setString(1, ConsoleService.scanner.nextLine());
            System.out.println("Enter surname");
            preparedStatement.setString(2, ConsoleService.scanner.nextLine());
            System.out.println("Enter number");
            preparedStatement.setLong(3, ConsoleService.scanner.nextLong());
            preparedStatement.execute();
            System.out.println("Contact was deleted");
            ConsoleService.scanner.nextLine();
        } catch (SQLException e) {
            System.err.println("Error");
        }catch (InputMismatchException e){
            System.err.println("Only numbers are accepted");
            ConsoleService.scanner.nextLine();
        }
    }

    public static void add(){
        try (PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(sqlThird)){
            System.out.println("Enter name");
            preparedStatement.setString(1, ConsoleService.scanner.nextLine());
            System.out.println("Enter surname");
            preparedStatement.setString(2, ConsoleService.scanner.nextLine());
            System.out.println("Enter number");
            preparedStatement.setLong(3, ConsoleService.scanner.nextLong());
            preparedStatement.execute();
            System.out.println("Contact was added");
            ConsoleService.scanner.nextLine();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error");
        }catch (InputMismatchException e){
            System.err.println("Only numbers are accepted");
            ConsoleService.scanner.nextLine();
        }
    }
}
