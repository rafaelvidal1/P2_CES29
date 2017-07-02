package P2EXE4.e4;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

import junit.framework.TestCase;

public class VulnerableClassTest extends TestCase {
	
	public void testNomeDoArquivoProblematico() {
		
		vulnerableClass vc = new vulnerableClass();
		
		String FILENAME = "Teste?..Nome";
		
		assertEquals("O nome do arquivo contem caracteres problematicos, por favor, mude o nome.",vc.vulnerableMethod(FILENAME,""));
		
	}
	

	public void testInputDoOperadorIncorreto() {
		vulnerableClass vc = new vulnerableClass();
		String FILENAME = "TesteNome.txt";		
		String input = "h";
	    
	    assertEquals("Digite uma opcao valida!",vc.vulnerableMethod(FILENAME,input));
	    
	}
	
	public void testInputCorretoRead(){
		vulnerableClass vc = new vulnerableClass();
		String FILENAME = "TesteNome.txt";		
		String input = "R";
	    
	    assertEquals(null,vc.vulnerableMethod(FILENAME,input));
	}
	
	public void testInputCorretoWrite(){
		vulnerableClass vc = new vulnerableClass();
		String FILENAME = "TesteNome.txt";		
		String input = "W";
	    
	    assertEquals(null,vc.vulnerableMethod(FILENAME,input));
	}
	
	public void testInputCorretoFim(){
		vulnerableClass vc = new vulnerableClass();
		String FILENAME = "TesteNome.txt";		
		String input = "E";
	    
	    assertEquals(null,vc.vulnerableMethod(FILENAME,input));
	}
	
	public void testNullInput(){
		vulnerableClass vc = new vulnerableClass();
		String FILENAME = "TesteNome.txt";		
		String input = null;
	    
	    assertEquals("Problema com o input",vc.vulnerableMethod(FILENAME,input));
	}
}
