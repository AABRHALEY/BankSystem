<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body>

<h2>All Transactions made with Primary Account</h2>

<table>
  <tr>
  <th>Description</th>
    <th>Date</th>
    <th>Type</th>
    <th>Status</th>
    <th>Amount</th>
    <th>AvailableValance</th>
 
    
  </tr>
  
  <c:forEach items="${primaryTransactionList}" var="user">
        <tr>
        <td><c:out value="${user.description}"/></td>
            <td><c:out value="${user.date}"/></td>
            <td><c:out value="${user.type}"/></td>
            <td><c:out value="${user.status}"/></td>
            <td><c:out value="${user.amount}"/></td>
            <td><c:out value="${user.availableBalance}"/></td>
            
       
              
        </tr>
    </c:forEach>
  
</table>

</body>
</html>

