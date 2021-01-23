<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="container">
    <main>
        <h1>Catégories</h1>
        <p>Voilà la page des catégories ! :D.</p>
        <table>
            <thead>
                <tr>
                    <th>Catégories</th>
                    <th>Actions</th>
                </tr>
            </thead>

            <tbody>
            <c:forEach items="${categories}" var="categorie">
                <tr>
                    <td>
                            ${categorie.catNom}
                    </td>
                    <td>
                        <a href="sup-categorie?id=${categorie.id}">Supprimer</a>

                        <a href="mod-categorie?catId=${categorie.id}">Modifier</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
    <form action="add-categorie" method="post">

                <tr>
                    <td>
                        <label><input type="text" name="catNom" placeholder="Nouvelle Catégorie"></label>
                    </td>

                    <td>
                        <input type="submit" value="Ajouter">
                    </td>
                </tr>

    </form>

        </table>
    </main>
</div>
<%@include file="../templates/footer.jsp"%>