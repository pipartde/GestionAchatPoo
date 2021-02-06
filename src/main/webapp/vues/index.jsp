<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String titre = "Index" ;%>

<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="container">
    <main>
        <h1>Mes listes</h1>
        <table>
            <thead>
            <tr>
                <th>Magasins</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${magasins}" var="magasin">
                <tr>
                    <td><a href="produits?magId=${magasin.magId}">${magasin.magNom}</a></td>
                    <td>
                        <a href="modMagasin?magId=${magasin.magId}">
                            <i class="fas fa-pen" title="modifier"></i>
                        </a>
                        <a href="supMagasin?id=${magasin.magId}">
                            <i class="fas fa-trash" title="supprimer"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <form action="addMagasin" method="post">
                <tr>
                    <td>
                        <input type="text" name="magNom" placeholder="Nouveau magasin">
                    </td>
                    <td>
                        <input type="submit" class="btn btn-primary btn-block" value="Ajouter">
                    </td>
                </tr>
            </form>
        </table>
    </main>
</div>
<%@include file="../templates/footer.jsp"%>