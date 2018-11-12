<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="windows-1251">
    <title>Hello</title>
</head>
<body>
    <h1>Users list</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Status</th>
            <th>E-mail</th>
            <th>Password</th>
        </tr>
        <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.status}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
