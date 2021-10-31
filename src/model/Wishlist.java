package model;

import java.util.Collection;

public class Wishlist {
	private Collection<Annuncio> annunci;
	
	public Wishlist() {
		annunci=null;
	}
	
	public void addItem(Annuncio annuncio) {
		annunci.add(annuncio);
	}
	
	public void deleteItem(Annuncio annuncio) {
		annunci.remove(annuncio);
	}
	
	public Collection<Annuncio> getWishlist(){
		return annunci;
	}
	
}
