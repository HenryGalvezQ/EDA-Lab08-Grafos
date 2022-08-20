import java.util.*;
public class Grafo {
  ArrayList <Vertice> listaAdyacencia;

  public Grafo(){
    listaAdyacencia = new ArrayList<Vertice>();
  }

  public LinkedList<Arista> verticesAdyacentes(String v){
    for(Vertice x : listaAdyacencia){
      if(x.nomVertice().equals(v))
      return x.adyacente;
    }
    return null;
  }

  public void nuevoVertice (String nombre){
    if(verticesAdyacentes(nombre)!=null)
      System.out.println("Ese vertice ya existe");
    else{
      Vertice v = new Vertice(nombre);
      listaAdyacencia.add(v);
    }
  }
  public boolean sonAdyacentes(String a, String b){
    LinkedList<Arista> temp = verticesAdyacentes(a);
    if(temp.search(new Arista(new Vertice(b)))!=null)
      return true;
    return false;
  }

  public void nuevaArista(String a, String b){
    this.nuevaArista(a,b,0);
  }

  public void nuevaArista(String a, String b, double peso){
    LinkedList<Arista> temp = verticesAdyacentes(a);
    Vertice aux = null;
    for(Vertice x : listaAdyacencia){
      if (x.nomVertice().equals(b)){
        aux = x;
        break;
      }
    }
    if(aux!=null)
      temp.insertar(new Arista(aux,peso));
  }

  public String toString(){
    String line = "";
    for(Vertice x : listaAdyacencia){
      line += x + "\n";
    }
    return line;
  }

  public static void main (String [] args){
    Grafo nuevo = new Grafo();
    nuevo.nuevoVertice("A");
    nuevo.nuevoVertice("B");
    nuevo.nuevoVertice("C");
    nuevo.nuevoVertice("D");
    nuevo.nuevaArista("A", "C", 5);
    nuevo.nuevaArista("A", "D", 10);
    nuevo.nuevaArista("B", "C", 7);
    nuevo.nuevaArista("D", "C");
    nuevo.nuevaArista("A", "D");
    nuevo.nuevaArista("D", "A");
    System.out.println(nuevo);
  }
}
