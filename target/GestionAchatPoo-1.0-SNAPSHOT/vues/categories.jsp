<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="container">
    <main>
        <h1>Catégories</h1>
        <p>Voilà la page des catégories ! :D.</p>

        <c:forEach items="${categories}" var="categories">
            <p>${categories.catNom}</p>
        </c:forEach>
        <%--Todo Mise en page + options modifier & supprimer--%>

    </main>
</div>
<%@include file="../templates/footer.jsp"%>