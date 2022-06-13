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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
		PrintWriter pw=response.getWriter();
		int idd=Integer.parseInt(request.getParameter("id"));
		int roll_num=Integer.parseInt(request.getParameter("roll"));
		String name=request.getParameter("namee");
		int age=Integer.parseInt(request.getParameter("age"));
		int mark=Integer.parseInt(request.getParameter("mark"));
		String grade=request.getParameter("grade");
	
		StudentModel stu=new StudentModel();
		stu.setId(idd);
		stu.setRollNum(roll_num);
		stu.setName(name);
		stu.setAge(age);
		stu.setMark(mark);
		stu.setGrade(grade);
		
		int result=StudentDB.insert(stu);
		
		if(result>0)
		{
			pw.print("<p>Inserted succesfully</p>");
			RequestDispatcher rd=request.getRequestDispatcher("Student.html");
			rd.include(request, response);
		}
		else
		{
			pw.print(" Sorry unable to insert");
		}
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
