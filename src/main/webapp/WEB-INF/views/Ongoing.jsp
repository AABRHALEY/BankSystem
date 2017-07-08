<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Transfer Between Accounts</title>

   <%--  <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"> --%>
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
ZARA BANK
<div id="global">
<form:form modelAttribute="recipient" action="toSomeoneElse" method="post">
    <fieldset>
    
    
    
    
          <p>
            Account Type : <form:select path="accountTypeFrom">
                           <form:option value="" label="Selecet Account Type"/>
                           <form:option value="Primary" label="checking account"/>
                           <form:option value="Saving" label="saving account"/>
                           </form:select>
         </p>     
         
         <p>
            Recipent UserName : <form:input path="userName"/>
            <%-- <form:errors path="username" cssStyle="color : red;"/> --%>
         </p>
          
           <p>
            Account Type : <form:select path="accountTypeTo">
                           <form:option value="" label="Selecet Account Type"/>
                           <form:option value="Primary" label="checking account"/>
                           <form:option value="Saving" label="saving account"/>
                           </form:select>
         </p>                    
         <p>
            Amount : <form:input path="amount"/>
            <%-- <form:errors path="username" cssStyle="color : red;"/> --%>
         </p>
         
         <p>
           Account number : <form:input path="accountNumber"/>
            <%-- <form:errors path="username" cssStyle="color : red;"/> --%>
         </p>
            
            <input id="submit" type="submit" value="Make Transfer"/> 
   
    </fieldset>
</form:form>
</div>
</body>
</html>