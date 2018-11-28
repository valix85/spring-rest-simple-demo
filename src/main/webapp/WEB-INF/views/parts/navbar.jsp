<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light mb-3">
    <div class="container">
        <a class="navbar-brand" href="#">Navbar w/ text</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/site/movie">Movie</a>
                </li>
            </ul>


     <span>
         <sec:authorize access="isAuthenticated()">
                 <div>Ciao <sec:authentication property="principal.username" /><a href="/logout" style="padding: .5rem .5rem;">(Logout)</a></div>
         </sec:authorize>
         <sec:authorize access="!isAuthenticated()">
             <div><a href="/login" class="nav-link">Login</a></div>
         </sec:authorize>
    </span>


        </div>
    </div>
</nav>