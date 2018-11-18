import com.VigenereAlghorithm;

public class Main {

	public static final String INPUTPATH = "D:\\MyWorkspace\\MyWorkspace-Eclipse-Windows\\Vigenere\\input_output\\input.txt";
	public static final String KEY = "ANA";
	public static final String OUTPUTPATH = "D:\\MyWorkspace\\MyWorkspace-Eclipse-Windows\\Vigenere\\input_output\\output.txt";

	public static void main(String[] args) {
		VigenereAlghorithm v = new VigenereAlghorithm(INPUTPATH,OUTPUTPATH,KEY);
		//v.encodeVigenere();
		v.decodeVigenere();
	}

}
