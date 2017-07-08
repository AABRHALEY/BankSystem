<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type"content="text/htmlcharset=ISO-8859-1">

<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger"> Your balance is insufficient Mr!!! ${Notransaction}</h1>
			</div>
		</div>
	</section>
	<section>
		<div>
			<p>${url}</p>
			<p>${exception}</p>
		</div>
		<div >
			
		</div>
	</section>
</body>
</html>