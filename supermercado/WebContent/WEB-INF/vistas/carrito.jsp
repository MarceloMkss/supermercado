<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1>Carrito de la compra</h1>
<!-- ${carrito} -->
<div class="contenedor-carrito">

	<table class="table">

		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Cantidad</th>
				<th>Total</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${carrito}" var="producto">
				<tr class="">
					<th>${producto.value.id}</th>
					<th>${producto.value.nombre}</th>
					<th><fmt:formatNumber type="currency"
							value="${producto.value.precioConDescuento}" /></th>
					<th>${producto.value.cantidad}</th>
					<th><fmt:formatNumber type="currency"
							value="${producto.value.total}" /></th>
					<!-- ${producto} -->
				</tr>
			</c:forEach>
		</tbody>

		<tfoot>

			<tr>

				<td colspan=4 style="font-weight: bold;">Total a Pagar:</td>
				<th><fmt:formatNumber type="currency" value="${totalCompra}" /></th>


			</tr>

		</tfoot>

	</table>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>