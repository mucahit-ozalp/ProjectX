/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veritabanı;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author mucah
 */
public class Sorgu {

    static int id;
    static String bilgi;

    Baglan b = new Baglan();
    static Sorgu sorgu = new Sorgu();

    public String tarih() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now)); //2016/11/16 12:08:43

        return dtf.format(now);
    }

    public int count() {
        int count = 0;

        String sorgu = "Select count(*) as sayi from mesaj_dbv where m_id ";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                count = rs.getInt("sayi");

            }

        } catch (SQLException ex) {

        }
        return count;

    }
        public ArrayList<History> history_cek(int id) {
        ArrayList<History> liste2 = new ArrayList<History>();

        String sorgu = "SELECT hd.m_id,kd.kullanici_adi,hd.yapilan_is,hd.tarih FROM kullanici_db kd, history_db hd WHERE hd.gonderen_adi=kd.k_id AND hd.m_id=? ";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                History history=new History();
                history.setM_id(rs.getInt("m_id"));
                history.setKullanici_adi(rs.getString("kullanici_adi"));
                history.setYapılan_iş(rs.getString("yapilan_is"));
                history.setTarih(rs.getString("tarih"));
               
                liste2.add(history);

            }

        } catch (SQLException ex) {
            System.out.println("mesaj hatalı" + ex.toString());

        }
        return liste2;
    }

    public ArrayList<Yorumlar> yorumlar(int id) {
        ArrayList<Yorumlar> liste2 = new ArrayList<Yorumlar>();

        String sorgu = "SELECT yd.y_id, yd.yorum,kd.kullanici_adi,yd.y_tarih,yd.m_id FROM kullanici_db kd,mesaj_dbv md, yorum_db yd WHERE kd.k_id=yd.yk_id and md.m_id= yd.m_id AND yd.m_id=? ";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Yorumlar yorumlar = new Yorumlar();
                yorumlar.setY_id(rs.getInt("y_id"));
                yorumlar.setYorum(rs.getString("yorum"));
                yorumlar.setKullanici_adi(rs.getString("kullanici_adi"));
                yorumlar.setY_tarih(rs.getString("y_tarih"));

                liste2.add(yorumlar);

            }

        } catch (SQLException ex) {
            System.out.println("mesaj hatalı" + ex.toString());

        }
        return liste2;
    }

    public void yorum_ekle(int mesaj_id, String yorum) {
        String sorgu = "insert into  yorum_db (  `m_id`, `yorum`, `y_tarih`, `yk_id`) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, mesaj_id);

            preparedStatement.setString(2, yorum);

            preparedStatement.setString(3, tarih());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("mesaj hatalı" + ex.toString());

        }

    }

    public void sorgu_ekle(String sorgum_adi, String sorgu_bas) {
        String sorgu = "insert into  filtre_db ( `fk_id`, `sorgu_adi`, `sorgu`) VALUES (?,?,?)";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, Sorgu.id);

            preparedStatement.setString(2, sorgum_adi);

            preparedStatement.setString(3, sorgu_bas);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("mesaj hatalı" + ex.toString());

        }

    }

    public String filtre_sorgu(int deger) {
        String sorgu_ek = null;
        String sorgu = "SELECT sorgu FROM filtre_db WHERE f_id=?";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, deger);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sorgu_ek = rs.getString("sorgu");

            }

        } catch (SQLException ex) {

        }

        return sorgu_ek;

    }

    public ArrayList<def_filtre> def_filtreList(String sorgu_devam) {
        ArrayList<def_filtre> liste = new ArrayList<def_filtre>();

        String sorgu = "select m_id, baslik, tanim, status, severity,reporter_id,mk_id,m_tarih from mesaj_dbv where  ";
        sorgu += sorgu_devam;
        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            //preparedStatement.setInt(1,80);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                def_filtre filtre = new def_filtre();
                filtre.setMesaj_id(rs.getInt("m_id"));
                filtre.setBaslık(rs.getString("baslik"));
                filtre.setTanım(rs.getString("tanim"));
                filtre.setDurum(rs.getString("status"));
                filtre.setSeviye(rs.getString("severity"));
                filtre.setGönderen(rs.getInt("reporter_id"));
                filtre.setAlıcı(rs.getInt("mk_id"));
                filtre.setTarih(rs.getString("m_tarih"));

                liste.add(filtre);

            }

        } catch (SQLException ex) {
            System.out.println("mesaj hatalı" + ex.toString());

        }
        return liste;
    }

    public ArrayList<String> calısanlar() {
        ArrayList<String> liste = new ArrayList<String>();
        String sorgu = "select kullanici_adi from kullanici_db ";
        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                liste.add(rs.getString("kullanici_adi"));

            }

        } catch (SQLException ex) {

        }
        return liste;
    }

    public ArrayList<String> filtrelerim(int id) {
        ArrayList<String> liste = new ArrayList<String>();
        String sorgu = "select f_id, sorgu_adi from filtre_db where fk_id=?";
        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String deger;
                deger = (rs.getString("f_id"));
                deger += " - ";
                deger += (rs.getString("sorgu_adi"));

                liste.add(deger);
                
            }

        } catch (SQLException ex) {

        }
        return liste;
    }

    public ArrayList<String> def_listele2(String kullanici) {
        ArrayList<String> liste = new ArrayList<String>();
        String sorgu = "select md.m_id, md.baslik from kullanici_db kd, mesaj_dbv md where kd.k_id=md.reporter_id and kd.kullanici_adi=?";
        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setString(1, kullanici);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String deger;
                deger = rs.getString("m_id");
                deger += " - ";
                deger += rs.getString("baslik");
                
                liste.add(deger);

            }

        } catch (SQLException ex) {

        }
        return liste;
    }

    public ArrayList<String> def_listele(int kullanici_id) {
        ArrayList<String> liste = new ArrayList<String>();

        String sorgu = "select hd.m_id, md.baslik from  mesaj_dbv md, history_db hd where hd.m_id=md.m_id and hd.alan_adi=?";
        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, kullanici_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                //liste.add(rs.getString("m_id"));
                String deger;
                deger = rs.getString("m_id");
                deger += " - ";
                deger += rs.getString("baslik");

                liste.add(deger);

            }

        } catch (SQLException ex) {

        }
        return liste;
    }

    public void status_guncelle(int mesaj_id, int deger,int alan_id) {

        String sorgu = "update history_db set son_durum=? where m_id=? and alan_adi=?";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, deger);
            preparedStatement.setInt(2, mesaj_id);
            preparedStatement.setInt(3, alan_id);
            
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {

        }

    }

    public String def_kontrol(int kullanici) {
        String geri = null;
        int durum;
        String sorgu = "select son_durum  from history_db where alan_adi=?";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, kullanici);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                durum = rs.getInt("son_durum");

                if (durum==0) {
                    geri = "yeni defect var";
                } else {
                    geri = "defect yok";
                }

            }

        } catch (SQLException ex) {

        }
        return geri;
    }

    public String gönderilen(int deger) {
        String gönderen = null;
        String sorgu = "SELECT kd.kullanici_adi FROM kullanici_db kd, mesaj_dbv md WHERE kd.k_id=md.mk_id AND md.m_id=?";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, deger);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                gönderen = rs.getString("kullanici_adi");

            }

        } catch (SQLException ex) {

        }

        return gönderen;

    }

    public int olusturan_id(int deger) {
        int olusturan = 0;
        String sorgu = "SELECT olusturan_id FROM  mesaj_dbv WHERE m_id=?";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, deger);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                olusturan = rs.getInt("olusturan_id");

            }

        } catch (SQLException ex) {

        }

        return olusturan;

    }

    public String[] mesaj_cek2(int mesaj_id) {
        String dizi[] = new String[5];

        String sorgu = "select md.tanim , md.baslik ,md.severity ,md.m_tarih, kd.kullanici_adi from mesaj_dbv md,kullanici_db kd where kd.k_id=md.mk_id and md.m_id=? ";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, mesaj_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                dizi[0] = rs.getString("tanim");
                dizi[1] = rs.getString("baslik");
                dizi[2] = rs.getString("severity");
                dizi[3] = rs.getString("m_tarih");
                dizi[4] = rs.getString("kullanici_adi");

            }

        } catch (SQLException ex) {
            System.out.println("mesaj hatalı" + ex.toString());

        }
        return dizi;

    }

    public String[] mesaj_cek(int mesaj_id,int kullanici_id) {
        String dizi[] = new String[6];

        String sorgu = "SELECT hd.tarih,md.severity,kd.kullanici_adi,md.baslik,md.tanim,md.olusturan_id FROM mesaj_dbv md, history_db hd,kullanici_db kd WHERE hd.gonderen_adi=kd.k_id and md.m_id=hd.m_id AND hd.m_id=? and hd.alan_adi=?";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, mesaj_id);
            preparedStatement.setInt(2, kullanici_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                dizi[0] = rs.getString("tanim");
                dizi[1] = rs.getString("baslik");
                dizi[2] = rs.getString("severity");
                dizi[3] = rs.getString("tarih");
                dizi[4] = rs.getString("kullanici_adi");
                dizi[5]= rs.getString("olusturan_id");

            }

        } catch (SQLException ex) {

        }
        return dizi;

    }

    public int def_id_ver(String calısann) {
        int id = 0;
        String sorgu = "select k_id from kullanici_db where kullanici_adi=? ";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setString(1, calısann);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("k_id");

            }

        } catch (SQLException ex) {

        }

        return id;
    }
      public void history_ekle (int mesaj_id,int gonderen, String alan,String yapılan, int kontrol) {
        String sorgu = "INSERT INTO history_db ( `m_id`, `gonderen_adi`, `alan_adi`, `yapilan_is`, `son_durum`, `tarih`) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, mesaj_id);
            //  System.out.println("1"+ preparedStatement.toString());
            preparedStatement.setInt(2, Sorgu.id);
            preparedStatement.setInt(3, def_id_ver(alan));
            preparedStatement.setString(4, yapılan);
            preparedStatement.setInt(5, kontrol);
            preparedStatement.setString(6, tarih());
          

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("mesaj hatalı" + ex.toString());

        }

    }

  
    public void mesaj_ekle(String baslık, String tanım, String calısan, String status, String seviye, int olusturan) {
        String sorgu = "insert into  mesaj_dbv (`reporter_id`,`mk_id`,  `baslik`,`status`,`severity`,`tanim`,m_tarih,olusturan_id) VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, Sorgu.id);
            //  System.out.println("1"+ preparedStatement.toString());
            preparedStatement.setInt(2, def_id_ver(calısan));
            preparedStatement.setString(3, baslık);
            preparedStatement.setString(4, status);
            preparedStatement.setString(5, seviye);
            preparedStatement.setString(6, tanım);
            preparedStatement.setString(7, tarih());
            preparedStatement.setInt(8, olusturan);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("mesaj hatalı" + ex.toString());

        }

    }

    public int departman(String kullanıcı_adı) {
        int departman = 0;
        String sorgu = "SELECT ddb.departman from kullanici_db kdb,departman_db ddb WHERE kdb.dk_id=ddb.d_id AND kullanici_adi=?";

        try {

            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setString(1, kullanıcı_adı);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                departman = rs.getInt("departman");
                
                
            }

        } catch (SQLException ex) {

        }

        return departman;

    }

    public int zamanlayıcı(String kullanıcı_adı) {
        int zaman = 0;
        String sorgu = "SELECT TIMESTAMPDIFF(MINUTE,blok_tarih,NOW()) as zaman FROM kullanici_db where kullanici_adi=? ";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setString(1, kullanıcı_adı);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                zaman = rs.getInt("zaman");
                
            }

        } catch (SQLException ex) {
            

        }

        return zaman;

    }

    public String zamanlayıcı2(String kullanıcı_adı) {
        String zaman = null;
        String sorgu = "SELECT  blok_tarih FROM kullanici_db where kullanici_adi= ?";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setString(1, kullanıcı_adı);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                zaman = rs.getString("blok_tarih");

            }

        } catch (SQLException ex) {

        }

        return zaman;

    }

    public void blok_tarih_ekle(String kullanıcı_adi, String tarih) {

        String sorgu = "update kullanici_db set blok_tarih=? where kullanici_adi=?";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setString(1, tarih);
            preparedStatement.setString(2, kullanıcı_adi);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {

        }

    }

    public void blok_tarih_temizle(String kullanıcı_adi, String tarih) {

        String sorgu = "update kullanici_db set blok_tarih=? where kullanici_adi=?";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setString(1, tarih);
            preparedStatement.setString(2, kullanıcı_adi);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {

        }

    }

    public void aktif_tarih(String kullanıcı_adi, String tarih) {

        String sorgu = "update kullanici_db set giris_tarihi=? where kullanici_adi=?";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setString(1, tarih);
            preparedStatement.setString(2, kullanıcı_adi);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {

        }

    }

    public int hatali_giris_cek(String kullanıcı_adi) {
        int sayi = 0;

        String sorgu = "select hatali_giris from kullanici_db where kullanici_adi=? ";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setString(1, kullanıcı_adi);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sayi = rs.getInt("hatali_giris");

            }

        } catch (SQLException ex) {

        }
        return sayi;

    }

    public void basarili_giris(String kullanıcı_adi, int sayac) {

        String sorgu = "update kullanici_db set hatali_giris=? where kullanici_adi=?";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, sayac);
            preparedStatement.setString(2, kullanıcı_adi);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {

        }

    }

    public void hatali_giris_ekle(String kullanıcı_adi, int sayac) {

        String sorgu = "update kullanici_db set hatali_giris=? where kullanici_adi=?";

        try {
            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setInt(1, sayac);
            preparedStatement.setString(2, kullanıcı_adi);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {

        }

    }

    public boolean giris_islem(String kullanici_adi, String parola) {
        boolean cıktı = false;
        String sorgu = "Select k_id,kullanici_adi  from kullanici_db where kullanici_adi=? and parola=?";

        try {

            PreparedStatement preparedStatement = b.Baglan().prepareStatement(sorgu);
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, parola);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("k_id");

                bilgi = rs.getString("kullanici_adi");
                cıktı = true;

                // cıktı = kontrol >= 1 ? true : false;
            }

        } catch (SQLException ex) {
            cıktı = false;

        }

        return cıktı;

    }

}
