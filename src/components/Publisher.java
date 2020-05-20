package components;

import java.util.HashMap;

public class Publisher extends Person {
	
	
	public Publisher(String name, String address, String phone) {
		super(name, address, phone);
	}

	@Override
	public HashMap<String, String>getAttributes(){
		HashMap<String, String>attributes = new HashMap<String, String>();
		attributes.put("address", super.getAddress());
		attributes.put("phone",super.getPhone());
		attributes.put("publisher_name", super.getName());
		return attributes;
	}
}
