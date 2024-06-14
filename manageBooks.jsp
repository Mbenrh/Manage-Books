<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="org.example.models.Livre"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>First JSP</title>
</head>
<h1 align="center"> Liste des livres </h1>
<br>
<table width="60%" align="center">
<tr>
<td> ISBN </td>
<td> Titre </td>
<td> Auteur </td>
<td> Editeur </td>
<td> Prix </td>
<td> Action </td>
<td> </td>
</tr>
<%
List<Livre> livres = (List<Livre>) request.getAttribute("bookList");
for (Livre livre : livres) {
%>
<tr>
<td> <%= livre.getIsbn() %> </td>
<td> <%= livre.getTitre() %> </td>
<td> <%= livre.getAuteur() %> </td>
<td> <%= livre.getEditeur() %> </td>
<td> <%= livre.getPrix() %> </td>
<td>
<a href="./supprimerLivre?idl=<%=livre.getIsbn()%>">Supprimer </a>
</td>

<td>
<a href="./modifierLivre?id=<%=livre.getIsbn()%>">Modifier </a>
</td>

</tr>

<%
}
%>

</table>
</body>
</html>