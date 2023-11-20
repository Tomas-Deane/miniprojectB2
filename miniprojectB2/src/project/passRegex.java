import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class passRegex {

	public static boolean validPassword(String password) {  // boolean return function to validate password based on parameters,
															// takes password as string as argument
		String string = password;							// must be at least 8 characters, must contain uppercase, lowercase letters,
															// at least 1 number and at least 1 special character
															// returns true if password is valid, false otherwise.
		final Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
		Matcher matcher = pattern.matcher(string);

		while (matcher.find()) {
			return true;
		} 
		return false;
	}
}