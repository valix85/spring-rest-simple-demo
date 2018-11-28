<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Movie Index</title>
    <%@ include file="parts/css.jsp" %>
</head>
<body>
<%@ include file="parts/navbar.jsp" %>

<div class="container">
    <h1><c:out value="${titolo}" /></h1>
    <%-- <h1>${titolo}</h1> --%>

    <ol>
        <c:forEach var="persona" items="${vincitori}">
            <li><c:out value="${persona}" /></li>
        </c:forEach>
    </ol>
    <hr>

    <div>Fare un link a una pagina che carichi tutti i film in una tabella HTML</div>
    <a href="/site/elenco-film">ELENCO FILM</a>



    <hr>
    <%-- Altri tag/proprietà di esempio di JSP/JSTL --%>
    <ol>
        <%-- definizione di variabile in JSTL --%>
    <c:set var="count" value="${0}" scope="page" />

    <c:forEach var="persona" items="${vincitori}" varStatus="cont" begin="0" end="${vincitori.size()}" >
        <!-- in your loops -->
        <c:if test="${vincitori[count].length()>7}">
        <li><c:out value="${vincitori[count]}" /> - ( ${cont.count} )</li>
        </c:if>
        <c:set var="count" value="${count + 1}" scope="page"/>
    </c:forEach>
    </ol>




</div><!-- container -->


    <%@ include file="parts/footer.jsp" %>

    <%@ include file="parts/footerjs.jsp" %>

</body>
</html>