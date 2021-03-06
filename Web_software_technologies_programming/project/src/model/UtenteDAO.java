package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrea Claro
 *
 */
public class UtenteDAO {
    
    public List<Utente> doRetrieveAll(int offset, int limit) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con
            .prepareStatement("SELECT id, username, passwordhash, name, email, admin FROM user LIMIT ?, ?");
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            ArrayList<Utente> utenti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Utente u = new Utente();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPasswordhash(rs.getString(3));
                u.setNome(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setAdmin(rs.getBoolean(6));
                utenti.add(u);
            }
            return utenti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Utente doRetrieveByUsernamePassword(String username, String password) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                              "SELECT id, username, passwordhash, name, email, admin FROM user WHERE username=? AND passwordhash=SHA1(?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente p = new Utente();
                p.setId(rs.getInt(1));
                p.setUsername(rs.getString(2));
                p.setPasswordhash(rs.getString(3));
                p.setNome(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setAdmin(rs.getBoolean(6));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Utente doRetrieveByUsername(String username) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, username, passwordhash, name, email, admin FROM user WHERE username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Utente p = new Utente();
				p.setId(rs.getInt(1));
				p.setUsername(rs.getString(2));
				p.setPasswordhash(rs.getString(3));
				p.setNome(rs.getString(4));
				p.setEmail(rs.getString(5));
				p.setAdmin(rs.getBoolean(6));
				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

    
    public void doSave(Utente utente) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO user (username, passwordhash, name, email, admin) VALUES(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, utente.getUsername());
			ps.setString(2, utente.getPasswordhash());
			ps.setString(3, utente.getNome());
			ps.setString(4, utente.getEmail());
			ps.setBoolean(5, utente.isAdmin());
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("INSERT error.");
			}
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			utente.setId(rs.getInt(1));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
    
    public void doAdmin(int id) {
    	try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE user SET admin= 1 WHERE id=?");
			ps.setInt(1, id);
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("UPDATE error.");
			}
    	}catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
    
    public void doDelete(int id) {
    	try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM user WHERE id=?");
			ps.setInt(1, id);
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("UPDATE error.");
			}
    	}catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }
}
