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
        String[] res = new String[size];//Se almacenara el orden en el que se recorreran los vertices
        vertices[0].visitado = true;//Se toma como visitado el primer vertice
        int idx = 0;
        res[idx++] = vertices[0].nombre;//Se almacena en res el nombre del primer vertice
        queue.add(vertices[0]);//Se almacena en la cola el primer vertice
        while (!queue.isEmpty() ) {
            Vertice vertex = queue.poll();//Se extrae el primer vertice de la cola
            int nextIdx = getUnvisitedVertex(vertex.indice);//se extrae el indice del primer vertice que no sea visitado en la lista de adyacencia
            while (nextIdx != -1) {//El bucle continuara hasta que todos los vertices de la lista de adyacencia sean visitados
                vertices[nextIdx].visitado = true;//Se cambia el estado del vertice no visitado
                res[idx++] = vertices[nextIdx].nombre;//Se almacena el vertice al arrays res
                queue.add(vertices[nextIdx]);//Se agrega el vertice a la cola
                nextIdx = getUnvisitedVertex(vertex.indice);//Se busca el siguiente vertice no visitado de la lista de adyacencia
            }
        }

        // Bucle que devuelve el estado de visitado a false de todos los vertices
        for (Vertice vertex : vertices) {
            if(vertex != null)
                vertex.visitado = false;
        }

        return res;
    }

    private int getUnvisitedVertex(int index) {//Revisara la lista de adyacencia del vertice en la posicion index
        for (int i = 0; i < lista_vertices[index].size(); i++) {
            if (lista_vertices[index].get(i).visitado == false) {//Se busca el primer vertice no visitado en la lista de adyacencia
                return lista_vertices[index].get(i).indice;//Se retorna el indice del primer vertice no visitado
            }
        }
        return -1;//en caso de que todos los vertices sean visitado se retorna -1
    }
}
