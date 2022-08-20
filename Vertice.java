public class Vertice {
  String nombre;
  LinkedList<Arista>adyacente;
  public Vertice(String name){
    nombre = name;
    adyacente = new LinkedList();
  }
  public String nomVertice(){
    return nombre;
  }
  public String toString(){
    return nombre + " : " +adyacente;
  }
}
