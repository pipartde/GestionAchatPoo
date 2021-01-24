<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="container">
    <main>
        <h4>Ajout d'un produit</h4>
        <form action="produitAdd" method="post">
            <select name="category">
                <c:forEach items="${categories}" var="categorie">
                    <option value="${categorie.id}">${categorie.catNom}</option>
                </c:forEach>
            </select>

            <input type="text" name="proNom" placeholder="produit">

            <input type="text" name="quantity" placeholder="Quantités voulue">

            <select name="mesures">
                <c:forEach items="${mesures}" var="mesure">
                    <option value="${mesure.mesId}">${mesure.mesNom}</option>
                </c:forEach>
            </select>

            <input type="submit" value="Ajouter">
            <p></p>
        </form>
    </main>
</div>

<%@include file="../templates/footer.jsp"%>