package views;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Update {
    public static void main(String[] args) {
        try{
           String nome = "UpdatePrepStatement";
           String descricao = "UpdatePrepStatement";
           int id = 1;

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            String sql = "UPDATE categoria SET (nome, descricao VALUES(?, ?) WHERE id=?";
            PreparedStatement prepStatement = connection.prepareStatement(sql);

            prepStatement.setInt(2, id);
            prepStatement.setString(1, nome);
            prepStatement.setString(3, descricao);

            prepStatement.execute();

            int linhasAfetadas = prepStatement.getUpdateCount();
            System.out.println(linhasAfetadas);
         
            connection.close();

        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("Não foi possível estabelecer uma conexão com o database"); 
        }
    }
}
