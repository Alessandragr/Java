package views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectionFactory;

public class Insert {
    public static void main(String[] args) {
        try(Connection connection =  new ConnectionFactory().getConnexion()){
            String nome = "UpdatePrepStatement";
            String descricao = "UpdatePrepStatement";
                       
            try(PreparedStatement prepStatement = connection.prepareStatement("INSERT INTO categoria (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            prepStatement.setString(1, nome);
            prepStatement.setString(2, descricao);

            prepStatement.execute();
            ResultSet ids = prepStatement.getGeneratedKeys();
            
            while(ids.next()) {
                int id = ids.getInt("id");
                System.out.println(id);
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}