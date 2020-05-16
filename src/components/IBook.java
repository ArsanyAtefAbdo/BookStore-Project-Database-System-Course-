package components;

import java.util.ArrayList;

public interface IBook {
	
	public enum cat {Science, Art, Religion, History, Geography}

	public String getISBN();
	
	public void setISBN(String iSBN);
	
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
}
