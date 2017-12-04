package com.tecsup.labspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.labspring.model.Employee;
import com.tecsup.labspring.model.Role;

public class EmployeeMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setEmployeeId(rs.getInt("employee_id"));
		emp.setLogin(rs.getString("login"));
		emp.setPassword(rs.getString("password"));
		emp.setFirstname(rs.getString("first_name"));
		emp.setLastname(rs.getString("last_name"));
		emp.setSalary(rs.getInt("salary"));
		
		Role r=new Role();
		
		
		
		r.setRoleId(rs.getString("role"));
		emp.setRole(r);
		return emp;
		
		//adicionar roles 
				//5-- descripcio
				//5 mostral rol- 5 modificar rol - 5 borrar rol and user
	}
}
