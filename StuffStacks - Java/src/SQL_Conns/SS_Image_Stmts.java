package SQL_Conns;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

import Objects.Image;
import Objects.Usables;

@SuppressWarnings("unused")
public class SS_Image_Stmts {
	
	private static Boolean duplicate;
	
	public static Boolean ifExists(Connection con, Image i) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("Select * FROM stuffstacks.album WHERE image_name = ?" + i.getName());
		ResultSet rs = stmt.executeQuery();
		if (rs.wasNull()) {
			return false;
		} else {
			return true;
		}
}
	
	@SuppressWarnings({ "deprecation" })
	public static void insertImage(Connection con, Image i) throws SQLException {
		duplicate = ifExists(con, i);
		if (duplicate == true) {
			Logger.getLogger(i.getName() + "already exists!"); 
		} else {
			try {
				Statement stm = con.createStatement();
				Calendar calendar = Calendar.getInstance();
				java.util.Date currentDate = calendar.getTime();
				java.sql.Date date = new java.sql.Date(currentDate.getTime());
				stm.executeQuery("INSERT INTO stuffstacks.album VALUES (" + Usables.useImage(i) + date.getDate() + ")");
				Logger.getLogger(i.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Image retrieveImage(Connection con, Image i) throws SQLException, IOException {
		duplicate = ifExists(con, i);
		if (duplicate == true) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * FROM stuffstacks.album WHERE image_name = " + i.getName());
			//use rs to create book
			ArrayList<String> al;
			if (rs.getString(6) != null) {
				//android.text.TextUtils.join(",", Image.getPeople());
				al = (ArrayList<String>) Arrays.asList(rs.getString(6).split(","));
			} else {
				al = null;
			}
			if (rs.getString(8) == null) {
				InputStream in = rs.getBlob(7).getBinaryStream();
				File f = new File(rs.getString(2));
				FileOutputStream out = new FileOutputStream(f);
				IOUtils.copy(in, out);
				i = new Image(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), al, f, rs.getDate(9), rs.getBoolean(10));
			} else if (rs.getString(7) == null) {
				URL u = new URL(rs.getString(8));
				i = new Image(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), al, u, rs.getDate(9), rs.getBoolean(10));
			} else {
				InputStream in = rs.getBlob(7).getBinaryStream();
				File f = new File(rs.getString(2));
				FileOutputStream out = new FileOutputStream(f);
				IOUtils.copy(in, out);
				URL u = new URL(rs.getString(8));
				i = new Image(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), al, u, f, rs.getDate(9), rs.getBoolean(10));
			}
			return i;
		} else {
			Logger.getLogger(i.getName() + "doesn't exist!");
			return null;
		}
	}
	
}