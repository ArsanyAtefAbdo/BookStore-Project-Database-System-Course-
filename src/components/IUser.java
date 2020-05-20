package components;

public interface IUser extends IPerson {

	public String getPassword();

	public void setPassword(String password);

	public String getFirst_name();

	public void setFirst_name(String first_name);

	public String getLast_name();

	public void setLast_name(String last_name);

	public String getEmail();

	public void setEmail(String email);
	
	public boolean getIsManager();
	
	public void setIsManager(boolean isManager);
	
	/**
	 * @return the cart
	 */
	public Cart getCart();

	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart);
}
