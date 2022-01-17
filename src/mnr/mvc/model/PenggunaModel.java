/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mnr.mvc.model;

import java.sql.SQLException;
import mnr.mvc.database.Koneksi;
import mnr.mvc.entity.Pengguna;
import mnr.mvc.error.PenggunaException;
import mnr.mvc.model.event.PenggunaListener;
import mnr.mvc.service.PenggunaDao;

/**
 *
 * @author KinetaNaraPutriniar
 */
public class PenggunaModel {
    private Integer id;
    private String namaDepan;
    private String namaBelakang;
    private String telepon;
    private String email;

    private PenggunaListener listener;
    
    public PenggunaListener getListener() {
        return listener;
    }
    
    public void setListener(PenggunaListener listener) {
        this.listener = listener;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChage();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        fireOnChage();
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
        fireOnChage();
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
        fireOnChage();
    }
    
    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
        fireOnChage();
    }

    protected void fireOnChage() {
        if (listener != null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Pengguna pengguna) {
        if (listener != null) {
            listener.onInsert(pengguna);
        }
    }

    protected void fireOnUpdate(Pengguna pengguna) {
        if (listener != null) {
            listener.onUpdate(pengguna);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }

    public void resetPengguna() {
        setId(0);
        setEmail("");
        setNamaBelakang("");
        setNamaDepan("");
        setTelepon("");
    }
    
    public void insertPengguna() throws SQLException, PenggunaException {
        PenggunaDao dao = Koneksi.getPenggunaDao();

        Pengguna pengguna = new Pengguna();
        pengguna.setEmail(email);
        pengguna.setNamaBelakang(namaBelakang);
        pengguna.setNamaDepan(namaDepan);
        pengguna.setTelepon(telepon);
        dao.insertPengguna(pengguna);

        fireOnInsert(pengguna);
    }
    
    public void updatePengguna() throws SQLException, PenggunaException {
        PenggunaDao dao = Koneksi.getPenggunaDao();

        Pengguna pengguna = new Pengguna();
        pengguna.setEmail(email);
        pengguna.setNamaBelakang(namaBelakang);
        pengguna.setNamaDepan(namaDepan);
        pengguna.setTelepon(telepon);
        pengguna.setId(id);
        dao.updatePengguna(pengguna);

        fireOnUpdate(pengguna);
    }
    
    public void deletePengguna() throws SQLException, PenggunaException {
        PenggunaDao dao = Koneksi.getPenggunaDao();
        dao.deletePengguna(id);
        fireOnDelete();
    }
}
