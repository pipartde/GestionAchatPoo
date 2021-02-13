<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String titre = "Catégories" ;%>
<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="container">
    <main>
        <h1>Catégories <c:if test="${magId != null}"><a href="produits?magId=${magId}"><i class="fas fa-angle-double-left" title="modifier"></i></a></c:if></h1>
        <table>
            <thead>
                <tr>
                    <th>Catégories</th>
                    <th>Actions</th>
                </tr>
            </thead>

            <tbody>
            <c:forEach items="${categories}" var="categorie">
                <c:if test="${categorie.id != 1}">
                    <tr>
                        <td>
                                ${categorie.catNom}
                        </td>
                        <td>
                            <a href="mod-categorie?catId=${categorie.id}<c:if test="${magId != null}">&mag_id=${magId}</c:if>"><i class="fas fa-pen" title="modifier"></i></a>
                            <a href="sup-categorie?id=${categorie.id}<c:if test="${magId != null}">&mag_id=${magId}</c:if>" onclick="return confirm('Êtes vous sûr(e) ?');"><i class="fas fa-trash" title="supprimer"></i></a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
    <form action="add-categorie" method="post">

                <tr>
                    <td>
                        <label><input type="text" name="catNom" placeholder="Nouvelle Catégorie" required></label>
                        <c:if test="${magId != null}"><input type="hidden" name="mag_id" value="${magId}"></c:if>
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