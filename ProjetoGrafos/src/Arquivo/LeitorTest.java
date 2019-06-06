package Arquivo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CasoTeste.GerarArquivo;

class LeitorTest {

	@Test
	void test() {
		Leitor leitor = new Leitor();
		leitor.ler("turma.txt");
	}

}
