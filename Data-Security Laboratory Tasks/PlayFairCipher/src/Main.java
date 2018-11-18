import com.PlayFairAlgorithm;

public class Main {

	public static final String INPUTPATH = "D:\\MyWorkspace\\MyWorkspace-Eclipse-Windows\\PlayFairCipher\\input_output\\input.txt";
	public static final String KEY = "ANA";
	public static final String OUTPUTPATH = "D:\\MyWorkspace\\MyWorkspace-Eclipse-Windows\\Vigenere\\input_output\\output.txt";

	public static void main(String[] args) {
		PlayFairAlgorithm p = new PlayFairAlgorithm(INPUTPATH,OUTPUTPATH,KEY);
		p.encodeVigenere();
		
	}

}
