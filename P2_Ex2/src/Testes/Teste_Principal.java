package Testes;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import exe2.VulnerableClass;

public class Teste_Principal {

	@Test
	public void NomeDoArquivoProblematico() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		
		VulnerableClass vc = new VulnerableClass();
		
		String FILENAME = "Teste?..Nome";
		vc.vulnerableMethod(FILENAME);
		
		assertEquals("O nome do arquivo contem caracteres problematicos, por favor, mude o nome.",outContent.toString() );
	}

}