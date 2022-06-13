package com.vastpro.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDB 
{
	public final static String DB_DRIVER_CLASS = "org.postgresql.Driver"; 
	private static String DB_URL = "jdbc:postgresql://localhost:5432/vastpro";
	private static String DB_USER = "postgres";
	private static String DB_PASSWORD = "postgres";
	private static String INSERT = "insert into studentdate (id,roll_num,name,age,totalmarks,grade) values (?,?,?,?,?,?);";
	private static String UPDATE = "update studentdate set totalmarks=?,grade=? where roll_num=?";
	private static String DELETE = "delete from studentdate where roll_num=?;";
	private static String SELECT="select * from studentdate where grade=?;";
	private static String SELECTALL="select * from studentdate;";
	
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName(DB_DRIVER_CLASS);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("Success");
		}
		catch(ClassNotFoundException |SQLException e)
		{
			System.out.println("Error connection");
		}
		return con;
	}
	
	public static int insert(StudentModel stu)
	{
		int res=0;
		try
		{
			Connection con=StudentDB.getConnection();
			PreparedStatement ps=con.prepareStatement(INSERT);
			ps.setInt(1,stu.getId());
			ps.setInt(2, stu.getRollNum());
			ps.setString(3, stu.getName());
			ps.setInt(4, stu.getAge());
			ps.setInt(5, stu.getMark());
			ps.setString(6, stu.getGrade());
			res=ps.executeUpdate();
			ps.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("result:"+res);
		return res;
	}
	
	public static int update(StudentModel stu)
	{  
        int status=0;  
        try{  
            Connection con=StudentDB.getConnection();  
            PreparedStatement ps=con.prepareStatement(UPDATE);
           
            ps.setInt(1,stu.getMark());  
            ps.setString(2, stu.getGrade());
            ps.setInt(3, stu.getRollNum());
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
	public static int delete(int roll)
    {  
        int status=0;  
        try{  
            Connection con=StudentDB.getConnection();  
            PreparedStatement ps=con.prepareStatement(DELETE);  
            ps.setInt(1,roll);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
	
	  public static List<StudentModel> getStudentByGrade(String grade)
	    {  
		  List<StudentModel> list=new ArrayList<StudentModel>(); 
	        try{  
	            Connection con=StudentDB.getConnection();  
	            PreparedStatement ps=con.prepareStatement(SELECT);  
	            ps.setString(1,grade);  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){ 
	            	StudentModel stu=new StudentModel();
	            	stu.setId(rs.getInt(1));  
	            	stu.setRollNum(rs.getInt(2));  
	            	stu.setName(rs.getString(3));  
	            	stu.setAge(rs.getInt(4));  
	            	stu.setMark(rs.getInt(5));  
	            	stu.setGrade(rs.getString(6));
	            	list.add(stu);
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return list;  
	    }  
	    
	    public static List<StudentModel> getAllStudents()
	    {  
	        List<StudentModel> list=new ArrayList<StudentModel>();  
	          
	        try{  
	            Connection con=StudentDB.getConnection();  
	            PreparedStatement ps=con.prepareStatement(SELECTALL);  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	StudentModel stu=new StudentModel();  
	            	stu.setId(rs.getInt(1));  
	            	stu.setRollNum(rs.getInt(2));  
	            	stu.setName(rs.getString(3));  
	            	stu.setAge(rs.getInt(4));  
	            	stu.setMark(rs.getInt(5));  
	            	stu.setGrade(rs.getString(6));
	                list.add(stu);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }
}
