package algorithms.task1;

public class CaesarAlgorithm {
	
	private char[] alphabetUpperCase = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
										'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private char[] alphabetLowerCase = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
										'n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private String plainText;
	private String cipherText;
	private char[] plainTextToCharArray;
	private int key;
	
	public CaesarAlgorithm(String plainText,int key) {
		this.plainText = plainText;
		this.key = key;
		this.cipherText = new String();
	}
	
	public String encrypt() {
		int x = 0;
		plainTextToCharArray = plainText.toCharArray();
			
		for(int i = 0;i < plainTextToCharArray.length;i++) {
			if(isLetter(plainTextToCharArray[i])) {
				x = indexOfChar(alphabetUpperCase, alphabetLowerCase, plainTextToCharArray[i]);
				if(isUpperCase(plainTextToCharArray[i])) {
					if(x < alphabetUpperCase.length - key) {
						plainTextToCharArray[i] = alphabetUpperCase[x+key]; 
					}else {
						plainTextToCharArray[i] = alphabetUpperCase[x-(alphabetUpperCase.length - key)];
					}
				}else {
					if(x < alphabetLowerCase.length - key) {
						plainTextToCharArray[i] = alphabetLowerCase[x+key]; 
					}else {
						plainTextToCharArray[i] = alphabetLowerCase[x-(alphabetUpperCase.length - key)];
					}
				}
			}
		}
		cipherText = charArrayToString(plainTextToCharArray);
		return cipherText;
	}
	
	public String decrypt() {
		int x = 0;
		plainTextToCharArray = plainText.toCharArray();
		
		for(int i = 0;i < plainTextToCharArray.length;i++) {
			if(isLetter(plainTextToCharArray[i])) {
				x = indexOfChar(alphabetUpperCase, alphabetLowerCase, plainTextToCharArray[i]);
				if(isUpperCase(plainTextToCharArray[i])) {
					if(x >= key) {
						plainTextToCharArray[i] = alphabetUpperCase[x-key]; 
					}else {
						plainTextToCharArray[i] = alphabetUpperCase[x+(alphabetUpperCase.length - key)];
					}
				}else {
					if(x >= key) {
						plainTextToCharArray[i] = alphabetLowerCase[x-key]; 
					}else {
						plainTextToCharArray[i] = alphabetLowerCase[x+(alphabetUpperCase.length - key)];
					}
				}
			}
		}
		cipherText = charArrayToString(plainTextToCharArray);
		return cipherText;
	}
	
	private boolean isLetter(char l) {
		if(Character.isLetter(l)) {
			return true;
		}else {
			return false;
		}
	}
	
	private int indexOfChar(char[] alphabetUpperCase,char[] alphabetLowerCase, char c) {
		for(int i = 0;i < alphabetUpperCase.length;i++) {
			if(c == alphabetUpperCase[i] || c == alphabetLowerCase[i]) {
				return i;
			}
		}
		return 0;
	}
	
	private String charArrayToString(char[] charArray) {
		String result = new String();
		for(char c : charArray) {
			result+=c;
		}
		return result;
	}
	
	private boolean isUpperCase(char l) {
		if(Character.isUpperCase(l)) {
			return true;
		}else {
			return false;
		}
	}
}
