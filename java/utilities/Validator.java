package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	public static String checkNome(String nome) throws Exception{
		Pattern p = Pattern.compile("^[a-zA-Z\\\\s]+");
		Matcher m = p.matcher(nome);
		if(!m.matches()) {
			throw new Exception("Invalid Name");
		}
		return nome;
	}
	
	public static String checkEmail(String email) throws Exception{
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(email);
		if(!m.matches()) {
			throw new Exception("Invalid Email");
		}
		return email;
	}
	
	public static String checkPassword(String pass,String passr) throws Exception {
		Pattern p = Pattern.compile("[a-zA-Z0-9]{6,}");
		Matcher m = p.matcher(pass);
		if(!m.matches()) {
			throw new Exception("Invalid Password");
		}else if(!pass.equals(passr)){
			throw new Exception("Password don't match");
		}
		return pass;
	}
	
	public static int checkMatricola(String mat) throws Exception {
		Pattern p = Pattern.compile("[0-9]{10,10}");
		Matcher m = p.matcher(mat);
		if(!m.matches()) {
			throw new Exception("Invalid Matricola");
		}
		return Integer.parseInt(mat);
	}
	
	public static String checkCellulare(String cell) throws Exception {
		Pattern p = Pattern.compile("[0-9]{10,}");
		Matcher m = p.matcher(cell);
		if(!m.matches()) {
			throw new Exception("Invalid Phone Number");
		}
		return cell;
	}
}
