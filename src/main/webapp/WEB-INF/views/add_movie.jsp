<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Movie - Add</title>
    <%@ include file="parts/css.jsp" %>
</head>
<body>
<%@ include file="parts/navbar.jsp" %>
    <div class="container">

        <div class="row">
            <div class="col">
                <h1><c:out value="${titolo}" /></h1>
            </div>
        </div>

        <div class="row">
            <div class="col">

                <form action="/api/movie/" method="post">
                    <div class="form-group row">
                        <label class="col-4 col-form-label" for="title">Movie Title</label>
                        <div class="col-8">
                            <input id="title" name="title" placeholder="Add Title here ..." type="text" class="form-control here" required="required" aria-describedby="titleHelpBlock">
                            <span id="titleHelpBlock" class="form-text text-muted">Filed Required</span>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="director" class="col-4 col-form-label">Movie Director</label>
                        <div class="col-8">
                            <input id="director" name="director" placeholder="Add Director here ..." type="text" class="form-control here">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="year" class="col-4 col-form-label">Movie Year</label>
                        <div class="col-8">
                            <input id="year" name="year" placeholder="Add Year here ..." type="text" class="form-control here">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="offset-4 col-8">
                            <button name="submit" type="button" class="btn btn-primary" id="btn-save">Save</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>



    </div><!-- container -->


    <%@ include file="parts/footer.jsp" %>
    <%@ include file="parts/footerjs.jsp" %>

    <script>
        const btnSave = document.getElementById("btn-save");
        btnSave.addEventListener("click",doSave);

        function doSave() {
            event.srcElement.disabled = true; //evito clic multipli
            let titolo = document.getElementById("title").value;
            let regista = document.getElementById("director").value;
            let anno = document.getElementById("year").value;

            //validazione campi lato client
            if(isNaN(anno) || anno<1900 || anno > 2036 || titolo==""){
                alert("Titolo non valido o Anno non valido, numero tra 1900 e 2036")
                return false;
            }

            //le chiavi sono i valori della entity/oggetto entrante nel metodo in Java
            let movie = {
                "title":titolo,
                "director":regista,
                "year":anno
            };

            fetch("/api/movie/",{
                method: 'POST',
                headers: {
                    'Accept': 'application/json',       //risposta
                    'Content-Type': 'application/json'  //invio
                },
                body: JSON.stringify(movie)
            })
                .then(risp=>risp.json())
                .then(r=>{
                    //console.log(r)
                    if (r.hasOwnProperty("mid") && r.mid!=null && !isNaN(r.mid)){
                        alert("Film inserito")
                        location.href = "/site/elenco-film"
                    }
            })
                .catch(err=>console.error(err));
        }
    </script>


</body>
</html>