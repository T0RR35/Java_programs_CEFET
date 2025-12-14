import java.util.Scanner;

// Exceção personalizada para números ímpares
class NaoParException extends Exception {
    int num;

    public NaoParException(int num) {
        this.num = num;
    }

    public String toString(){
        return "Excecao: o número [" + num + "] não é par!";
    }
}

public class CalculadoraDePare {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1 = 0, num2 = 0;

        try {
            // Lê o primeiro número até ser par
            while (true) {
                System.out.print("Digite um número par: ");
                num1 = entrada.nextInt();
                if (num1 % 2 != 0) {
                    throw new NaoParException(num1);
                }
                break; // sai do loop se for par
            }

            // Lê o segundo número até ser par
            while (true) {
                System.out.print("Digite outro número par: ");
                num2 = entrada.nextInt();
                if (num2 % 2 != 0) {
                    throw new NaoParException(num2);
                }
                break; 
            }

            // Exemplo de operação: soma dos dois pares
            int resultado = num1 + num2;
            System.out.println("Resultado da soma: " + resultado);

        } catch (NaoParException e) {
            System.out.println("Erro capturado -> " + e);
        } finally {
            entrada.close(); // fecha o scanner só no final
        }
    }
}
