<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Projeto java crud</title>
</head>
<body>

<h1>Cadastrar Cliente</h1>
<div style="width: 900px; margin-left: auto; margin-right: auto";>
    <form action="JSP/confignovo.jsp" method="post">
         <br>
        <label>Nome:
            <input type="text" name="nome_cliente" style="windth:200px">
        </label>
      <br>
        <label>  RG:
            <input type="text" name="rg_cliente" style="width: 200px">
        </label>
        <br>
        <label>CPF:
            <input type="text" name="cpf_cliente" style="width: 200px">
        </label>
        <input type="submit" value="Submit">
    </form>
</div>

</body>
</html>