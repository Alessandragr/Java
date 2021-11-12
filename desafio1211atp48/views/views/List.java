package views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class List {
    public static void main(String[] args) {
        try {
            
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            PreparedStatement prepStatement = connection.prepareStatement("SELECT * FROM categoria");

            prepStatement.execute();
            
            ResultSet result = prepStatement.getResultSet();

            while(result.next()) {
                int id = result.getInt("id");
                System.out.println(id);
                String nome = result.getString("nome");
                String descricao = result.getString("descricao");
                System.out.printf("Produto: %s\nDescrição: %s", nome, descricao);

            }
        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
