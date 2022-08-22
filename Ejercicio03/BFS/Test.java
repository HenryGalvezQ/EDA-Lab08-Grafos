public class Test {
  public static void main(String [] args){
    Grafo x = new Grafo(10);
    x.agregarVertice("A");
    x.agregarVertice("B");
    x.agregarVertice("C");
    x.agregarVertice("D");
    x.agregarVertice("E");

    x.addEdge(0, 4);
    x.addEdge(0, 3);
    x.addEdge(1, 0);
    x.addEdge(1, 3);
    x.addEdge(3, 2);
    x.addEdge(3, 4);

    System.out.println(x);

    String [] a = x.bfs();
    for(String y : a)
        System.out.print(y + ", ");

    System.out.println();
  }
}
