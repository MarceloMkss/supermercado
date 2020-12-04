package com.ipartek.formacion.supermercado.accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.ipartek.formacion.supermercado.modelos.Producto;

public class ProductoDaoTreeMap implements Dao<Producto> {

	private static TreeMap<Long, Producto> productos = new TreeMap<>();

	static {
		productos.put(1L, new Producto(1L, "Beefeater",
				"es una crema de whisky elaborada a partir de la uni�n de deliciosa nata irlandesa, de licor, de whisky irland�s y esencias naturales de cacao.",
				"img/Baileys.jpg", new BigDecimal("12.95"), 20, "Litro", new BigDecimal("12.95"), 1));
		productos.put(2L, new Producto(2L, "Beefeater light",
				"El licor de Hierbas Jagermeister se elabora con 56 ingredientes naturales. Pasa 383 controles de calidad: El sabor de J�germeister va m�s all� de la suma de sus componentes, creando un sabor �nico y singular que combina matices dulces y amargos. ",
				"img/jagemeilter2.jpg", new BigDecimal("7.90"), null, "Litro", new BigDecimal("18.50"), 1));

		for (Long id = 3L; id <= 12L; id++) {
			productos.put(id,
					new Producto(id, "Producto" + id, "Descripci�n" + id, "http://placeimg.com/640/480/tech?" + id,
							new BigDecimal(11 * id), id.intValue(), "Unidad" + id, new BigDecimal(10 * id),
							id.intValue()));
		}
	}

	// SINGLETON

	// Ponemos privado el constructor por defecto para que nadie pueda crear
	// instancias de esta clase de forma libre
	// Con esto evitamos la posibilidad de que nadie haga new de esta clase (salvo
	// esta clase en s� misma)

	private ProductoDaoTreeMap() {

	}

	private static ProductoDaoTreeMap INSTANCIA = new ProductoDaoTreeMap();

	// Creamos un m�todo p�blico que de acceso a la �nica instancia disponible
	// Desde otras clases deberemos hacer
	// ProductoDaoTreeMap dao = ProductoDaoTreeMap.getInstancia();
	// o mejor
	// Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();
	public static ProductoDaoTreeMap getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON

	@Override
	public Iterable<Producto> listar() {

		return productos.values();
	}

	@Override
	public Producto recuperar(Long id) {

		return productos.get(id);
	}

	@Override
	public void crear(Producto producto) {

		Long id = productos.size() == 0 ? 1L : productos.lastKey() + 1L;
		producto.setId(id);
		productos.put(id, producto);

	}

	@Override
	public void modificar(Producto producto) {

		productos.put(producto.getId(), producto); // usando la variable productos de treeMap, accesamos a la id del
													// producto del modelo "Producto"
	}

	@Override
	public void eliminar(Long id) {
		productos.remove(id);

	}

}
