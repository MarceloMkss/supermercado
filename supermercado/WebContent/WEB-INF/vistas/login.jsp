<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>


<div class="container-fluido">


<div class="contenedor-login">


<h1>Login Usuario</h1>

	<form action="login" method="post">
		<div class="form-group row">
			<label for="email" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="email" name="email">
			</div>
		</div>


		<div class="form-group row">
			<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password"
					name="password">
			</div>
		</div>


		<div class="form-group row">
			<div class="offset-sm-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Iniciar
					sesión</button>
			</div>
		</div>
	</form>
	</div>

</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>