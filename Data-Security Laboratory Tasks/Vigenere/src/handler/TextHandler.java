package handler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TextHandler {

	public static String readFromFile(String inputFile) {
		String plainText = new String();
		try(BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String sCurrentLine;
			while((sCurrentLine = br.readLine()) != null) {
				plainText+=sCurrentLine;
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return plainText;
	}
	
	public static void writeInFile(String cipherText,String outputFile) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(outputFile, "UTF-8");
			writer.println(cipherText);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}