<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type ="text/javascript" language="javascript">

	function validate(id, pass1, pass2) {
		var regex = RegExp("^(?:(?=.*?[A-Z])(?:(?=.*?[0-9])(?=.*?[-!@#$%^&*()_[\\]{},.<>+=])|(?=.*?[a-z])(?:(?=.*?[0-9])|(?=.*?[-!@#$%^&*()_[\\]{},.<>+=])))|(?=.*?[a-z])(?=.*?[0-9])(?=.*?[-!@#$%^&*()_[\\]{},.<>+=]))[A-Za-z0-9!@#$%^&*()_[\\]{},.<>+=-]{7,50}$");
		//The above regex checks whether or not a password contains:
		//8 characters, 1 lower case, and 1 uppercase

		var password1 = document.forms[id].elements[pass1].value; //Fetches password1
		var password2 = document.forms[id].elements[pass2].value; //Fetches password 2

		if(password1 != password2) {
			alert("Your passwords do not match.");
			//var password = document.forms[id].elements[pass].focus;
			return false;
		} else if(regex.test(password1) == false) {

			alert("You password doesn't contain at least three of the following: one lowercase, one uppercase, one number, and one special character.");
			//var password = document.forms[id].elements[pass].focus;
			return false;
		}
	};

</script>

	<form id = "registerform" action="LoginRegister" method = "post" onsubmit="javascript:return validate('registerform','password1', 'password2');" >
		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" id = "password1" name="password1"></td>
			</tr>
			<tr>
				<td>Re-Enter Password :</td>
				<td><input type="password" id = "password2" name="password2"></td>
			</tr>
			<tr> 
				<td></td>
				<td><input type="submit" name="submit" value="Register"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>