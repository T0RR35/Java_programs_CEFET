import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class Janela extends JPanel {

    JLabel tituloLabel;
    JTextField tituloInput;

    JLabel midiaLabel;
    JTextField midiaInput;

    JRadioButton filme, software;
    ButtonGroup tipoGroup;

    JLabel diretorLabel;
    JTextField diretorInput;

    JLabel dataLabel;
    JTextField dataInput;

    JLabel distribuidorLabel;
    JTextField distribuidorInput;

    JLabel versionLabel;
    JTextField versionInput;

    JLabel plataformaLabel;
    JTextField plataformaInput;

    JButton insertButton;
    JButton cleanButton;

    JLabel resultText;

    boolean tipoFoiSelecionado = false;
    String tipoSelecionado;
    boolean podeAdicionar = false;

    ArrayList<Gravacao> gravacoes = new ArrayList<>();

    public Janela() {

        this.setLayout(new BorderLayout(10, 10));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        tituloLabel = new JLabel("Título:");
        tituloInput = new JTextField(20);

        midiaLabel = new JLabel("Mídia:");
        midiaInput = new JTextField(20);

        filme = new JRadioButton("Filme");
        software = new JRadioButton("Software");
        tipoGroup = new ButtonGroup();
        tipoGroup.add(filme);
        tipoGroup.add(software);
        RadioButtonHandler radioHandler = new RadioButtonHandler();
        filme.addItemListener(radioHandler);
        software.addItemListener(radioHandler);

        diretorLabel = new JLabel("Diretor:");
        diretorInput = new JTextField(20);

        dataLabel = new JLabel("Data:");
        dataInput = new JTextField(20);

        distribuidorLabel = new JLabel("Distribuidor:");
        distribuidorInput = new JTextField(20);

        versionLabel = new JLabel("Versão:");
        versionInput = new JTextField(20);

        plataformaLabel = new JLabel("Plataforma:");
        plataformaInput = new JTextField(20);

        insertButton = new JButton("Inserir");
        cleanButton = new JButton("Limpar");
        resultText = new JLabel("");

        TextFieldHandler handler = new TextFieldHandler();
        insertButton.addActionListener(handler);
        cleanButton.addActionListener(handler);

        // Linha 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(tituloLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(tituloInput, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(midiaLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(midiaInput, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Tipo:"), gbc);
        gbc.gridx = 1;
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        radioPanel.add(filme);
        radioPanel.add(software);
        formPanel.add(radioPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(diretorLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(diretorInput, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(dataLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(dataInput, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(distribuidorLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(distribuidorInput, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(versionLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(versionInput, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(plataformaLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(plataformaInput, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.add(insertButton);
        buttonPanel.add(cleanButton);
        formPanel.add(buttonPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        formPanel.add(resultText, gbc);

        this.add(formPanel, BorderLayout.CENTER);

        if (tipoFoiSelecionado) {
            if (tipoSelecionado.equals("Filme")) {
                gravacoes.add(new Filme(tituloInput.getText(), midiaInput.getText(), diretorInput.getText(),
                        dataInput.getText(), distribuidorInput.getText()));
            } else if (tipoSelecionado.equals("Software")) {
                gravacoes.add(new Software(tituloInput.getText(), midiaInput.getText(),
                        Integer.valueOf(versionInput.getText()), plataformaInput.getText()));
            }
        }
    }

    class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == insertButton) {
                if (tipoFoiSelecionado) {
                    if (tipoSelecionado.equals("Filme")) {
                        gravacoes.add(new Filme(
                                tituloInput.getText(),
                                midiaInput.getText(),
                                diretorInput.getText(),
                                dataInput.getText(),
                                distribuidorInput.getText()));
                    } else if (tipoSelecionado.equals("Software")) {
                        gravacoes.add(new Software(
                                tituloInput.getText(),
                                midiaInput.getText(),
                                Integer.valueOf(versionInput.getText()),
                                plataformaInput.getText()));
                    }
                } else {
                    resultText.setText("Selecione um tipo antes de inserir.");
                }
            }

            if (e.getSource() == cleanButton) {
                tituloInput.setText("");
                midiaInput.setText("");
                diretorInput.setText("");
                dataInput.setText("");
                distribuidorInput.setText("");
                versionInput.setText("");
                plataformaInput.setText("");
                tipoGroup.clearSelection();
                resultText.setText("Campos limpos!");
            }
        }
    }

    private class RadioButtonHandler implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                if (event.getSource() == filme)
                    tipoFoiSelecionado = true;
                tipoSelecionado = "Filme";
                if (event.getSource() == software)
                    tipoFoiSelecionado = true;
                tipoSelecionado = "Software";
            } else {
                tipoFoiSelecionado = false;
            }
        }
    }

    public ArrayList<Gravacao> getGravacoes(){
        return gravacoes;
    }
}
