<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

${produto}

<h1>Listado de Productos</h1>




<!-- tabla 2-->

<div class="table-responsive">
        <table class="table table-striped table-bordered table-hover table-sm">
            <!--  <caption>Listado de Productos</caption> -->
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Descripcion</th>
                    <th scope="col">Image</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Descuento</th>
                    <th scope="col">Unidad Medida</th>
                    <th scope="col">Precio Unidad Medida</th>
                    <th scope="col">Cantidad</th>
                    
                    <th scope="col">Opciones</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${productos}" var="producto">
                <tr>
                    <th scope="row">${producto.id}</th>
                    <td>${producto.nombre}</td>
                    <td>${producto.descripcion}</td>
                    <td>${producto.urlImagen}</td>	
                    <td>${producto.precio}</td>	
                    <td>${producto.descuento}</td>	
                    <td>${producto.unidadMedida}</td>	
                    <td>${producto.precioUnidadMedida}</td>	
                    <td>${producto.cantidad}</td>	
                    
                    <td>
                        <div class="btn-group" role="group" aria-label="Opciones">
                            <a class="btn btn-primary btn-sm" href="cliente.html">Editar</a>
                            <a class="btn btn-danger btn-sm" href="cliente.html">Borrar</a>
                        </div>
                    </td>
                </tr>
                
            </c:forEach>
               
                
                
            </tbody>
        </table>
    </div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>