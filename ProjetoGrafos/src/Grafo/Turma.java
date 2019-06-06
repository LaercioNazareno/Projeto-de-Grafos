package Grafo;

public class Turma {
	
	private String id,periodo;
	
	
	public Turma() {
	}
	
	public Turma(String id, String periodo) {
		super();
		this.id = id;
		this.periodo = periodo;
	}




	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPeriodo() {
		return periodo;
	}


	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	
}
