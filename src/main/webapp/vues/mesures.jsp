<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container">
    <main>
        <h1>Mesures</h1>

        <table>
            <thead>
            <tr>
                <th>Mesures</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ListeDesMesures}" var="mesure">                 <%-- Va rechercher les infos depuis le servelt - donc l'objet liste 'mesures' retourné par le daoImpl est renommé 'ListeDesMesures' par le servlet --%>
                <tr>
                    <td>${mesure.mesNom}</td>
                    <td>
                        <a href="mesures-mod?mesId=${mesure.mesId}">
                            <i class="fas fa-pen" title="modifier"></i>
                        </a>
                        <a href="mesures-sup?mesId=${mesure.mesId}">            <%-- ATTENTION à l'url 'mesId=x' -> Il lit dans le servlet le parameter url recu --%>
                            <i class="fas fa-minus" title="supprimer"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <form action="mesures-add" method="post">
                <tr>
                    <td>
                        <input type="text" name="mesNom" placeholder="Nouvelle mesure">
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