package SQL_Conns;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Objects.*;


public class SS_Con {
	
	public int objID;
	public int intent;
	

	public static Boolean estCon(Object o, int objID, int intent) throws ClassNotFoundException, SQLException {
		Connection con;
		Boolean success = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		String URL = "jdbc:mysql://127.0.0.1:3306/?";
		String user = "root";
		String pass = "P@ssw0rd";
		con = DriverManager.getConnection(URL, user, pass);
		
		switch (intent) {
		case 0: //check
			
		case 1: //insert
			success = insert(con, o, objID);
		case 2: //pull
			
		}
		
		if (success == true) {
			return true;
		} else {
			return false;
		}		
	}
	
	public static Boolean insert(Connection con, Object o, int objID) throws SQLException {
		switch (objID) {
		case 0:
			SS_Book_Stmts.insertBook(con, (Book) o);
		case 1:
			SS_Image_Stmts.insertImage(con, (Image) o);
		case 2:
			SS_Song_Stmts.insertSong(con, (Song) o);
		case 3:
			SS_Video_Stmts.insertVideo(con, (Video) o);
		}
		con.close();
		return true;
	}
}
