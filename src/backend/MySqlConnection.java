package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javafx.util.Pair;

/**
 * 
 * @author Arsany
 * Connect operations in MySQL like insertion, delete, ...etc
 */
public class MySqlConnection implements IMySqlConnection {
	
	Connection conn = null;
	Statement stmt = null;
	/*
	 * Singleton
	 */
	private static MySqlConnection instance = new MySqlConnection();
	private MySqlConnection() {
		// TODO Auto-generated constructor stub
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","scott","database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			printSQLException(e);
		}
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			printSQLException(e);
		}
	}
	public static MySqlConnection getInstance() {
		return instance;
	}
	
	public ResultSet search_item(String table, ArrayList<String> attributes,
			HashMap<String, Pair<String, String>> conditions) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select ");
		if (attributes == null) {
			sqlBuilder.append("* ");
		} else {
			for (int i = 0; i < attributes.size(); i++) {
				if (i == attributes.size() - 1) {
					sqlBuilder.append(attributes.get(i));
				}
				sqlBuilder.append(attributes.get(i) + ", ");
			}
		}
		sqlBuilder.append("from " + table);
		if ("book".equals(table)) {
			sqlBuilder.append(" natural join authors ");
		}
		if (!conditions.isEmpty()) {
			sqlBuilder.append("where ");
			for (Entry<String, Pair<String, String>> e:conditions.entrySet()) {
				sqlBuilder.append(e.getKey());
				sqlBuilder.append(e.getValue().getKey());
				sqlBuilder.append(e.getValue().getValue());
				sqlBuilder.append(" AND");
			}
			sqlBuilder.delete(sqlBuilder.length() - 4, sqlBuilder.length() - 1);
		}
		try {
			rs = stmt.executeQuery(sqlBuilder.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			printSQLException(e);
		}
		return rs;
	}

	@Override
	public boolean insert_item(String table, HashMap<String, String> attributes) {
		// TODO Auto-generated method stub
		String temp = "";
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("insert into " + table + " (");
		
		if (!attributes.isEmpty()) {
			if (attributes.containsKey("authors")) {
				temp = attributes.get("auhtors");
				attributes.remove("authors");
			}
			for (Entry<String, String> a:attributes.entrySet()) {
				sqlBuilder.append(a.getKey() + ", ");
			}
			
			sqlBuilder.replace(sqlBuilder.length() - 2, sqlBuilder.length() - 1, ")");
			sqlBuilder.append(" values (");
			
			for (Entry<String, String> a:attributes.entrySet()) {
				sqlBuilder.append(a.getValue() + ", ");
			}
			
			sqlBuilder.replace(sqlBuilder.length() - 2, sqlBuilder.length() - 1, ")");
			
			try {
				stmt.executeUpdate(sqlBuilder.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				printSQLException(e);
				return false;
			}
			
			if (!temp.isEmpty()) {
				String [] authors = temp.split(",");
				for (int i = 0; i < authors.length - 1; i++) {
					sqlBuilder = new StringBuilder();
					sqlBuilder.append("insert into authors values (");
					sqlBuilder.append(attributes.get("ISBN") + ", ");
					sqlBuilder.append(authors[i] + ")");
					try {
						stmt.executeUpdate(sqlBuilder.toString());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						printSQLException(e);
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean update_item(String table, HashMap<String, String> attributes,
			HashMap<String, Pair<String, String>> conditions) {
		// TODO Auto-generated method stub
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("update ");
		sqlBuilder.append(table);
		
		if (!attributes.isEmpty()) {
			
//			if ("book".equals(table)) {
//				sqlBuilder.append(" natural join authors");
//			}
			
			sqlBuilder.append("set ");
			for (Entry<String, String> a:attributes.entrySet()) {
				sqlBuilder.append(a.getKey() + "=" + a.getValue() + ", ");
			}
			sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length() - 1);
			sqlBuilder.append("where");
			for (Entry<String, Pair<String, String>> e:conditions.entrySet()) {
				sqlBuilder.append(e.getKey());
				sqlBuilder.append(e.getValue().getKey());
				sqlBuilder.append(e.getValue().getValue());
				sqlBuilder.append(" AND");
			}
			sqlBuilder.delete(sqlBuilder.length() - 4, sqlBuilder.length() - 1);
			try {
				stmt.executeUpdate(sqlBuilder.toString());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				printSQLException(e1);
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean delete_item(String table, HashMap<String, Pair<String, String>> conditions) {
		// TODO Auto-generated method stub
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("delete from ");
		sqlBuilder.append(table);
		
		if (!conditions.isEmpty()) {
			
//			if ("book".equals(table)) {
//				sqlBuilder.append(" natural join authors ");
//			}
			
			sqlBuilder.append("where ");
			for (Entry<String, Pair<String, String>> e:conditions.entrySet()) {
				sqlBuilder.append(e.getKey());
				sqlBuilder.append(e.getValue().getKey());
				sqlBuilder.append(e.getValue().getValue());
				sqlBuilder.append(" AND");
			}
			sqlBuilder.delete(sqlBuilder.length() - 4, sqlBuilder.length() - 1);
			try {
				stmt.executeUpdate(sqlBuilder.toString());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				printSQLException(e1);
				return false;
			}
		}
		return true;
	}
	
	public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
