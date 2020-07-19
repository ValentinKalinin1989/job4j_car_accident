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
    <form name='login' action="<c:url value='/reg'/>" method='POST'>
    <table class="table table-borderless">
        <tr>
            <td>Имя:</td>
            <td><input type='text' name='username'></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Зарегестрироваться" class="btn btn-dark"/></td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
