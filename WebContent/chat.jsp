<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Hi <c:out value="${login}"/> Be free to write anythink ;)</h3>
	<table>
		<tr>
			<th>From:</th>
			<th>Message</th>
		</tr>
		<c:forEach var="msg" items="${mList}">
		<tr>
			<td><c:out value="${msg.text}"/></td>
			<td><c:out value="${msg.userId}"/></td>
		</tr>
		</c:forEach>
	</table>
	<form method="post" action="">
		<input type="text" name="msg"/>
		<button type="submit">Send</button>
	</form>
	
</body>
</html>