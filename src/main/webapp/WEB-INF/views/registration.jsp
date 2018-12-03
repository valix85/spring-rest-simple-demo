<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>
    <%@ include file="parts/css.jsp" %>
</head>
<body>
    <%@ include file="parts/navbar.jsp" %>

    <div class="container">

        <div class="row">
            <div class="col">
                <h1>Registration</h1>
            </div>
        </div>

        <div class="row">
            <div class="col">

                <form action="/registration" method="post">

                    <div class="form-group row">
                        <label class="col-4 col-form-label" for="name">Name</label>
                        <div class="col-8">
                            <input id="name" name="name" placeholder="..." type="text" class="form-control here" required="required">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-4 col-form-label" for="lname">Last Name</label>
                        <div class="col-8">
                            <input id="lname" name="lastName" placeholder="..." type="text" class="form-control here" required="required">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-4 col-form-label" for="email">Username</label>
                        <div class="col-8">
                            <input id="email" name="email" placeholder="valid email here..." type="email" class="form-control here" required="required">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="password" class="col-4 col-form-label">Password</label>
                        <div class="col-8">
                            <input id="password" name="password" placeholder="..." type="password" class="form-control here" required>
                        </div>
                    </div>



                    <c:if test="${not empty successMessage }">
                    <div class="row">
                        <div class="col-12">
                            <p>${successMessage}</p>
                        </div>
                    </div>
                    </c:if>

                    <spring:hasBindErrors name="customerAccountFormObj">
                        <div>
                            <p>${errors.email}</p>
                            <p>${errors.getFieldError("email")}</p>
                        </div>

                    </spring:hasBindErrors>


                    <div class="form-group row">
                        <div class="offset-4 col-8">
                            <button name="submit" type="submit" class="btn btn-success" id="btn-save">REGISTER</button>
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