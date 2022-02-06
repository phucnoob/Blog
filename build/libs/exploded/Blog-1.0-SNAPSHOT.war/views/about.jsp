<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="${requestScope.get('title')}" />
<t:base title="${title}">
    <h1>About Page</h1>
    <a href="https://www.facebook.com/phuclac2k3/">My facebook</a><br>
    <a href="mailto:phuclinux123@gmail.com">Send me email</a><br>

    <a href="test.jsp">Test Image</a>
</t:base>