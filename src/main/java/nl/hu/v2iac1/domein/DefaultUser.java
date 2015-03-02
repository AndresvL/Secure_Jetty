package nl.hu.v2iac1.domein;

public class DefaultUser {
	private String name, password, email, emailpassword;
	// Setup default user
	public DefaultUser(String nm, String pass, String em, String empass) {
		name = nm;
		password = pass;
		email = em;
		emailpassword = empass;
	}

	public void setName(String nm) {
		name = nm;
	}

	public void setPass(String pass) {
		password = pass;
	}

	public void setEmail(String em) {
		email = em;
	}

	public void setEmailPassword(String empass) {
		emailpassword = empass;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getEmailPassword() {
		return emailpassword;
	}

	public String toString() {
		return name + password + email + emailpassword;
	}
}
