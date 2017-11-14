package Model;

public class Projeto {
	private String nome;
	private String statusDoProjeto;
	private java.util.List<String> pesquisadores;
	
	public java.util.List<String> getPesquisadores() {
		return pesquisadores;
	}
	public void setPesquisadores(java.util.List<String> list) {
		this.pesquisadores = list;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getStatusDoProjeto() {
		return statusDoProjeto;
	}
	public void setStatusDoProjeto(String statusDoProjeto) {
		this.statusDoProjeto = statusDoProjeto;
	}
}
