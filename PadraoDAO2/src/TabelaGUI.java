import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TabelaGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private int index = 0, dadosSize;
	ArrayList<String[]> dados;

	private JTextField matriculaField;
	private JTextField nomeField;
	private JTextField emailField;
	private JTextField senhaField;
	private JTextField cargoField;
	private JTextField turmaField;
	private JTextField setorField;

	public TabelaGUI(ArrayList<String[]> dados) {
		this.dados = dados;
		dadosSize = dados.size();
		// ConfiguraÃ¯Â¿Â½Ã¯Â¿Â½o inicial da janela
		setTitle("Tabela");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Configurar layout
		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(new JLabel("Matricula:"));
		matriculaField = new JTextField(50);
		add(matriculaField);

		add(new JLabel("Nome:"));
		nomeField = new JTextField(50);
		add(nomeField);

		add(new JLabel("Email:"));
		emailField = new JTextField(50);
		add(emailField);

		add(new JLabel("Senha:"));
		senhaField = new JTextField(50);
		add(senhaField);

		add(new JLabel("Cargo:"));
		cargoField = new JTextField(50);
		add(cargoField);

		add(new JLabel("Turma:"));
		turmaField = new JTextField(50);
		add(turmaField);

		add(new JLabel("Setor:"));
		setorField = new JTextField(50);
		add(setorField);

		JButton prevButton = new JButton("Anterior");
		prevButton.addActionListener(e -> mostrarAnterior());
		add(prevButton);

		JButton nextButton = new JButton("Proximo");
		nextButton.addActionListener(e -> mostrarProximo());
		add(nextButton);

		JButton updateButton = new JButton("Atualizar");
		updateButton.addActionListener(e -> atualizarDado());
		add(updateButton);

		JButton deleteButton = new JButton("Deletar");
		deleteButton.addActionListener(e -> deletarDado());
		add(deleteButton);

		JButton saveButton = new JButton("Salvar");
		saveButton.addActionListener(e -> Conexao.salvarDados("tabela.csv", dados));
		add(saveButton);
	}

	public int mostrarDado(Pessoa pessoa) {
		if (pessoa != null &&  index < dadosSize && index >= 0) {
			//String[] dado = dados.get(index);
			matriculaField.setText(Integer.toString(pessoa.getMatricula()));
			nomeField.setText(pessoa.getNome());
			emailField.setText(pessoa.getEmail());
			senhaField.setText(pessoa.getSenha());
			cargoField.setText(pessoa.getCargo());
			turmaField.setText(pessoa.getTurma());
			setorField.setText(pessoa.getSetor());
		}
		return index;
	}

	private void mostrarAnterior() {
		if (index > 0) {
			index--;
		}
	}

	private void mostrarProximo() {
		if (index < dadosSize - 1) {
			index++;
		}
	}

	private void atualizarDado() {
		if (!dados.isEmpty() && index < dadosSize && index >= 0) {
			String[] dado = new String[7];
			dado[0] = matriculaField.getText();
			dado[1] = nomeField.getText();
			dado[2] = emailField.getText();
			dado[3] = senhaField.getText();
			dado[4] = cargoField.getText();
			dado[5] = turmaField.getText();
			dado[6] = setorField.getText();
			dados.set(index, dado);
		}
	}

	private void deletarDado() {
		if (!dados.isEmpty() && index < dadosSize && index >= 0) {
			dados.remove(index);
			if (index > 0) {
				index--;
			}
		}
	}
}
