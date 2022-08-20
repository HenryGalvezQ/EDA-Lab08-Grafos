public class Nodo<T> {
  private T data;
  private Nodo<T> nextNode = null;

  Nodo(T data){
    this.data = data;
  }

  public void setData(T t) {
    this.data = t;
  }

  public void setNextNode(Nodo<T> next) {
    this.nextNode = next;
  }

  public T getData() {
    return data;
  }

  public Nodo<T> getNextNode() {
    return nextNode;
  }
  public String toString() {
    return data.toString();
  }
}
