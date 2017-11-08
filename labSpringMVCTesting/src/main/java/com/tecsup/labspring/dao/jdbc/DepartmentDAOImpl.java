package com.tecsup.labspring.dao.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.labspring.dao.DepartmentDAO;
import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.exception.EmptyResultException;
import com.tecsup.labspring.mapper.DepartmentMapper;

import com.tecsup.labspring.model.Department;



@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
//--_-----------------------------------Buscar un deparment DAO-------------------------------------------------	
	@Override
	public Department findDepartment(int department_id) throws DAOException, EmptyResultException {
		String query = "SELECT department_id, name, description, city FROM departments WHERE department_id = ?";

		Object[] params = new Object[] { department_id };

		try {

			Department dpo = (Department) jdbcTemplate.queryForObject(query, params, new DepartmentMapper());
			//
			return dpo;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

//--------------------------------------------- Crear un department DAO-------------------------------------------------	
	@Override
	public void create(String name, String description, String city) throws DAOException {

		String query = "INSERT INTO departments (name, description, city)  VALUES ( ?,?,?)";

		Object[] params = new Object[] { name, description, city};

		//Department emp = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);

		} catch (Exception e) {
			logger.error("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}
	
//--------------------------------------------- Delete un department DAO-------------------------------------------------
	@Override
	public void delete(String name) throws DAOException {
		String query = "DELETE FROM  departments WHERE name = ? ";

		Object[] params = new Object[] { name };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	
	//--------------------------------------------- Update un department DAO-------------------------------------------------	
	@Override
	public void update(String name, String description, String city) throws DAOException {
		String query = "UPDATE departments SET  description =?, city = ? WHERE name = ?";

		Object[] params = new Object[] { description, city, name };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	//--------------------------------------------- Listar todos los departments DAO---------------------------------------------	
	@Override
	public List<Department> findAllDepartments() throws DAOException, EmptyResultException {
		
		String query = "SELECT department_id, name, description, city FROM departments ";

		try {

			List<Department> dptos = jdbcTemplate.query(query, new DepartmentMapper());
			//
			return dptos;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

}
