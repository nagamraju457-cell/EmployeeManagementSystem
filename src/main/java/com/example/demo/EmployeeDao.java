package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	@Autowired
	private JdbcTemplate temp;
	
	public String StoreData(Employee emp)
	{
		String qry="Insert into Employee values(?,?,?)";
		temp.update(qry,emp.getId(),emp.getName(),emp.getSal());
		return "row created";
	}
	public List<Employee> getData()
	{
		String qry="select * from Employee";
		return temp.query(qry,(rs,rowNum)->{
			Employee emp=new Employee();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setSal(rs.getDouble("salary"));
			return emp;
		});
	}
	public String Update(Employee emp)
	{
		String qry="update Employee set name=?,salary=? where id=?";
		temp.update(qry,emp.getName(),emp.getSal(),emp.getId());
		return "Updated successfully";
	}
	public String Delete(int id)
	{
		String qry="Delete from  Employee where id=?";
		temp.update(qry,id);
		return "deleted successfully";
	}

}
