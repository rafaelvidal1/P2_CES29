package exe2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecureClass {
	public void secureMethod(String FILENAME){

		Pattern pattern = Pattern.compile("[^A-Za-z0-9._]");
		Matcher matcher = pattern.matcher(FILENAME);

		if(matcher.find()){
			System.out.print("O nome do arquivo contem caracteres problematicos, por favor, mude o nome.");
			return;
		}
		
		File file = new File(FILENAME);
		if(!file.exists()){
			System.out.print("O arquivo nao existe.");
			return;
		}

		Scanner console = new Scanner(System.in);

		System.out.print("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, W para escrever em um arquivo>? ");

		String opr=null;
		try{
			opr = console.next();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		if(opr==null){
			System.out.print("Opcao invalida!");
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
				System.out.print("Escreva algo: ");
				linha = console.next();
				
				if(linha.length() > 200){
					System.out.print("String fora dos limites.");
					return;
				}
				
				buffWrite.append(linha + "\n");
				buffWrite.close();

			}catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.print("Opcao invalida!");
			return;
		}
		console.close();
	}

	public static void main(String[] args) {
		SecureClass vc = new SecureClass();
		String FILENAME = "TesteNome.txt";
		
	    vc.secureMethod(FILENAME);
	    
	}

}
