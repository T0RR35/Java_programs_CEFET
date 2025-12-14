import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Biblioteca {
    protected int numeroCatalogo;
    protected int numeroCopias;

    public void Adquirir() {

    }

    public void retornar() {

    }

    @Override
    public String toString() {
        return String.format(Integer.toString(numeroCopias) + "; " + Integer.toString(numeroCatalogo));
    }
}

class Main {
    public static void main(String[] args) {
        // QUESTAO 1
        Gravacao filme1 = new Filme();
        // itemInfo(filme1);
        Gravacao filme2 = new Filme();
        // itemInfo(filme2);
        Gravacao software1 = new Software();
        // itemInfo(software1);
        Gravacao software2 = new Software();
        // itemInfo(software2);

        // QUESTAO 2
        JFrame frame = new JFrame("Minha Janela");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        Janela janela = new Janela();
        frame.setContentPane(janela);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int resposta = JOptionPane.showConfirmDialog(
                        frame,
                        "Deseja realmente sair?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    try{
                         escreveNoArquivo(janela);
                    }catch(FileNotFoundException f){
                         f.printStackTrace();
                    }
                    System.exit(0);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void itemInfo(Gravacao item) {
        System.out.println(item.toString());
    }

    public static void escreveNoArquivo(Janela janela) throws FileNotFoundException{
        FileOutputStream out = new FileOutputStream("Gravadoras.txt");
        PrintStream ps = new PrintStream(out);

        //ps.println("Code" + ";" + "Name" + ";" + "Users" + ";" + "Note");

        for (Gravacao gravacao : janela.getGravacoes()) {
            ps.println(gravacao.toString());
        }

        ps.close();
    }
}