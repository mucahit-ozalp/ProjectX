/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veritabanı;

import com.mysql.jdbc.Connection;
import com.sun.javafx.font.FontConstants;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mucah
 */
public class Baglan {

    private String kullanici_adi = "root";
    private String parola = "";
    private String db_isim = "kullaniciler";
    private String host = "localhost";
    private int port = 3306;
    private Connection con = null;
   
    private PreparedStatement preparedStatement = null;


    /*
    public boolean musteriler(String kullanıcı_adi, String parola) {
        boolean login = false;
        String sorgu = "Select count(*) as sayi from m_database where kullanici_adi ='" + kullanıcı_adi + "' and parola = '" + parola + "'";
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            while (rs.next()) {

                int deger = rs.getInt("sayi");
                if (deger >= 1) {
                    login = true;

                } else {
                    login = false;

                }

            }
        } catch (SQLException ex) {

        }

        return login;
    }
     */
    public Connection Baglan() {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db_isim;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("driver bulunamadı");
        }
        try {
            con = (Connection) DriverManager.getConnection(url, kullanici_adi, parola);
            System.out.println("veritabanı bağlantısı başarılı");
        } catch (SQLException ex) {
            System.out.println("veritabanı bağlantısı başarısız");
        }
        return con;
    }

    public static void main(String[] args) {
        Baglan baglann = new Baglan();
        //Sorgu sorgu = new Sorgu();

        //baglann.musteriler();
    }
}
