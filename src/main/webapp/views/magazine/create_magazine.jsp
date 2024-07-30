<%--
  Created by IntelliJ IDEA.
  User: Skipper
  Date: 29.07.2024
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Magazine</title>
    <jsp:include page="/fragments/css.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/create-magazine.css">
</head>

<body>
<%--<jsp:include page="/fragments/navbar.jsp"/>--%>
<%--<h1>Create Magazine Page</h1>--%>

<div class="login-container">
    <h1 class="btn btn-success">Create Magazine</h1>
    <form action="/seller/magazine/create" method="POST">

        <label for="name">Name</label>
        <input type="text" id="name" name="name" placeholder="Name" required>

        <label for="description">Description</label>
        <textarea id="description" name="description" placeholder="Description" required rows="5"></textarea>
        <br>
        <h3 class="btn-warning">Address Magazine</h3>
        <label for="city">City</label>
        <input type="text" id="city" name="city" placeholder="Tashkent City" required>

        <label for="district">District</label>
        <input type="text" id="district" name="district" placeholder="Chilanzar District" required>

        <label for="street">Street</label>
        <input type="text" id="street" name="street" placeholder="Yakka Bog' Street" required>

        <label for="houseNumber">House Number</label>
        <input type="text" id="houseNumber" name="houseNumber" placeholder="123A" required>
        <br>
        <button class="btn btn-success" type="submit">CREATE</button>
    </form>
</div>


<jsp:include page="/fragments/js.jsp"/>
</body>
</html>
