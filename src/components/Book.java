package components;

import java.util.ArrayList;

import components.IBook;

public class Book implements IBook {

	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}

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
	
	public int getNo_Of_Books() {
		return No_Of_Books;
	}

	public void setNo_Of_Books(int no_Of_Books) {
		No_Of_Books = no_Of_Books;
	}
	
	public cat getCategory() {
		return category;
	}

	public void setCategory(cat category) {
		this.category = category;
	}
	
	private cat category;
	
	private String ISBN;
	
	private String title;
	
	private String publisher_name;
	
	private String publication_year;
	
	private int price;
	
	private int No_Of_Books;
	
	private ArrayList<String> authors;
}
