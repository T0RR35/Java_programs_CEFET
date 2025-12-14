package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Model {

    Vector<String> estudantes;

    public Model(){
        carregaDados();
    }

    public void carregaDados(){

        Vector<String> lista = new Vector<>();

        try {
            Scanner leitor = new Scanner(new File("D:\\2025\\cefet\\3 ano\\LPII\\Atividade33MVC\\Model\\estudantes.csv"));
            leitor.nextLine(); // Remove o cabecalho.

            while (leitor.hasNextLine()) {
                lista.add(leitor.nextLine());
            }
            leitor.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        estudantes = lista;
    }

    public Vector<String> getAllEstudantes(){
        return estudantes;
    }

    public String getUmEstudante(int index){
        return estudantes.get(index);
    }   
}
