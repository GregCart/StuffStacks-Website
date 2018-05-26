package SQL_Conns;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

import Objects.Book;
import Objects.Usables;

@SuppressWarnings("unused")
public class SS_Book_Stmts {
	
	private static Boolean duplicate;
	
	public static Boolean ifExists(Connection con, Book b) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("Select * FROM stuffstacks.library WHERE book_title = ?" + b.getTitle());
		ResultSet rs = stmt.executeQuery();
		if (rs.wasNull()) {
			return false;
		} else {
			return true;
		}
}
	
	@SuppressWarnings("deprecation")
	public static void insertBook(Connection con, Book b) throws SQLException {
		duplicate = ifExists(con, b);
		if (duplicate == true) {
			Logger.getLogger(b.getTitle() + "already exists!"); 
		} else {
			try {
				Statement stm = con.createStatement();
				Calendar calendar = Calendar.getInstance();
				java.util.Date currentDate = calendar.getTime();
				java.sql.Date date = new java.sql.Date(currentDate.getTime());
				stm.executeQuery("INSERT INTO stuffstacks.library VALUES (" + Usables.useBook(b) + date.getDate() + ")");
				Logger.getLogger(b.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Book retrieveBook(Connection con, Book b) throws SQLException, IOException {
		duplicate = ifExists(con, b);
		if (duplicate == true) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * FROM stuffstacks.library WHERE book_title = " + b.getTitle());
			//use rs to create book
			if (rs.getString(9) == null) {
				InputStream in = rs.getBlob(8).getBinaryStream();
				File f = new File(rs.getString(2));
				FileOutputStream out = new FileOutputStream(f);
				IOUtils.copy(in, out);
				b = new Book(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getInt(5), rs.getInt(7), f, rs.getDate(10), rs.getBoolean(11));
			} else if (rs.getString(8) == null) {
				URL u = new URL(rs.getString(9));
				b = new Book(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getInt(5), rs.getInt(7), u, rs.getDate(10), rs.getBoolean(11));
			} else {
				InputStream in = rs.getBlob(8).getBinaryStream();
				File f = new File(rs.getString(2));
				FileOutputStream out = new FileOutputStream(f);
				IOUtils.copy(in, out);
				URL u = new URL(rs.getString(9));
				b = new Book(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getInt(5), rs.getInt(7), f, u, rs.getDate(10), rs.getBoolean(11));
			}
			return b;
		} else {
			Logger.getLogger(b.getTitle() + "doesn't exist!");
			return null;
		}
	}
	
}