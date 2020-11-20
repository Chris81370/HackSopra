package pack;

import java.sql.DriverManager; //pilote de connexion

public class Connexion {
	com.mysql.jdbc.Connection conn; // attribut de connexion
	{
		String url = "jdbc:mysql://localhost:3306/";
		String dbName;
		dbName = "tp_vulnerabilite";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		try {
			Class.forName(driver).newInstance();
			conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("la connexion a reussie");
		} catch (Exception e) {
			System.out.println("la connexion est echoué");
		}
	}

}