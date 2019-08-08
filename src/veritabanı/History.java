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
public class History {

    private int m_id;
    private String kullanici_adi;
    private String yapılan_iş;
    private String tarih;

    public History() {
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getYapılan_iş() {
        return yapılan_iş;
    }

    public void setYapılan_iş(String yapılan_iş) {
        this.yapılan_iş = yapılan_iş;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

}
