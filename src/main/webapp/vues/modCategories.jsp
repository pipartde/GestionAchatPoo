<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<div class="container">
    <main>
        <h1>Catégories</h1>
        <h2>Modification de la catégorie</h2>
        <form action="mod-categorie" method="post">
            <label><input type="text" name="catNom" placeholder=${categorie.catNom}></label>
            <input type="hidden" name="catId" value=${categorie.id}>
            <input type="submit" value="Modifier">
        </form>
    </main>
</div>

<%@include file="../templates/footer.jsp"%>
