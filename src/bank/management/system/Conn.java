package bank.management.system;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

public class Conn {

    Connection connection;
    Statement statement;
    PreparedStatement ps; // so it is not vulnerable to sql injection

    public Conn(){
        try{
            // 1. Naya Properties object banaao
            Properties prop = new Properties();

            // 2. File ko load karo (Yeh file ko 'src' folder se dhoondh lega)
            InputStream input = ClassLoader.getSystemResourceAsStream("config.properties");

            // 3. Properties ko load karo
            prop.load(input);

            // 4. File se properties get karo
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String pass = prop.getProperty("db.pass");

            connection = DriverManager.getConnection(url, user, pass);

            statement  = connection.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
