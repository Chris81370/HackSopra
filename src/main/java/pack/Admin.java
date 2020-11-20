package pack;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
	private String idAdm, identifiant, mdp;

	public String getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(String idAdm) {
		this.idAdm = idAdm;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Admin() {
		super();
	}

	public Admin(String identifiant, String mdp) {
		super();
		this.identifiant = identifiant;
		this.mdp = mdp;
	}

	public Admin(String idAdm, String identifiant, String mdp) {
		super();
		this.idAdm = idAdm;
		this.identifiant = identifiant;
		this.mdp = mdp;
	}

	public Admin authentifier() {
		try {
			Connexion c = new Connexion();
			PreparedStatement pst;
			pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM `admin` WHERE `identifiant`='"
					+ this.identifiant + "' AND `mdp`='" + this.mdp + "'");
			pst.executeQuery();
			ResultSet rs = (ResultSet) pst.executeQuery();
			if (rs.next()) {
				Admin adm = new Admin();
				adm.setIdentifiant(rs.getString("identifiant"));
				adm.setMdp(rs.getString("mdp"));
				return adm;
			} else
				return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}