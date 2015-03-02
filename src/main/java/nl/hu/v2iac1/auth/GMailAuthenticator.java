package nl.hu.v2iac1.auth;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class GMailAuthenticator extends Authenticator {
     String email;
     String pw;
     public GMailAuthenticator (String mail, String password)
     {
        super();
        this.email = mail;
        this.pw = password;
     }
    public PasswordAuthentication getPasswordAuthentication()
    {
       return new PasswordAuthentication(email, pw);
    }
}