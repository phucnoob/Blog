<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="${requestScope.get('title')}" />
<t:base title="${title}">
    <div class="content-section">
        <form method="post"
              action="${pageContext.request.contextPath}/post/new"
              role="form" data-toggle="validator"
              novalidate
              class="needs-validation"
        >
            <fieldset class="form-group">
                <legend class="border-bottom mb-4">Blog Post</legend>
                <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" class="form-control" id="title" name="title" required >
                    <div class="invalid-feedback">
                        Title should not be blank
                    </div>
                </div>
                <div class="form-group">
                    <label for="content">Content</label>
                    <textarea class="form-control" id="content" name="content" required rows="5"></textarea>
                    <div class="invalid-feedback">
                        Content should not blank
                    </div>
                </div>
            </fieldset>
            <div class="form-group">
                <button class="btn btn-outline-info" type="submit">Post</button>
            </div>
        </form>
    </div>
    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict'

            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.querySelectorAll('.needs-validation')

            // Loop over them and prevent submission
            Array.prototype.slice.call(forms)
                .forEach(function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault()
                            event.stopPropagation()
                        }

                        form.classList.add('was-validated')
                    }, false)
                })
        })()
    </script>
</t:base>
