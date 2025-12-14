package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlunoComponent extends JPanel{

	private static final long serialVersionUID = 2L;
	
	private JTextField labelMatricula;
	private JTextField labelName;
	
	private JButton buttonEditar;
	private JButton buttonExcluir;
	 
	public AlunoComponent(String matricula, String name) {
		
		setLayout(new FlowLayout());
		
		labelMatricula = new JTextField(matricula);
		labelName = new JTextField(name);
		
		buttonEditar = new JButton("Editar");
		buttonExcluir = new JButton("Excluir");
		
		
		labelMatricula.setPreferredSize(new Dimension(80, 20));
		labelName.setPreferredSize(new Dimension(250, 20));
	
		add(labelMatricula);
		add(labelName);
		add(buttonEditar);
		add(buttonExcluir);
		
		labelMatricula.setEnabled(false);
		labelName.setEnabled(false);
	}
	
	public int getMatricula() {
		return Integer.parseInt(labelMatricula.getText().toString());
	}
	
	public String getName() {
		return labelName.getText().toString();
	}

	// Adiciona um novo escutador para o botao
	public void addListenerDeleteButton(ActionListener listener) {
		
		for( ActionListener al : buttonExcluir.getActionListeners() ) {
			buttonExcluir.removeActionListener( al );
	    }
		
		this.buttonExcluir.addActionListener(listener);
	}
	
	// Adiciona um novo escutador para o botao
	public void addListenerUpdateButton(ActionListener listener) {
		
		for( ActionListener al : buttonEditar.getActionListeners() ) {
			buttonEditar.removeActionListener( al );
	    }
		
		this.buttonEditar.addActionListener(listener);
	}
	
	// Ativa ou desativa os formularios
	public void setEnableComponents(boolean value) {
		labelMatricula.setEnabled(value);
		labelName.setEnabled(value);
	}

	public JButton getButtonEditar() {
		return buttonEditar;
	}
	
}
