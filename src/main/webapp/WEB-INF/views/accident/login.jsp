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
     <c:if test="${not empty errorMessage}">
         <div style="color:red; font-weight: bold; margin: 30px 0px;">
                 ${errorMessage}
         </div>
     </c:if>
     <form name='login' action="<c:url value='/login'/>" method='POST'>
         <table class="table table-borderless">
             <tr>
                 <td>Имя пользователя:</td>
                 <td><input type='text' name='username'></td>
             </tr>
             <tr>
                 <td>Пароль:</td>
                 <td><input type='password' name='password'/></td>
             </tr>
             <tr>
                 <td colspan='2'><input name="submit" type="submit" value="submit" class="btn btn-dark"/></td>
             </tr>
         </table>
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
     </form>
 </div>

</body>
</html>