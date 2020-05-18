package backend;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;

/**
 * 
 * @author Arsany
 * Connect operations in MySQL like insertion, delete, ...etc
 */
public class MySqlConnection implements IMySqlConnection {

	@Override
	public ResultSet search_item(String table, ArrayList<String> attributes,
			HashMap<String, Pair<String, String>> conditions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert_item(String table, HashMap<String, String> attributes) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update_item(String table, HashMap<String, String> attributes,
			HashMap<String, Pair<String, String>> conditions) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete_item(String table, HashMap<String, Pair<String, String>> conditions) {
		// TODO Auto-generated method stub
		return false;
	}

}
