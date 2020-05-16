package components;

import components.IBook;

public class Book implements IBook {
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPublisher_name() {
		return publisher_name;
	}
	
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
	
	public String getPublication_year() {
		return publication_year;
	}
	
	public void setPublication_year(String publication_year) {
		this.publication_year = publication_year;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getNoOfBooks() {
		return NoOfBooks;
	}
	
	public void setNoOfBooks(int noOfBooks) {
		NoOfBooks = noOfBooks;
	}
	
	public enum category {Science, Art, Religion, History, Geography}
	
	private String ISBN;
	
	private String title;
	
	private String publisher_name;
	
	private String publication_year;
	
	private int price;
	
	private int NoOfBooks;
}
