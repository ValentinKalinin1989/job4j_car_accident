<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"/>
    <title>Accident</title>
</head>
<body>
<div class="container">
    <table border="2" class="table table-bordered table-hover">
        <thead class="thead-dark">
        <tr>
            <th>Город</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${towns}" var="town">
            <tr>
                <td>${town}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
