<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="${requestScope.get('title')}" />
<c:set var="next" value="${requestScope.get('next')}" />
<t:base title="${title}">
    <div class="content-section">
        <form method="post"
              action="${pageContext.request.contextPath}/login?next=${next}"
              role="form" data-toggle="validator"
              novalidate
        >
            <fieldset class="form-group">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" name="username" id="username" required data-minlength="5" placeholder="Enter username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" class="form-control" required id="password" placeholder="Password">
                    <small class="form-text text-muted">Forget your password? <a href="#"> Reset </a> </small>
                    <div class="invalid-feedback">
                        Password should not blank
                    </div>
                </div>
            </fieldset>
            <div class="form-group">
                <button class="btn btn-outline-info" type="submit">Log In</button>
            </div>
        </form>
        <div class="border-top pt-3">
            <small class="text-muted">
                Dont have a account? <a class="ml-2" href="#">Sign Up</a>
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