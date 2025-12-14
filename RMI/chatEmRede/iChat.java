import java.rmi.*;

public interface iChat extends Remote {

       String trocaMensagem(String mensagem) throws RemoteException;
       String recebeBoasVindas() throws RemoteException;

}
