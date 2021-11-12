package views;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Delete {
   public static void main(String[] args) {
    try{
        int id = 2;

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
                
        String sql = "DELETE FROM categoria WHERE id=?";
        PreparedStatement prepStatement = connection.prepareStatement(sql);
        prepStatement.setInt(1, id);

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
