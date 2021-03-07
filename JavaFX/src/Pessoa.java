import java.util.ArrayList;
import java.util.List;

public class Pessoa {

	private String nome;
	private String sobrenome;
	private Integer idade;
	private String outros;
	
	public Pessoa (String nome, String sobrenome, Integer idade, String outros) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.outros = outros;
	}
	
	public static List<Pessoa> pessoas(){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(new Pessoa("Alberto", "Silva", 20, "Filho"));
		pessoas.add(new Pessoa("Barbara", "Silva", 25, "Filha"));
		pessoas.add(new Pessoa("Carlos", "Silva", 50, "Pai"));
		pessoas.add(new Pessoa("Dalva", "Silva", 50, "Mãe"));
		pessoas.add(new Pessoa("Ernesto", "Silva", 40, "Tio"));
		return pessoas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getOutros() {
		return outros;
	}
	public void setOutros(String outros) {
		this.outros = outros;
	}
}
