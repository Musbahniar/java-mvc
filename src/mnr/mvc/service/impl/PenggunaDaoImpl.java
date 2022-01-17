/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mnr.mvc.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mnr.mvc.entity.Pengguna;
import mnr.mvc.error.PenggunaException;
import mnr.mvc.service.PenggunaDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KinetaNaraPutriniar
 */
public class PenggunaDaoImpl implements PenggunaDao {
    private Connection connection;
    
    private final String insertPengguna = "INSERT INTO PENGGUNA (NAMA_DEPAN, NAMA_BELAKANG, TELEPON, EMAIL) VALUES (?,?,?,?)";
    private final String updatePengguna = "UPDATE PENGGUNA SET NAMA_DEPAN = ?, NAMA_BELAKANG = ?, TELEPON = ?, EMAIL = ? WHERE ID = ?";
    private final String deletePengguna = "DELETE FROM PENGGUNA WHERE ID = ?";
    private final String getById = "SELECT * FROM PENGGUNA WHERE ID = ?";
    private final String getByEmail = "SELECT * FROM PENGGUNA WHERE EMAIL = ?";
    private final String selectAll = "SELECT * FROM PENGGUNA";
    
    public PenggunaDaoImpl (Connection connection) {
        this.connection = connection;
    }
    
    public void insertPengguna(Pengguna pengguna) throws PenggunaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPengguna,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pengguna.getNamaDepan());
            statement.setString(2, pengguna.getNamaBelakang());
            statement.setString(3, pengguna.getTelepon());
            statement.setString(4, pengguna.getEmail());
            statement.executeUpdate();
            
            ResultSet result = statement.getGeneratedKeys();
            if(result.next()) {
                pengguna.setId(result.getInt(1));
            }
            
            connection.setAutoCommit(true);
            
        } catch (SQLException exception){
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenggunaException (exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            }catch (SQLException ex) {
            }
            if(statement != null) {
                try {
                    statement.close();
                }catch (SQLException ex) {
                }
            }
        }
    }
    
    public void updatePengguna(Pengguna pengguna) throws PenggunaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePengguna);
            statement.setString(1, pengguna.getNamaDepan());
            statement.setString(2, pengguna.getNamaBelakang());
            statement.setString(3, pengguna.getTelepon());
            statement.setString(4, pengguna.getEmail());
            statement.setInt(5, pengguna.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenggunaException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    
    public void deletePengguna(Integer id) throws PenggunaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePengguna);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenggunaException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    
    public Pengguna getPengguna(Integer id) throws PenggunaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            Pengguna pengguna = null;
            if (result.next()) {
                pengguna = new Pengguna();
                pengguna.setEmail(result.getString("EMAIL"));
                pengguna.setId(result.getInt("ID"));
                pengguna.setNamaBelakang(result.getString("NAMA_BELAKANG"));
                pengguna.setNamaDepan(result.getString("NAMA_DEPAN"));
                pengguna.setTelepon(result.getString("TELEPON"));
            } else {
                throw new PenggunaException("Pengguna dengan id " + id + " tidak ditemukan");
            }
            connection.commit();
            return pengguna;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenggunaException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    
    public Pengguna getPengguna(String email) throws PenggunaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByEmail);
            statement.setString(1, email);

            ResultSet result = statement.executeQuery();
            Pengguna pengguna = null;
            if (result.next()) {
                pengguna = new Pengguna();
                pengguna.setEmail(result.getString("EMAIL"));
                pengguna.setId(result.getInt("ID"));
                pengguna.setNamaBelakang(result.getString("NAMA_BELAKANG"));
                pengguna.setNamaDepan(result.getString("NAMA_DEPAN"));
                pengguna.setTelepon(result.getString("TELEPON"));
            } else {
                throw new PenggunaException("Pengguna dengan email " + email + " tidak ditemukan");
            }
            connection.commit();
            return pengguna;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenggunaException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    
    public List<Pengguna> selectAllPengguna() throws PenggunaException {
        Statement statement = null;
        List<Pengguna> list = new ArrayList<Pengguna>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectAll);

            while (result.next()) {
                Pengguna pengguna = new Pengguna();
                pengguna.setEmail(result.getString("EMAIL"));
                pengguna.setId(result.getInt("ID"));
                pengguna.setNamaBelakang(result.getString("NAMA_BELAKANG"));
                pengguna.setNamaDepan(result.getString("NAMA_DEPAN"));
                pengguna.setTelepon(result.getString("TELEPON"));

                list.add(pengguna);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenggunaException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

}
