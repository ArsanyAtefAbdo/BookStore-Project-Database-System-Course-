package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.cj.xdevapi.Result;

import components.IBook;
import components.IUser;
import components.User;
import javafx.util.Pair;

public class Testing {

	private static Object object;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		IMySqlConnection mysql = MySqlConnection.getInstance();
		 
//		//insert into customers
//		HashMap<String, String> attributes = new HashMap<>();
//		attributes.put("username", "sanyatef");
//		attributes.put("password", "******");
//		attributes.put("firstname", "arsany");
//		attributes.put("lastname", "atef");
//		attributes.put("email", "@gmail.com");
//		attributes.put("phone", "0120000000");
//		attributes.put("shipaddress", "ibnmom");
//		attributes.put("type", "user");
//		mysql.insert_item("customers", attributes);		
		
//		//insert into cart
//		HashMap<String, String> attributes = new HashMap<>();
//		attributes.put("username", "sanyatef");
//		attributes.put("ISBN", "12");
//		attributes.put("NoOfBooks", "500");
//		attributes.put("date", "2020-2-10");
//		mysql.insert_item("cart", attributes);		
		
//		//insert into book
//		HashMap<String, String> attributes = new HashMap<>();
//		attributes.put("title", "olivertwist");
//		attributes.put("ISBN", "53");
//		attributes.put("NoOfBooks", "500");
//		attributes.put("publisher_name", "Arsany");
//		attributes.put("publication_year", "1900-9-28");
//		attributes.put("price", "30");
//		attributes.put("category", "art");
//		attributes.put("author", "kokoko");
//		mysql.insert_item("book", attributes);
		
//		// update book
//		HashMap<String, String> attributes = new HashMap<>();
//		HashMap<String, Pair<String, String>> conditions = new HashMap<>();
//		attributes.put("ISBN", "900");
//		conditions.put("ISBN", new Pair<String, String>("=", "53"));
//		mysql.update_item("book", attributes, conditions);
		
//		// delete book
//		HashMap<String, Pair<String, String>> conditions = new HashMap<>();
//		conditions.put("author", new Pair<String, String>("=", "kokoko"));
//		mysql.delete_item("book", conditions);
		

		//select book
//		ArrayList<String> attributes = new ArrayList<>();
//		HashMap<String, Pair<String, String>> conditions = new HashMap<>();
//		conditions.put("ISBN", new Pair<String, String>("<", "20"));
//		conditions.put("author", new Pair<String, String>("=", "michael said"));
//		ResultSet rs = mysql.search_item("book", null, conditions);
//		try {
//			while (rs.next()) {
//				for (int i = 1; i < 9; i++) {
//					System.out.print(rs.getString(i) + " ");
//				}
//				System.out.println();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		IUser user = new User("micosaid", "alex", "01280233126");
		user.setPassword("lolo+lyly");
		user.setFirst_name("michael");
		user.setLast_name("said");
		user.setEmail("mico@gmail.com");
		IBookStore bookStore = new BookStore();
		
		System.out.println(bookStore.logIn("micosaid", "lolo+lyly"));
		
//		System.out.println(bookStore.updateSettings(user));
		
//		bookStore.demandUser();
		HashMap<String, Pair<String, String>>filters = new HashMap<String, Pair<String,String>>();
		filters.put("ISBN", new Pair<String, String>(" = ", "10"));
		ArrayList<IBook> books  = bookStore.search(filters);
		
		for(IBook book : books) {
			System.out.println(book.toString());
			book.setRequest_amount(20);
			bookStore.addBookToCart(book);
		}
		System.out.println(bookStore.chechOut("4545", "2021-05-30"));
		
		
		
	}

}