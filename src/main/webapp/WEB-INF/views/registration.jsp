<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<link href="${contextPath}/resources/css/login.css" rel="stylesheet">
<body>

<h3>Registration Page</h3>

<div align="center">
<form:errors path="*" cssStyle="color:red"/>
  <form:form action="registration"  method="POST" modelAttribute="userForm" class="form-signin" enctype="multipart/form-data">
    <label for="firstName">First Name:</label>
    <form:input type="text" path="firstName" placeholder="firstName" autofocus="true" cssStyle="width:200px" />
    <form:errors path="firstName" cssStyle="color:red" /><br/>
   
    <label for="lastName">Last Name:</label>
    <form:input type="text" path="lastName" placeholder="lastName" autofocus="true" cssStyle="width:200px" />
    <form:errors path="lastName" cssStyle="color:red" /><br/>
    
    
    <label for="username">UserName:</label>
    <form:input type="text" path="username" placeholder="Username" autofocus="true" cssStyle="width:200px" />
    <form:errors path="username" cssStyle="color:red" /><br/>
     
    <label for="Passwor ">Password:</label>
     <form:input type="password" path="password"  placeholder="Password" cssStyle="width:200px"/>
     <form:errors path="password" cssStyle="color:red"/><br/>
    
<label for="email">Email :</label>
    <form:input type="text" path="email" placeholder="email" autofocus="true" cssStyle="width:200px" />
    <form:errors path="email" cssStyle="color:red" /><br/>
    
    <label for="userImage">User Image:</label>
    <form:input type="file" path="userImage" placeholder="userImage" autofocus="true" cssStyle="width:200px" />
    <form:errors path="userImage" cssStyle="color:red" /><br/>
    
  
    <input type="submit" value="Create" cssStyle="width:250px"/>
 
  </form:form>
</div>

</body>
</html>
