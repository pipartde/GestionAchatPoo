<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String titre = "Produits";%>
<%@include file="../templates/header.jsp" %>
<%@include file="../templates/navigation.jsp" %>

<div class="container">
    <main>
        <h1>Liste pour le magasin : <c:forEach items="${magasins}" var="magasin">
            <c:if test="${magasin.magId == magId}">${magasin.magNom}</c:if>
        </c:forEach> &ensp;<a href="${pageContext.request.contextPath}"><i class="fas fa-angle-double-left" title="modifier"></i></a></h1>



        <table>
            <thead>
            <tr>
                <th>Catégorie &ensp;<a href="categories?mag_id=${magId}"><i class="fas fa-pen" title="modifier"></i></a></th>
                <th>Produit</th>
                <th>Quantitée</th>
                <th>Mesure &ensp;<a href="mesures"><i class="fas fa-pen" title="modifier"></i></a></th>
                <th>actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${produits}" var="produit">
                <tr>
                    <td><c:forEach items="${categories}" var="categorie">
                        <c:if test="${categorie.id == produit.proCatId}">${categorie.catNom}</c:if>
                    </c:forEach></td>

                    <td>${produit.proNom}</td>

                    <td>${produit.proQtt}</td>

                    <td><c:forEach items="${mesures}" var="mesure">
                        <c:if test="${mesure.mesId == produit.proMesId}">${mesure.mesNom}</c:if>
                    </c:forEach></td>

                    <td>
                        <a href="produitMod?id=${produit.id}&magId=${magId}">
                            <i class="fas fa-pen" title="modifier"></i>
                        </a>
                        <a href="produitSup?id=${produit.id}&magId=${magId}" onclick="return confirm('Êtes vous sûr(e) ?')">
                            <i class="fas fa-trash" title="supprimer"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <form action="produitAdd" method="post">
                <tr>
                    <td>
                        <select name="category">
                            <c:forEach items="${categories}" var="categorie">
                                <option value="${categorie.id}">${categorie.catNom}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <input type="text" name="proNom" placeholder="produit" required>
                    </td>
                    <td>
                        <input type="text" name="quantity" placeholder="Quantités voulue" required>
                    </td>
                    <td>
                        <select name="mesures">
                            <c:forEach items="${mesures}" var="mesure">
                                <option value="${mesure.mesId}">${mesure.mesNom}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <input type="hidden" name="magId" value="${magId}">
                        <input type="submit" value="Ajouter">
                    </td>
                </tr>
            </form>
        </table>

    </main>
</div>

<%@include file="../templates/footer.jsp" %>