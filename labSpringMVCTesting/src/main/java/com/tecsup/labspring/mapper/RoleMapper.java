package com.tecsup.labspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tecsup.labspring.model.EmployeeRoles;
import com.tecsup.labspring.model.Role;

public class RoleMapper  implements RowMapper<EmployeeRoles> {

	public EmployeeRoles mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		EmployeeRoles rl = new EmployeeRoles();
		
		rl.setEmployeeRoleId(rs.getInt("employee_role_id"));
		rl.setLogin(rs.getString("login"));
		rl.setRole(rs.getString("role"));
		return rl;
	}
}
