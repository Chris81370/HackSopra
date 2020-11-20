package pack;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Vulnerabilite v = new Vulnerabilite();
		// v.create();
		// v.setIdV(5);
		// v.delete();
		// v.readSelect();
		Abonne a = new Abonne("132@gmail.com");
		a.setIdA(4);
		a.update();
	}

}
