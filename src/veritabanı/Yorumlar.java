/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veritabanı;

/**
 *
 * @author mucah
 */
public class Yorumlar {
    private int y_id;
    private  String yorum;
    private  String kullanici_adi;
    private String y_tarih;

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public int getY_id() {
        return y_id;
    }

    public void setY_id(int y_id) {
        this.y_id = y_id;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

 

    public String getY_tarih() {
        return y_tarih;
    }

    public void setY_tarih(String y_tarih) {
        this.y_tarih = y_tarih;
    }
    
}
