<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<h1>Listado de Productos</h1>


<!-- Recupero todo los usuario -->
${usuario}


<!-- tabla 2-->



<div class="table-responsive">
        <table class="table table-striped table-bordered table-hover table-sm">
            <!--  <caption>Listado de Productos</caption> -->
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Email</th>
                    <th scope="col">Password</th>                                       
                    <th scope="col">Opciones</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${usuario}" var="usuario">
                <tr>
                    <th scope="row">${usuario.id}</th>
                    <td>${usuario.email}</td>
                    <td>${usuario.password}</td>
                    	                    
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


<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>