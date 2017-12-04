<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring Edit-Role</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-6">
				<h4 class="text-center">Edit Only Role</h4>
				<hr>
				<form:form method="post" action="../editsaverole">
					<form:hidden path="employeeId" />
					<div class="form-group">
						<label for="login">Login: </label>
						<form:input path="login" class="form-control" readonly="true" />
					</div>
					<div class="form-group">
						<label for="password">Password: </label>
						<form:input path="password" class="form-control" readonly="true" />
					</div>
					<div class="form-group">
						<label for="firstname">Firstname: </label>
						<form:input path="firstname" class="form-control" readonly="true" />
					</div>
					<div class="form-group">
						<label for="lastname">Lastname: </label>
						<form:input path="lastname" class="form-control"  readonly="true"/>
					</div>
					<div class="form-group">
						<label for="salary">Salary: </label>
						<form:input path="salary" class="form-control"  readonly="true"/>
					</div>
					
					<div class="form-group">
						<label for="salary">Role: </label>
						<form:input path="role.roleId" class="form-control"/>
					</div>
					
					<div class="form-group">
						<input type="submit" value="Save" class="btn btn-success" />
						<a href="<%=request.getContextPath()%>/admin/emp/list" class="btn btn-danger">Cancel</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>


</body>
</html>
