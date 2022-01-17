/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mnr.mvc.main;

import java.sql.SQLException;
import mnr.mvc.database.Koneksi;
import mnr.mvc.entity.Pengguna;
import mnr.mvc.error.PenggunaException;
import mnr.mvc.service.PenggunaDao;

/**
 *
 * @author KinetaNaraPutriniar
 */
public class Main {
    public static void main(String[] args) throws SQLException, PenggunaException {
        PenggunaDao dao = Koneksi.getPenggunaDao();
        Pengguna pengguna = new Pengguna();
        
        pengguna.setNamaDepan("Kineta");
        pengguna.setNamaBelakang("Nara");
        pengguna.setTelepon("08522266515");
        pengguna.setEmail("333@gmail.com");
        
        dao.insertPengguna(pengguna);
        
    }
}
