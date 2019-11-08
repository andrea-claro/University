package model;
/**
 * @author Andrea Claro
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
	public List<Categoria> doRetrieveAll() {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("SELECT id, name, description FROM category");
			ArrayList<Categoria> categorie = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getInt(1));
				c.setNome(rs.getString(2));
				c.setDescrizione(rs.getString(3));
				categorie.add(c);
			}
			return categorie;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void doSave(Categoria categoria) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO category (name, description) VALUES(?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, categoria.getNome());
			ps.setString(2, categoria.getDescrizione());
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("INSERT error.");
			}
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			categoria.setId(rs.getInt(1));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void doDelete(int id) {
		try (Connection con = ConPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM category WHERE id=?");
			ps.setInt(1, id);
			if (ps.executeUpdate() != 1) {
				throw new RuntimeException("DELETE error.");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}