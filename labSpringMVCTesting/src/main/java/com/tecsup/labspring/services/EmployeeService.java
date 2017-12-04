package com.tecsup.labspring.services;

import java.util.List;

import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.exception.EmptyResultException;

import com.tecsup.labspring.model.Employee;
import com.tecsup.labspring.model.EmployeeRoles;
import com.tecsup.labspring.model.Role;

public interface EmployeeService {
	
	Employee find(int employee_id) throws DAOException, EmptyResultException;

	List <Employee> findAll() throws DAOException, EmptyResultException;
	
	//List <Employee> fin
	
	
void update(String login, String password, String lastname, String firstname, int salary, int dptId)
		throws DAOException;

void delete(String login) throws DAOException;

void create(String login, String password, String lastname, String firstname, int salary, int deptId) throws DAOException;

Employee findByLogin(String login_user)throws DAOException, EmptyResultException;


boolean isEmployeeExist(Employee emp)throws DAOException, EmptyResultException;

void createWithRole(String login, String password, String lastname, String firstname, int salary, int deptId,
		String roleId) throws DAOException;

void updateRole(String roleId,String login)throws DAOException;

void deleteRole(String login) throws DAOException;

}