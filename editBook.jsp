<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="org.example.models.Livre"%>
<html>
<head>
    <title> modification livre </title>
</head>
<body>
    <h1> Modifier Livre</h1>

<% Livre livre = (Livre) request.getAttribute("livre"); %>

    <form action="modifierLivre" method="post">

        <label>ISBN</label>
        <input type="text" readonly name="isbn" value="<%=livre.getIsbn()%>"/>


        <label>Titre</label>
        <input type="text" name="titre" value="<%=livre.getTitre()%>"/>

        <label>Auteur</label>
        <input type="text" name="auteur" value="<%=livre.getAuteur()%>"/>

         <label>Editeur</label>
         <input type="text" name="editeur" value="<%=livre.getEditeur()%>"/>

         <label>Prix</label>
         <input type="text" name="prix" value="<%=livre.getPrix()%>"/>

        <input type="submit" value="Modifier"/>
    </form>
</body>
</html>