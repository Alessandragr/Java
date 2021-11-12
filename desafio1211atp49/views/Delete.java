package views;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import utils.ConnectionFactory;

public class Delete {
   public static void main(String[] args) {
    try(Connection connection =  new ConnectionFactory().getConnexion()){
        int id = 2;
                   
        String sql = "DELETE FROM categoria WHERE id=?";
        try (PreparedStatement prepStatement = connection.prepareStatement(sql)) {
            prepStatement.setInt(1, id);

            prepStatement.execute();

            int linhasAfetadas = prepStatement.getUpdateCount(); 
            System.out.println(linhasAfetadas);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    } catch (SQLException e) {
       e.printStackTrace();
       System.out.println("Não foi possível estabelecer uma conexão com o database"); 
    }
   }
}
