package dao;

import db.DBUtils;
import model.Cliente;
import model.New;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataAccess {
    public void addNovo(Cliente cliente){
        try {
            PreparedStatement ps = DBUtils.getPreparedStatement("insert into pizzaria.cliente (nome, rg, cpf) values(?,?,?)");
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getRg());
            ps.setString(3, cliente.getCpf());
            ps.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Cliente> getAll(){
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            ResultSet rs = DBUtils.getPreparedStatement("select * from cliente").executeQuery();
            while(rs.next()){
                int id = rs.getInt("idcliente");
                String nome = rs.getString("nome");
                String rg = rs.getString("rg");
                String cpf = rs.getString("cpf");

                Cliente cliente = new Cliente(nome, rg, cpf);
                cliente.setId(id);
                listaClientes.add(cliente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return  listaClientes;
    }

    public static List<Cliente> getNewById(int id){
        List<Cliente> ls = new LinkedList<>();
        String sql = "select *from cliente where idcliente = " + id;

        try {
            ResultSet rs = DBUtils.getPreparedStatement("select * from cliente").executeQuery();
            while (rs.next()){
                Cliente cliente = new Cliente(rs.getString(1),rs.getString(2), rs.getString(3));
                ls.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return ls;
    }

    public static void edit (Cliente cliente){

        try {
            String sql = "UPDATE INTO pizzaria.cliente  SEt nome = ?, rg = ?, cpf = ? where idcliente = ?) VALUES (?,?,?))";

            PreparedStatement st = DBUtils.getPreparedStatement((sql));

            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getRg());
            st.setString(3, cliente.getCpf());
            st.execute();
            st.close();
            ResultSet rs = DBUtils.getPreparedStatement("select * from cliente").executeQuery();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id ){
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
