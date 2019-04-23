package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtils {
    public static PreparedStatement getPreparedStatement(String sql)throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        String url = "jdbc:mysql://localhost:3306/pizzaria?useTimezone=true&serverTimezone=America/Sao_Paulo&autoReconnect=true&verifyServerCertificate=false&useSSL=true";
        String user = "root";
        String pass = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url,user,pass);
        ps = con.prepareStatement(sql);

        return ps;
    }

    //verifica conexao

    public static void main (String[] args) throws SQLException, ClassNotFoundException {
        getPreparedStatement("select * from cliente ");

        System.out.println("conectado!");
    }

}
