package SS_servelets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import Objects.Video;

/**
 * Servlet implementation class bHome
 */
@WebServlet(name="Home.java", urlPatterns="/vHome")
public class vHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public vHome() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File f = new File("D:\\Programming\\Workspaces\\Eclipse\\Apps\\StuffStacks - HTML\\bin\\WebContent\\Contents.txt");
		
		if (!f.exists()) {
			f.createNewFile();
		}
		
		String title = request.getParameter("title");
		String creator = request.getParameter("create");
		String type = request.getParameter("type");
		String released = request.getParameter("found");
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		Date fDate = null;
		try {
			fDate = DATE_FORMAT.parse(released);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String length = request.getParameter("lengt");
		double Flength = Double.parseDouble(length);
		String link = request.getParameter("Link");
		URL fLink = new URL(link);
		String file = request.getParameter("fileN");
		File fFile = new File(file);
		String sName, eName, sNum, eNum;
		Integer nSNum, nENum;
		Boolean isSeason;
		if (request.getParameter("isS") == "true") {
			isSeason = true;
			sName = request.getParameter("seasonName");
			sNum = request.getParameter("seasonNum");
			eName = request.getParameter("epiName");
			eNum = request.getParameter("epiNum");
			nSNum = Integer.parseInt(sNum);
			nENum = Integer.parseInt(eNum);
		} else{
			isSeason = false;
			sName = (String) null;
			sNum = (String) null;
			eName = (String) null;
			eNum = (String) null;
			nSNum = (Integer) null;
			nENum = (Integer) null;
		}
		

		Map<String, Integer[]> m = new HashMap<String, Integer[]>();
		Integer[] SN = {nSNum, nENum};
		m.put(sName, SN);
		m.put(eName, SN);
		String SNS = SN[0] + "." + SN[1];
		Object SE;
		if (SN[0] == null) {
			SE = null;
		} else {
			SE = Double.parseDouble(SNS);
		}
		Video video = new Video(title, creator, type, SE, fFile, fLink, Flength, fDate, isSeason);
		
		Gson g = new Gson();
		String j = g.toJson(video);
		
		FileOutputStream fOut = new FileOutputStream(f);
		byte[] b = j.getBytes();
		fOut.write(b);

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		fOut.close();
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
