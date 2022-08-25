package org.example;

import org.example.util.ConnectionManager;

import java.sql.SQLException;
import java.sql.Statement;

public class DeleteContact {
    private static String sql = """
                delete from book
                where Name="Misha" AND Number="380950056080";
                """;

    public static void remove(){
        try (Statement statement = ConnectionManager.open().createStatement()){
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.println("Не удалось загрузить класс драйвера");
        }
    }
}
