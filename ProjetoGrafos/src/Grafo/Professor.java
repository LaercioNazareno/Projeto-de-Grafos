package Grafo;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	
	private String nome;
	private List<Aula> aulas = new ArrayList();
		
	public Professor(String nome) {
		this.nome = nome;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Aula> getAulas() {
		return aulas;
	}
	public void setAulas(Aula aula) {
		this.aulas.add(aula);
	}
	
	
}
