<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="${requestScope.get('title')}" />
<t:base title="${title}">
    <p>You have been log out</p>
    <a href="${pageContext.request.contextPath}/login">Log In again</a>
</t:base>