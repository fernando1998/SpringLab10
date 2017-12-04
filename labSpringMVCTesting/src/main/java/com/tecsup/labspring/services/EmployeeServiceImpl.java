package com.tecsup.labspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tecsup.labspring.dao.EmployeeDAO;
import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.exception.EmptyResultException;
import com.tecsup.labspring.model.Employee;
import com.tecsup.labspring.model.EmployeeRoles;
import com.tecsup.labspring.model.Role;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee find(int employee_id) throws DAOException, EmptyResultException {
		
		Employee emp = employeeDAO.findEmployee(employee_id);

		return emp;
	}

	@Override
	public List<Employee> findAll() throws DAOException, EmptyResultException {
		
		List<Employee> emps = employeeDAO.findAllEmployees();
		return emps;
	}
	
	@Override
	public void update(String login, String password, String lastname, String firstname, int salary, int dptId)
			throws DAOException {
	
		employeeDAO.update(login, password, lastname, firstname, salary, dptId);
	}

	@Override
	public void delete(String login) throws DAOException {
		 
		employeeDAO.delete(login);
	
	}

	@Override
	public void create(String login, String password, String lastname, String firstname, int salary, int dptId)
			throws DAOException {
	
		employeeDAO.create(login, password, lastname, firstname, salary, dptId);

	}
	
	@Override
	public Employee findByLogin(String login) throws DAOException, EmptyResultException {
		
		Employee emp = employeeDAO.findEmployeeByLogin(login);

		return emp;
		
	}

	@Override
	public boolean isEmployeeExist(Employee emp) throws DAOException, EmptyResultException {
		
		emp.getLogin();
			
		if(employeeDAO.isEmployeeExist(emp.getLogin()) !=null){
			
			return true;
			
		}else{
			
			return false;
		}
		
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { DAOException.class })
	public void createWithRole(String login, String password, String lastname, String firstname, int salary, int dptId,
			String roleId) throws DAOException {

		employeeDAO.create(login, password, lastname, firstname, salary, dptId);
		employeeDAO.addRole(login, roleId);

	}

	@Override
	public void updateRole(String roleId, String login) throws DAOException {
		employeeDAO.editRole(roleId, login);
	
	}

	@Override
	public void deleteRole(String login) throws DAOException {
		employeeDAO.deleterole(login);
		
		
	}

}