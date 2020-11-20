package pack;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class ContreMesure {
	private int IdC, IdV;
	private String titre, description, sources;

	public ContreMesure() {
		super();
	}

	public ContreMesure(int idV, String titre, String description, String sources) {
		super();
		IdV = idV;
		this.titre = titre;
		this.description = description;
		this.sources = sources;
	}

	public ContreMesure(String description, String sources) {
		super();
		this.description = description;
		this.sources = sources;
	}

	public int getIdV() {
		return IdV;
	}

	public void setIdV(int idV) {
		IdV = idV;
	}

	public int getIdC() {
		return IdC;
	}

	public void setIdC(int idC) {
		IdC = idC;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSources() {
		return sources;
	}

	public void setSources(String sources) {
		this.sources = sources;
	}

	public void create() {
		try {
			Connexion c = new Connexion(); // instance de connexion
			java.sql.PreparedStatement statement = c.conn
					.prepareStatement("INSERT INTO `contremesure`( `IdV`, `titre`, `description`, `sources`) VALUES  ('"
							+ this.getIdV() + "','" + this.getTitre() + "','" + this.getDescription() + "','"
							+ this.getSources() + "')");
			statement.executeUpdate();
			// JOptionPane.showMessageDialog(null, "Ajouté avec succés", "",
			// JOptionPane.INFORMATION_MESSAGE);
			System.out.println("ajout réussi");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	public ResultSet read() { // TODO Auto-generated method stub try {

		try {

			Connexion c = new Connexion();
			PreparedStatement pst;

			pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM  contremesure ORDER BY IdC");

			pst.executeQuery();
			ResultSet rs = (ResultSet) pst.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void update() throws SQLException {
		try {
			Connexion c = new Connexion();
			String sql = "UPDATE `contremesure` SET  `description`= '" + this.getDescription() + "',`sources`= '"
					+ this.getSources() + "' WHERE `IdC`='" + this.IdC + "';";
			java.sql.PreparedStatement statement = c.conn.prepareStatement(sql);
			statement.executeUpdate();
			;
			System.out.println("Modification réussie");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	public void delete() {
		try {
			Connexion c = new Connexion();
			String sql = "DELETE FROM `contremesure` WHERE `IdC`=?";
			java.sql.PreparedStatement statement = c.conn.prepareStatement(sql);
			statement.setInt(1, this.getIdC());
			statement.execute();

			System.out.println("Suppression réussie");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	public ResultSet detail(int idV1) throws SQLException {
		// TODO Auto-generated method stub
		Connexion c = new Connexion();
		PreparedStatement pst;
		pst = (PreparedStatement) c.conn.prepareStatement(
				"SELECT vu.titre, vu.description, vu.gravite, vu.logiciels, cm.titre, cm.description, cm.sources FROM contremesure cm, vulnerabilite vu  WHERE vu.idV="
						+ idV1 + " and vu.idV=cm.idV ");
		pst.executeQuery();
		ResultSet rsc = (ResultSet) pst.executeQuery();
		return rsc;
	}

	public ResultSet jointure() throws SQLException {
		// TODO Auto-generated method stub
		Connexion c = new Connexion();
		PreparedStatement pst;
		pst = (PreparedStatement) c.conn.prepareStatement(
				"SELECT vu.titre, vu.description, vu.gravite, vu.logiciels, cm.titre, cm.description, cm.sources FROM contremesure cm, vulnerabilite vu  WHERE vu.idV=cm.idV ");
		pst.executeQuery();
		ResultSet rsc = (ResultSet) pst.executeQuery();
		return rsc;
	}
}
