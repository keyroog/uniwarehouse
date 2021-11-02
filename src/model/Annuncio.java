package model;

import java.sql.Blob;
import java.time.LocalDate;

public class Annuncio {
	
	
	private int idannuncio;
	private String nomelibro;
	private LocalDate datainserimento;
	private String descrizione;
	private int matricola;
	private int fkannuncio;
	private String price;
	private String nome;
	private String cognome;
	private String dipartimento;
	private Blob image;
	
	
	
	public void setPrice(String s) {
		price = s;
	}
	
	
	public void setNome(String s) {
		nome = s;
	}
	
	public void setCognome(String s) {
		cognome = s;
	}
	
	public void setId(int i) {
		idannuncio=i;
	}
	
	public void setImage(Blob img) {
		image = img;
	}
	public void setNomeLibro(String libro) {
		nomelibro=libro;
	}
	
	public void setDate() {
		datainserimento = LocalDate.now();
	}
	
	public void setDate(LocalDate d) {
		datainserimento = d;
	}
	
	public void setDescrizione(String desc) {
		descrizione = desc;
	}
	
	public void setMatricola(int i) {
		matricola=i;
	}
	
	
	public void setFkannuncio(int i) {
		fkannuncio=i;
	}
	
	public int getId() {
		return idannuncio;
	}
	
	public Blob getImage() {
		return image;
	}
	
	public String getNomeLibro() {
		return nomelibro;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	
	public String getDate() {
		return datainserimento.toString();
	}
	
	public int getMatricola() {
		return matricola;
	}
	
	public int getFkannuncio() {
		return fkannuncio;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDipartimento() {
		return dipartimento;
	}
	
	public void setDipartimento(String dip) {
		dipartimento=dip;
	}
	
	public String getCognome() {
		return cognome;
	}
	
}
