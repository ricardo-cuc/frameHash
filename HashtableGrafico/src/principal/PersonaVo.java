package principal;

public class PersonaVo {
	
	private int Nlugar;
	private String Nit;
	private String nombre;
	private String FechaNacimiento;
	
	public PersonaVo(int Nlugar,String Nit,String nombre,String FechaNacimiento) 
	{
		   
		this.Nlugar=Nlugar;
		this.Nit=Nit;
		this.nombre=nombre;
		this.FechaNacimiento=FechaNacimiento;
	}

	public int getNlugar() {return Nlugar;}
	public void setNlugar(int Nlugar) {this.Nlugar=Nlugar;}
	
	public String getNit() {return Nit;}
	public void setNit(String Nit) {this.Nit=Nit;}
	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre=nombre;}
	
	public String getFechaNacimiento() {return FechaNacimiento;}
	public void setFechaNacimiento(String FechaNacimiento) {this.FechaNacimiento=FechaNacimiento;}
	
	
}
