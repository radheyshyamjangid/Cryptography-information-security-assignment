import java.io.*;

public class VigenereCipher{

    public static boolean DEBUG = false;
    
    private String input;
    private String output;

    /**
       Relative frequencies of letters from A to Z in the English
       alphabet. (probability distribution: the sum is approximately 1)
    */
    private final double frequencies[] = {
	0.080, 0.015, 0.030, 0.040, 0.130, 0.020, 0.015, 0.060, 0.065, 0.005, 
	0.005, 0.035, 0.030, 0.070, 0.080, 0.020, 0.002, 0.065, 0.060, 0.090, 
	0.030, 0.010, 0.015, 0.005, 0.020, 0.002};
    

    public VigenereCipher(String in, String out){
	input = in;
	output = out;
    }

    public void encrypt(){
	
	// Read plaintext from input file
	String text = VigenereUtil.getTextFrom(input);

	// What is your key ?
	String key = VigenereUtil.getKeyFromPrompt();
	
	// Encrypting the text
	String cipher = VigenereUtil.fromCipherToPlain(text,key);
	System.out.println("Ciphertext:");
	System.out.println(cipher);

	// Outputing ciphertext to output file
	VigenereUtil.writeTextToFile(cipher,output);
    }

    public void decrypt(){

	// Reading ciphertext from input file
	String ciphertext = VigenereUtil.getTextFrom(input);

	// Find the key
	String key = findKey(ciphertext);
	System.out.println("Key: "+key);

	// Decryption 
	String plaintext = VigenereUtil.fromCipherToPlain(ciphertext,key);
	System.out.println("Plaintext:");
	System.out.println(plaintext);
	
	// Outputing plaintext to output file
	VigenereUtil.writeTextToFile(plaintext,output);
    }

    public String findKey(String ciphertext){

	int m = findKeyLength(ciphertext);
	String bestKey="";

	// implement your algorithm here

	return bestKey;
    }

    public int findKeyLength(String ciphertext){
	int k = 1;
	// to complete
	return k; 
    }

    public int findBestKeyForCeasarDecryption(String text,int keyLength,int orgCipherLength){
	int key=0;
	// to complete
	return key;
    }

    public double getIndexOfCoincidence(String ciphertext){
	double ic=0.0;
	// to complete
	return ic;
    }

    public static void usage(){
	String st="############"+"\n";
	st+=      "#  Usage:\n";
	st+=      "#\t Encryption: java Vigenere -e <plaintext> <ciphertext>"+"\n";
	st+=      "#\t Decryption: java Vigenere -d <ciphertext> <plaintext>"+"\n";
	st+=      "#\n############";
	System.out.println(st);
    }

    public static void main(String[] args) {

	

	if(args.length < 3){ usage(); return; }

	Vigenere vig = new Vigenere(args[1],args[2]);

	if      (args[0].equals("-e")) { vig.encrypt(); }
	else if (args[0].equals("-d")) { vig.decrypt(); }
	else                           { usage();       }
	
    }

}
