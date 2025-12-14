class UmaClasse{
    static int contador = 0;
    static private UmaClasse instance = null;

    private UmaClasse(){
        contador++;
    }

    public static int getContador(){
        return contador;
    }

    public static UmaClasse getInstance(){
        if(instance == null)instance = new UmaClasse();
        return instance;
    }
}

public class TestadorDeUmaClasse{
    public static void main(String[] args) {
        for(int i = 0; i < 4; i++){
            UmaClasse.getInstance();
        }
        System.out.println("Total de instancias criadas: " + UmaClasse.getContador());
    }
}