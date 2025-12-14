import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Iterator;
import java.util.Scanner;

public class FlowLayoutDemo extends JFrame {

    JRadioButton RtoLbutton;
    JRadioButton LtoRbutton;
    FlowLayout experimentLayout = new FlowLayout();

    JButton botaoCreate = new JButton("Create");
    JButton botaoUpdate = new JButton("Update");
    JButton botaoDelete = new JButton("Delete");
    JButton botaoRead = new JButton("Read");

    Delete delete;
    Update update;
    Create create;
    Read read;

    String nome, matriculaString, idString;
    int id, matricula;

    static ArrayList<String> alunos = new ArrayList<>();

    public FlowLayoutDemo(String name) {
        super(name);
    }

    public static void reescreve() throws IOException {
		FileWriter fw = new FileWriter("D:\\2025\\cefet\\3 ano\\LPII\\ParaCasaGUI\\dados.csv");
		BufferedWriter out = new BufferedWriter(fw);

		for (String aluno : alunos) {
			fw.write(aluno + ",\n");
		}

        out.close();
	}

    public static void leArquivo() throws IOException {
        FileReader fr;
        fr = new FileReader("D:\\2025\\cefet\\3 ano\\LPII\\ParaCasaGUI\\dados.csv");
        BufferedReader in = new BufferedReader(fr);

        String line;
        while ((line = in.readLine()) != null) {
            alunos.add(line);
        }
        in.close();
    }

    public static void main(String args[]) {

        try {
            leArquivo();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        FlowLayoutDemo frame = new FlowLayoutDemo("FlowLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
    }

    public void addComponentsToPane(final Container pane) {
        JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);
        experimentLayout.setAlignment(FlowLayout.CENTER);

        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout(FlowLayout.CENTER));

        compsToExperiment.add(botaoCreate);
        compsToExperiment.add(botaoRead);
        compsToExperiment.add(botaoUpdate);
        compsToExperiment.add(botaoDelete);

        compsToExperiment.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        pane.add(compsToExperiment, BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);

        verificaClique(pane, compsToExperiment, controls);
    }

    public void verificaClique(final Container pane, JPanel compsToExperiment, JPanel controls) {
        botaoCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                create = new Create(pane, compsToExperiment, controls, alunos);
                try {
                    reescreve();
                } catch (IOException i) {
                    // TODO Auto-generated catch block
                    i.printStackTrace();
                }
            }
        });

        botaoRead.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    read = new Read(pane, compsToExperiment, controls, alunos);
                } catch (FileNotFoundException f) {
                    // TODO Auto-generated catch block
                    f.printStackTrace();
                }
            }
        });

        botaoUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update = new Update(pane, compsToExperiment, controls, "");
            }
        });

        botaoDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para o botão Delete (deletar)
            }
        });
    }

}
