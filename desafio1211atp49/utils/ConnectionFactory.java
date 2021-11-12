package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class ConnectionFactory {
    private DataSource dataSource;

    public ConnectionFactory() {
        
        ComboPooledDataSource pool = new ComboPooledDataSource(); // Onde ele se conecta, qual o usuário e qual a senha. Tem vários usuários para fazer isso.
        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        pool.setUser("postgres");
        pool.setPassword("123456");
        pool.setMaxPoolSize(15); 
        this.dataSource = pool;  
         
    }
    public Connection getConnexion() throws SQLException{
        return this.dataSource.getConnection();        
    }   
}

