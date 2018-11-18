package com;

import java.util.ArrayList;

import handler.TextHandler;

public class VigenereAlghorithm {

	private String inputText;
	private char[] alphabetArray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	private String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private char[][] matrix;
	private String key;

	public VigenereAlghorithm(String inputFile,String outputFile,String key) {
		this.inputText = TextHandler.readFromFile(inputFile).toLowerCase().replaceAll("\\s+", "");
		this.matrix = new char[26][26];
		this.key = key.toLowerCase().replaceAll("\\s+", "");
		TextHandler.writeInFile(encodeVigenere(), outputFile);
		pululateMatrix();
	}

	private void pululateMatrix() {
		for (int i = 0; i < alphabetArray.length; i++) {
			for (int j = 0; j < alphabetArray.length; j++) {
				matrix[i][j] = alphabetArray[(j + i) % 26];
			}
		}

		System.out.println("Matricea Vigenere este: ");
		for (int i = 0; i < alphabetArray.length; i++) {
			for (int j = 0; j < alphabetArray.length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public String encodeVigenere(){
		String result = "";
		for(int i=0;i<inputText.length();i++) {
			result+= matrix[alphabet.indexOf(inputText.charAt(i))][alphabet.indexOf((key.charAt(i%key.length())))];
		}
		System.out.println();
		System.out.println("Vigenere cipher text: ");
		System.out.println(result);
		return result;
	}
	
	public String decodeVigenere(){
		String result = "";
		for(int i=0;i<inputText.length();i++) {
			result+= matrix[alphabet.indexOf(key.charAt(i%key.length()))][alphabet.indexOf((inputText.charAt(i)))];
		}
		System.out.println();
		System.out.println("Plain text: ");
		System.out.println(result);
		return result;
	}
	
	
	

}
