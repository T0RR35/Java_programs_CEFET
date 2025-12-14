package View;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;

public class View extends JFrame implements ActionListener {

    JLabel lblMatricula, lblNome, lblSerie, lblCurso;
    JTextField txtMatricula, txtNome, txtSerie, txtCurso;
    JButton btnProximo, btnAnterior;

    Controller controller = new Controller();

    public View() {
        montaJanela();
    }

    private void montaJanela() {

        lblMatricula = new JLabel("Matricula");
        txtMatricula = new JTextField(20);

        lblNome = new JLabel("Nome");
        txtNome = new JTextField(22);

        lblSerie = new JLabel("Serie");
        txtSerie = new JTextField(3);

        lblCurso = new JLabel("Curso");
        txtCurso = new JTextField(15);

        btnProximo = new JButton("Next");
        btnProximo.setPreferredSize(new Dimension(130, 26));
        btnProximo.addActionListener(this);

        btnAnterior = new JButton("Previus");
        btnAnterior.setPreferredSize(new Dimension(130, 26));
        btnAnterior.addActionListener(this);
        // this.setLayout();

        Box painel = Box.createVerticalBox();

        Component box = Box.createRigidArea(new Dimension(30, 30));

        // Container painel = new JPanel(new FlowLayout());

        painel.add(novaLinha(box, lblMatricula, txtMatricula));
        painel.add(novaLinha(lblNome, txtNome));
        painel.add(novaLinha(lblSerie, txtSerie, lblCurso, txtCurso));

        painel.add(novaLinha(btnAnterior, box, btnProximo));

        this.add(painel);

        this.setSize(new Dimension(320, 180));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void carregaDadosNaJanela() {
        String linha = controller.getUmEstudante();
        String[] tokens = linha.split(";", -1);
        txtNome.setText(tokens[0]);
        txtMatricula.setText(tokens[1]);
        txtSerie.setText(tokens[2]);
        txtCurso.setText(tokens[3]);

        //DIALOGO VIEW-CONTROLLER
        this.setTitle(controller.getIndiceEstudante() + 1 + " - " + tokens[1]);
        boolean[] value = controller.testaLimites();
        btnAnterior.setEnabled(value[0]);
        btnProximo.setEnabled(value[1]);
    }

    public JPanel novaLinha(Component... componentes) {
        return novaLinha(FlowLayout.TRAILING, componentes);
    }

    public JPanel novaLinha(int alinhamento, Component... componentes) {
        // alinhamento= FlowLayout.TRAILING;
        JPanel painel = new JPanel(new FlowLayout(alinhamento, 3, 2));
        for (Component component : componentes) {
            painel.add(component);
        }
        return painel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(btnProximo.getActionCommand())) {
            controller.aumentaIndiceEstudante();
        } else {
            controller.diminuiIndiceEstudante();
        }
        carregaDadosNaJanela();
    }
}