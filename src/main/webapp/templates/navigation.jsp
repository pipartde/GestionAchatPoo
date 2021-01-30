<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <div>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}" <% if(titre == "Index"){ %>class="active"<% } %> >Gestion Achat</a>
            </li>
        </ul>
        <ul class="right">
            <li>
               <a href="magasins" <% if(titre == "Magasin"){ %>class="active"<% } %> >Magasins</a>
            </li>
            <li>
                <a href="categories" <% if(titre == "Catégories"){ %>class="active"<% } %> >Catégories</a>
            </li>
            <li>
                <a href="mesures" <% if(titre == "Mesures"){ %>class="active"<% } %> >Mesures</a>
            </li>
            <li>
                <a href="produits" <% if(titre == "Produits"){ %>class="active"<% } %> >Produits</a>
            </li>
        </ul>
    </div>
</nav>
