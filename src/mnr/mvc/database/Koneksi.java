/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mnr.mvc.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import mnr.mvc.service.PenggunaDao;
import mnr.mvc.service.impl.PenggunaDaoImpl;

/**
 *
 * @author KinetaNaraPutriniar
 */
public class Koneksi {
    private static Connection connection;
    private static PenggunaDao penggunaDao;
    
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource datasource = new MysqlDataSource();
            datasource.setURL("jdbc:mysql://localhost:3306/latihanmvc");
            datasource.setUser("root");
            datasource.setPassword("");
            
            connection = datasource.getConnection();
        }
        
        return connection;
    }
    
    public static PenggunaDao getPenggunaDao() throws SQLException {
        if(penggunaDao == null) {
            penggunaDao = new PenggunaDaoImpl(getConnection());
        }
        return penggunaDao;
    }
       
    
}
