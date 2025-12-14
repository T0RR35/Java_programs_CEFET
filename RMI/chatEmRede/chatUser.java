import java.rmi.Naming;
import java.util.*;

import javax.swing.JOptionPane;

public class chatUser {
  // constructor
  public chatUser() {
  }

  public static void main(String args[]) {
    iChat remoteCal;
    Scanner sc = new Scanner(System.in);
    String mensagemUser = "";

    try {
      remoteCal = (iChat) Naming.lookup("rmi:///ChatImpl");
      System.out.println(remoteCal.recebeBoasVindas());
      System.out.println("Digite uma mensagem: ");
      mensagemUser = sc.nextLine();

      while (!mensagemUser.equals("!exit")) {
        System.out.println("Resposta do servidor: "+ remoteCal.trocaMensagem(mensagemUser));
        System.out.println("\nDigite uma resposta: ");
        mensagemUser = sc.nextLine();
      }
      System.out.println("Chat encerrado!");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sc.close();
    }
  }
}
