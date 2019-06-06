package Grafo;

public class Aula {
	
	private Professor professor;
	private Disciplina disciplina;	
	private Turma turma;
	//o vetor é de tamanho 2, a primeira posição é o dia, o segunda posição é o horario 
	private int[] horarios;
	
	
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public int[] getHorarios() {
		return horarios;
	}
	public void setHorarios(int[] horario) {
		this.horarios = horario;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public String toString() {
		return "professor: "+professor.getNome()+" disciplina:"+disciplina.getNome()+" horario:"+horarios[0]+" "+horarios[1]+ " turma:"+getTurma().getId();
	}
}
