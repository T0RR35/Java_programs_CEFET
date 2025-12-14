package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	// Tamanho da janela
	private final int LARGURA_TELA = 600;
	private final int ALTURA_TELA = 400;

	// Componentes da janela
	private JButton botaoAdicionar;
	private JButton botaoLimpar;
	private JPanel panelAlunos;
	private JTextField textFieldMatricula;
	private JTextField textFieldName;

	// Lista que contem a lista de components para cada aluno
	private ArrayList<AlunoComponent> lista = new ArrayList<>();

	public JanelaPrincipal() {

		// Define as caracteristicas da janela (JFrame)
		setTitle("MVC - Alunos");
		setSize(LARGURA_TELA, ALTURA_TELA);
		setPreferredSize(getSize());
		setLayout(new FlowLayout());
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Define e carrega os componentes da janela
		init();

		// Torna a janela vis�vel
		setVisible(true);
	}

	// Define e adiciona os componentes do JFrame
	private void init() {
		botaoAdicionar = new JButton("Adicionar Aluno");

		botaoLimpar = new JButton("Limpar");
		botaoLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
		});

		textFieldMatricula = new JTextField();
		textFieldMatricula.setPreferredSize(new Dimension(100, 20));
		textFieldName = new JTextField();
		textFieldName.setPreferredSize(new Dimension(300, 20));

		panelAlunos = new JPanel();
		panelAlunos.setPreferredSize(new Dimension(200, 200));
		panelAlunos.setLayout(new FlowLayout());

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setPreferredSize(new Dimension((int) getSize().getWidth() - 10, 200));
		scrollPane.add(panelAlunos);

		add(scrollPane);

		add(new JLabel("Matr�cula"));
		add(textFieldMatricula);
		add(new JLabel("Nome"));
		add(textFieldName);
		add(botaoAdicionar);
		add(botaoLimpar);
	}

	// Cria um JOptionPane com uma mensagem
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(getParent(), message);
	}
	
	// Limpa os dados do formul�rio
	public void clear() {
		textFieldMatricula.setText("");
		textFieldName.setText("");
	}

	// Adiciona um escutador para o botao de inserir aluno
	public void addListenerAddButton(ActionListener listener) {

		for (ActionListener al : botaoAdicionar.getActionListeners()) {
			botaoAdicionar.removeActionListener(al);
		}

		botaoAdicionar.addActionListener(listener);
	}

	// Getters and Setters
	public String getNameAluno() {
		return textFieldName.getText().toString();
	}

	public int getMatricula() throws NumberFormatException {
		return Integer.parseInt(textFieldMatricula.getText().toString());
	}

	public JButton getBotaoAdicionar() {
		return botaoAdicionar;
	}

	public JPanel getPanelAlunos() {
		return panelAlunos;
	}

	public ArrayList<AlunoComponent> getComponentList() {
		return lista;
	}

}
