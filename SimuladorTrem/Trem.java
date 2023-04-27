package SimuladorTrem;

public class Trem {
    int id;
    String direcao;
    int pessoas;
    int velocidade;
    int posicao;

    public Trem(int id, String direcao, int pessoas) {
        this.id = id;
        this.direcao = direcao;
        this.pessoas = pessoas;
        this.velocidade = 60;
        this.posicao = 0;
    }
}