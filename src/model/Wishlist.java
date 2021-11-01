package model;

import java.util.ArrayList;
import java.util.List;
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

		public List<T> getItems() {
			return items;
		}

		public void deleteItems() {
			items.clear();
		}
}

	

