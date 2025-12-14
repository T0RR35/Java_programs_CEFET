import java.util.ArrayList;

public class TesteGarbageCollector {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        System.out.println("Memória antes da alocação: " + (runtime.totalMemory() - runtime.freeMemory()));

        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            lista.add("Objeto " + i);
        }

        System.out.println("Memória após alocação: " + (runtime.totalMemory() - runtime.freeMemory()));

        lista = null;
        System.gc();

        try {
            Thread.sleep(2000); // Aguarda o GC
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Memória após GC: " + (runtime.totalMemory() - runtime.freeMemory()));
    }
}
