package backend;

import java.util.ArrayList;
import java.util.HashMap;

import components.Cart;
import components.IBook;
import components.IUser;
import javafx.util.Pair;

public interface IBookStore {
	
	public IUser logIn(String username, String password);
	public boolean signUp(IUser user);
	public boolean updateSettings(IUser user);
	
	public void demandUser();
	
	public void logOut();
	
	public ArrayList<IBook> search(HashMap<String, Pair<String, String>> filters);
	
	public Cart addBookToCart(IBook newBook);
	
	public Cart removeBookFromCart(IBook newBook);
	
	public Cart removeBookFromCart(int index);
	
	public void clearCart();
	
	public boolean chechOut(String card, String date);
	
	
	
	
	
}
