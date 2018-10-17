package main;
import algorithms.task1.CaesarAlgorithm;
import handler.TextHandler;

public class MainClass {
	final static int CAESARKEY = 3;
	final static String PLAINTEXTFILE= "/root/eclipse-workspace/Data-Security Laboratory Tasks/inputs_outputs/PlainTextCaesar.txt"; 
	final static String CIPHERTEXTFILE= "/root/eclipse-workspace/Data-Security Laboratory Tasks/inputs_outputs/CipherTextCaesar.txt"; 
	final static String DECRYPTEDTEXTFILE= "/root/eclipse-workspace/Data-Security Laboratory Tasks/inputs_outputs/DecryptedTextCaesar.txt"; 

	public static void main(String[] args) {
		String plainText = TextHandler.readFromFile(PLAINTEXTFILE);
		String cipherText = TextHandler.readFromFile(CIPHERTEXTFILE);
		CaesarAlgorithm caesarEncrypt = new CaesarAlgorithm(plainText,CAESARKEY);
		CaesarAlgorithm caesarDecrypt = new CaesarAlgorithm(cipherText,CAESARKEY);
		TextHandler.writeInFile(caesarEncrypt.encrypt(), CIPHERTEXTFILE);
		TextHandler.writeInFile(caesarDecrypt.decrypt(), DECRYPTEDTEXTFILE);
	}

}
