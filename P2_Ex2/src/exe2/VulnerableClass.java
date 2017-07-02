package exe2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VulnerableClass {
	public void vulnerableMethod(String FILENAME){
		
		Pattern pattern = Pattern.compile("[^A-Za-z0-9._]");
		Matcher matcher = pattern.matcher(FILENAME);
		
		if(matcher.find()){
			System.out.print("O nome do arquivo contem caracteres problematicos, por favor, mude o nome.");
			return;
		}
		
		Scanner console = new Scanner(System.in);
		
		while (true) {
			
		    System.out.print("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, "
		    		+ "W para escrever em um arquivo, E para sair>? ");
			
		    String opr=null;
		    try{
		    	opr = console.next();
		    }catch(Exception e){
		    	System.out.println(e.getMessage());
		    }
		    
		    if(opr == null){
		    	return;
		    }
		    
		    switch (opr){
		    
		    case "R":
		    	BufferedReader br = null;
				FileReader fr = null;
				
				try {

					fr = new FileReader(FILENAME);
					br = new BufferedReader(fr);

					String sCurrentLine;

					br = new BufferedReader(new FileReader(FILENAME));

					while ((sCurrentLine = br.readLine()) != null) {
						System.out.println(sCurrentLine);
					}

				} catch (IOException e) {

					e.printStackTrace();

				}
				break;
		    case "W": 
		    	BufferedWriter buffWrite;
					  
				try {
					buffWrite = new BufferedWriter(new FileWriter(FILENAME));
					String linha = "";
					System.out.println("Escreva algo: ");
					linha = console.next();
					buffWrite.append(linha + "\n");
					buffWrite.close();
					     
				}catch (IOException e) {
					e.printStackTrace();
				}
				break;
		    case "E":
		    	console.close();
		    	return;
			default:
				System.out.println("Digite uma opcao valida!\n");
				break;
		    }
		}
	}
	
	public static void main(String[] args) {
		VulnerableClass vc = new VulnerableClass();
		
		String FILENAME = "TesteNome.txt";
		vc.vulnerableMethod(FILENAME);
	}

}
