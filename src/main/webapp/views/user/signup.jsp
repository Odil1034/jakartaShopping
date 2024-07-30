<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Signup Page</title>
    <jsp:include page="/fragments/css.jsp"/>
    <style>
        /* Global Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 100%;
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
        }

        .row {
            display: flex;
            justify-content: center;
        }

        .col-md-6 {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 100%;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        /* Form Styles */
        form {
            display: flex;
            flex-direction: column;
        }

        .mb-3 {
            margin-bottom: 1rem;
        }

        label {
            margin-bottom: 0.5rem;
            font-weight: bold;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 100%;
        }

        input[type="text"]:focus,
        input[type="email"]:focus,
        input[type="password"]:focus {
            border-color: #007bff;
            outline: none;
        }

        button {
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            background-color: #0056b3;
        }

        .btn.success {
            background-color: #28a745;
        }

        .btn.success:hover {
            background-color: #218838;
        }

        .text-danger {
            color: #dc3545;
            font-size: 0.875rem;
            margin-top: -15px;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h2>Sign Up</h2>
            <form action="${pageContext.request.contextPath}/signup" method="post">
                <div class="mb-3">
                    <label for="fullName">Full Name</label>
                    <input type="text" id="fullName" name="fullName" placeholder="Full Name" required>
                    <c:if test="${fullname_error != null}">
                        <span class="text-danger">${fullname_error}</span>
                    </c:if>
                </div>
                <div>
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" placeholder="Username" required>
                    <c:if test="${username_error != null}">
                        <span class="text-danger">${username_error}</span>
                    </c:if>
                </div>
                <div>
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" placeholder="Email" required>
                    <c:if test="${email_error != null}">
                        <snap class="text-danger">${email_error}</snap>
                    </c:if>
                </div>
                <div>
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" placeholder="Password" required>
                    <c:if test="${password_error != null}">
                        <span class="text-danger">${password_error}</span>
                    </c:if>
                </div>
                <div>
                    <label for="c_password">Confirm Password</label>
                    <input type="password" id="c_password" name="confirmPassword" placeholder="Password Again" required>
                    <c:if test="${password_error != null}">
                        <span class="text-danger">${password_error}</span>
                    </c:if>
                </div>
                <button class="btn btn success" type="submit">Submit</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="/fragments/js.jsp"/>
</body>
</html>
