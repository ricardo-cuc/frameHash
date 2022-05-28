package ConfiguracionHash;

public class PersonasLinkList {
	    // encabezado de la lista de enlaces
	    private Persona head;

	    // agregar
	    public void add(Persona persona) {
	        if (head == null) {
	            head = persona;
	          
	            return;
	        }else {
	        	System.out.print("*");
	        }
	        Persona tPersona = head;
	        while (tPersona.next != null) {
	            // hacia atrás
	            tPersona = tPersona.next;
	            
	        }
	        tPersona.next = persona;
	    }
	    
	    // eliminar
	    public void deletePersonaById(int id) {
	        if (head == null) {
	            return;
	        }
	        Persona tPersona = head;

	        while (true) {
	            if (tPersona.id == id) {
	                // eliminar
	                head = tPersona.next;
	                break;
	            }

	            if (tPersona.next == null) {
	                break;
	            }

	            if (tPersona.next.id == id) {
	                // Eliminar el nodo Persona
	                tPersona.next = tPersona.next.next;
	                break;
	            }

	            // hacia atrás
	            tPersona = tPersona.next;
	        }
	    }

	    // Encuentra
	    public Persona findPersonaById(int id) {
	        if (head == null) {
	            return null;
	        }
	        Persona tPersona = head;
	        while (true) {
	            if (tPersona.id== id) {
	                break;
	            }
	            if (tPersona.next == null) {
	                tPersona = null;
	                break;
	            }
	            // hacia atrás
	            tPersona = tPersona.next;
	        }
	        return tPersona;
	    }

	    // Colicion
	    public void list(int no) {
	    	 Persona tPersona = head;
	        if (head == null) {
	            System.out.println("Indice " + (no) + " vacía");
	            return;
	        }else {
	        	System.out.println("Coliciones indice " + (no + 1)+" Con indice "+tPersona.id );	
	        }
	        
	       
	        while (true) {
	            System.out.println(tPersona + " --> ");
	            if (tPersona.next == null) {
	                break;
	            }
	            // hacia atrás
	            tPersona = tPersona.next;
	        }
	        System.out.println();
	    }

}