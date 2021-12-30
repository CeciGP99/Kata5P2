package view;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReaderBD {
    
    public List<Mail> read(String fileName){
        List<Mail> list = new ArrayList<>();
        String sql = "SELECT * FROM direcc_email";
        Connection conn = null;
        
        try {
            conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Mail email = new Mail(rs.getString("email"));
                list.add(email);
            }
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
            return null;
        }
        return list;
    }
    
    private Connection connect(){
        Connection conn = null;
        String url = "jdbc:sqlite:mail.db";
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conneccion establecida");
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
        }
        return  conn;
    }
    
}
