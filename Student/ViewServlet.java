package com.vastpro.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
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
	        out.println("<a href='Student.html'>Add New Student</a>");  
	        out.println("<h1>Students List</h1>");  
	          
	        List<StudentModel> list=StudentDB.getAllStudents();  
	          
	        out.print("<table border='1' width='100%'>");  
	        out.print("<tr><th>Id</th><th>Roll Number</th><th>Name</th><th>Age"
	        		+ "</th><th>Mark</th><th>Grade</th><th>Edit</th><th>Delete</th></tr>");  
	        for(StudentModel stu:list)
	        {  
	         out.print("<tr><td>"+stu.getId()+"</td><td>"+stu.getRollNum()+"</td><td>"+stu.getName()+"</td><td>"+stu.getAge()+
	        		 "</td><td>"+stu.getMark()+"</td><td>"+stu.getGrade()+"</td>"
	        		 		+ "<td><a href='UpdateServletHtml?roll="+stu.getRollNum()+
	        		 "'>edit</a></td><td><a href='DeleteServlet?roll="+stu.getRollNum()+"'>delete</a></td></tr>");  
	        }  
	        out.print("</table>");  
	          
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
