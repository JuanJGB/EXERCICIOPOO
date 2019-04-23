<%@ page import="model.Cliente" %>
<%@ page import="dao.DataAccess" %><%--
  Created by IntelliJ IDEA.
  User: francinecardoso
  Date: 2019-04-14
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <%
       String nome, rg, cpf;
       nome = request.getParameter("nome_cliente");
       rg = request.getParameter("rg_cliente");
       cpf = request.getParameter("cpf_cliente");

       Cliente cliente = new Cliente(nome, rg, cpf);

       DataAccess da = new DataAccess();
       da.edit(cliente);

       response.sendRedirect("/web_war_exploded/lista.jsp");
   %>
</head>
<body>

</body>
</html>
