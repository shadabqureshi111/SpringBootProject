package com.csm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.csm.model.Emp;

public class EmpDao 
{
	private static Connection con;

	public static Connection getConnection() 
	{
	
		try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shadab", "root", "root");
			} 
		catch (Exception e) 
			{
				System.out.println(e);
			}
		return con;
	}

	public static int save(Emp e) {
		int status = 0;
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into emp(id,name,salary) values (?,?,?)");
			ps.setLong(1, e.getId());
			ps.setString(2, e.getName());
			ps.setDouble(3, e.getSalary());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Emp e) {
		int status = 0;
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update emp set name=?,salary=? where id=?");
			ps.setString(1, e.getName());
			ps.setDouble(2, e.getSalary());
			ps.setLong(3, e.getId());
			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from emp where id=?");
			ps.setLong(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	
	public static List<Emp> getAllEmployees() {
		List<Emp> list = new ArrayList<Emp>();

		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getLong(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public static Emp getEmployeeById(int id){
		Emp e=new Emp();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from emp where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getLong(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getDouble(3));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
}