package components;

import java.util.ArrayList;

public class Cart {

	private ArrayList<IBook> books;
	
	public Cart() {
		// TODO Auto-generated constructor stub
		this.books = new ArrayList<>();
	}
	/**
	 * @param book to be added
	 */
	public void add_items(IBook book) {
		this.books.add(book);
	}
	/**
	 * @param index of item.
	 * @return the price of this item.
	 */
	public int get_item_price(int index) {
		
		if(index < 0 || this.books.isEmpty()) {
			return 0;
		}
		return this.books.get(index).getPrice();
	}
	
	/**
	 * @return the total price of all items.
	 */
	public int get_total_price() {
		int total = 0;
		
		for(IBook book: this.books) {
			total += book.getPrice();
		}
		return total;
	}
	
	/**
	 * @param index of item to be removed.
	 * @return true if the item is removed successfully.
	 */
	public boolean remove_item(IBook book) {
		
		if(this.books.isEmpty()) {
			return false;
		}
		this.books.remove(book);
		return true;
	}
	
	/**
	 * @param index of item to be removed.
	 * @return true if the item is removed successfully.
	 */
	public boolean remove_item(int index) {
		
		if(index < 0 || this.books.isEmpty()) {
			return false;
		}
		
		this.books.remove(index);
		return true;
	}
	
	/**
	 * @return the books
	 */
	public ArrayList<IBook> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(ArrayList<IBook> books) {
		this.books = books;
	}
	
	/**
	 * clear the cart from books
	 */
	public void clear() {
		
		this.books.clear();
	}
}
