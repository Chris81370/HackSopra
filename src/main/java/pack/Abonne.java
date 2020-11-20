package pack;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.mysql.jdbc.PreparedStatement;

public class Abonne {
	private int IdA;
	private String nom, prenom, email;
	private LinkedList<Abonne> listeAbonnes = new LinkedList<Abonne>();

	public Abonne() {
		super();
	}

	public Abonne(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Abonne(String email) {
		super();
		this.email = email;
	}

	public LinkedList<Abonne> getListeAbonnes() {
		return listeAbonnes;
	}

	public void setListeAbonnes(LinkedList<Abonne> listeAbonnes) {
		this.listeAbonnes = listeAbonnes;
	}

	public int getIdA() {
		return IdA;
	}

	public void setIdA(int idA) {
		IdA = idA;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void create() {
		try {
			Connexion c = new Connexion(); // instance de connexion
			java.sql.PreparedStatement statement = c.conn
					.prepareStatement("INSERT INTO `abonne`( `nom`, `prenom`, `email`) VALUES  ('" + this.getNom()
							+ "','" + this.getPrenom() + "','" + this.getEmail() + "')");
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

			pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM  abonne ORDER BY IdA");

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
			String sql = "UPDATE `abonne` SET  `email`= '" + this.getEmail() + "' WHERE `IdA`='" + this.IdA + "';";
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
			String sql = "DELETE FROM `abonne` WHERE `IdA`=?";
			java.sql.PreparedStatement statement = c.conn.prepareStatement(sql);
			statement.setInt(1, this.getIdA());
			statement.execute();

			System.out.println("Suppression réussie");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	public void lister() throws SQLException {
		Connexion c = new Connexion();
		PreparedStatement pst;
		pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM abonne");
		pst.executeQuery();
		ResultSet rs = (ResultSet) pst.executeQuery();
		while (rs.next()) {
			System.out.println("nom: " + rs.getString("nom") + " prenom: " + rs.getString("prenom"));
		}
	}

	public LinkedList<Abonne> display() throws SQLException {
		// Variable Creation
		LinkedList<Abonne> listeabonnes = new LinkedList<Abonne>();
		ResultSet rs = this.read();
		// Parcour Base Donnes
		while (rs.next()) {
			Abonne a = new Abonne();
			// Set Object Parameters
			a.setIdA(rs.getInt("IdA"));
			a.setNom(rs.getString("nom"));
			a.setPrenom(rs.getString("prenom"));
			a.setEmail(rs.getString("email"));
			// Add object to the list
			listeabonnes.add(a);
		}
		return listeabonnes;
	}

	public String mailList() throws SQLException {
		String listEmail = "";
		for (Abonne ab : this.display()) {
			listEmail = listEmail + ", " + ab.getEmail();
		}
		return listEmail.substring(2);
	}
}
