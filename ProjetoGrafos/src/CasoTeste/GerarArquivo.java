package CasoTeste;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import Grafo.Turma;

public class GerarArquivo {
	private static OutputStream file;
	private static BufferedReader leitor;
	
	public static void criar(String nome) {
		
		 try {
             OutputStream output = new FileOutputStream(nome);
             String aulas = getAulas();
             byte[] bytes = aulas.getBytes();
             int count = bytes.length;

             while (count >= 0) {

                    output.write(bytes);

                    count--;
             }
             output.close();
      } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
      }

	}
	
	private static String getAulas() {
		
		String[] professores = {"Barone", "Eveline", "Guta", "Hugo","JoãoC","João","Juliana", "Jose Wilson", "Tadeu", "Rommel", "Roberto", "Sandro"};
		String[] turmas = {"1","2","3","4"};
		String[] periodo = {"1","2","3","4"};
		String[] disciplinas = {"AED","DIW","TIS","FS","Lab","IC","AED II","LabII","TIS II","Modular","Modelagem","AC","TIS III","Lab III","MD","SO","Requisitos","TIS IV", "Grafos", "IHC", "Pojeto", "Lab IV", "Banco de dados"};
		
		String aulas =	turmas[3]+";"+professores[10]+";"+disciplinas[0]+";"+periodo[0]+"\n";
			 	aulas +=turmas[3]+";"+professores[9]+";"+disciplinas[1]+";"+periodo[0]+"\n";
			 	aulas +=turmas[3]+";"+professores[9]+";"+disciplinas[2]+";"+periodo[0]+"\n";
			 	aulas +=turmas[3]+";"+professores[2]+";"+disciplinas[3]+";"+periodo[0]+"\n";
			 	aulas +=turmas[3]+";"+professores[10]+";"+disciplinas[4]+";"+periodo[0]+"\n";
			 	aulas +=turmas[3]+";"+professores[4]+";"+disciplinas[5]+";"+periodo[0]+"\n";
			 	aulas +=turmas[3]+";"+professores[1]+";"+disciplinas[6]+";"+periodo[0]+"\n";
			 	aulas +=turmas[2]+";"+professores[1]+";"+disciplinas[7]+";"+periodo[1]+"\n";
			 	aulas +=turmas[2]+";"+professores[3]+";"+disciplinas[8]+";"+periodo[1]+"\n";
			 	aulas +=turmas[2]+";"+professores[3]+";"+disciplinas[9]+";"+periodo[1]+"\n";
			 	aulas +=turmas[2]+";"+professores[8]+";"+disciplinas[10]+";"+periodo[1]+"\n";
			 	aulas +=turmas[2]+";"+professores[7]+";"+disciplinas[11]+";"+periodo[1]+"\n";
			 	aulas +=turmas[1]+";"+professores[1]+";"+disciplinas[12]+";"+periodo[2]+"\n";
			 	aulas +=turmas[1]+";"+professores[11]+";"+disciplinas[12]+";"+periodo[2]+"\n";
		
		return aulas; 
	}

	
}
