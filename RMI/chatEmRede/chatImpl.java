import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class chatImpl extends UnicastRemoteObject implements iChat {

	Scanner sc = new Scanner(System.in);

	public chatImpl() throws RemoteException {
	}

	public String trocaMensagem(String mensagem) throws RemoteException {
		System.out.println("user: "+mensagem);
		System.out.println("Digite uma resposta: ");
		return sc.nextLine();
	}

	public String recebeBoasVindas() throws RemoteException{
		return "Voce esta conectado ao chat! Bem vindo!";
	}

	public static void main(String args[]) {
		chatImpl cal;
		try {
			cal = new chatImpl();
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi:///ChatImpl", cal);
			System.out.println("Server rodando!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
