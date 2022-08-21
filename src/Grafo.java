import java.util.LinkedList;

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
	
	// Atributos de la clase grafo por lista de adyacencia
	private LinkedList<Vertice>[] lista_vertices; // arreglo de listas de adyacencia de v�rtices
	private Vertice[] vertices;                   // arreglo de v�rtices
	private int size;                             // n�mero actual de v�rtices en la lista
	 
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
	
    public void agregarVertice(String nombre) {
        int indice = size++;
        vertices[indice] = new Vertice(indice, nombre);
    }
 
    public void addEdge(int inicio, int fin) {
    	lista_vertices[inicio].add(vertices[fin]); // En la lista de adyacencia agrega la referencia del v�rtice
    	lista_vertices[fin].add(vertices[inicio]);
    }
}
