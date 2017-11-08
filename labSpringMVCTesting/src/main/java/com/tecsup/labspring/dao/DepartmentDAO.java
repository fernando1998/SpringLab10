package com.tecsup.labspring.dao;

import java.util.List;

import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.exception.EmptyResultException;
import com.tecsup.labspring.model.Department;

public interface DepartmentDAO {
	
	Department findDepartment(int id) throws DAOException, EmptyResultException;

	void create(String name, String description, String city) throws DAOException;

	void delete(String name) throws DAOException;

	void update(String name, String description, String city) throws DAOException;

	
	List<Department> findAllDepartments() throws DAOException, EmptyResultException;


}
