package Testes;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exe2.SecureClass;

public class SecureClassTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	
	@Before
	public void setUpStreams(){
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUpStreams(){
		System.setOut(null);
	}
	
	@Test
	public void NomeDoArquivoProblematico() {
		SecureClass vc = new SecureClass();
		
		String FILENAME = "Teste?..Nome";
		vc.secureMethod(FILENAME);
		
		assertEquals("O nome do arquivo contem caracteres problematicos, por favor, mude o nome.",outContent.toString() );
		
	}
	
	@Test
	public void ImputDoOperadorIncorreto() {
		SecureClass vc = new SecureClass();
		String FILENAME = "TesteNome.txt";
		
		String input = " h\n ";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    vc.secureMethod(FILENAME);
	    
	    assertEquals("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, W para escrever em um arquivo>? " +  "Opcao invalida!", outContent.toString());
	    
	}
	
	@Test
	public void NomeIncorretoDoArquivo() {
		SecureClass vc = new SecureClass();
		String FILENAME = "NomeIncorreto";
		
	    vc.secureMethod(FILENAME);
	    
	    assertEquals("O arquivo nao existe.", outContent.toString());
	    
	}

}
