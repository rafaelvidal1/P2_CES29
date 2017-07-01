package exe2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
		
		while (true) {
		    Scanner console = new Scanner(System.in);
		    System.out.print("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, "
		    		+ "W para escrever em um arquivo>? ");
			
		    String opr= console.nextLine();
		    console.close();
			
		    switch (opr){
		    
		    case "R":
				BufferedReader br = null;
				FileReader fr = null;
				
				try {

					fr = new FileReader(FILENAME);
					br = new BufferedReader(fr);
					br = new BufferedReader(new FileReader(FILENAME));

					while (br.readLine() != null) {
						String sCurrentLine = br.readLine();
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
					linha = console.nextLine();
					console.close();
					buffWrite.append(linha + "\n");
					     
				}catch (IOException e) {
					e.printStackTrace();
				} 
				break;
			default:
				System.out.println("Digite uma opcao valida!\n");
		    }
		}
	}
}
