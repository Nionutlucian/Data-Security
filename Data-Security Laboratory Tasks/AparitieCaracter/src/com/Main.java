package com;

public class Main {
	
	final static String PLAINTEXTFILE= "D:\\MyWorkspace\\MyWorkspace-Eclipse-Windows\\AparitieCaracter\\src\\input\\input.txt"; 
	
	public static void main(String args[]) {
		AparitieChar a = new AparitieChar(PLAINTEXTFILE);
		a.countApp();
	}
}
