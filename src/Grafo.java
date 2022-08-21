
public class Grafo {
	// Clase de representaci�n de un v�rtice
	public class Vertice {
		public int indice;
	    public String nombre;
	    public boolean visitado;
	 
	    public Vertice(int indice, String nombre) {
	        this.indice = indice;
	        this.nombre = nombre;
	        this.visitado = false;
	    }
	 
	    public String toString() {
	        return nombre;
	    }
	}
	
}
