/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mnr.mvc.model.event;

import mnr.mvc.entity.Pengguna;
import mnr.mvc.model.PenggunaModel;

/**
 *
 * @author KinetaNaraPutriniar
 */
public interface PenggunaListener {
    public void onChange(PenggunaModel model);
    public void onInsert(Pengguna pengguna);
    public void onUpdate(Pengguna pengguna);
    public void onDelete();
}
