<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-user-style.css">	
</head>

<body>
<h1>Registration Successful Please Login</h1>



<form action="LoginRegistrationServlet" method="POST">

    <input type="hidden" name="command" value="AUTHENTICATE" /> 
            
<table>
	<tbody>
	 <tr>
		<td><label>User Name:</label></td>
		<td><input type="text" name="userName" /></td>
	 </tr>
	 
	 <tr>
	 	<td><label>Password:</label></td>
	 	<td><input type="password" name="password" /></td>
	 </tr>
	 
	 <tr>
	 	<td><label></label></td>
	 	<td><input type="submit" value="Login" class="save" /> <td>
	 </tr>

      <tr>
         <td><label>Register?</label></td>
	     <td><input type="button" value="Not Registered?"
                onclick="window.location.href='register.jsp';return false;"
                class="save" /></td>
	 </tr>
	 
	</tbody>


</table>

</form>

</body>

</html>