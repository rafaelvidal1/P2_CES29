package P2EXE4.e4;

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

public class vulnerableClass {
	public String vulnerableMethod(String FILENAME,String in){ //Método principal

		Pattern pattern = Pattern.compile("[^A-Za-z0-9._]");
		Matcher matcher = pattern.matcher(FILENAME);

		if(matcher.find()){
			return "O nome do arquivo contem caracteres problematicos, por favor, mude o nome.";
		}

		String opr=in;

		if(opr==null){
			return "Problema com o input";
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
		case "W": 
			BufferedWriter buffWrite;

			try {
				buffWrite = new BufferedWriter(new FileWriter(FILENAME));
				String linha = "";
				System.out.println("Escreva algo: ");
				linha = "Linha teste";
				buffWrite.append(linha + "\n");
				System.out.println(buffWrite.toString());
				buffWrite.close();

			}catch (IOException e) {
				e.printStackTrace();
			}
		case "E":
			break;
		default:
			return "Digite uma opcao valida!";
		}
		return null;
	}

}
