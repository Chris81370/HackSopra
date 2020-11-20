package pack;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Vulnerabilite {
	private int IdV, gravite;
	private String titre, synthese, description, logiciels;

	public Vulnerabilite() {
		super();
	}

	public Vulnerabilite(int gravite, String titre, String synthese, String description, String logiciels) {
		super();
		this.gravite = gravite;
		this.titre = titre;
		this.synthese = synthese;
		this.description = description;
		this.logiciels = logiciels;
	}

	public int getIdV() {
		return IdV;
	}

	public void setIdV(int idV) {
		IdV = idV;
	}

	public int getGravite() {
		return gravite;
	}

	public void setGravite(int gravite) {
		this.gravite = gravite;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getSynthese() {
		return synthese;
	}

	public void setSynthese(String synthese) {
		this.synthese = synthese;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogiciels() {
		return logiciels;
	}

	public void setLogiciels(String logiciels) {
		this.logiciels = logiciels;
	}

	public void create() {
		try {
			Connexion c = new Connexion(); // instance de connexion
			java.sql.PreparedStatement statement = c.conn.prepareStatement(
					"INSERT INTO `vulnerabilite`( `titre`, `synthese`, `description`, `logiciels`, `gravite`) VALUES  ('"
							+ this.getTitre() + "','" + this.getSynthese() + "','" + this.getDescription() + "','"
							+ this.getLogiciels() + "','" + this.getGravite() + "')");
			statement.executeUpdate();
			// JOptionPane.showMessageDialog(null, "Ajouté avec succés", "",
			// JOptionPane.INFORMATION_MESSAGE);
			System.out.println("ajout réussi");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	public ResultSet read() throws SQLException { // TODO Auto-generated method stub try {

		Connexion c = new Connexion();
		PreparedStatement pst;
		pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM  vulnerabilite ORDER BY IdV");
		pst.executeQuery();
		ResultSet rs = (ResultSet) pst.executeQuery();
		return rs;
	}

	public void update() throws SQLException {
		try {
			Connexion c = new Connexion();
			String sql = "UPDATE `vulnerabilite` SET  `synthese`='" + this.getSynthese() + "',`description`='"
					+ this.getDescription() + "',`logiciels`='" + this.getLogiciels() + "',`gravite`='"
					+ this.getGravite() + "' WHERE `IdV`='" + this.IdV + "';";
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
			String sql = "DELETE FROM `vulnerabilite` WHERE `IdV`=?";
			java.sql.PreparedStatement statement = c.conn.prepareStatement(sql);
			statement.setInt(1, this.getIdV());
			statement.execute();

			System.out.println("Suppression réussie");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	public ResultSet select() throws SQLException {
		Connexion c = new Connexion();
		PreparedStatement pst;
		pst = (PreparedStatement) c.conn.prepareStatement(
				"SELECT idV,titre,synthese,logiciels, gravite FROM vulnerabilite order by idV desc limit 4");
		pst.executeQuery();
		ResultSet rs = (ResultSet) pst.executeQuery();
		return rs;

	}

	public ResultSet detailVul(int idV1) throws SQLException {

		Connexion c = new Connexion();
		PreparedStatement pst;
		pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM vulnerabilite WHERE idV=" + idV1 + " ");
		pst.executeQuery();
		ResultSet rsv = (ResultSet) pst.executeQuery();
		return rsv;
	}
	
}
