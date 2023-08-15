package org.techhub.SpringMVC.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.techhub.SpringMVC.model.Employee;

@Repository("employeeRepo")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	List<Employee> employeeList;

	public EmployeeRepositoryImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rnt", "root", "Nikhil@21");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean findByEmpMail(String mail) {
		String query = "select * from employee_info where emp_mail = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException s) {
			System.out.println(s);
			return true;
		}
	}

	@Override
	public boolean findByEmpContact(String contact) {
		String query = "select * from employee_info where contact_no = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, contact);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException s) {
			System.out.println(s);
			return true;
		}
	}

	@Override
	public boolean isAddEmployee(Employee e) {
		String query = "insert into employee_info values(?,?,?,?,?,?,'0')";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, e.getEmpContact());
			pstmt.setString(2, e.getEmpName());
			pstmt.setString(3, e.getEmpMail());
			pstmt.setString(4, e.getEmpGender());
			pstmt.setString(5, e.getPassword());
			pstmt.setDouble(6, e.getEmpSal());		
			int val = pstmt.executeUpdate();
			if (val > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e1) {
			System.out.println(e1);
			return false;
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		employeeList = new ArrayList<Employee>();
		String query = "select * from employee_info";
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getInt(7));
				e.setEmpName(rs.getString(2));
				e.setEmpMail(rs.getString(3));
				e.setEmpContact(rs.getString(1));
				e.setEmpGender(rs.getString(4));
				e.setPassword(rs.getString(5));
				e.setEmpSal(rs.getDouble(6));
				employeeList.add(e);
			}
			return employeeList;
		} catch (Exception e1) {
			System.out.println(e1);
			return employeeList;
		}
	}

	@Override
	public boolean validation(String email, String password) {
		String query = "select * from employee_info where emp_mail = ? and emp_password = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException s) {
			System.out.println(s);
			return false;
		}
	}

	@Override
	public List<Employee> getEmployee(String mail) {
		try {
			pstmt = con.prepareStatement("select * from employee_info where emp_mail = ?");
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			employeeList = new ArrayList<Employee>();
			while (rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getInt(6));
				e.setEmpName(rs.getString(2));
				e.setEmpMail(rs.getString(3));
				e.setEmpContact(rs.getString(1));
				e.setEmpGender(rs.getString(4));
				e.setPassword(rs.getString(5));
				employeeList.add(e);
			}
			return employeeList;
		} catch (Exception e1) {
			System.out.println(e1);
			return employeeList;
		}
	}

	@Override
	public boolean isDeleteById(int id) {
		try {
			pstmt = con.prepareStatement("delete from employee_info where emp_id = ?");
			pstmt.setInt(1, id);
			int val = pstmt.executeUpdate();
			if (val > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e1) {
			System.out.println(e1);
			return false;
		}
	}

	@Override
	public List<Employee> getEmployeeById(int id) {
		try {
			pstmt = con.prepareStatement("select * from employee_info where emp_id = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			employeeList = new ArrayList<Employee>();
			while (rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getInt(7));
				e.setEmpContact(rs.getString(1));
				e.setEmpName(rs.getString(2));
				e.setEmpMail(rs.getString(3));
				e.setEmpGender(rs.getString(4));
				e.setPassword(rs.getString(5));
				e.setEmpSal(rs.getDouble(6));
				employeeList.add(e);
			}
			return employeeList;
		} catch (Exception e1) {
			System.out.println(e1);
			return employeeList;
		}
	}

	@Override
	public boolean isUpdateEmployee(int id, String name, String email, String contact, String gender, String password, int uniId, double sal) {
		try {
			pstmt = con.prepareStatement("update employee_info set emp_id=?, emp_name=?, emp_mail=?, contact_no=?, emp_gender=?, emp_password=?,emp_sal=? where emp_id=?");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, contact);
			pstmt.setString(5, gender);
			pstmt.setString(6, password);
			pstmt.setDouble(7, sal);
			pstmt.setInt(8, uniId);
			int val1 = pstmt.executeUpdate();
			if (val1 > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e1) {
			System.out.println(e1);
			return false;
		}
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		try {
			pstmt = con.prepareStatement("select * from employee_info where emp_name = ?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			employeeList = new ArrayList<Employee>();
			while (rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getInt(7));
				e.setEmpName(rs.getString(2));
				e.setEmpMail(rs.getString(3));
				e.setEmpContact(rs.getString(1));
				e.setEmpGender(rs.getString(4));
				e.setPassword(rs.getString(5));
				e.setEmpSal(rs.getDouble(6));
				employeeList.add(e);
			}
			return employeeList;
		} catch (Exception e1) {
			System.out.println(e1);
			return null;
		}
	}

	@Override
	public List<Employee> getByGender(String gender) {
		String query="select * from employee_info where emp_gender = ?";
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, gender);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setEmpId(rs.getInt(7));
				e.setEmpName(rs.getString(2));
				e.setEmpMail(rs.getString(3));
				e.setEmpContact(rs.getString(1));
				e.setEmpGender(rs.getString(4));
				e.setEmpSal(rs.getDouble(6));
				employeeList.add(e);
			}
			return employeeList;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
}
