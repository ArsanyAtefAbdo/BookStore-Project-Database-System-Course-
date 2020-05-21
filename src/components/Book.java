package components;

import java.util.ArrayList;
import java.util.HashMap;

import components.IBook;

public class Book implements IBook {
	
	public Book() {
		this.authors = new ArrayList<>();
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}

	public int getISBN() {
		return ISBN;
	}
	
	public void setISBN(int iSBN) {
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
	
	private int ISBN;
	
	private String title;
	
	private String publisher_name;
	
	private String publication_year;
	
	private int price;
	
	private int No_Of_Books;
	
	private int request_amount;
	
	/**
	 * @return the request_amount
	 */
	public int getRequest_amount() {
		return request_amount;
	}

	/**
	 * @param request_amount the request_amount to set
	 */
	public void setRequest_amount(int request_amount) {
		this.request_amount = request_amount;
	}

	private ArrayList<String> authors;

	@Override
	public void addAuthor(String author) {
		// TODO Auto-generated method stub
		this.authors.add(author);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("ISBN : " + this.ISBN);
		sb.append(" title : " + this.title);
		sb.append(" publisher_name : " + this.publisher_name);
		sb.append(" publication_year : " + this.publication_year);
		sb.append(" price : " + this.price);
		sb.append(" No_Of_Books : " + this.No_Of_Books);
		sb.append(" category : " + this.category);
		sb.append(" authors : { ");
		for(String s : authors) {
			sb.append(s + ", ");
		}
		sb.replace(sb.length() - 2, sb.length() - 1, "}");
		return sb.toString();
	}

	@Override
	public HashMap<String, String> getAttributes() {
		// TODO Auto-generated method stub
		HashMap<String, String>attributes = new HashMap<String, String>();
		attributes.put("ISBN", ""+ISBN);
		attributes.put("title",title);
		attributes.put("publisher_name", publisher_name);
		attributes.put("publication_year", publication_year);
		attributes.put("price", ""+price);
		attributes.put("No_Of_Books", ""+No_Of_Books);
		attributes.put("category", ""+category);
		String au = "";
		for(String s : authors) {
			au += s + ",";
		}
		attributes.put("authors",au.substring(0, au.length()-1));
		return attributes;
	}
}
