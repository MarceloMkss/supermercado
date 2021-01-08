package com.ipartek.formacion.supermercado.accesodatos;


import java.util.TreeMap;


import com.ipartek.formacion.supermercado.modelos.Usuario;



public class UsuarioDaoTreeMap implements Dao<Usuario> {

	private static TreeMap<Long, Usuario> usuarios = new TreeMap<>();

	static {
		usuarios.put(1L, new Usuario(1L,"marcelo@gmail.com","123456"));
		usuarios.put(2L,new Usuario(2L,"marcio@gmail.com","654321"));

	}

	// SINGLETON

	// Ponemos privado el constructor por defecto para que nadie pueda crear
	// instancias de esta clase de forma libre
	// Con esto evitamos la posibilidad de que nadie haga new de esta clase (salvo
	// esta clase en s� misma)

	private UsuarioDaoTreeMap() {

		
	}

	private static UsuarioDaoTreeMap INSTANCIA = new UsuarioDaoTreeMap();

	// Creamos un m�todo p�blico que de acceso a la �nica instancia disponible
	// Desde otras clases deberemos hacer
	// ProductoDaoTreeMap dao = ProductoDaoTreeMap.getInstancia();
	// o mejor
	// Dao<Producto> dao = ProductoDaoTreeMap.getInstancia();
	public static UsuarioDaoTreeMap getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON
	
	@Override
	public Iterable<Usuario> listar() {
		
		return usuarios.values();
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		
		return usuarios.get(id);
	}

	@Override
	public void crear(Usuario usuario) {
		
		Long id = usuarios.size() == 0 ? 1L : usuarios.lastKey() + 1L;
		usuario.setId(id);
		usuarios.put(id, usuario);
		
	}

	@Override
	public void modificar(Usuario usuario) {
		usuarios.put(usuario.getId(), usuario);
		
	}

	@Override
	public void eliminar(Long id) {
		
		usuarios.remove(id);

	
	}
	
	// Método específico de este DAO creado por nosotros aqui
	
		public Usuario obtenerPorEmail(String email) {
			for(Usuario usuario: usuarios.values()) {
				if(usuario.getEmail().equals(email)) {
					return usuario;
				}
			}
			
			return null;
		}

		
	

}
