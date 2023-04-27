package SimuladorTrem;

public class TesteSimulador {
    public static void main(String[] args) {
        Simulador simulador = new Simulador();

        testNumeroDeEstacoes(simulador);
        testNosEDesvios(simulador);
        testGetNo(simulador);

        System.out.println("Todos os testes passaram!");
    }

    public static void testNumeroDeEstacoes(Simulador simulador) {
        int numeroDeEstacoes = 0;
        No noAtual = simulador.inicio;

        while (noAtual != null) {
            if (noAtual instanceof Estacao) {
                numeroDeEstacoes++;
            }
            noAtual = noAtual.proximo;
        }

        if (!(numeroDeEstacoes >= 10 && numeroDeEstacoes <= 30)) {
            throw new RuntimeException("Teste de número de estações falhou");
        }
    }

    public static void testNosEDesvios(Simulador simulador) {
        int noCounter = 0;
        int desvioCounter = 0;
        No noAtual = simulador.inicio;

        while (noAtual != null) {
            if (noAtual instanceof Estacao) {
                noCounter = 0;
            } else if (noAtual.desvio) {
                desvioCounter++;
                if (noCounter != 19) {
                    throw new RuntimeException("Teste de nós e desvios falhou");
                }
            } else {
                noCounter++;
            }
            noAtual = noAtual.proximo;
        }

        if (desvioCounter != simulador.N) {
            throw new RuntimeException("Teste de nós e desvios falhou");
        }
    }

    public static void testGetNo(Simulador simulador) {
        No noAtual = simulador.inicio;
        int posicao = 0;

        while (noAtual != null) {
            if (!noAtual.equals(simulador.getNo(posicao))) {
                throw new RuntimeException("Teste getNo falhou");
            }
            noAtual = noAtual.proximo;
            posicao++;
        }
    }
}
