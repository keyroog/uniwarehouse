package model;

public class Utente {
	private String nome;
	private String cognome;
	private String email;
	private String tipolaurea;
	private String dipartimento;
	private int matricola;

	public Utente() {}
	
	public void setNome(String name) {
		nome=name;
	}
	
	public void setCognome(String cogn) {
		cognome=cogn;
	}
	
	public void  setEmail(String em) {
		email=em;
	}
	
	public void setDipartimento(String dip) {
		dipartimento =  dip;
	}
	
	public void setTipolaurea(String s) {
		tipolaurea = s;
	}
	
	public void setMatricola(int mat) {
		matricola=mat;
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getEmail() {
		return email;
	}

	public String getTipolaurea() {
		return tipolaurea;
	}
	
	public String getDipartimento() {
		return dipartimento;
	}
}
