<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
<h1>Unsuccessful User ID already taken or Values cannot be left blank!</h1>



<form action="LoginRegistrationServlet" method="POST">

    <input type="hidden" name="command" value="REGISTER" /> 
            
<table>
	<tbody>
	
	
	<tr>
		<td><label>First Name:</label></td>
		<td><input type="text" name="firstName" /></td>
	 </tr>
	 
	 <tr>
	 	<td><label>Last Name:</label></td>
	 	<td><input type="text" name="lastName" /></td>
	 </tr>
	
	<tr>
		<td><label>Email:</label></td>
		<td><input type="text" name="email" /></td>
	 </tr>
	
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
	 	<td><input type="submit" value="Register" class="save" /> <td>
	 </tr>

     <tr>
         <td><label>Registered?</label></td>
	     <td><input type="button" value="Registered?"
                onclick="window.location.href='login.jsp';return false;"
                class="save" /></td>
	 </tr>
	 
	</tbody>


</table>

</form>

</body>

</html>