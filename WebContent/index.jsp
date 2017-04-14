<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="index.jsp">Home</a> 
			<c:if test="${sessionScope.login != null }">
				<li><a href="logout">LogOut</a>
			</c:if>
		</ul>
	</nav>
	<h3>This is your area of comfort!</h3>
		<p>
			<c:out value='${sessionScope.login}' />
		</p>
	<p>asd</p>
	<form method="post" action="/auth">
		<input type="text" name="login" /> <input type="password" name="pass" />
		<button type="submit">Login</button>
	</form>
	<a href="reg.jsp">Registration</a>
</body>
<footer>
	<p>YT &copy; 2017</p>
</footer>
</html>