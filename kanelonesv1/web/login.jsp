<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link href="<c:url value='/css/bootstrap-theme.min.css'/>"
	rel="stylesheet"></link>
<link href="<c:url value='/css/bootstrap-theme.min.css.map'/>"
	rel="stylesheet"></link>
<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet"></link>
<link href="<c:url value='/css/bootstrap.min.css.map'/>"
	rel="stylesheet"></link>
<link href="<c:url value='/css/font-awesome.min.css'/>" rel="stylesheet"></link>

<script src="<c:url value='/js/jquery-3.1.1.min.js'/>"</script>
<script src="<c:url value='/js/bootstrap.min.js'/>"</script>
</head>

<body>
	<div class="row" style="margin-top: 5%">
		<div style="width:20%;margin-left:40%">
			<div class="panel panel-default">
				<div class="panel-body">
				    <div class="well well-sm" style="margin: 5px 10px 5px 10px;">Ingrese sus credenciales</div>
					<c:url var="loginUrl" value="/login" />
					<form action="${loginUrl}" method="post" class="form-horizontal">
						<c:if test="${param.login_error != null}">
							<div class="alert alert-danger" style="margin: 5px 10px 5px 10px;">
								<p>Nombre de usuario o constraseña invalido</p>
							</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert alert-success">
								<p>You have been logged out successfully.</p>
							</div>
						</c:if>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="username"><i
								class="fa fa-user"></i></label> <input type="text" class="form-control"
								id="username" name="username" placeholder="Nombre de usuario"
								required>
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="password"><i
								class="fa fa-lock"></i></label> <input type="password"
								class="form-control" id="password" name="password"
								placeholder="Contraseña" required>
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

						<div class="input-sm">
							<button type="submit"
								class="btn btn-block btn-primary btn-default">Iniciar sesión</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>