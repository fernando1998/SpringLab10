package com.tecsup.labspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.labspring.model.Department;

public class DepartmentMapper implements RowMapper<Department>{
	
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Department dpo = new Department();
		dpo.setDepartmentId(rs.getInt("department_id"));
		dpo.setName(rs.getString("name"));
		dpo.setDescription(rs.getString("description"));
		dpo.setCity(rs.getString("city"));
		
		
		return dpo;
	}
	

}
