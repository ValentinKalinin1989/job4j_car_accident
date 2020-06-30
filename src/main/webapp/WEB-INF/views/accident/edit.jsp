<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"/>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand">Редактирование информации об автонарушителе</a>
    <a class="text-white" href="<c:url value='./'/>">На главную страницу</a>
</nav>
<br>
<div class="container">
    <form action="<c:url value='./save'/>" method='POST'>
        <input type="hidden" name="id" value="<%= request.getParameter("id")%>">
        <div class="form-group">
            <label class="input-group-addon">ФИО нарушителя</label>
            <input id="msg" type="text" class="form-control" name="name" value="<%= request.getParameter("name")%>">
        </div>
        <div class="form-group">
            <label class="input-group-addon">Описание события</label>
            <input id="msg" type="text" class="form-control" name="text" value="<%= request.getParameter("text")%>">
        </div>
        <div class="form-group">
            <label class="input-group-addon">Место события</label>
            <input id="msg" type="text" class="form-control" name="address"
                   value="<%= request.getParameter("address")%>">
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-dark" name="submit" value="Сохранить">
        </div>
    </form>
</div>
</body>
</html>
