<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String titre = "Produits" ;%>
<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="container">
    <main>
        <h4>Modification d'un produit</h4>
        <form action="produitMod" method="post">
            <select name="category">
                <c:forEach items="${categories}" var="categorie">
                    <option value="${categorie.id}" <c:if test="${categorie.id == produit.proCatId}">selected</c:if>>${categorie.catNom}</option>
                </c:forEach>
            </select>

            <input type="text" name="proNom" value="${produit.proNom}">

            <input type="text" name="quantity" value="${produit.proQtt}">

            <select name="mesures">
                <c:forEach items="${mesures}" var="mesure">
                    <option value="${mesure.mesId}" <c:if test="${mesure.mesId == produit.proMesId}">selected</c:if>>${mesure.mesNom}</option>
                </c:forEach>
            </select>

            <input type="hidden" name="proId" value="${produit.id}">
            <input type="hidden" name="magId" value="${magId}">
            <input type="submit" value="Modifier">
            <p></p>
        </form>
    </main>
</div>

<%@include file="../templates/footer.jsp"%>