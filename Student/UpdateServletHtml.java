package com.vastpro.Student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServletHtml
 */
@WebServlet("/UpdateServletHtml")
public class UpdateServletHtml extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServletHtml() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Student Mark and grade</h1>"); 
        int roll=Integer.parseInt(request.getParameter("roll")); 
          
        out.print("<form method='post'>");  
        out.print("<table>");  
        out.print("<tr><td>Mark:</td><td><input type='text' name='up_mark'  /></td></tr>");  
        out.print("<tr><td>Grade:</td><td><input type='text' name='up_grade' /></td></tr>"); 
        out.print("<tr><td>Roll Number</td><td><input type='text' name='roll' /></td></tr>"); 
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save ' formaction='UpdateServlet'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
