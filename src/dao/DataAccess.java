package dao;

import db.DBUtils;
import model.Cliente;
import model.New;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DataAccess {
    public void addNovo(Cliente cliente){
        try {
            PreparedStatement ps = DBUtils.getPreparedStatement("insert into cliente (nome, rg, cpf) values(?,?, ?)");
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getRg());
            ps.setString(2, cliente.getCpf());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Cliente> getAll(){
        List<Cliente> ls = new LinkedList<>();

        try {
            ResultSet rs = (ResultSet) DBUtils.getPreparedStatement("select * from cliente").executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente(rs.getString(1),rs.getString(2), rs.getString(3));
                ls.add(cliente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return  ls;
    }

    public static List<New> getNewById(int id){
        List<New> ls = new LinkedList<>();
        String sql = "select *from usuario where id = " + id;

        try {
            ResultSet rs = DBUtils.getPreparedStatement("select * from usuario").executeQuery();
            while (rs.next()){
                New n = new New(rs.getInt(1), rs.getString(2),rs.getInt(3));
                ls.add(n);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return ls;
    }

    public void edit (int id, String nome, int idade){
        String sql = "update usuario set nome = ?, idade=?" + "where id = ?";
        PreparedStatement ps;
        try {
            ps = DBUtils.getPreparedStatement(sql);
            ps.setString(1, nome);
            ps.setInt(2,idade);
            ps.setInt(3,id);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id ){
        try {
            String sql = "delete usuario where id = ?";
            PreparedStatement ps = DBUtils.getPreparedStatement(sql);
            ps.setInt(1,id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
