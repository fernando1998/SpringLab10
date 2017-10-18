package com.tecsup.labspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.labspring.dao.EmployeeDAO;
import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.exception.EmptyResultException;
import com.tecsup.labspring.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee find(int employee_id) throws DAOException, EmptyResultException {
		
		Employee emp = employeeDAO.findEmployee(employee_id);

		return emp;
	}


}
