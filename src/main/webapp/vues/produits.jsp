<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container">
    <main>
        <h1>Produits</h1>
        <h2>Ceci est la page des produits.</h2>
        <table>
            <thead>
            <tr>
                <th>produit</th>
                <th>catégorie</th>
                <th>Mesure</th>
                <th>quantité</th>
                <th>actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${produits}" var="produit">
                <tr>
                    <td>${produit.proNom}</td>

                    <td><c:forEach items="${categories}" var="categorie">
                        <c:if test="${categorie.id == produit.proCatId}">${categorie.catNom}</c:if>
                    </c:forEach></td>

                    <td><c:forEach items="${mesures}" var="mesure">
                        <c:if test="${mesure.mesId == produit.proMesId}">${mesure.mesNom}</c:if>
                    </c:forEach></td>

                    <td>${produit.proQtt}</td>
                    <td>
                        <a href="produitSup?id=${produit.id}">
                            Supprimer
                        </a>
                        <a href="produitMod?id=${produit.id}">
                            Modifier
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p>Ajout d'un produit : <a href="produitAdd">Ajouter</a></p>
    </main>
</div>

<%@include file="../templates/footer.jsp"%>