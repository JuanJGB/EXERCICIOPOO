<%--
  Created by IntelliJ IDEA.
  User: francinecardoso
  Date: 2019-04-14
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@page import="dao.DataAccess"%>
<%@page import="model.New"%>
<%@ page import="model.Cliente" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<%
    String nome, rg, cpf;
    nome = request.getParameter("nome_cliente");
    rg = request.getParameter("rg_cliente");
    cpf = request.getParameter("cpf_cliente");

    Cliente cliente = new Cliente(nome, rg, cpf);

    DataAccess da = new DataAccess();
    da.addNovo(cliente);

    response.sendRedirect("/web_war_exploded/lista.jsp");
%>

</body>
</html>
