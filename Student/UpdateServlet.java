package com.vastpro.Student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
	        int roll=Integer.parseInt(request.getParameter("roll"));
	        int mark=Integer.parseInt(request.getParameter("up_mark"));
	        String grade=request.getParameter("up_grade");  
	         
	        
	        StudentModel stu=new StudentModel();  
	       
	        stu.setMark(mark);  
	        stu.setGrade(grade);  
	        stu.setRollNum(roll); 
	          
	        int status=StudentDB.update(stu);  
	        if(status>0)
	        {  
	        	out.print("<p>Updated succesfully</p>");
				RequestDispatcher rd=request.getRequestDispatcher("/ViewServlet");
				rd.include(request, response);
	        }
	        else
	        {  
	            out.println("Sorry! unable to update record");  
	        }  
	     
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
