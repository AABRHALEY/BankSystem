 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<link href="${contextPath}/resources/css/login.css" rel="stylesheet">
<body>


<h3>Welcome To Zara Bank</h3>

<h4>Login</h4>
<div align="center">
  <form action="<spring:url value="/postLogin1"></spring:url>" method="post">
    <label for="username">UserName</label>
    <input type="text" id="fname" name="username" placeholder="UserName" style=" width:200px"><br/>

    <label for="Passwor">Password</label>
    <input type="password" id="password" name="password" placeholder="Password" style="width:200px"><br/>

    
  
    <input type="submit" value="Submit" style=" width:300px">
    <p><a href="${contextPath}/registration">Create an account</a></p>
  </form>
</div>

</body>
</html>


