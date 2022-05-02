package proyecto;

//import java.util.*;
public class principal {
	public static void main (String[] args) {
		Lista lista = new Lista();
		numeroAleatorio numero = new numeroAleatorio();
		int codProd = 20;
		int cantidad=14;
		System.out.println("\n0910-14-8526\n Ricardo Humberto Cuc Salazar\n");
		//crea la lista
		for (int i = 0; i < cantidad; ++i) {
			Producto producto = new Producto("SC-"+codProd+"X","Producto "+i+" ", numero.generarNumeros());	
			lista.insertarFinal(producto);
			int n=i+1;
			System.out.println(""+n+","+lista.obtener(i).getCodigo()+","+lista.obtener(i).getArticulo()+","+lista.obtener(i).getPrecio()+"");
			codProd++;
		}
		//imprime la lista creada
		System.out.println("\nREGISTO CREADO CREADOS");
		if(lista.estaVacio()==false){
			for(int j=0; j < lista.contar();j++){
				int n=j+1;
				System.out.println("|"+n+"|"+lista.obtener(j).getCodigo()+"|"+lista.obtener(j).getArticulo()+"|"+lista.obtener(j).getPrecio()+"|");
			}
		}
		System.out.println("---Eliminar registros---");
		System.out.println("Registro en cualquier posición de la lista que no sea al inicio y al final.");
		lista.eliminarProducto(10);
		System.out.println("Registro al final de la lista.");
		lista.eliminarUltimo();
		System.out.println("El primer registro de la lista..");
		lista.eliminarPrincipio();
		
		System.out.println("---Agregar registros---");
		System.out.println("Al inicio de la lista.");
		Producto productoi = new Producto("SC-"+80+"X","Producto "+50+" ", numero.generarNumeros());
		lista.insertarPricipio(productoi);
		System.out.println("Al final de la lista.");
		Producto productof = new Producto("SC-"+90+"X","Producto "+60+" ", numero.generarNumeros());
		lista.insertarFinal(productof);
		System.out.println("Ecualquier posición de la lista.");
		Producto productod = new Producto("SC-"+100+"X","Producto "+70+" ", numero.generarNumeros());
		lista.insertarDespues(11, productod);
		System.out.println("---Registros actuales---");
		
		if(lista.estaVacio()==false){
			for(int j=0; j < lista.contar();j++){
				int n=j+1;
				if(lista.obtener(j).getCodigo()!=null) {
					System.out.println("|"+n+"|"+lista.obtener(j).getCodigo()+"|"+lista.obtener(j).getArticulo()+"|"+lista.obtener(j).getPrecio()+"|");
				}
			}
		}else {
			System.out.println("no tenemos producto para mostrar");
		}
		
	}
}
