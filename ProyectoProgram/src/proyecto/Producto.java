package proyecto;

public class Producto {
	private String codigo;
	private String articulo;
	private float precio;

	public Producto(String codigo, String articulo, float precio ) {
		this.codigo=codigo;
		this.articulo=articulo;
		this.precio=precio;
	}
	public String getCodigo() {return codigo;}
	public void setCodigo(String codigo) {this.codigo=codigo;}
	public String getArticulo() {return articulo;}
	public void setArticulo(String producto) {this.articulo=producto;}
	public float getPrecio() {return precio;}
	public void setPrecio(float precio) {this.precio=precio;}
}
