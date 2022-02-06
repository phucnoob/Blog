<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="${requestScope.get('title')}" />
<jsp:useBean id="user" scope="request" type="blog.me.blog.models.User" />
<t:base title="${title}">
    <div class="content-section">
        <div class="media">
            <img class="rounded-circle account-img" src="${pageContext.request.contextPath}/image?image=${ user.avatar }" alt="Avatar">
            <div class="media-body">
                <h2 class="account-heading">${ user.username }</h2>
                <p class="text-secondary">${ user.email }</p>
            </div>
        </div>
        <form method="post"
              action="${pageContext.request.contextPath}/profile"
              role="form" data-toggle="validator"
              novalidate
              class="needs-validation"
              enctype="multipart/form-data"
        >
            <fieldset class="form-group">
                <legend class="border-bottom mb-4">Profile Info</legend>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" name="username" value="${ user.username }" id="username" required data-minlength="5" placeholder="Enter username">
                    <div class="invalid-feedback">
                        Username should not contain special characters and at least length of 5
                    </div>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="${ user.email }" required aria-describedby="emailHelp" placeholder="Enter email">
                    <div class="invalid-feedback">
                        Please enter a valid email
                    </div>
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="image">Avatar</label>
                    <input type="file" name="image" class="form-control" id="image" placeholder="Password">
                </div>
                <input type="hidden" name="user_id" value="${ user.user_id }">
            </fieldset>
            <div class="form-group">
                <button class="btn btn-outline-info" type="submit">Update</button>
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