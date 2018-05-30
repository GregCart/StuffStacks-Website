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

import Objects.Book;
import Objects.Video;

/**
 * Servlet implementation class bHome
 */
@WebServlet(name="Home.java", urlPatterns="/vHome")
public class bHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public bHome() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File f = new File("D:\\Programming\\Workspaces\\Eclipse\\Apps\\StuffStacks - HTML\\bin\\WebContent\\Shelf.txt");
		
		if (!f.exists()) {
			f.createNewFile();
		}

		
		String title = request.getParameter("titl");
		String author = request.getParameter("autho");
		String publisher = request.getParameter("publish");
		String released = request.getParameter("publishe");
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
		int Flength = Integer.parseInt(length);
		String link = request.getParameter("Link");
		URL fLink = new URL(link);
		String file = request.getParameter("fileN");
		File fFile = new File(file);
		String sName, eName, sNum, eNum;
		int nSNum, nENum;
		Boolean isSeries;
		if (request.getParameter("isS") == "true") {
			isSeries = true;
			sName = request.getParameter("serName");
			sNum = request.getParameter("seriesN");
			nSNum = Integer.parseInt(sNum);
		} else{
			isSeries = false;
			sName = (String) null;
			sNum = (String) null;
			nSNum = (Integer) null;
		}
		
		Book book;
		if(isSeries == true && fFile != null && fLink != null) {
			book = new Book(title, author, sName, publisher, Flength, nSNum, fFile, fLink, fDate, isSeries);
		} else if (isSeries == true && fFile != null && fLink == null) {
			book = new Book(title, author, sName, publisher, Flength, nSNum, fFile, fDate, isSeries);
		} else {
			book = new Book(title, author, sName, publisher, Flength, nSNum, fLink,fDate, isSeries);
		}
		
		Gson g = new Gson();
		String j = g.toJson(book);
		
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
