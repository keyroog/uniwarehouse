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
	
	public static void main(String[] args) throws Exception{
		System.out.print(checkNome(""));
	}

}
