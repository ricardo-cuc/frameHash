package ConfiguracionHash;


public class Persona {
	int id;
	private String codigo;
	private String nombre;
	private int edad;
	public Persona next;
	public Persona(int id, int edad, String nombre, String codigo ) {
		this.id=id;
		this.codigo=codigo;
		this.nombre=nombre;
		this.edad=edad;
		
	}
	public int getid() {return id;}
	public void setid(int id) {this.id=id;}
	public String getcodigo() {return codigo;}
	public void setcodigo(String codigo) {this.codigo=codigo;}
	public String getnombre() {return nombre;}
	public void setnombre(String nombre) {this.nombre=nombre;}
	public int getedad() {return edad;}
	public void setedad(int edad) {this.edad=edad;}
    @Override
    public String toString() {
        return "Persona{" + "id=" + id +", codigo='" +"FX-" + codigo +"Y'" +", nombre='" +nombre+", edad='"+edad+'\'' +'}';
    }
}
