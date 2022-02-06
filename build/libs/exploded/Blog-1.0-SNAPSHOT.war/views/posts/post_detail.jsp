<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page pageEncoding="UTF-8" %>

<c:set var="title" value="${requestScope.get('title')}" />

<c:set var="user" value="${sessionScope.get('islogin')}" />
<c:set var="is_login" value="${sessionScope.get('is_login')}" />

<t:base title="${title}">
    <jsp:useBean id="post" scope="request" type="blog.me.blog.models.Post"/>

        <article class="media content-section">
            <img class="rounded-circle article-img" src="${pageContext.request.contextPath}/image?image=${ post.author.avatar }">
            <div class="media-body">
                <div class="article-metadata">
                    <a class="mr-2" href="#">${ post.author.username }</a>
                    <small class="text-muted">${ post.date_posted }</small>
                </div>
                <h2 class="article-title" >${ post.title }</h2>
                <p class="article-content">${ post.content }</p>
            </div>
        </article>
</t:base>