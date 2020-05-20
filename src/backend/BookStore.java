package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import components.Book;
import components.Cart;
import components.IBook;
import components.IBook.cat;
import components.IUser;
import components.User;
import javafx.util.Pair;

/**
 * 
 * @author Arsany
 * the main class which uses the other classes 
 */

public class BookStore implements IBookStore {
	
	private static String USERS_TABLE = "customers";
	private static String BOOKS_TABLE = "book";
	private static String ORDERS_TABLE = "orders";
	private static String CARTS_TABLE = "cart";
	private static String PUBLISHERS_TABLE = "publishers";
	private static String PROMOTE_TABLE = "promote";
	
	private IUser user;
	private IMySqlConnection mySqlConnection;
	private SimpleDateFormat ft;
	
	public BookStore() {
		mySqlConnection = MySqlConnection.getInstance();
		ft = new SimpleDateFormat ("yyyy-MM-dd");
	}

	@Override
	public IUser logIn(String username, String password) {
		// TODO Auto-generated method stub
		this.user = null;
		HashMap<String, Pair<String, String>> conditions = new HashMap<>();
		conditions.put("username", new Pair<String, String>("=", username));
		ResultSet result = this.mySqlConnection.search_item(USERS_TABLE, null, conditions);
		
		try {
			if(result.next() && result.getString("password").equals(password)) {
				this.user = new User(username, result.getString("shipAddress"), result.getString("phone"));
				this.user.setEmail(result.getString("email"));
				this.user.setFirst_name(result.getString("firstname"));
				this.user.setLast_name(result.getString("lastname"));
				this.user.setPassword(result.getString("password"));
				this.user.setIsManager("manager".equals(result.getString("type")));
				return this.user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		return this.user;
	}

	@Override
	public boolean signUp(IUser user) {
		// TODO Auto-generated method stub
		HashMap<String, Pair<String, String>> conditions = new HashMap<>();
		conditions.put("username", new Pair<String, String>("=", user.getName()));
		ResultSet result = this.mySqlConnection.search_item(USERS_TABLE, null, conditions);
		
		try {
			if(!result.next()) {
				
				if(this.mySqlConnection.insert_item(USERS_TABLE, user.getAttributes())) {
					this.user = user;
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		return false;
	}

	@Override
	public boolean updateSettings(IUser user) {
		// TODO Auto-generated method stub
		HashMap<String, Pair<String, String>> conditions = new HashMap<>();
		conditions.put("username", new Pair<String, String>("=", this.user.getName()));
		HashMap<String, String> attributes = user.getAttributes();
		//---------------------------
		if(mySqlConnection.update_item(USERS_TABLE, attributes, conditions)) {
			this.user = user;
			return true;
		}
		return false;
	}

	@Override
	public void demandUser() {
		// TODO Auto-generated method stub
		if(user.getIsManager()) {
			return;
		}
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put("username", user.getName());
		this.mySqlConnection.insert_item(PROMOTE_TABLE, attributes);
	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub
		this.clearCart();
		user = null;
		
	}

	@Override
	public Cart addBookToCart(IBook newBook) {
		// TODO Auto-generated method stub
		this.user.getCart().add_items(newBook);
		return this.user.getCart();
	}

	@Override
	public boolean chechOut(String card, String date) {
		// TODO Auto-generated method stub
		try {
			if(ft.parse(date).before(new Date())) {
				return false;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return false;
		}
		
		return this.checkOut();
	}

	@Override
	public void clearCart() {
		// TODO Auto-generated method stub
		this.user.getCart().clear();
		
	}

	@Override
	public Cart removeBookFromCart(IBook newBook) {
		// TODO Auto-generated method stub
		return this.user.getCart();
	}

	@Override
	public Cart removeBookFromCart(int index) {
		// TODO Auto-generated method stub
		this.user.getCart().remove_item(index);
		return this.user.getCart();
	}

	@Override
	public ArrayList<IBook> search(HashMap<String, Pair<String, String>> filters) {
		// TODO Auto-generated method stub
		ResultSet result = this.mySqlConnection.search_item(BOOKS_TABLE, null, filters);
		ArrayList<IBook>books = new ArrayList<IBook>();
		HashMap<String, IBook> map = new HashMap<>();
		
		try {
			while(result.next()) {
				String ISBN = result.getString("ISBN");
				if(!map.containsKey(ISBN)) {
					IBook book = new Book();
					book.setISBN(ISBN);
					book.setTitle(result.getString("title"));
					book.setPublisher_name(result.getString("publisher_name"));
					book.setPublication_year(result.getString("publication_year"));
					book.setPrice(result.getInt("price"));
					book.setNo_Of_Books(result.getInt("NoOfBooks"));
					book.setCategory(cat.valueOf(result.getString("category")));
					book.addAuthor(result.getString("author"));
					map.put(ISBN, book);
					books.add(book);
				}else {
					map.get(ISBN).addAuthor(result.getString("author"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			return new ArrayList<IBook>();
		}
		return books;
	}
	
	private boolean checkOut() {
		
		// need to disable auto commit.
		
		HashMap<String, String> attributes = new HashMap<>();
		HashMap<String, Pair<String, String>> conditions = new HashMap<>();
		
		for(IBook book : user.getCart().getBooks()) {
			
			conditions.clear();
			attributes.clear();
			conditions.put("ISBN", new Pair<String, String>(" = ", book.getISBN()));
			attributes.put("NoOfBooks", ""+(book.getNo_Of_Books()-book.getRequest_amount()));
			
			if(mySqlConnection.update_item(BOOKS_TABLE, attributes, conditions)) {
				attributes.clear();
				attributes.put("ISBN", book.getISBN());
				attributes.put("username", user.getName());
				attributes.put("date", ft.format(new Date()));
				attributes.put("NoOfBooks", ""+book.getRequest_amount());
				if(!mySqlConnection.insert_item(CARTS_TABLE, attributes)) {
					// error
				}
				
			}else {
				// error
			}
		}
		
		this.clearCart();
		return true;
	}
}
