
public class Grafo {
	// Clase de representación de un vértice
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
