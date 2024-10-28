package game.pkg2.pkg0.supremo;

import java.util.Scanner;

public class Game20Supremo {

    // Boas Vindas
    public static void introduzirGameShow() {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Bem-vindos ao Game 2.0 Supremo");
        System.out.println("Neste jogo, você enfrentará desafios sobre adivinhação e irá multiplica sua aposta inicial.");
    }

    //Número Aleatório
    public static int escolherNumeroSecreto() {
        return (int) (Math.random() * 100) + 1;
    }

    // Verificador de palpites
    public static boolean verificarPalpite(int numeroSecreto, int palpite, int tentativaz) {

        if (palpite == numeroSecreto) {
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("Parabéns, você acertou o número secreto! depois de " + tentativaz + " tentativas.");
            return true;
        } else if (palpite > numeroSecreto) {
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("O seu palpite foi alto demais!");
        } else {
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("O seu palpite foi baixo demais");
        }
        return false;
    }

    public static String exibirPontuacaoFinal(String nome, String tentou, String acertos, String valor) {
        String end = nome + " você tentou acertar " + tentou + " vezes, e com isso acertou " + acertos + " vezes e ganhou incríveis R$" + valor + ". Volte sempre e até a próxima Xiruuu! :)";
        return end;
    }
// Game Show

    public static void main(String[] args) {
// Imports
        Scanner ler = new Scanner(System.in);
// Variaveis
        int tentou = 0, tentativas = 0, acertos = 0;
        boolean jogo = false, iniciar = true, acertou = true;
        String inicio, nome, repetir, respostaFinal;
        double aposta, valor;
        aposta = 0;
        valor = 0;
// Boas-vindas
        introduzirGameShow();
// Entradas
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Antes de tudo; Qual é o seu nome?");
        nome = ler.nextLine();

// Looping caso o cliente erra se quer começar ou não
        while (!jogo) {
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("Você deseja iniciar o jogo? sim ou nao?");
            inicio = ler.next();
// If Iniciar
            if (inicio.equals("sim")) {
                iniciar = false;
                acertou = false;
                respostaFinal = "Volte sempre, até a próxima Xiruuu! :)";
                System.out.println("-------------------------------------------------------------------------------------------");
                System.out.println("Quanto quer apostar?");
                aposta = ler.nextDouble();
            } else if (inicio.equals("nao")) {
                jogo = true;
                iniciar = true;
                respostaFinal = "Que pena que não queira jogar, mas até a próxima Xiruuu! :(";
            } else {
                System.out.println("-------------------------------------------------------------------------------------------");
                respostaFinal = "Digite apenas sim ou nao";
            }
// Looping do game
            while (!iniciar) {
                jogo = true;
                final int RANDOM = escolherNumeroSecreto();
// Looping das tentativas
                while (!acertou) {
                    System.out.println("-------------------------------------------------------------------------------------------");
                    System.out.println("Estou pensando em um número entre 1 e 100...");
                    System.out.print("Digite sua tentativa: ");
                    int palpite = ler.nextInt();
                    tentativas++;
                    // If palpite
                    verificarPalpite(RANDOM, palpite, tentativas);
                    // If calculo da recompensa
                    if (palpite == RANDOM) {
                        aposta *= 2;
                        valor += aposta;
                        acertos++;
                        acertou = true;
                        iniciar = true;
                    }
                }
                tentou += tentativas;
                tentativas = 0;
// Entrada do continuar
                System.out.println("-------------------------------------------------------------------------------------------");
                System.out.println("Você deseja continuar o jogo e aumentar suas recompensas? sim ou nao?");
                repetir = ler.next();
// If do continuar
                if (repetir.equals("sim")) {
                    iniciar = false;
                    acertou = false;
                } else if (repetir.equals("nao")) {
                    iniciar = true;
                    String tentou1 = Integer.toString(tentou);
                    String acertos1 = Integer.toString(acertos);
                    String valor1 = Double.toString(valor);
                    respostaFinal = exibirPontuacaoFinal(nome, tentou1, acertos1, valor1);
                } else {
                    System.out.println("-------------------------------------------------------------------------------------------");
                    System.out.println("Escreva apenas sim ou nao");
                    iniciar = false;
                    acertou = true;
                }
            }
// Saída geral
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println(respostaFinal);
        }
        ler.close();
    }
}
