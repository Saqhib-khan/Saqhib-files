package com.curd_project.package01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Student_table {
	static String url="jdbc:mysql://localhost:3306/curd_project";									
	static String user="root";
	static String pass="Rithesh@123";
	static Scanner A=new Scanner(System.in);
	public static void menu()	{
		System.out.println("***********************");
		System.out.println("****ARCTIX COLLEGE***");
		System.out.println("***********************");
		System.out.println("1.INSERT STUDENT DETAIL");
		System.out.println("2.UPDATE STUDENT DETAIL");
		System.out.println("3.DELETE STUDENT DETAIL");
		System.out.println("**4.VIEW STUDENT DETAIL");
		System.out.println("*5.STOP PROGRAM******");
		System.out.println("***********************\n\n");  }
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			while(true) {
			menu();
	   	System.out.println("ENTER YOUR CHOICE");
	   	int a=A.nextInt();
	   	switch(a)	{
	   	case 1:System.out.println("\n\nINSERT YOUR DETAILS");
	   	System.out.println("***********************");
	   	insert();
	   	break;
	   	case 2:System.out.println("\n\nUPDATE YOUR DETAILS");
	   	System.out.println("***********************");
	   	update();
	   	break;
	   	case 3:System.out.println("\n\nDELETE YOUR DETAILS");
	   	System.out.println("***********************");
	   	delete();
	   	break;
	   	case 4:System.out.println("\n\nVIEW YOUR DETAILS");
	   	System.out.println("***********************");
	   	view();
	   	break;
	   	case 5:System.out.println("\n\nPROGRAM STOPPED");
	   	System.out.println("***********************");
	   	System.exit(a);
	   	break;
	   	default :System.out.println("\n\nENTER A VALID NUMBER");
	   	System.out.println("***********************");
	   	break;
	   	}  }  }
	public static void insert() throws ClassNotFoundException, SQLException{	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
		String query="insert into student_table values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		System.out.println("\nENTER YOUR NAME:");
		String name=A.next();
		System.out.println("\nENTER YOUR COURSE:");
		String course=A.next();
		System.out.println("\nENTER YOUR REGISTER NUMBER:");
		int reg_no=A.nextInt();
		System.out.println("\nENTER YOUR DATE OF BIRTH:");
		String dob=A.next();
		System.out.println("\nENTER YOUR ADDRESS:");
		String address=A.next();
		System.out.println("\nENTER YOUR MARKS:");
		int marks=A.nextInt();
		ps.setString(1,name);
		ps.setString(2,course);
		ps.setInt(3,reg_no);
		ps.setString(4,dob);
		ps.setString(5,address);
		ps.setInt(6,marks);
		int rows=ps.executeUpdate();
		System.out.println("\nNUMBER OF ROWS AFFECTED:"+rows);
		con.close(); }
	public static void menu2() {
		System.out.println("************************");
		System.out.println("1.UPDATE NAME");
		System.out.println("2.UPDATE COURSE");
		System.out.println("3.UPDATE DATE OF BIRTH");
		System.out.println("4.UPDATE ADDRESS");
		System.out.println("5.UPDATE MARKS");
		System.out.println("************************"); }
	public static void update() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,pass);
		System.out.println("\nENTER THE REGISTER NUMBER OF THE STUDENT TO UPDATED");
		int b=A.nextInt();
		String query="select * from student_table where reg_no="+b;
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)); }
		menu2();
		int c=A.nextInt();
		switch(c){
		case 1:System.out.println("**********************");
		String query0="update student_table set name=? where reg_no="+b;
		PreparedStatement ps0=con.prepareStatement(query0);
		System.out.println("\nENTER YOUR NEW NAME:");
		String name=A.next();
		ps0.setString(1,name);
		ps0.executeUpdate();
		break;
		case 2:System.out.println("**********************");
		String query1="update student_table set course=? where reg_no="+b;
		PreparedStatement ps1=con.prepareStatement(query1);
		System.out.println("\nENTER YOUR NEW COURSE:");
		String course=A.next();
		ps1.setString(1,course);
		ps1.executeUpdate();
		break;
		case 3:System.out.println("**********************");
		String query2="update student_table set dob=? where reg_no="+b;
		PreparedStatement ps2=con.prepareStatement(query2);
		System.out.println("\nENTER YOUR NEW DATE OF BIRTH:");
		String dob=A.next();
		ps2.setString(1,dob);
		ps2.executeUpdate();
		break;
		case 4:System.out.println("**********************");
		String query3="update student_table set address=? where reg_no="+b;
		PreparedStatement ps3=con.prepareStatement(query3);
		System.out.println("\nENTER YOUR NEW ADDRESS:");
		String address=A.next();
		ps3.setString(1,address);
		ps3.executeUpdate();
		break;
		case 5:System.out.println("**********************");
		String query4="update student_table set marks=? where reg_no="+b;
		PreparedStatement ps4=con.prepareStatement(query4);
		System.out.println("\nENTER YOUR NEW MARKS:");
		int marks=A.nextInt();
		ps4.setInt(1,marks);
		ps4.executeUpdate();
		break;
		default :System.out.println("**********************");
		System.out.println("\nENTER A VALID NUMBER:");
		break;  }   }
	public static void view() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,pass);
		String query="select * from student_table";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6));}
		con.close();}
	public static void delete()
			throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,pass);
		String query="delete from student_table where reg_no=?";
		PreparedStatement ps=con.prepareStatement(query);
		System.out.println("\nENTER YOUR REGISTER NUMBER:");
		int reg_no=A.nextInt();
		ps.setInt(1,reg_no);
		int rows=ps.executeUpdate();
		System.out.println("\nNUMBER OF ROWS AFFECTED:\n\n"+rows);
		con.close();}}