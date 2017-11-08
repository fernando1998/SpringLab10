<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Delete Department</title>
</head>
<body>

<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-6">
				<h4 class="text-center">Delete Department</h4>
				<hr>
				<form:form method="post" action="../Depdelete">
					<form:hidden path="departmentId" />
					<div class="form-group">
						<label for="login">Name: </label>
						<form:input path="name" class="form-control" readonly="true" />
					</div>
					<div class="form-group">
						<label for="password">Description: </label>
						<form:input path="description" class="form-control" readonly="true" />
					</div>
					<div class="form-group">
						<label for="firstname">City: </label>
						<form:input path="city" class="form-control" readonly="true" />
					</div>
					
					<div class="form-group">
						<input type="submit" value="Delete" class="btn btn-success" />
						<a href="<%=request.getContextPath()%>/admin/dpto/Deplist" class="btn btn-danger">Cancel</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>


</body>
</html>