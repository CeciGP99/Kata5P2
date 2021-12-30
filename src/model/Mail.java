package model;

public class Mail {

    private final String mail;
    
    public Mail(String mail) {
        this.mail = mail;
    }
    
    public String getDomain(){
        String[] parts = mail.split("@");
        return parts[1];
    }
    
}
