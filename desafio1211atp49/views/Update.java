package views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.ConnectionFactory;


public class Update {
    public static void main(String[] args) {
        try(Connection connection =  new ConnectionFactory().getConnexion()){
            
            String nome = "UpdatePrepStatement";
            int id = 25;
            String sql = "UPDATE categoria SET nome =? WHERE id=?"; 
            try (PreparedStatement prepstatement = connection.prepareStatement(sql)){ 
                prepstatement.setString(1, nome);
                prepstatement.setInt(2, id);
    
                prepstatement.execute(); 
    
                int linhasAfetadas = prepstatement.getUpdateCount(); 
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
