package backend;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;

/*
 *  user / manager
 *  --------------
 *  Sign up and log in
 *  search book with any attribute
 *  add book to cart
 *  manage shopping cart
 *  checkout shopping cart
 *  log out
 */

/*  manager
*   --------
*   add book
*   modify book
*   place order (insert in orders table)
*   confirm     (delete in orders table)
*   change attribute type in customer table from user to manager
*   reports using (JASPER)
*/

public interface IMySqlConnection {
	
	/* ArrayList<String> attributes*/
	// contain the attributes to be returned in the Select query in MySQL
	
	/* HashMap<A, Pair<B, C>> conditions*/
	// select attributes from **** where A (B {=, <, >}) C */
	
	public ResultSet search_item(String table, ArrayList<String> attributes, HashMap<String, Pair<String, String>> conditions);
	public boolean insert_item(String table, HashMap<String, String> attributes);
	public boolean update_item(String table, HashMap<String, String> attributes, HashMap<String, Pair<String, String>> conditions);
	public boolean delete_item(String table, HashMap<String, Pair<String, String>> conditions);
	
}
