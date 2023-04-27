package SimuladorTrem;

public class No {
    boolean desvio;
    Trem trem;
    No proximo;
    
    public No(boolean desvio) {
        this.desvio = desvio;
        this.trem = null;
        this.proximo = null;
    }
}