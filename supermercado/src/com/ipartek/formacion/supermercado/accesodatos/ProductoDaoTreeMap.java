package com.ipartek.formacion.supermercado.accesodatos;

import java.math.BigDecimal;

import java.util.TreeMap;

import org.apache.commons.lang3.SerializationUtils;


import com.ipartek.formacion.supermercado.modelos.Producto;

public class ProductoDaoTreeMap implements Dao<Producto> {

	
	// me trae todo los datos ordenados por id
	private static TreeMap<Long, Producto> productos = new TreeMap<>();

	static {
		productos.put(1L, new Producto(1L, "Baileys",
				"es una crema de whisky elaborada a partir de la unión de deliciosa nata irlandesa, de licor, de whisky irlandés y esencias naturales de cacao.",
				"img/Baileys.jpg", new BigDecimal("12.95"), 20, "Litro", new BigDecimal("12.95"), 1,new BigDecimal("0")));
		
		productos.put(2L, new Producto(2L, "jagemeilter",
				"El licor de Hierbas Jagermeister se elabora con 56 ingredientes naturales.creando un sabor único y singular que combina matices dulces y amargos.",
				"img/jagemeilter2.jpg", new BigDecimal("7.90"), null, "Litro", new BigDecimal("18.50"), 1,new BigDecimal("0")));

		
		productos.put(3L, new Producto(3L, "Captain Morgan",
				"El licor de Hierbas Jagermeister se elabora con 56 ingredientes naturales.creando un sabor único y singular que combina matices dulces y amargos.",
				"img/Captain Morgan.jpg", new BigDecimal("10.90"), 5, "Litro", new BigDecimal("18.50"), 1,new BigDecimal("0")));
		
		productos.put(4L, new Producto(4L, "Absolut",
				"El licor de Hierbas Jagermeister se elabora con 56 ingredientes naturales.creando un sabor único y singular que combina matices dulces y amargos.",
				"img/Absolut1.jpg", new BigDecimal("11.80"), 3, "Litro", new BigDecimal("18.50"), 1,new BigDecimal("0")));
		
		productos.put(5L, new Producto(5L, "Jack Daniels",
				"El licor de Hierbas Jagermeister se elabora con 56 ingredientes naturales.creando un sabor único y singular que combina matices dulces y amargos.",
				"img/Jack Daniels.jpg", new BigDecimal("7.90"), null, "Litro", new BigDecimal("18.50"), 1,new BigDecimal("0")));
		
		productos.put(6L, new Producto(6L, "Jinro",
				"El licor de Hierbas Jagermeister se elabora con 56 ingredientes naturales.creando un sabor único y singular que combina matices dulces y amargos.",
				"img/Jinro.jpg", new BigDecimal("9.59"), null, "Litro", new BigDecimal("18.50"), 1,new BigDecimal("0")));
		
		productos.put(7L, new Producto(7L, "Johnnie Walkie",
				"El licor de Hierbas Jagermeister se elabora con 56 ingredientes naturales.creando un sabor único y singular que combina matices dulces y amargos.",
				"img/Johnnie Walke.jpg", new BigDecimal("9.56"), 10, "Litro", new BigDecimal("17.50"), 1,new BigDecimal("0")));
		
		productos.put(8L, new Producto(8L, "Khlibniy.PNG",
				"El licor de Hierbas Jagermeister se elabora con 56 ingredientes naturales.creando un sabor único y singular que combina matices dulces y amargos.",
				"img/Khlibniy.PNG", new BigDecimal("7.90"), null, "Litro", new BigDecimal("18.50"), 1,new BigDecimal("0")));
		
		productos.put(9L, new Producto(9L, "McDowell ‘s",
				"El licor de Hierbas Jagermeister se elabora con 56 ingredientes naturales.creando un sabor único y singular que combina matices dulces y amargos.",
				"img/McDowell ‘s.jpg", new BigDecimal("7.90"), 8, "Litro", new BigDecimal("18.50"), 1,new BigDecimal("0")));
		
		productos.put(10L, new Producto(10L, "Pirassunga 51.jpg",
				"El licor de Hierbas Jagermeister se elabora con 56 ingredientes naturales.creando un sabor único y singular que combina matices dulces y amargos.",
				"img/Pirassunga 51.jpg", new BigDecimal("7.90"), null, "Litro", new BigDecimal("18.50"), 1,new BigDecimal("0")));
		
		productos.put(11L, new Producto(11L, "Red Star Er Guo",
				"El licor de Hierbas Jagermeister se elabora con 56 ingredientes naturales.creando un sabor único y singular que combina matices dulces y amargos.",
				"img/Red Star Er Guo.PNG", new BigDecimal("7.90"), null, "Litro", new BigDecimal("18.50"), 1,new BigDecimal("0")));
		
				
		productos.put(12L, new Producto(12L, "Smirnoff",
				"El licor de Hierbas Jagermeister se elabora con 56 ingredientes naturales.creando un sabor único y singular que combina matices dulces y amargos.",
				"img/Smirnoff.jpg", new BigDecimal("7.90"), null, "Litro", new BigDecimal("18.50"), 1,new BigDecimal("0")));
		
	
	}

	// SINGLETON

	// Ponemos privado el constructor por defecto para que nadie pueda crear
	// instancias de esta clase de forma libre
	// Con esto evitamos la posibilidad de que nadie haga new de esta clase (salvo
	// esta clase en sí misma)

	private ProductoDaoTreeMap() {

	}

	private static ProductoDaoTreeMap INSTANCIA = new ProductoDaoTreeMap();

	// Creamos un método público que de acceso a la única instancia disponible
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
	public Producto obtenerPorId(Long id) {
		return SerializationUtils.clone(productos.get(id));
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
