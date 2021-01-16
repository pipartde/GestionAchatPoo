<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="container">
    <main>
        <h1>Magasins</h1>
        <p>Ceci est la pade des magasins.</p>
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
                            supprimer
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</div>
<%@include file="../templates/footer.jsp"%>