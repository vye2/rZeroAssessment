<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<meta charset="ISO-8859-1">
<title>Victor Ye - rZeroAssessment</title>
</head>
<body>

	<div>
		<table>
			<tr>
				<th>UserID</th>
				<th>UserName</th>			
			</tr>
			<tr>
				<td>test</td>
				<td>test</td>
			</tr>
		</table>	
	</div>
	
	<form action="addUser">
		<h2>ID</h2>
		<input type="text" name="id"></input>
		<h2>Name</h2>
		<input type="text" name="name"></input>
		<br>
		<input type="submit">
	</form>
	
</body>
</html>