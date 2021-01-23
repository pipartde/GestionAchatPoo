<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container">
    <main>
        <h1>Mesures</h1>
        <h2>Liste des mesures.</h2>

        <table>
            <thead>
            <tr>
                <th>Mesure</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ListeDesMesures}" var="mesure">                 <%-- Va rechercher les infos depuis le servelt - donc l'objet liste 'mesures' retourné par le daoImpl est renommé 'ListeDesMesures' par le servlet --%>
                <tr>
                    <td>${mesure.mesNom}</td>
                    <td>
                        <a href="mesures-sup?mesId=${mesure.mesId}">            <%-- ATTENTION à l'url 'mesId=x' -> Il lit dans le servlet le parameter url recu --%>
                            Supprimer
                        </a>
                        <a href="mesures-mod?mesId=${mesure.mesId}">
                            Modifier
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h2>Ajout d'une mesure</h2>
        <form action="mesures-add" method="post">
            <input type="text" name="mesNom" placeholder="Nouvelle mesure">
            <input type="submit" class="btn btn-primary btn-block" value="Ajouter">
        </form>

    </main>
</div>

<%@include file="../templates/footer.jsp"%>