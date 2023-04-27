package SimuladorTrem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Simulador {
    ArrayList<Trem> trens;
    No inicio;
    int N;

    public Simulador() {
        this.trens = new ArrayList<>();
        this.inicio = null;
        gerarNos();
    }

    public void gerarNos() {
        Random random = new Random();
        N = random.nextInt(21) + 10;
        int totalNos = N * 21;
        No ultimo = null;

        for (int i = 0; i < totalNos; i++) {
            No novoNo;

            if (i % 21 == 0) {
                int idEstacao = i / 21 + 1;
                novoNo = new Estacao(idEstacao);
            } else if (i % 21 == 20) {
                novoNo = new No(true);
            } else {
                novoNo = new No(false);
            }

            if (ultimo != null) {
                ultimo.proximo = novoNo;
            } else {
                inicio = novoNo;
            }

            ultimo = novoNo;
        }
    }

    public int tempoParada(Trem trem, Estacao estacao) {
        int tempoParada = (estacao.pessoasSubindo + estacao.pessoasDescendo) * 30;
        return tempoParada;
    }

    public void loopSimulacao() {
        Scanner scanner = new Scanner(System.in);
        int minutosSimulacao = 9 * 60 + 30;
        int minutosPassados = 0;

        while (minutosPassados <= minutosSimulacao) {
            if (minutosPassados % 30 == 0) {
                Random random = new Random();
                int pessoas = random.nextInt(41) + 10;

                if (minutosPassados % 60 == 0) {
                    Trem trem = new Trem(trens.size() + 1, "A->B", pessoas);
                    trens.add(trem);
                } else {
                    Trem trem = new Trem(trens.size() + 1, "B->A", pessoas);
                    trens.add(trem);
                }
            }

            // Atualizar posição dos trens
            for (Trem trem : trens) {
                if (trem.posicao >= 0) {
                    No noAtual = getNo(trem.posicao);
                    noAtual.trem = null;
                    int novaPosicao = trem.posicao + (trem.direcao.equals("A->B") ? 1 : -1);
                    No novoNo = getNo(novaPosicao);

                    if (novoNo instanceof Estacao) {
                        Estacao estacao = (Estacao) novoNo;
                        int tempoParada = tempoParada(trem, estacao);

                        if (tempoParada > 0) {
                            System.out.println("Trem " + trem.id + " parado na estação " + estacao.id + " por " + tempoParada + " segundos.");
                            continue;
                        }
                    }

                    if (novoNo.desvio) {
                        if (novoNo.trem != null) {
                            System.out.println("Trem " + trem.id + " esperando no desvio.");
                            continue;
                        }
                    }

                    novoNo.trem = trem;
                    trem.posicao = novaPosicao;
                }
            }

            // Imprimir estado atual
            imprimirEstado();

            // Aguardar o pressionamento de uma tecla
            scanner.nextLine();
            minutosPassados++;
        }
        scanner.close();
    }

    public No getNo(int posicao) {
        No noAtual = inicio;

        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.proximo;
        }

        return noAtual;
    }

    public void imprimirEstado() {
        No noAtual = inicio;

        while (noAtual != null) {
            if (noAtual.trem != null) {
                System.out.print("T" + noAtual.trem.id);
            } else if (noAtual instanceof Estacao) {
                System.out.print("E" + ((Estacao) noAtual).id);
            } else if (noAtual.desvio) {
                System.out.print("D");
            } else {
                System.out.print("-");
            }

            noAtual = noAtual.proximo;
        }

        System.out.println();
    }
}
