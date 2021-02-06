<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<%! String titre = "Mesures" ;%>
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
                <c:if test="${mesure.mesId != 1}">
                    <tr>
                        <td>${mesure.mesNom}</td>
                        <td>
                            <a href="mesures-mod?mesId=${mesure.mesId}">
                                <i class="fas fa-pen" title="modifier"></i>
                            </a>
                            <a href="mesures-sup?mesId=${mesure.mesId}" onclick="return confirm('Êtes vous sûr(e) ?')">            <%-- ATTENTION à l'url 'mesId=x' -> Il lit dans le servlet le parameter url recu --%>
                                <i class="fas fa-trash" title="supprimer"></i>
                            </a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>

            </tbody>
            <form action="mesures-add" method="post">
                <tr>
                    <td>
                        <input type="text" name="mesNom" placeholder="Nouvelle mesure" required>
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