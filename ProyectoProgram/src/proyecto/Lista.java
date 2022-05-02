package proyecto;

public class Lista {
	private Nodo cabeza;
	private int numero=0;
	
	private class Nodo{
		private Producto producto;
		public Nodo siguiente = null;
		
		public Nodo (Producto producto) {
			this.producto=producto;
		}
	}
	public void insertarPricipio(Producto producto) {
		Nodo nodo = new Nodo(producto);
		nodo.siguiente=cabeza;
		cabeza=nodo;
		numero++;
	}
	public void insertarFinal(Producto producto) {
		Nodo nodo = new Nodo(producto);
		if(cabeza == null) {
			cabeza = nodo;
		}else {
			Nodo puntero = cabeza;
			while(puntero.siguiente != null) {
				puntero = puntero.siguiente;
			}
			puntero.siguiente=nodo;
		}
		numero++;
		System.out.println("Registro "+numero+" Creado");
	}
	
	public void insertarDespues(int n, Producto producto) {
		Nodo nodo = new Nodo(producto);
		if(cabeza == null) {
			cabeza = nodo;
		}else {
			int contador = 0;
			Nodo puntero = cabeza;
			while(contador <n && puntero.siguiente != null) {
				puntero = puntero.siguiente;
				contador ++;
			}
			nodo.siguiente = puntero.siguiente;
			puntero.siguiente = nodo;
		}
		numero++;
	}
	
	public Producto obtener(int n) {
		if(cabeza == null) {
			return null;
		}else {
			Nodo puntero = cabeza;
			int contador=0;
			while(contador <n && puntero.siguiente != null) {
				puntero = puntero.siguiente;
				contador ++;
			}
			if(contador!=n) {
				return null;
			}else {
				return puntero.producto;
			}
		}
	}
	public int contar() {
		return numero;
	}
	//funcion para verificar si tenemos algo ingresado en la lista
	public boolean estaVacio() {
		return cabeza==null;
	}
	
	public void eliminarPrincipio() {
		if(cabeza != null) {
		Nodo primer = cabeza;
		cabeza = cabeza.siguiente;
		primer.siguiente = null;
		numero--;
		}
	}
	//elimina ultimo elimento
	public void eliminarUltimo() {
		if (cabeza !=null) {
			if(cabeza.siguiente == null) {
				cabeza=null;
			}
			Nodo puntero = cabeza;
			while (puntero.siguiente.siguiente != null) {
				puntero = puntero.siguiente;
			}
			puntero.siguiente = null;
		}
	}
	//para eliminar un elemento de la lista que queramos
	public void eliminarProducto(int n) {
		if(cabeza != null) {
			if(n==0) {
				Nodo primer=cabeza;
				cabeza = cabeza.siguiente;
				primer.siguiente = null;
				numero--;
			}else if (n<numero){
			Nodo puntero = cabeza;
			int contador = 0;
			while (contador<(n-1)) {
				puntero = puntero.siguiente;
				contador++;
			}
			Nodo temp = puntero.siguiente;
			puntero.siguiente = temp.siguiente;
			temp.siguiente = null;
			numero--;
			}
		}
	}
}
