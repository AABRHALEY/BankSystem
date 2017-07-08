<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
 <link href="${contextPath}/resources/css/welcome.css" rel="stylesheet">
</head>
<body>

<p align="right"><a href="<spring:url value='/welcome' />" > Logout</a></p>

 <%-- welcome.springmvc : <spring:message code="welcome.springmvc"/> --%>
<!--  --> 
 <a href="?language=en" >English</a>|<a href="?language=zh" >Dutch</a>

<div class="header">
<!-- picture -->
<div class="card" style="width:15%">
  <img src="${contextPath}/resources/images/${user.username}.png" alt="Avatar" style="width:100%"> 
  
  
  
  <div class="container" style="height:0px">
    <h4><b>Welcome ${username}</b></h4> 
 </div>

</div>
  <h1 align="center">ZARA Bank</h1>
<h2 align="center">Customer satisfaction is our motto.</h2>

</div>



<!--  -->
<div class="clearfix">
  <div class="column menu">
    <ul>
    <label for="primary">
      <li id="primary"><h1><a href="${contextPath}/account/primaryAccount">PrimaryAccount</a></h1>
  
  <h2> Balance: $ ${primaryAccount.accountBalance} <br/>
  Account Number: ${primaryAccount.accountNumber}</h2></li></label>
     
      <li><ul><label for="checking">
      <li id="checking"><h1><a href="${contextPath}/account/savingAccount">SavingsAccount</a></h1>
  
  <h2> Balance: $ ${savingAccount.accountBalance}<br/>
  Account Number: ${savingAccount.accountNumber} </h2></li></label></li>
    </ul>
  </div>
  
  
  
  <p class="acc"><a href="${contextPath}/transfer/recipient">Recipient</a></p>

<p class="acc"><a href="${contextPath}/transfer/toSomeoneElse">Transfer to some one else</a></p>
  
 <p class="acc"><a href="${contextPath}/transfer/betweenAccounts">Transfer b/n Accounts</a></p>
 <p class="acc"><a href="${contextPath}/account/withdraw">Withdrawal</a></p>
<p class="acc"><a href="${contextPath}/account/deposit">deposit</a></p>


  <div class="column content">
    <h1>ZARA</h1>
    <p>ZARA Bank is the leading bank in the mid-west. We are dedicated to serving you with quality and perfection.</p>  
    <p>Together we thrive!!!</p>
  </div>
</div>

<div class="footer">
  <p>ZARA Bank the number one rated bank of 2017 by people's magazine!</p>
</div>

</body>
</html>

