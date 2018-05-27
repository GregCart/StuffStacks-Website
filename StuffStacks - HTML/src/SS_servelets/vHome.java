package SS_servelets;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File f = new File("D:\\Programming\\Workspaces\\Eclipse\\Apps\\StuffStacks - HTML\\bin\\WebContent\\Contents.txt");
		
		if (!f.exists()) {
			f.createNewFile();
		}
		
		FileOutputStream fOut = new FileOutputStream(f);
		OutputStream os = response.getOutputStream();
		FileDescriptor fD = ((FileOutputStream) os).getFD();
		FileInputStream in = new FileInputStream(fD);
		IOUtils.copy(in, fOut);

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		in.close();
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
