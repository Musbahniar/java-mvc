/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mnr.mvc.service;

import java.util.List;
import mnr.mvc.entity.Pengguna;
import mnr.mvc.error.PenggunaException;

/**
 *
 * @author KinetaNaraPutriniar
 */
public interface PenggunaDao {
    public void insertPengguna(Pengguna pengguna) throws PenggunaException;
    public void updatePengguna(Pengguna pengguna) throws PenggunaException;
    public void deletePengguna(Integer id) throws PenggunaException;
    public Pengguna getPengguna(Integer id) throws PenggunaException;
    public Pengguna getPengguna(String email) throws PenggunaException;
    public List<Pengguna> selectAllPengguna() throws PenggunaException;
}
