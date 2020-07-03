<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"/>
    <title>Accident</title>
</head>

<body>

<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand">Автонарушители</a>
    <a class="text-white" href="<c:url value='./create'/>">Добавить инцидент</a>
</nav>

<br>

<div class="container">
    <table border="2" class="table table-bordered table-hover">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>ФИО нарушителя</th>
            <th>Тип события</th>
            <th>Список нарушенных статей</th>
            <th>Событие</th>
            <th>Место</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="accident" items="${accidents}">
            <tr>
                <form action="<c:url value='./edit'/>" method="GET">
                    <td><input type="hidden" name="id" value="${accident.id}">${accident.id}</td>
                    <td><input type="hidden" name="name" value="${accident.name}">${accident.name}</td>
                    <td><input type="hidden" name="accidentTypeId"
                               value="${accident.accidentType.id}">${accident.accidentType.name}</td>
                    <td>
                        <table class="table-borderless">
                            <c:forEach var="rule" items="${accident.rules}">
                                <tr>
                                    <td><input type="hidden" name="${rule.id}" value="${rule.id}">${rule.name}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                    <td><input type="hidden" name="text" value="${accident.text}">${accident.text}</td>
                    <td><input type="hidden" name="address" value="${accident.address}">${accident.address}</td>
                    <td><input name="submit" type="submit" value="Редактировать" class="btn btn-dark"></td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
