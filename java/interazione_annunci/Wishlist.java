package interazione_annunci;

import java.util.ArrayList;
import java.util.List;

import annunci.Annuncio;
public class Wishlist<T>{

		List<T> items;

		public Wishlist() {
			items = new ArrayList<T>();
		}

		public void addItem(T item) {
			items.add(item);
		}

		public void deleteItem(int id) {
			/*
			 * for(T it: items) { 
			 * 	if(it.equals(item)) { 
			 * 		items.remove(it); 
			 * 		break; } }
			 */
			items.remove(id);
		}
		
		public void deleteItem2(int id) {
			if(items.size()>0) {
				for(int i=0;i<items.size();i++) {
					Annuncio x =(Annuncio) items.get(i);
					int s=x.getId();
					if(id==s) {
						items.remove(i);
					}
				}
			}
		}
		
		public List<T> getItems() {
			return items;
		}

		public void deleteItems() {
			items.clear();
		}
		
		public boolean isIn(int id) {
			if(items.size()>0) {
				for(int i=0;i<items.size();i++) {
					Annuncio x =(Annuncio) items.get(i);
					int s=x.getId();
					if(id==s) {
						return true;
					}
				}
			}
			return false;
		}
}

	

