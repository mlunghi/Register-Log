<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<form id = "loginform" action="LoginRegister" method="post">

		<table>
			<tr>
			
			<td> <h3 style=" color: red;">${message}</h3>
				 <h3 style=" color: green;">${message2}</h3>
			    </td>
				
			<td></td>
			
			</tr>
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="submit" value="Login"></td>
				<td><a href="register.jsp">Registration</a></td>
			</tr>
		</table>

	</form>

</body>
</html>