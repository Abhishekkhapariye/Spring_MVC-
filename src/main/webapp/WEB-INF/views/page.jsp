<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<center>
		<h2>Employee Detail: ${em.id }</h2>
	
	<table border="1" cellspacing="5" cellpadding="10">

			<th>ID</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			
			
			
				<tr>
					<td>${em.id}</td>
					<td>${em.firstName}</td>
					<td>${em.lastName}</td>
					<td>${em.email}</td>

			</tr>
			
		
			
					</table>
					</center>
					</body>
					</html>