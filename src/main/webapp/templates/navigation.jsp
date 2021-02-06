<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <div>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}" <% if(titre == "Index"){ %>class="active"<% } %> ><i class="fas fa-home"></i></a>
            </li>
        </ul>
        <ul class="right">
            <li class="dropdown">
                <button class="dropbtn">Options</button>
                <div class="dropdown-content">
                    <a href="categories">Catégories</a>
                    <a href="mesures">Mesures</a>
                </div>
            </li>

        </ul>
    </div>
</nav>
