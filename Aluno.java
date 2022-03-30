public class Aluno extends Pessoa{
	private double notaFinal;

	public Aluno(String nome, String telefone, String nascimento, String cadastro, String ultimaAlteracao,double notaFinal) {
		super(nome, telefone, nascimento, cadastro, ultimaAlteracao);
		this.notaFinal = notaFinal;
	}

	public double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}
	
	@Override
	public String toString() {
		return "Aluno { " + "Nome: " + getNome() + ", "
	+ "Telefone: " + getTelefone() + ", "
	+ "Data de Nascimento: " + getNascimento() + ", "
	+ "Data de Cadastro: " + getCadastro() + ", "
	+ "Data da última alteração: " + getUltimaAlteracao() + ", "
	+ "Nota Final: " + getNotaFinal()
	+ " }";
    }
	
}
