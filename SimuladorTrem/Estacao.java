package SimuladorTrem;

public class Estacao extends No {
    int id;
    int pessoasSubindo;
    int pessoasDescendo;

    public Estacao(int id) {
        super(false);
        this.id = id;
        this.pessoasSubindo = 0;
        this.pessoasDescendo = 0;
    }
}