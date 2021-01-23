<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 23/01/2021
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un produit</title>
</head>
<body>
<h4>Ajout d'un produit</h4>
<form action="produitAdd" method="post">

    <select name="categorie">
        <c:forEach items="${categories}" var="cat">
            <option value="${cat.catId}">${cat.catNom}</option>
        </c:forEach>
    </select>

    <input type="text" name="proNom" placeholder="produit">

    <select name="mesure">
        <c:forEach items="${mesures}" var="mesure">
            <option value="${mesure.mesId}">${mesure.mesNom}</option>
        </c:forEach>
    </select>

    <input type="text" name="quantity" placeholder="Quantity">


    <input type="submit" value="Ajouter">
</form>

</body>
</html>
