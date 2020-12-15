package com.ipartek.formacion.supermercado.accesodatos;

public interface Dao<P> { // P = tipo de dato

	Iterable<P> listar();

	P  obtenerPorId(Long id);

	void crear(P objeto);

	void modificar(P objeto);

	void eliminar(Long id);
	
}
