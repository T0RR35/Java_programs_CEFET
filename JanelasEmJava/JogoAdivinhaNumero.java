import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JogoAdivinhaNumero {
    JFrame frame = new JFrame();

    public JogoAdivinhaNumero() {
        int sorteado, tentativas = 0, palpite = 0;
        String palpiteString;

        Random geradorDeAleatorios = new Random();
        sorteado = geradorDeAleatorios.nextInt(1000) + 1;
       //System.out.println("Número entre 1 e 1000 sorteado!");

        do {
            palpiteString = JOptionPane.showInputDialog(frame, "Numero de tentativas: " + tentativas + "\nDigite um numero",
                "Teste caixa de dialogo", JOptionPane.QUESTION_MESSAGE);
            palpite = Integer.valueOf(palpiteString);

            dica(palpite, sorteado, tentativas);
            tentativas++;

        } while (palpite != sorteado && frame != null);
    }

    public void dica(int palpite, int numero, int tentativas) {
        if (palpite > numero) {
            System.out.println("Seu palpite eh maior que o numero sorteado!");
        } else {
            if (palpite < numero) {
                System.out.println("Seu palpite eh menor que o numero sorteado!");
            } else {
                System.out.println("Parabéns, você acertou! O número era " + numero);
                System.out.println("Voce precisou de " + tentativas +" tentativas para acertar");
            }
        }
    }

    public static void main(String[] args) {
        JogoAdivinhaNumero jogo = new JogoAdivinhaNumero();

    }
}