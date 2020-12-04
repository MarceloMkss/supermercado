<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	
	<h1>Editar Y Adicionar Producto</h1>

	<i>***Esto envia datos por POST al controlador</i>



	<form method="post" action="Guardar-Producto" class="col-md-6" enctype = "multipart/form-data">



		<div class="form-group">
			<label for="id">Id:</label> <input value="${producto.id}" type="text"
				id="id" name="id" readonly>
		</div>

		<div class="form-group">
			<label for="nombre">Nombre:</label> <input value="${producto.nombre}"
				type="text" autofocus id="nombre" name="nombre"
				placeholder="Nombre del producto" required>
		</div>
		
		<div class="form-group">
			<label for="descripcion">Descripcion:</label> <input value="${producto.descripcion}"
				type="text" autofocus id="descripcion" name="descripcion"
				placeholder="descripcion del producto" required>
		</div>

       

		<div class="form-group" >
			<label for="urlImagen">Foto:</label>
			<input type="file" name ="urlImagen">
			<img src="${producto.urlImagen}" class="card-img-top" alt="" id="urlImagen" name="urlImagen">
		</div>

		<div class="form-group">
			<label for="precio">Precio:</label> <input
				value="${producto.precio}" type="text" id="precio" name="precio"
				placeholder="$" required>
		</div>


		<div class="form-group">
			<label for="descuento">Descuento:</label> <input value="${producto.descuento}"
				type="text" id="descuento" name="descuento" placeholder="descuento del producto"
				required>
		</div>
		
		<div class="form-group">
			<label for="unidadMedida">Unidad Medida:</label> <input value="${producto.unidadMedida}"
				type="text" id="unidadMedida" name="unidadMedida" placeholder="unidad de Medida del producto"
				required>
		</div>
		
		<div class="form-group">
			<label for="precioUnidadMedida">Precio Unidad Medida:</label> <input value="${producto.precioUnidadMedida}"
				type="text" id="precioUnidadMedida" name="precioUnidadMedida" placeholder="precio Unidad Medida del producto"
				required>
		</div>
		
		<div class="form-group">
			<label for="cantidad">Cantidad:</label> <input value="${producto.cantidad}"
				type="text" id="cantidad" name="cantidad" placeholder="cantidad  del producto"
				required>
		</div>
		




		<input type="submit" class="btn btn-outline-primary" value="Guardar Datos">


	</form>


	<jsp:include page="includes/pie.jsp" />


</body>
</html>