package Testes;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
	
	@Test
	public void ImputDoOperadorIncorreto() {
		VulnerableClass vc = new VulnerableClass();
		String FILENAME = "TesteNome.txt";
		
		String input = "h";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);

	    vc.vulnerableMethod(FILENAME);
	    
	}

}
