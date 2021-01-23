<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
    <main>
        <h1>Catégories</h1>
        <h2>Modification de la catégorie</h2>
        <form action="mod-categorie" method="post">
            <label><input type="text" name="catNom" placeholder=${categorie.catNom}></label>
            <input type="hidden" name="catId" value=${categorie.catId}>
            <input type="submit" value="Modifier">
        </form>
    </main>

<%@include file="../templates/footer.jsp"%>
