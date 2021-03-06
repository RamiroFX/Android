package py.com.misgruposv05.utils;

public enum RequestCode {
	ITEM_EDITAR_TARJETA(1, "Editar tarjeta del menu de MostrarTarjetaActivity"),
	ACT_LANZADA_CREAR_GRUPO(2, "Actividad lanzada Crear Grupo");
	
	private int codigo;	
	private String descripcion;
	
	RequestCode(int codigo, String descripcion){
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
