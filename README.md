# unisinos-homework

## Simulador de trem

Em uma cidade do interior, o único transporte entre os diferentes bairros é um trem. Existem vários trens na cidade,
que transitam do ponto A (que fica em um lado da cidade) até o ponto B (que fica no outro lado da cidade). Entre os
pontos A e B existem N estações (uma em cada bairro), que são distantes 20 quilômetros uma da outra. A imagem
abaixo ilustra o trajeto do trem.

Os primeiros trens saem as 8h, e o último sai as 17h30min (inclusive). A partir da hora inicial, de meia em meia hora
em hora um trem sai de um ponto e vai até o outro. O número de trens não é importante, pois sempre há um trem
disponível para sair dos pontos especificados nos horários corretos. A velocidade de cada trem é de exatamente
60km/h.

O trajeto de cada trem entre os dois pontos teria o mesmo tempo, não fosse o tempo de parada em cada estação. Em
cada estação, o trem ficará parado para que as pessoas desçam e subam, e o tempo de parada depende da quantidade
de pessoas que vão embarcar e desembarcar. Como as portas do trem são apertadas, apenas uma pessoa pode descer
ou subir de cada vez. Naturalmente, as pessoas que sobem devem aguardar todas as pessoas que querem desembarcar
descerem, para aí entrarem no trem (também uma a uma). O tempo que uma pessoa leva para subir ou descer do
trem é o mesmo: 30 segundos.

O que acontece nesta linha de trem, entretanto, é que **existe apenas um trilho para os dois trajetos** (de A para B e de
B para A). Assim sendo, os trens usarão o mesmo espaço para ir e vir, o que pode ocasionar acidentes. Para evitar
situações como esta, a prefeitura criou desvios antes e depois de cada estação, para que os trens possam desviar um
do outro em caso de necessidade de passarem no mesmo tempo por alguma parte do trajeto. A imagem abaixo ilustra
os desvios criados pela prefeitura.

Cada desvio começa 1 quilômetro antes da estação (nos dois sentidos). Nos desvios, os trens ficam parados até que
seja possível continuar a viagem. Ao sair do desvio, o trem automaticamente estará na próxima estação no próximo
instante de tempo.

Sabendo disto, você deve realizar uma implementação que simule os trens indo e vindo, durante o período de tempo
estipulado.

Para isto, você deve estar atento aos seguintes itens:

- O trilho do trem deve ser uma estrutura encadeada. Desta forma, entre uma estação e outra haverá nós
    encadeados, que devem ser desenvolvidos e organizados para simular os trilhos. Sobre o trilho:
       o Entre uma estação e outra, devem existir 20 nós (um nó para cada quilômetro)
       o O desvio é composto apenas por um nó (pois cada nó representa 1 quilômetro)

### DESAFIO

```
Programação II
```
(^) ...
Ponto A (^) Estação 1 (^) Estação 2 Ponto B (^)
Estação 3^ Estação 4^ Estação^ N^

# ...

Ponto A (^) Estação 1 (^) Estação 2 Ponto B (^)
Estação 3^ Estação 4^ Estação^ N^


- Sua simulação deve ser feita a cada instante de tempo de 1 minuto. Ou seja, quando o simulador começar, a
    cada vez que uma tecla qualquer for apertada, seu sistema simulará o que acontece no próximo minuto e
    aguardará que mais uma tecla seja pressionada para simular o próximo minuto, e assim por diante
- Considere que o trem assume sua velocidade instantaneamente, sem aceleração e desaceleração
- A cada instante de tempo executado, impressões na tela devem aparecer para informar o que está
    acontecendo na simulação, de forma clara e completa. Preferencialmente, as impressões na tela devem ser
    feitas utilizando desenhos (em texto mesmo) que mostrem os trens se movimentando a cada instante de
    tempo
- A quantidade de estações N é definida por sorteio no começo da execução do seu programa, devendo ser um
    valor entre 10 e 30
- A quantidade de pessoas que está em cada trem é definida por sorteio logo antes da partida do trem de um
    dos pontos. A quantidade mínima de pessoas em cada trem é 10, e a máxima é 50
- Caso algum trem chegue na estação e ninguém vá subir nem descer, o trem fica parado 1 minuto na estação
- A quantidade de pessoas que sobem e descem do trem em cada estação é definida por sorteio, quando o trem
    chegar no local de parada. Somadas, a quantidade de pessoas que sobem e descem deve totalizar um número
    par de pessoas. No máximo 10 pessoas podem subir em cada estação, e no máximo 10 pessoas podem descer
    em cada estação
- No final da simulação, um arquivo deve ser criado, informando a quantidade total de pessoas que subiram e
    desceram em cada uma das estações durante todo o período de tempo da simulação (do trem que sai as 8h
    até o trem que sai as 17h30min)
- Nos pontos de partida (A e B), caso seja necessário, os trens não podem sair e entrar no mesmo instante de
    tempo. Um trem deverá esperar o outro sair para chegar ao ponto desejado (quando for o caso)
- As classes a serem criadas e a estrutura do programa devem ser pensadas por você


