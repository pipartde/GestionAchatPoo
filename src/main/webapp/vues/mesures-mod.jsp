<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String titre = "Mesures" ;%>
<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container">
    <main>
        <h1>Mesures</h1>
        <h2>Modification des mesures</h2>
        <form action="mesures-mod" method="post">
            <input type="text" name="mesNom" value="${mesure.mesNom}">
            <input type="hidden" name="mesId" value="${mesure.mesId}">
            <c:if test="${magId != null}"><input type="hidden" name="mag_id" value="${magId}"></c:if>
            <input type="submit" value="Modifier">
        </form>
    </main>
</div>

<%@include file="../templates/footer.jsp"%>