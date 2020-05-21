package components;

import java.util.ArrayList;
import java.util.HashMap;

public interface IBook {
	
	public enum cat {Science, Art, Religion, History, Geography}

	public int getISBN();
	
	public void setISBN(int iSBN);
	
	public String getTitle();
	
	public void setTitle(String title);
	
	public String getPublisher_name();
	
	public void setPublisher_name(String publisher_name);
	
	public String getPublication_year();
	
	public void setPublication_year(String publication_year);
	
	public int getPrice();
	
	public void setPrice(int price);
	
	public int getNo_Of_Books();

	public void setNo_Of_Books(int no_Of_Books);
	
	public cat getCategory();

	public void setCategory(cat category);

	public ArrayList<String> getAuthors();

	public void setAuthors(ArrayList<String> authors);
	
	public void addAuthor(String author);
	
	/**
	 * @return the request_amount
	 */
	public int getRequest_amount();

	/**
	 * @param request_amount the request_amount to set
	 */
	public void setRequest_amount(int request_amount);
	
	public HashMap<String, String>getAttributes();
}
