package assprac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/SessionTrackingHiddenField")
public class SessionTrackingHiddenField extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTrackingHiddenField() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			response.setContentType("text/html");  
	        PrintWriter pw = response.getWriter();  
	        String str=request.getParameter("userName");
	        pw.print("Welcome "+str+"\n");
	        //creating form that have invisible textfield 
	        
	        pw.print("<form action='Project8'>");  
	        pw.print("<p style=\"text-align: center;\">");
	        pw.print("	<input type='hidden' name='uname' value='"+str+"'>");  
	        pw.print("	<input type='submit' value='Click here for Hidden form field tracking'>");  
	        pw.print("</p>");
	        pw.print("</form>");  
	        pw.close();  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
