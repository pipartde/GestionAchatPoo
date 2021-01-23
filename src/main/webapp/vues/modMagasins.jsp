<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="container">
    <main>
        <h1>Magasins</h1>
        <h2>Modification du magasins</h2>
        <form action="add-magasin" method="post">
            <input type="text" name="magNom" placeholder=${magasin.magNom}>
            <input type="hidden" name="magId" value=${magasin.magId}>
            <input type="submit" value="Ajouter">
        </form>
    </main>
</div>
<%@include file="../templates/footer.jsp"%>