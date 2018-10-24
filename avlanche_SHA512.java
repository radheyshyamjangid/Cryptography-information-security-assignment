
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class avalanche_SHA512 { 
	public static String encryptThisString(String input) 
	{ 
		try { 
			
			MessageDigest md = MessageDigest.getInstance("SHA-512"); 

			 
			byte[] messageDigest = md.digest(input.getBytes()); 

			 
			BigInteger no = new BigInteger(1, messageDigest); 

			 
			String hashtext = no.toString(16);  
			while (hashtext.length() < 32) { 
				hashtext = "0" + hashtext; 
			} 

			// return the HashText 
			return hashtext; 
		} 
 
		catch (NoSuchAlgorithmException e) { 
			throw new RuntimeException(e); 
		} 
	} 

	// Driver code 
	public static void main(String args[]) throws NoSuchAlgorithmException 
	{ 
 

		String s1 = "00011100011"; 
		System.out.println("\n" + s1 + " : " + encryptThisString(s1)); 

		String s2 = "00011100010"; 
		System.out.println("\n" + s2 + " : " + encryptThisString(s2));
	} 
} 
