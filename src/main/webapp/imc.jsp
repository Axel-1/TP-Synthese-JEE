<%--
  Created by IntelliJ IDEA.
  User: axel
  Date: 09/02/2023
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IMC</title>
</head>
<body>

<h1>Calculer votre IMC</h1>

<h3>Moyenne des Utilisateurs : <%=request.getAttribute("moyenne")%></h3>

<form method="post" action="${pageContext.request.contextPath}/imc-servlet">
    <label for="taille">Taille (en m) :</label>
    <input type="number" step=".01" id="taille" name="taille" value=""/><br/>

    <label for="poids">Poids (en kg) :</label>
    <input type="number" id="poids" name="poids" value=""/><br/>

    <input type="submit" value="Calculer"/>
</form>

<% if (request.getAttribute("imc") != null || request.getAttribute("corpulence") != null) { %>
<h3>Votre IMC : <%=request.getAttribute("imc")%></h3>
<h3>Votre Corpulence : <%=request.getAttribute("corpulence")%></h3>
<% } %>

</body>

</html>
