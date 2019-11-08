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
public class ProdottoDAO {

	public List<Prodotto> doRetrieveAll(int offset, int limit) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("SELECT id, name, description, price, path FROM product LIMIT ?, ?");
			ps.setInt(1, offset);
			ps.setInt(2, limit);
			ArrayList<Prodotto> prodotti = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prodotto p = new Prodotto();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setDescrizione(rs.getString(3));
				p.setPrezzoCent(rs.getInt(4));
				p.setCategoria(getCategoria(con, p.getId()));
				p.setImage(rs.getBytes(5));
				prodotti.add(p);
			}
			return prodotti;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static Categoria getCategoria(Connection con, int idProdotto) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"SELECT id, name, description FROM category LEFT JOIN product_category ON id=idcategory WHERE idproduct=?");
		ps.setInt(1, idProdotto);
		Categoria categoria= new Categoria();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			categoria.setId(rs.getInt(1));
			categoria.setNome(rs.getString(2));
			categoria.setDescrizione(rs.getString(3));
		}
		return categoria;
	}
	
	public Prodotto doRetrieveById(int id) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("SELECT id, name, description, price, path FROM product WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Prodotto p = new Prodotto();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setDescrizione(rs.getString(3));
				p.setPrezzoCent(rs.getLong(4));
				p.setCategoria(getCategoria(con, p.getId()));
				p.setImage(rs.getBytes(5));
				return p;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Prodotto> doRetrieveByMatch(String against, int offset, int limit) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, name, description, price, path FROM product WHERE MATCH(name, description) AGAINST( ? IN BOOLEAN MODE) LIMIT ?, ?");
			ps.setString(1, against);
			ps.setInt(2, offset);
			ps.setInt(3, limit);
			ArrayList<Prodotto> prodotti = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prodotto p = new Prodotto();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setDescrizione(rs.getString(3));
				p.setPrezzoCent(rs.getLong(4));
				p.setCategoria(getCategoria(con, p.getId()));
				p.setImage(rs.getBytes(5));
				prodotti.add(p);
			}
			return prodotti;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Prodotto> doRetrieveByCategoria(int categoria, int offset, int limit) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT id, name, description, price, path FROM product LEFT JOIN product_category ON id=idproduct WHERE idcategory=? LIMIT ?, ?");
			ps.setInt(1, categoria);
			ps.setInt(2, offset);
			ps.setInt(3, limit);
			ArrayList<Prodotto> prodotti = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Prodotto p = new Prodotto();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setDescrizione(rs.getString(3));
				p.setPrezzoCent(rs.getLong(4));
				p.setCategoria(getCategoria(con, p.getId()));
				p.setImage(rs.getBytes(5));
				prodotti.add(p);
			}
			return prodotti;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void doDelete(int id) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM product WHERE id=?");
			ps.setInt(1, id);
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("DELETE error.");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void doSave(Prodotto prodotto) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO product (name, description, price, path) VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, prodotto.getNome());
			ps.setString(2, prodotto.getDescrizione());
			ps.setLong(3, prodotto.getPrice());
			ps.setBytes(4, prodotto.getImage());
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("INSERT error.");
			}
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			prodotto.setId(id);

			PreparedStatement psCa = con
					.prepareStatement("INSERT INTO product_category (idproduct, idcategory) VALUES (?, ?)");
			psCa.setInt(1, id);
			psCa.setInt(2, prodotto.getCategoria().getId());
			psCa.addBatch();
			psCa.executeBatch();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}