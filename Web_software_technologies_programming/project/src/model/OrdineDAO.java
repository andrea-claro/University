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
public class OrdineDAO {
	
	public void doSave(Ordine order, Utente user) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO `order` (idproduct, quantity, price) VALUES(?, ?, ?)", 					
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, order.getProduct().getId());
			ps.setInt(2, order.getQuantity());
			ps.setLong(3, order.getPrice());
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("INSERT error.");
			}
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			order.setId(id);
			PreparedStatement psCa = con
					.prepareStatement("INSERT INTO user_order (idorder, iduser) VALUES (?, ?)");
			psCa.setInt(1, id);
			psCa.setInt(2, user.getId());
			psCa.addBatch();
			psCa.executeBatch();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Ordine> doRetrieveByUser(int id, int offset, int limit) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, idproduct, quantity, price FROM `order` LEFT JOIN user_order ON id=idorder WHERE iduser=? LIMIT ?, ?");
			ps.setInt(1, id);
			ps.setInt(2, offset);
			ps.setInt(3, limit);
			ArrayList<Ordine> orders = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ordine o = new Ordine();
				o.setId(rs.getInt(1));
				o.setIdproduct(rs.getInt(2));
				o.setQuantity(rs.getInt(3));
				o.setPrice(rs.getLong(4));
				orders.add(o);
			}
			return orders;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int doRetrieveNumberByUser(int id) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT id FROM `order` LEFT JOIN user_order ON id=idorder WHERE iduser=?");
			ps.setInt(1, id);
			int n= 0;;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				n++;
			}
			return n;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Ordine> doRetrieveAll(int offset, int limit){
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("SELECT id, idproduct, quantity, price FROM `order` LIMIT ?, ?");
			ps.setInt(1, offset);
			ps.setInt(2, limit);
			ArrayList<Ordine> orders = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ordine o = new Ordine();
				o.setId(rs.getInt(1));
				o.setIdproduct(rs.getInt(2));
				o.setQuantity(rs.getInt(3));
				o.setPrice(rs.getLong(4));
				orders.add(o);
			}
			return orders;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
