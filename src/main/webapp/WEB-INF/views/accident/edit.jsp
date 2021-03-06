<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"/>
    <title>Редактирование события</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand">Редактирование информации об автонарушителе</a>
    <a class="text-white" href="<c:url value='./'/>">На главную страницу</a>
</nav>
<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand font-italic text-primary">Вход под именем: ${user.username}</a>
</nav>
<br>
<div class="container">
    <form action="<c:url value='./save'/>" method='POST'>
        <input type="hidden" name="id" value='${param["id"]}'>
        <div class="form-group">
            <label class="input-group-addon">ФИО нарушителя</label>
            <input id="msg" type="text" class="form-control" name="name" value='${param["name"]}'>
        </div>
        <div class="form-group">
            <label class="input-group-addon">Тип</label>
            <select name="accidentType.id" class="form-control">
                <c:forEach var="accidentType" items='${accidentTypes}'>
                    <option value="${accidentType.id}"
                            <c:set var="typeId" value='${param["accidentTypeId"]}'/>
                            <c:if test='${accidentType.id eq typeId}'> selected="selected" </c:if>
                    >${accidentType.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label class="input-group-addon">Список нарушенных статей</label>
            <select multiple="multiple" name="ruleIds" class="form-control">
                <c:forEach var="rule" items="${rules}" varStatus="loop">
                    <option value="${rule.id}"
                            <c:set var="ruleId" value='${param["1"]}'/>
                            <c:if test='${rule.id eq ruleId}'> selected="selected" </c:if>
                            <c:set var="ruleId" value='${param["2"]}'/>
                            <c:if test='${rule.id eq ruleId}'> selected="selected" </c:if>
                            <c:set var="ruleId" value='${param["3"]}'/>
                            <c:if test='${rule.id eq ruleId}'> selected="selected" </c:if>
                            <c:set var="ruleId" value='${param["4"]}'/>
                            <c:if test='${rule.id eq ruleId}'> selected="selected" </c:if>
                            <c:set var="ruleId" value='${param["5"]}'/>
                            <c:if test='${rule.id eq ruleId}'> selected="selected" </c:if>
                            <c:set var="ruleId" value='${param["6"]}'/>
                            <c:if test='${rule.id eq ruleId}'> selected="selected" </c:if>
                            <c:set var="ruleId" value='${param["7"]}'/>
                            <c:if test='${rule.id eq ruleId}'> selected="selected" </c:if>
                            <c:set var="ruleId" value='${param["8"]}'/>
                            <c:if test='${rule.id eq ruleId}'> selected="selected" </c:if>
                            <c:set var="ruleId" value='${param["9"]}'/>
                            <c:if test='${rule.id eq ruleId}'> selected="selected" </c:if>
                    >${rule.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label class="input-group-addon">Описание события</label>
            <input id="msg" type="text" class="form-control" name="text" value='${param["text"]}'>
        </div>
        <div class="form-group">
            <label class="input-group-addon">Место события</label>
            <input id="msg" type="text" class="form-control" name="address"
                   value='${param["address"]}'>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-dark" name="submit" value="Сохранить">
        </div>
    </form>
</div>
</body>
</html>
