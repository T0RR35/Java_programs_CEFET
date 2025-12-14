import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

public class Read {

     String nome, idString, matriculaString;
    
    public Read(final Container pane, JPanel compsToExperiment, JPanel controls, ArrayList<String> alunos) throws FileNotFoundException {
        pane.remove(compsToExperiment);
        compsToExperiment.removeAll();

        JButton botaoPesquisar = new JButton("Pesquisar");
        JTextField nomeField = new JTextField(20);

        JLabel labelNome = new JLabel("Nome:");

        compsToExperiment.setLayout(new FlowLayout(FlowLayout.CENTER));

        compsToExperiment.add(labelNome);
        compsToExperiment.add(nomeField);
        compsToExperiment.add(botaoPesquisar);

        compsToExperiment.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        pane.add(compsToExperiment, BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);

        botaoPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nome = nomeField.getText();
                if (nome != null) {
                    pesquisaNome(pane, compsToExperiment, controls, alunos);
                }
            }
        });

        pane.revalidate();
        pane.repaint();

    }

    public void pesquisaNome(final Container pane, JPanel compsToExperiment, JPanel controls, ArrayList<String> alunos) {
        Iterator<String> iter = alunos.iterator();
        boolean achou = false;
        while (iter.hasNext()) {
            String aluno = iter.next();
            String[] dados = aluno.split(",");
            for (int i = 0; i < dados.length; i++) {
                if (dados[i].equals(nome)) {
                    achou = true;
                    pane.remove(compsToExperiment);
                    compsToExperiment.removeAll();

                    JButton botaoEditar = new JButton("Editar");
                    JButton botaoDeletar = new JButton("Deletar");

                    JLabel labelNome = new JLabel(
                            "Nome: " + dados[2] + ", Matricula " + dados[1] + ", id " + dados[0]);
                    compsToExperiment.setLayout(new FlowLayout(FlowLayout.CENTER));

                    compsToExperiment.add(botaoEditar);
                    compsToExperiment.add(botaoDeletar);
                    compsToExperiment.add(labelNome);

                    compsToExperiment.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

                    pane.add(compsToExperiment, BorderLayout.CENTER);
                    pane.add(controls, BorderLayout.SOUTH);
                    pane.revalidate();
                    pane.repaint();

                    botaoEditar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            new Update(pane, compsToExperiment, controls, nome);
                        }
                    });
                    botaoDeletar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            //pesquisaNome(pane, compsToExperiment, controls);                   
                        }
                    });
                    break;
                }
                break;
            }
            if(!achou)
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado", "Mensagem", JOptionPane.PLAIN_MESSAGE);
        }
    }

}
