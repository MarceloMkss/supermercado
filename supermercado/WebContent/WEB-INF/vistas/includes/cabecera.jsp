<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Sirve para hacer formateados de los numeros -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="es_ES"/>

<!doctype html>
<html lang="es">
<head>
<!-- <base href="/supermercado/" /> importante poner siempre, vale para todos como global-->
<base href="${pageContext.request.contextPath}/" />
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- FontAwesome -->
<link rel="stylesheet" href="css/all.min.css">
<!-- Hoja de estilos personalizada -->
<link rel="stylesheet" href="css/supermercado.css">

<title>Supermercado</title>
</head>
<body>

	<header class="sticky-top">
		<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #096ebe;">
		<div class="logo">
                <img src="img/logo.PNG " width="50" alt="logo Supermercado">
                
            </div>
			<a class="navbar-brand" href="#"> Supermercado</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
				
				<!-- Pagina de inicio -->
					<li class="nav-item active"><a class="nav-link" href="#">Inicio
							<span class="sr-only">(current)</span>
					</a></li>
					
					<!-- Ver un producto -->
					<li class="nav-item active"><a class="nav-link" href="producto-detalle">Lista Producto
							<span class="sr-only">(current)</span>
					</a></li>
					
					<li class="nav-item active"><a class="nav-link" href="usuario-detalle">Lista Usuario
							<span class="sr-only">(current)</span>
					</a></li>
					
					<!-- Dar de alta a un producto -->
					<li class="nav-item active"><a class="nav-link" href="Guardar-Producto">Alta Producto
							<span class="sr-only">(current)</span>
					</a></li>
					
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="login">Login</a>
					</li>
				</ul>

			</div>
		</nav>
	</header>
	<main class="container-fluid pt-3">