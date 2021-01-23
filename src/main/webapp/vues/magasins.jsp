<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="container">
    <main>
        <h1>Magasins</h1>
        <h2>Liste des magasins.</h2>
        <table>
            <thead>
            <tr>
                <th>Magasin</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${magasins}" var="magasin">
                <tr>
                    <td>${magasin.magNom}</td>
                    <td>
                        <a href="supMagasin?id=${magasin.magId}">
                            Supprimer
                        </a>
                        <a href="modMagasin?magId=${magasin.magId}">
                            Modifier
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <h2>Ajout d'un magasin</h2>
        <form action="addMagasin" method="post">
            <input type="text" name="magNom" placeholder="Nouveau magasin">
            <input type="submit" class="btn btn-primary btn-block" value="Ajouter">
        </form>
    </main>
</div>
<%@include file="../templates/footer.jsp"%>