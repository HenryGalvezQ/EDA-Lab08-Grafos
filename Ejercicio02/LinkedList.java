public class LinkedList<T>{
  protected Nodo<T> root;
  //Constructores
  public LinkedList(T data) {
    this.root = new Nodo<T>(data);
  }
  public LinkedList(){
    this.root = null;
  }
  public Nodo<T> getRoot() {
    return this.root;
  }
  public void setRoot(Nodo<T> root) {
    this.root = root;
  }
  // Inserta un nodo al final
  public void insertar(T data)	{
    if (this.root == null)
      this.root = new Nodo<T>(data);
    else {
      Nodo<T> nodoActual = root;
      while(nodoActual.getNextNode() != null)
        nodoActual = nodoActual.getNextNode();
      nodoActual.setNextNode(new Nodo<T>(data));
      }
    }

    public T search(T data){
      Nodo <T> nodoActual = this.root;
      while(nodoActual!= null && !nodoActual.getData().equals(data)){
        nodoActual = nodoActual.getNextNode();
      }
      if(nodoActual != null)
        return nodoActual;
      return null;
    }

    public String toString() {
      String listado = "";
      Nodo <T> nodoActual = root;
      while(nodoActual != null) {
        listado += nodoActual.getData() + "  ";
        nodoActual = nodoActual.getNextNode();
      }
      return listado;
    }
}
