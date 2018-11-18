package com;

import java.util.ArrayList;

import handler.TextHandler;

public class PlayFairAlgorithm {

	private String inputText;
	private String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private char[][] matrix;
	private String key;
	private char[] vector;

	public PlayFairAlgorithm(String inputFile, String outputFile, String key) {
		this.inputText = TextHandler.readFromFile(inputFile).toLowerCase().replaceAll("\\s+", "");
		this.matrix = new char[5][5];
		this.key = key.toLowerCase().replaceAll("\\s+", "");
		// TextHandler.writeInFile(encodeVigenere(), outputFile);
		this.vector = new char[25];
		populateVector();
	}

	private void populateVector() {

		boolean bool = false;
		for (int i = 0; i < vector.length; i++) {
			vector[i] = '.';
		}
		
		for (int i = 0; i < vector.length; i++) {
			if(i < key.length()) {
				if(!bool) {
				if(isInVector(key.charAt(i))) {
					vector[i] = key.charAt(i+1);
				}else {
					vector[i] = key.charAt(i);
				}
				}else {
					
				}
			}else {
				if(i == key.length()) {
					bool = true;
					i=0;
				}
				if(isInVector(alphabet.charAt(i))) {
					
				}else {
					vector[i] = alphabet.charAt(i);
				}
			}
		}

	}

	private boolean isInVector(char c) {
		for (int i = 0; i < vector.length; i++) {
			if (c == vector[i]) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

	public String encodeVigenere() {
		String result = "";
		for (int i = 0; i < inputText.length(); i++) {
			result += matrix[alphabet.indexOf(inputText.charAt(i))][alphabet.indexOf((key.charAt(i % key.length())))];
		}
		System.out.println();
		System.out.println("Vigenere cipher text: ");
		System.out.println(result);
		return result;
	}

	public String decodeVigenere() {
		String result = "";
		for (int i = 0; i < inputText.length(); i++) {
			result += matrix[alphabet.indexOf(key.charAt(i % key.length()))][alphabet.indexOf((inputText.charAt(i)))];
		}
		System.out.println();
		System.out.println("Plain text: ");
		System.out.println(result);
		return result;
	}

}
