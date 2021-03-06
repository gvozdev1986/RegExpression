package by.gvozdev.regextraining;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Gvozdev Alexander May 7, 2018
 */

public class IpEmailChecker {

	private static Pattern emailPattern, ipPattern, telPattern;
	private static Matcher matcher;
	
	/**
	 * Create regular expression
	 */
	private static final String EMAIL_REGEX_PATTERN = "^[-._a-z0-9]+@(?:[a-z0-9][-a-z0-9]+\\.)+[a-z]{2,6}$";  
	private static final String IP_REGEX_PATTERN = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$";
	private static final String TEL_BY_REGEX_PATTERN = "^((8|\\+3)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$"; 

	/**
	 *  Create rules in constructor
	 */
	public IpEmailChecker() {
		emailPattern = Pattern.compile(EMAIL_REGEX_PATTERN);
		ipPattern = Pattern.compile(IP_REGEX_PATTERN);
		telPattern = Pattern.compile(TEL_BY_REGEX_PATTERN);
	}

	/**
	 * Create rule to formal parameters
	 * @param email
	 * @return boolean (true/false)
	 */
	public boolean checkEmail(String email) {
		matcher = emailPattern.matcher(email);
		return matcher.matches();
	}
	
	/**
	 * Create rule to formal parameters
	 * @param ip
	 * @return boolean (true/false)
	 */
	public boolean checkIp(String ip) {
		matcher = ipPattern.matcher(ip);
		return matcher.matches();
	}
	
	/**
	 * Create rule to formal parameters for telephones number in Belarus.
	 * @param tel
	 * @return
	 */
	public boolean checkTel(String tel) {
		matcher = telPattern.matcher(tel);
		return matcher.matches();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Create new class instance 
		 */
		IpEmailChecker emailIpChecker = new IpEmailChecker();
		System.out.println(emailIpChecker.checkEmail("a.gvozdev@outlook.com")); //true
		System.out.println(emailIpChecker.checkIp("127.0.0.1")); //true
		System.out.println(emailIpChecker.checkTel("+375291473624")); //true
	}

}
