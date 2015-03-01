package nl.hu.v2iac1.domein;

public class User {
	private String name, password, email, key;
	
	public User(String nm, String pass, String em, String k){
		name = nm;
		password = pass;
		email = em;
		key = k;
	}
	public User(String nm, String pass){
		name = nm;
		password = pass;
	}
	public void setName(String nm){
		name = nm;
	}
	public void setPass(String pass){
		password = pass;
	}
	public void setEmail(String em){
		email = em;
	}
	public void setKey(String k){
		key = k;
	}
	public String getName(){
		return name;
	}
	public String getPassword(){
		return password;
	}
	public String getEmail(){
		return email;
	}
	public String getKey(){
		return key;
	}
	public String toString(){
		return name + password + email + key;
	}
}
