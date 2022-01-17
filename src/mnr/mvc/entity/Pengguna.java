/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mnr.mvc.entity;

import java.util.Objects;

/**
 *
 * @author KinetaNaraPutriniar
 */
public class Pengguna {
    private Integer id;
    private String namaDepan;
    private String namaBelakang;
    private String telepon;
    private String email;

    public Pengguna() {
    }

    public Pengguna(String namaDepan, String namaBelakang, String telepon, String email) {
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.telepon = telepon;
        this.email = email;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.namaDepan);
        hash = 13 * hash + Objects.hashCode(this.namaBelakang);
        hash = 13 * hash + Objects.hashCode(this.telepon);
        hash = 13 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pengguna other = (Pengguna) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.namaDepan, other.namaDepan)) {
            return false;
        }
        if (!Objects.equals(this.namaBelakang, other.namaBelakang)) {
            return false;
        }
        if (!Objects.equals(this.telepon, other.telepon)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
