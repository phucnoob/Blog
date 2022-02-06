<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="title" type="java.lang.String"  %>
<!DOCTYPE html>
<html>
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">

    <c:choose>
        <c:when test="${ title != null && !title.blank }">
            <title>Blog - <c:out value="${title}" /></title>
        </c:when>
        <c:otherwise>
            <title>Blog</title>
        </c:otherwise>
    </c:choose>

</head>
<body>
<header class="site-header">
    <nav class="navbar navbar-expand-md navbar-dark bg-steel fixed-top">
        <div class="container">
            <a class="navbar-brand mr-4" href="${pageContext.request.contextPath}/home">Jsp Blog</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggle" aria-controls="navbarToggle" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarToggle">
                <div class="navbar-nav mr-auto">
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/home">Home</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/about">About</a>
                </div>
                <!-- Navbar Right Side -->
                <div class="navbar-nav">
                    <c:set var="is_login" value="${sessionScope.get('is_login')}" />
                    <c:choose>
                       <c:when test="${is_login == null}">
                           <a class="nav-item nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                           <a class="nav-item nav-link" href="${pageContext.request.contextPath}/register">Register</a>
                       </c:when>
                       <c:otherwise>
                           <a class="nav-item nav-link" href="${pageContext.request.contextPath}/profile">Profile</a>
                           <a class="nav-item nav-link" href="${pageContext.request.contextPath}/post/new">Post</a>
                           <a class="nav-item nav-link" href="${pageContext.request.contextPath}/logout">Log out</a>
                       </c:otherwise>
                   </c:choose>
                </div>
            </div>
        </div>
    </nav>
</header>
<main role="main" class="container">
    <div class="row">
        <div class="col-md-8">
            <c:set var="message" value="${sessionScope.get('message')}" />
            <c:set var="tag" value="${sessionScope.get('tag')}" />
            <c:if test="${message != null}">
                <div class="alert alert-${tag}">
                    <c:out value="${message}"/>
                </div>
            </c:if>
            <c:remove var="tag" scope="session"/>
            <c:remove var="message" scope="session" />
            <jsp:doBody/>
        </div>
        <div class="col-md-4">
            <div class="content-section">
                <h3>Our Sidebar</h3>
                <p class='text-muted'>You can put any information here you'd like.
                <ul class="list-group">
                    <li class="list-group-item list-group-item-light">Latest Posts</li>
                    <li class="list-group-item list-group-item-light">Announcements</li>
                    <li class="list-group-item list-group-item-light">Calendars</li>
                    <li class="list-group-item list-group-item-light">etc</li>
                </ul>
            </div>
        </div>
    </div>
</main>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
