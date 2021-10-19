package model;

import java.sql.Date;

public class Annuncio {
	
	
	private static int idannuncio=0;
	private String nomelibro;
	private Date datainserimento;
	private String descrizione;
	private int matricola;
	private String linkimage;
	
	public void setId() {
		idannuncio=idannuncio+1;
	}
	
	public void setNomeLibro(String libro) {
		nomelibro=libro;
	}
	
	public void setDate(Date now) {
		datainserimento= (Date) now.clone();
	}
	
	public void setDescrizione(String desc) {
		descrizione = desc;
	}
	
	public void setMatricola(Utente u) {
		matricola=u.getMatricola();
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
	
	public Date getDate() {
		return datainserimento;
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	
}
