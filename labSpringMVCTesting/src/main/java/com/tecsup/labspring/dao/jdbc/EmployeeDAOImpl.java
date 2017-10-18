package com.tecsup.labspring.dao.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.labspring.dao.EmployeeDAO;
import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.exception.EmptyResultException;
import com.tecsup.labspring.mapper.EmployeeMapper;
import com.tecsup.labspring.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public Employee findEmployee(int employee_id) throws DAOException, EmptyResultException {

		String query = "SELECT employee_id, login, password, first_name, last_name, salary, department_id "
				+ " FROM employees WHERE employee_id = ?";

		Object[] params = new Object[] { employee_id };

		try {

			Employee emp = (Employee) jdbcTemplate.queryForObject(query, params, new EmployeeMapper());
			//
			return emp;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

}
