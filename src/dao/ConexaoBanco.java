package dao;

import java.sql.*;
import java.util.Properties;

class ConexaoBanco {

    private Connection conexao=null;


    private Connection getConnection(String url){
        try {
            Class.forName("org.postgresql.Driver");
            Properties properties = new Properties();
            String username = "postgres";
            properties.setProperty("user", username);
            String password = "toor";
            properties.setProperty("password", password);
            conexao = DriverManager.getConnection(url,properties);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conexao;
    }

    Connection getConnection(){
        if (conexao != null){
            return conexao;
        }

        String url = "jdbc:postgresql://localhost/ProvaMurakami";
        return getConnection(url);
    }


}
