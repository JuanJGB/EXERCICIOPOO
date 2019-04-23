<%--
  Created by IntelliJ IDEA.
  User: francinecardoso
  Date: 2019-04-14
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Edit News</h1>
<div style="width: 900px; margin-left: auto; margin-right: auto">
    <c:forEach items="${getNewsById}" var="p">
        <form action="JSP/configedit.jsp" method="post">
            <input type="hidden" name="id" value="${p.id}">
            Nome:<br>
            <input type="text" value="${p.nome}" name="nome" style="width: 200px"><br>
            Idade:<br>
            <input type="text" value="${p.idade}" name="idade" style="width: 200px"><br>
            <input type="submit" value="Submit">
        </form>
    </c:forEach>

</div>
</body>
</html>
