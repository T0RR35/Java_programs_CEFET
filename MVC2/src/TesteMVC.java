import controller.AlunoController;
import model.Aluno;
import view.JanelaPrincipal;

public class TesteMVC {
	
	public static void main(String[] args) {
		// modelo
		Aluno model = new Aluno();
		// visao
		JanelaPrincipal view = new JanelaPrincipal();
		// controlador
		AlunoController controller = new AlunoController(model, view);
	}
}
