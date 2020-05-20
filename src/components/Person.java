package components;

import java.util.HashMap;

import components.IPerson;

public abstract class Person implements IPerson {

	
	public Person(String name, String address, String phone) {
		this.setName(name);
		this.setAddress(address);
		this.setPhone(phone);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public abstract HashMap<String, String>getAttributes();

	private String name;
	
	private String address;
	
	private String phone;
}
