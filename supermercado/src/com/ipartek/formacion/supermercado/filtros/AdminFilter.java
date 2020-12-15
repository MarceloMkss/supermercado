package com.ipartek.formacion.supermercado.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.modelos.Usuario;

/**
 * Filtro de administración para usuarios logueados 
 */
@WebFilter("/admin/*")
public class AdminFilter implements Filter {

   
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// llamamos la classe HTTP y creamos una variable llama (req = de request) para tener acceso a la sesion getsesion
		HttpServletRequest req = (HttpServletRequest)request;
		
		// llamamos la classe HTTP y creamos una variable llama (res = de response) 
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		
		// obejecto Usuario de la clase Usuario de la capa modelo, luego le pasamos el atributo a la variable usuario
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		
		// si usuario es igual a nulo, o sea que no hay usuario, nos mandara ingresar el login de usuario por sendRedirect
		if(usuario == null) {
			res.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		
		// Nos envía a donde hubiéramos ido sin filtro
		chain.doFilter(request, response);
	}

	
	
}
