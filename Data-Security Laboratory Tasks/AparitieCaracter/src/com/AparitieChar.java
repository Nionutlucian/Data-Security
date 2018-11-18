package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AparitieChar {

	private String alphabetString = "abcdefghijklmnopqrstuvwxyz";
	private ArrayList<Character> alphabet;
	private ArrayList<Integer> countAlph;
	private String inputText;
	private char[] inputTextCharArray;

	public AparitieChar(String inputFile) {
		this.inputText = readFromFile(inputFile).toLowerCase().replaceAll("\\s+","");
		this.alphabet = new ArrayList<>();
		this.countAlph = new ArrayList<>();
		this.inputTextCharArray = this.inputText.toCharArray();
		populateArray();
	}

	private void populateArray() {
		char arr[] = alphabetString.toCharArray();
		for (char c : arr) {
			alphabet.add(c);
		}

		for (int i = 0, j = 0; j < 26; j++) {
			countAlph.add(i);
		}
	}

	public void countApp() {
		for(char c : inputTextCharArray) {
			int x = countAlph.get(alphabetString.indexOf(c));
			x++;
			countAlph.set(alphabetString.indexOf(c), x);
		}
		for(int i = 0;i < alphabet.size();i++) {
			System.out.println(alphabet.get(i) + " : " + countAlph.get(i));
		}
	}
	
	private String readFromFile(String inputFile) {
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
	

}
