package components;

import java.util.HashMap;

import components.IUser;

public class User extends Person implements IUser{
	
	

	public User(String name, String address, String phone) {
		super(name, address, phone);
		// TODO Auto-generated constructor stub
		this.cart = new Cart();
		this.isManager = false;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	@Override
	public boolean getIsManager() {
		// TODO Auto-generated method stub
		return this.isManager;
	}

	@Override
	public void setIsManager(boolean isManager) {
		// TODO Auto-generated method stub
		this.isManager = isManager;
		
	}
	@Override
	public HashMap<String, String>getAttributes(){
		HashMap<String, String>attributes = new HashMap<String, String>();
		attributes.put("shipAddress", super.getAddress());
		attributes.put("phone",super.getPhone());
		attributes.put("username", super.getName());
		attributes.put("password", this.password);
		attributes.put("firstname", this.first_name);
		attributes.put("lastname", this.last_name);
		attributes.put("email", this.email);
		attributes.put("type", this.isManager ? "manager" : "user");
		return attributes;
	}

	private String password;
	
	private String first_name;
	
	private String last_name;
	
	private String email;
	
	private Cart cart;
	
	private boolean isManager;
}