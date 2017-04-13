<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Hi %UserName%! Be free to write anythink ;)</h3>
	<table>
		<tr>
			<th>From:</th>
			<th>Message</th>
		</tr>
		<tr>
			<td>Yarik:</td>
			<td>Hello!</td>
		</tr>
		<tr>
			<td>Vasil:</td>
			<td>hi there!</td>
		</tr>
	</table>
	<form>
		<input type="text" name="msg"/>
		<button type="submit">Send</button>
	</form>
	
</body>
</html>