package Arquivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Grafo.Aula;
import Grafo.Disciplina;
import Grafo.Professor;
import Grafo.Turma;

public class Leitor {
	
	private static FileReader file;
	private static BufferedReader leitor;
	private static List<Professor> professores = new ArrayList();
	private static List<Disciplina> disciplinas = new ArrayList();
	private static List<Turma> turmas = new ArrayList();
	private static List<Aula> aulas = new ArrayList();
	
	private static List<int[]> horarios;

	private static final int[] DIAS = {1,2,3,4,5};
	private static final int[] HORARIOS = {1,2,3};
	
	public static Turma ler(String nome) {
		
		Turma turma = new Turma();
		try {
			
			abrirArquivo(nome);    
			
			String linha = leitor.readLine();
			
			while(linha!=null) {

				alocar(linha);
				linha = leitor.readLine();
			}
			
			distribuirAulas();
								
			fecharArquivo();
					    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		aulas.forEach(e->{
			System.out.println(e);
		});
		
		return turma;
	}
	
	private static void alocar(String linha) {
		
		String[] info = linha.split(";");
		Turma turma = new Turma(info[0],info[3]);
		Disciplina disciplina = new Disciplina(info[1]);
		Professor professor = new Professor(info[2]);
		
		professor = getProfessor(professor);
		turma = getTurma(turma);
		disciplina = getDisciplina(disciplina);
		
		Aula aula = new Aula();
		aula.setProfessor(professor);
		aula.setDisciplina(disciplina);
		aula.setTurma(turma);
		aulas.add(aula);
		professor.setAulas(aula);
		
	}
	
	private static void distribuirAulas() {
		for(int j =0; j <DIAS.length; j++) {
			for(int i =0; i <HORARIOS.length; i++) {
				List<Professor> prof = profCopy();
				List<Turma> disc = turmaCopy();
				for(Aula a : aulas) {
					if(a.getHorarios() == (null)) {
						for(Professor professor: professores) {
							for(Turma turma: turmas) {
								if(prof.contains(a.getProfessor())&&disc.contains(a.getTurma())) {
									int[] h = {DIAS[j],HORARIOS[i]};
									a.setHorarios(h);
									prof.remove(professor);
									disc.remove(turma);
								} 
							}
						}
					
					}
				}
			}
		}
		
	}
	
	private static List<Turma> turmaCopy(){
		List<Turma> turma = new ArrayList<Turma>();
		turmas.forEach(e->{
			turma.add(e);
		});
		return turma;
	}
	
	private static List<Professor> profCopy(){
		List<Professor> prof = new ArrayList<Professor>();
		for(Professor professor: professores){
			prof.add(professor);
		}
		return prof;
	}
	
	private static Turma getTurma(Turma disciplina) {
		if(!disciplinas.isEmpty()) {
			if(naoContemTurma(disciplina.getId())) {
				turmas.add(disciplina);
			}else {
				disciplina = getTurmaById(disciplina.getId());
			}
			return disciplina;
		}
		turmas.add(disciplina);
		return disciplina;
	}
	
	private static Turma getTurmaById(String id) {
		for(Turma p : turmas) {
			if(p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	private static boolean naoContemTurma(String nome) {
		for(Turma p : turmas) {
			if(p.getId().equals(nome)) {
				return false;
			}
		}
		return true;
	}
	
	private static Disciplina getDisciplina(Disciplina disciplina) {
		if(!disciplinas.isEmpty()) {
			if(naoContemDisciplina(disciplina.getNome())) {
				disciplinas.add(disciplina);
			}else {
				disciplina = getDisciplinaByName(disciplina.getNome());
			}
			return disciplina;
		}
		disciplinas.add(disciplina);
		return disciplina;
	}
	
	private static Disciplina getDisciplinaByName(String nome) {
		for(Disciplina p : disciplinas) {
			if(p.getNome().equals(nome)) {
				return p;
			}
		}
		return null;
	}
	
	private static boolean naoContemDisciplina(String nome) {
		for(Disciplina p : disciplinas) {
			if(p.getNome().equals(nome)) {
				return false;
			}
		}
		return true;
	}
	
	private static Professor getProfessor(Professor professor) {
		if(!professores.isEmpty()) {
			if(naoContemProfessor(professor.getNome())) {
				professores.add(professor);
				return professor;
			}
				professor = getProfessorByName(professor.getNome());
				return professor;
		}
		professores.add(professor);
		return professor;
	}
	
	private static Professor getProfessorByName(String nome) {
		for(Professor p : professores) {
			if(p.getNome().equals(nome)) {
				return p;
			}
		}
		return null;
	}
	
	private static boolean naoContemProfessor(String nome) {
		for(Professor p : professores) {
			if(p.getNome().equals(nome)) {
				return false;
			}
		}
		return true;
	}

	private static void abrirArquivo(String nome) throws IOException{
		file = new FileReader(nome);
		leitor = new BufferedReader(file);
		
	}
	
	private static void fecharArquivo()  throws IOException{
		leitor.close();
	    file.close();
	}
	
}
