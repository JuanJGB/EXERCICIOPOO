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
    <title>Title</title>
</head>
<body>
<div style="width: 1200px; margin-left: auto; margin-right: auto;">
    <table cellpadding="10">
        <tr>
            <a href="cadastro.jsp">Cadastrar Cliente</a>
        </tr>

            <% for (model.Cliente clientes: DataAccess.getAll()) {
            %>
            <tr>
                <td><%=clientes.getId()%></td>
                <td><%=clientes.getNome()%></td>
                <td><%=clientes.getRg()%></td>
                <td><%=clientes.getCpf()%></td>
                <td>
                    <a href="editar?id=<%=clientes.getId()%>">Edit</a>
                    <a href="deletar">Delete</a>
                </td>
            </tr>
            <%}%>

    </table>
</div>
</body>
</html>
