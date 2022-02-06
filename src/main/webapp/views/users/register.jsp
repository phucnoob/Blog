<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="${requestScope.get('title')}" />
<t:base title="${title}">
    <div class="content-section">
        <form method="post"
              action="${pageContext.request.contextPath}/register"
              role="form" data-toggle="validator"
              novalidate
              class="needs-validation"
              >
            <fieldset class="form-group">
                <legend class="border-bottom mb-4">Join Today</legend>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" data-remote="" class="form-control" name="username" id="username" required data-minlength="5" placeholder="Enter username">
                    <div class="invalid-feedback">
                        Username should not contain special characters and at least length of 5
                    </div>
                </div>
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" class="form-control" id="email" name="email" required aria-describedby="emailHelp" placeholder="Enter email">
                    <div class="invalid-feedback">
                        Please enter a valid email
                    </div>
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" class="form-control" required id="password" placeholder="Password">
                    <div class="invalid-feedback">
                        Password should not blank
                    </div>
                </div>
                <div class="form-group">
                    <label for="password-check">Password Confirm</label>
                    <input type="password" name="passwordCheck" class="form-control" required data-match="#password" data-match-error="Whoops, these don't match" id="password-check" placeholder="Password (Again)">
                    <div class="invalid-feedback">
                        The passwords are not identical
                    </div>
                    <div class="valid-feedback">
                        Correct
                    </div>
                </div>
            </fieldset>
            <div class="form-group">
                <button class="btn btn-outline-info" type="submit">Sign Up</button>
            </div>
        </form>
        <div class="border-top pt-3">
            <small class="text-muted">
                Already Have An Account? <a class="ml-2" href="#">Sign In</a>
            </small>
        </div>
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
