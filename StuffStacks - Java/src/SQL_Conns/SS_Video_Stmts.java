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

import Objects.Usables;
import Objects.Video;

@SuppressWarnings("unused")
public class SS_Video_Stmts {
	
	private static Boolean duplicate;
	
	public static Boolean ifExists(Connection con, Video v) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * FROM stuffstacks.folder WHERE video_title = '" + v.getTitle() + "'");
		if (rs.wasNull()) {
			return false;
		} else {
			return true;
		}
}
	
	@SuppressWarnings("deprecation")
	public static void insertVideo(Connection con, Video v) throws SQLException {
		duplicate = ifExists(con, v);
		if (duplicate == true) {
			Logger.getLogger(v.getTitle() + "already exists!"); 
		} else {
			Statement stm = con.createStatement();
			Calendar calendar = Calendar.getInstance();
			java.util.Date currentDate = calendar.getTime();
			java.sql.Date date = new java.sql.Date(currentDate.getTime());
			Object[] u = Usables.useVideo(v);
			stm.executeQuery("INSERT INTO stuffstacks.folder Video_title, video_creator, video_type, video_se, video_file, video_link, video_length, video_displayed, video_isSeason, video_dateAdded)VALUES (" + u[0] + u[1] + u[2] + u[3] + u[4] + u[5] + u[6] + u[7] + u[8] + u[9] + date.getDate() + ")");
			Logger.getLogger(v.toString());
			}
	}
	
	@SuppressWarnings("null")
	public static Video retrieveVideo(Connection con, Video v) throws SQLException, IOException {
		duplicate = ifExists(con, v);
		if (duplicate == true) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * FROM stuffstacks.folder WHERE video_title LIKE " + v.getTitle());
			//use rs to create book
			double d;
			if (rs.getDouble(5) != (Double) null) {
				//android.text.TextUtils.join(",", Video.getPeople());
				d = rs.getDouble(5);
			} else {
				d = (Double) null;
			}
			if (rs.getString(7) == null) {
				InputStream in = rs.getBlob(6).getBinaryStream();
				File f = new File(rs.getString(2));
				FileOutputStream out = new FileOutputStream(f);
				IOUtils.copy(in, out);
				v = new Video(rs.getString(2), rs.getString(3), rs.getString(4), d, f, rs.getDouble(8), rs.getDate(9), rs.getBoolean(10));
			} else if (rs.getString(6) == null) {
				URL u = new URL(rs.getString(7));
				v = new Video(rs.getString(2), rs.getString(3), rs.getString(4), d, u, rs.getDouble(8), rs.getDate(9), rs.getBoolean(10));
			} else {
				InputStream in = rs.getBlob(6).getBinaryStream();
				File f = new File(rs.getString(2));
				FileOutputStream out = new FileOutputStream(f);
				IOUtils.copy(in, out);
				URL u = new URL(rs.getString(7));
				v = new Video(rs.getString(2), rs.getString(3), rs.getString(4), d, f, u, rs.getDouble(8), rs.getDate(9), rs.getBoolean(10));
			}
			return v;
		} else {
			Logger.getLogger(v.getTitle() + "doesn't exist!");
			return null;
		}
	}
	
}