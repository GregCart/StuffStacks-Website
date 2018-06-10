package SS_servelets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Objects.Usables;
import Objects.Video;

/**
 * Servlet implementation class bHome
 */
@WebServlet(name="vHome", urlPatterns= {"/vHome/ins", "/vHome/get"})
@WebInitParam(name = "allowedTypes", value = "mp4,mp5")
public class vidCalls extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public vidCalls() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inte = request.getServletPath();
		File f = new File("D:\\Programming\\Workspaces\\Eclipse\\Apps\\StuffStacks - HTML\\bin\\WebContent\\Vids.txt");
		
		if (!f.exists()) {
			f.createNewFile();
		}

		if (inte == "/ins") {	
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
			//System.out.println(fDate);
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
			if (isSeason == null) {
				m = null;
			}
			
			Video video;
			if(isSeason == true && fFile != null && fLink != null) {
				video = new Video(title, creator, type, m, fFile, fLink, Flength, fDate, isSeason);
			} else if (isSeason == true && fFile != null && fLink == null) {
				video = new Video(title, creator, type, m, fFile, Flength, fDate, isSeason);
			} else {
				video = new Video(title, creator, type, m, fLink, Flength, fDate, isSeason);
			}
			
			Gson g = new Gson();
			String j = g.toJson(video);
			
			FileOutputStream fOut = new FileOutputStream(f);
			byte[] v = j.getBytes();
			fOut.write(v);
	
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());
			fOut.close();
		} else if (inte == "/get") {
			Scanner fScan = new Scanner(f);
			ArrayList<Object[]> lOVids = new ArrayList<Object[]>();
			Gson g = new Gson();

			
			while (fScan.hasNextLine()) {
				Video v =  g.fromJson(fScan.nextLine(), Video.class);
				Object[] o = Usables.useVideo(v);
				lOVids.add(o);
			}
			
			Object[] vA = lOVids.toArray();
			String j = g.toJson(vA);
//			StringBuffer sb = request.getRequestURL();
//			Document page = Jsoup.parse(readURL(sb.toString()));
//			Element ol = page.getElementById("list");
			response.getWriter().write(j);
			fScan.close();
		}
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static String readURL(String url) {

        String fileContents = "";
        String currentLine = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            fileContents = reader.readLine();
            while (currentLine != null) {
                currentLine = reader.readLine();
                fileContents += "\n" + currentLine;
            }
            reader.close();
            reader = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error Message", JOptionPane.OK_OPTION);
            e.printStackTrace();

        }

        return fileContents;
    }

}
