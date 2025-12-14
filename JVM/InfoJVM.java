import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class InfoJVM {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();

        System.out.println("Nome da JVM: " + mxBean.getVmName());
        System.out.println("Versão da JVM: " + mxBean.getVmVersion());
        System.out.println("Diretório de instalação: " + System.getProperty("java.home"));
        System.out.println("Memória máxima (bytes): " + runtime.maxMemory());
        System.out.println("Memória usada (bytes): " + (runtime.totalMemory() - runtime.freeMemory()));
        System.out.println("Número de núcleos: " + runtime.availableProcessors());
    }
}
