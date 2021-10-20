package model;
ciao antonio

import java.time.LocalDate;

public class Annuncio {
	
	
	private static int idannuncio=0;
	private String nomelibro;
	private LocalDate datainserimento;
	private String descrizione;
	private int matricola;
	private String linkimage;
	
	public void setId() {
		idannuncio=idannuncio+1;
	}
	
	public void setNomeLibro(String libro) {
		nomelibro=libro;
	}
	
	public void setDate() {
		datainserimento = LocalDate.now();
	}
	
	public void setDescrizione(String desc) {
		descrizione = desc;
	}
	
	public void setMatricola(int i) {
		matricola=i;
	}
	
	public void setImage(String link) {
		linkimage = link;
	}
	
	public int getId() {
		return idannuncio;
	}
	
	public String getNomeLibro() {
		return nomelibro;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public String getImage() {
		return linkimage;
	}
	
	public String getDate() {
		return datainserimento.toString();
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	
}
