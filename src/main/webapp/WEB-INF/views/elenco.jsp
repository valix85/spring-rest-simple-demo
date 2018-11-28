<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Movie List</title>




    <%@ include file="parts/css.jsp" %>

</head>
<body>
<%@ include file="parts/navbar.jsp" %>
<div class="container">

<h1><c:out value="${titolo}"/></h1>

    <sec:authorize access="hasRole('ROLE_ADMIN') || hasRole('ROLE_RUOLO2')">
    <div class="row mt-4">
        <div class="col text-right">
            <a class="btn btn-primary" href="/site/movie/add"><i class="fas fa-plus-square"></i> ADD</a>
        </div>
    </div>
    </sec:authorize>




    <div class="row mt-3">
    <div class="col ">

<table class="table">
    <thead>
    <tr>
        <th scope="col">mID</th>
        <th scope="col">Title</th>
        <th scope="col">Director</th>
        <th scope="col">Year</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="film" items="${films}">
    <tr>
        <th scope="row">${film.MID}</th>
        <td><c:out value="${film.title}"/></td>
        <td><c:out value="${film.director}"/></td>
        <td><c:out value="${film.year}"/></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
    </div>
    </div>

</div> <!-- chiusura container -->


<%@ include file="parts/footer.jsp" %>

<%@ include file="parts/footerjs.jsp" %>
</body>
</html>