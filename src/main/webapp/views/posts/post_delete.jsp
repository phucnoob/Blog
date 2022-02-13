<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>

<c:set var="title" value="${requestScope.get('title')}" />
<t:base title="${title}">
    <jsp:useBean id="post" scope="request" type="blog.me.blog.models.Post"/>

    <div class="content-section">

        <form method="post"
              action="${pageContext.request.contextPath}/post/delete/${ post.post_id }"
              role="form" data-toggle="validator"
              novalidate
              class="needs-validation"
        >
            <fieldset class="form-group">
                <legend class="border-bottom mb-4">Are you sure you want to detele "${ post.title }" post</legend>
            </fieldset>
            <div class="form-group">
                <button class="btn btn-danger" type="submit">Delete</button>
                <a class="btn btn-outline-info" href="/post/${ post.post_id }"> Cancel </a>
            </div>
        </form>
    </div>
</t:base>