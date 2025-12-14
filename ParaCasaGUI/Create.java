import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Scanner;

public class Create {

    String nome, idString, matriculaString;
    
     public Create(final Container pane, JPanel compsToExperiment, JPanel controls, ArrayList<String> alunos) {
        pane.remove(compsToExperiment);
        compsToExperiment.removeAll();

        JButton botaoInsert = new JButton("Insert");
        JTextField nomeField = new JTextField(20);
        JTextField matriculaField = new JTextField(20);
        JTextField idField = new JTextField(20);

        JLabel labelNome = new JLabel("Nome:");
        JLabel labelId = new JLabel("Id:");
        JLabel labelMatricula = new JLabel("Matrícula:");

        compsToExperiment.setLayout(new FlowLayout(FlowLayout.CENTER));

        compsToExperiment.add(labelNome);
        compsToExperiment.add(nomeField);
        compsToExperiment.add(labelId);
        compsToExperiment.add(idField);
        compsToExperiment.add(labelMatricula);
        compsToExperiment.add(matriculaField);
        compsToExperiment.add(botaoInsert);

        compsToExperiment.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        pane.add(compsToExperiment, BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);

        botaoInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nome = nomeField.getText();
                idString = idField.getText();
                matriculaString = matriculaField.getText();
                if (nome != null && idString != null && matriculaString != null) {
                    alunos.add(idString + "," + matriculaString + "," + nome);
                    JOptionPane.showMessageDialog(null, "Sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
            }
        });
        
        pane.revalidate();
        pane.repaint();
    }
}
