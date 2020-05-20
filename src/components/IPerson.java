package components;

import java.util.HashMap;

public interface IPerson {

	public String getName();

	public void setName(String name);

	public String getAddress();

	public void setAddress(String address);

	public String getPhone();

	public void setPhone(String phone);
	
	public abstract HashMap<String, String>getAttributes();
}
