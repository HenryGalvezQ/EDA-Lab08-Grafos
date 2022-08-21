import java.util.*;
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

    public void agregarVertice(String nombre) {
        int indice = size++;
        vertices[indice] = new Vertice(indice, nombre);
    }

    public void addEdge(int inicio, int fin) {
    	lista_vertices[inicio].add(vertices[fin]); // En la lista de adyacencia agrega la referencia del vértice
    	lista_vertices[fin].add(vertices[inicio]);
    }

    public String toString(){
        String text = "";
        int i = 0;
        for(LinkedList<Vertice>x: lista_vertices){
            if(!x.isEmpty())
                text += vertices[i++] + " : " + x +"\n";
        }
        return text;
    }

    // bfs
    private Queue<Vertice> queue = new LinkedList<Vertice>();
    public String[] bfs() {
        String[] res = new String[size];
        vertices[0].visitado = true;
        int idx = 0;
        res[idx++] = vertices[0].nombre;
        queue.add(vertices[0]);
        while (!queue.isEmpty() ) {
            Vertice vertex = queue.poll();
            int nextIdx = getUnvisitedVertex(vertex.indice);
            while (nextIdx != -1) {
                vertices[nextIdx].visitado = true;
                res[idx++] = vertices[nextIdx].nombre;
                queue.add(vertices[nextIdx]);
                nextIdx = getUnvisitedVertex(vertex.indice);
            }
        }

        // reset vertices
        for (Vertice vertex : vertices) {
            if(vertex != null)
                vertex.visitado = false;
        }

        return res;
    }

    private int getUnvisitedVertex(int index) {
        for (int i = 0; i < lista_vertices[index].size(); i++) {
            if (lista_vertices[index].get(i).visitado == false) {
                return lista_vertices[index].get(i).indice;
            }
        }
        return -1;
    }
}
