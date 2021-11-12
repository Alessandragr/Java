package views;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnectionFactory;

import java.sql.PreparedStatement;

public class List {
    public static void main(String[] args) {
        try (Connection connection =  new ConnectionFactory().getConnexion()) {

            try(PreparedStatement prepStatement = connection.prepareStatement("SELECT * FROM categoria");){
                    
               prepStatement.execute();
            
                ResultSet result = prepStatement.getResultSet();

                while(result.next()) {
                    int id = result.getInt("id");
                    System.out.println(id);
                    String nome = result.getString("nome");
                    String descricao = result.getString("descricao");
                    System.out.printf("Produto: %s\nDescrição: %s", nome, descricao);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
