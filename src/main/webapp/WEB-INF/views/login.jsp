<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <%@ include file="parts/css.jsp" %>
</head>
<body>
    <%@ include file="parts/navbar.jsp" %>

    <div class="container">

        <div class="row">
            <div class="col">
                <h1>Login</h1>
            </div>
        </div>

        <div class="row">
            <div class="col">

                <form action="/login" method="post">
                    <div class="form-group row">
                        <label class="col-4 col-form-label" for="txtuser">Username</label>
                        <div class="col-8">
                            <input id="txtuser" name="txtuser" placeholder="..." type="text" class="form-control here" required="required">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtpwd" class="col-4 col-form-label">Password</label>
                        <div class="col-8">
                            <input id="txtpwd" name="txtpwd" placeholder="..." type="password" class="form-control here" required>
                        </div>
                    </div>


                    <c:if test="${not empty param.error && param.error==true }">
                    <div class="row">
                        <div class="col-12">
                            <p>Dati non validi</p>
                        </div>
                    </div>
                    </c:if>

                    <div class="form-group row">
                        <div class="offset-4 col-8">
                            <button name="submit" type="submit" class="btn btn-success" id="btn-save">LOG-IN</button>
                            <a class="btn btn-warning" href="/registration">REGISTER</a>
                        </div>
                    </div>
                </form>

            </div>
        </div>









    </div><!-- container -->


    <%@ include file="parts/footer.jsp" %>
    <%@ include file="parts/footerjs.jsp" %>



</body>
</html>