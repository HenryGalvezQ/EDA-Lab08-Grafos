public class Arista {
    Vertice destino;
    double peso;
    public Arista(Vertice d){
        destino = d;
    }
    public Arista(Vertice d, double p){
        this(d);
        peso = p;
    }
    public boolean equals(Arista b){
        return this.getDestino().nomVertice().equals(b.getDestino().nomVertice());
    }
    public Vertice getDestino(){
        return destino;
    }
    public String toString(){
        return "(" + destino.nomVertice() + " ; " + peso + ")";
    }
}
