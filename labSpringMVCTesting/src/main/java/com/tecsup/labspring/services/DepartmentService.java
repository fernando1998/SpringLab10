package com.tecsup.labspring.services;

import java.util.List;

import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.exception.EmptyResultException;
import com.tecsup.labspring.model.Department;


public interface DepartmentService {

	/*`department_id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(45) DEFAULT NULL,
	`desc` varchar(90) DEFAULT NULL,
	`city` varchar(45) DEFAULT NULL,
	*/
	Department find(int department_id) throws DAOException, EmptyResultException;

	List <Department> findAll() throws DAOException, EmptyResultException;
		
	void update(String name, String description, String city)
		throws DAOException;

	void delete(String name) throws DAOException;

	void create(String name, String description, String city)
			throws DAOException;
}
