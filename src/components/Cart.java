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
		
		book.setRequest_amount(book.getRequest_amount() + 1);
		
		if(book.getRequest_amount() == 1) {
			this.books.add(book);

		}
		
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
			total += book.getPrice() * book.getRequest_amount();
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
		book.setRequest_amount(book.getRequest_amount() - 1);
		
		if(book.getRequest_amount() == 0) {
			this.books.remove(book);
		}
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
		IBook book = this.books.get(index);
		
		if(book.getRequest_amount() == 1) {
			this.books.remove(index);
		}else {
			book.setRequest_amount(book.getRequest_amount() - 1);
		}
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
	
	public ArrayList<String> getReport(){
		ArrayList<String> report = new ArrayList<>();
		for(IBook book : this.books) {
			String s = "book title : " + book.getTitle() + "   ";
			s = s + " book amount : " + book.getRequest_amount() + "   ";
			s = s + " book price : " +book.getPrice() + "   ";
			s = s + " total price : " + book.getPrice() * book.getRequest_amount();
			report.add(s);
		}
		return report;
		
	}
}
