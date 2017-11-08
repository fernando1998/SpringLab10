package com.tecsup.labspring.dao;

import java.util.List;

import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.exception.EmptyResultException;
import com.tecsup.labspring.exception.LoginException;
import com.tecsup.labspring.model.Employee;

public interface EmployeeDAO {

	Employee findEmployee(int id) throws DAOException, EmptyResultException;

	void create(String login, String password, String lastname, String firstname, int salary, int dptId) throws DAOException;

	void delete(String login) throws DAOException;


	void update(String login, String password, String lastname, String firstname, int salary, int dptId) throws DAOException;

	Employee findEmployeeByLogin(String login) throws DAOException, EmptyResultException;

	List<Employee> findAllEmployees() throws DAOException, EmptyResultException;

	List<Employee> findEmployeesByName(String name) throws DAOException, EmptyResultException;
	
	
	List<Employee> findEmployeesByNameLastnameSalary(String name,String lastname, int salary) throws DAOException, EmptyResultException;
	
	
	
	List<Employee> findEmployeeLastName(String lastname) throws DAOException, EmptyResultException;
	
	Employee validate(String login, String pwd) throws LoginException, DAOException;


}