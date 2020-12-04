package com.ipartek.formacion.supermercado.accesodatos;

public interface Dao<P> { // T = tipo de dato

	Iterable<P> listar();

	P recuperar(Long id);

	void crear(P objeto);

	void modificar(P objeto);

	void eliminar(Long id);
	
}
