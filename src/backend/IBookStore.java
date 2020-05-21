package backend;

import java.util.ArrayList;
import java.util.HashMap;

import components.Cart;
import components.IBook;
import components.IPerson;
import components.IUser;
import javafx.util.Pair;

public interface IBookStore {
	
	public IUser logIn(String username, String password);
	public boolean signUp(IUser user);
	public boolean updateSettings(IUser user);
	public void logOut();
	
	public ArrayList<String>getdemandUsers();
	public boolean acceptUser(ArrayList<String> usernames);
	public boolean rejectUser(ArrayList<String> usernames);
	public void demandUser();
	
	public ArrayList<IBook> search(HashMap<String, Pair<String, String>> filters);
	public Cart addBookToCart(IBook newBook);
	public Cart removeBookFromCart(IBook newBook);
	public Cart removeBookFromCart(int index);
	public void clearCart();
	public boolean chechOut(String card, String date);
	
	
	
	public boolean addNewBook(IBook book);
	public boolean addNewBook(HashMap<String, String>attributes);
	public boolean updateBook(String ISBN, HashMap<String, String> attributes);
	
	
	public boolean placeOrder(String ISBN, int amount);
	public HashMap<String, String> getOrders();
	public boolean confirmOrders(ArrayList<String>ISBNs);
	
	IUser getCurrentUser();
	
	public boolean addNewPublisher(IPerson newPublisher);
	
	
	
	
	
}
