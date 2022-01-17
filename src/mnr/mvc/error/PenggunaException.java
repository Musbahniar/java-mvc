/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mnr.mvc.error;

/**
 *
 * @author KinetaNaraPutriniar
 */
public class PenggunaException extends Exception {

    /**
     * Creates a new instance of <code>PenggunaException</code> without detail
     * message.
     */
    public PenggunaException() {
    }

    /**
     * Constructs an instance of <code>PenggunaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PenggunaException(String msg) {
        super(msg);
    }
}
