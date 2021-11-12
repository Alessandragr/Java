package views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    public static void main(String[] args) {
        try{
            String nome = "UpdatePrepStatement";
            String descricao = "UpdatePrepStatement";
            
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            PreparedStatement prepStatement = connection.prepareStatement("INSERT INTO categoria (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, nome);
            prepStatement.setString(2, descricao);

            prepStatement.execute();
            ResultSet ids = prepStatement.getGeneratedKeys();
            
            while(ids.next()) {
                int id = ids.getInt("id");
                System.out.println(id);
            }
            connection.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
