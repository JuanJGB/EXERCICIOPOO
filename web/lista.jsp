<%@ page import="model.Cliente" %>
<%@ page import="db.DBUtils" %>
<%@ page import="dao.DataAccess" %><%--
  Created by IntelliJ IDEA.
  User: francinecardoso
  Date: 2019-04-14
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>lista</title>
</head>
<body>
<div style="width: 1200px; margin-left: auto; margin-right: auto;">
    <table cellpadding="10">
        <tr>
            <h1>Lista de Clientes</h1>
            <a href="index.jsp">Cadastrar Cliente</a>
        </tr>

        <% for (model.Cliente clientes : DataAccess.getAll()) {

        %>
            <th>Id</th>
            <th>Nome</th>
            <th>RG</th>
            <th>CPF</th>
            <th></th>

            <tr>
                <td><%=clientes.getId()%>
                </td>
                <td><%=clientes.getNome()%>
                </td>
                <td><%=clientes.getRg()%>
                </td>
                <td><%=clientes.getCpf()%>
                </td>
                <td>
                    <a href="editar.jsp">Editar</a>
                    <a >Deletar</a>
                </td>
            </tr>
            <%}%>

    </table>
</div>
</body>
</html>
