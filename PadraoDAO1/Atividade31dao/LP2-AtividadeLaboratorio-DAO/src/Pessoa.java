public class Pessoa {
	int matricula;
	String nome, email, senha, cargo, turma, setor;

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula){
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String toString(){
		return Integer.toString(matricula) + "; " + nome + "; " + email + "; " + senha + "; " + cargo + "; " + turma + "; " + setor;
	}
}

