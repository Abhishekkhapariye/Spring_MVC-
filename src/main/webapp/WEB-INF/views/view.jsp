<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<center>
		<h2>VIEW EMPLOYEES</h2>
	
	
		<table border="1" cellspacing="5" cellpadding="10">
<form>action="/find" 
<input type="text" name="id" placeholder="Enter id to search">
<button>Find</button>

</form>
	<br/>		<th>ID</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Action</th>	
			
			<c:forEach var="emp" items="${listEmployees}">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.firstName}</td>
					<td>${emp.lastName}</td>
					<td>${emp.email}</td>


					<td><a href="delete?id=${emp.id}">delete ${emp.id}<i class="fas fa-trash text-danger" style="font-size:30px;"></i> </a> | 
					<s:url var="edit" value="/edit">
					<s:param name="id" value="${emp.id}"/>
					</s:url>
					<a	href="edit?id=${emp.id}">Edit ${emp.id}></a></td>

				</tr>
			</c:forEach>
		</table>
		
</body>
</center>
</html>

<!--  <div style="margin-bottom: 5px" class="form-group">
						Button
						<div class="col-sm-12 controls">
							<button id="btn-delete" type="delete" value="id"
								class="btn btn-success">delete</button> 

						 -->

