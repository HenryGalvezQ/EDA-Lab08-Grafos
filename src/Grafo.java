import java.util.LinkedList;

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
	
	// Atributos de la clase grafo por lista de adyacencia
	private LinkedList<Vertice>[] lista_vertices; // arreglo de listas de adyacencia de vértices
	private Vertice[] vertices;                   // arreglo de vértices
	private int size;                             // número actual de vértices en la lista
	 
	// CONSTRUCTO DEL GRAFO
	public Grafo(int capacidad) {
		lista_vertices = new LinkedList[capacidad];
		vertices = new Vertice[capacidad];
		size = 0;
	 
		// Inicializando el arreglo de listas enlazadas
		for (int i = 0; i< lista_vertices.length; i++) {
			lista_vertices[i] = new LinkedList<Vertice>();
		}
	}
	
}
