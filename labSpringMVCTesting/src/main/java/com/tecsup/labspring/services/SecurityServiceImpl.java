package com.tecsup.labspring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.labspring.dao.EmployeeDAO;
import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.exception.LoginException;
import com.tecsup.labspring.model.Employee;


@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override	
	public Employee validate(String login, String pwd) throws LoginException, DAOException {

		Employee emp = employeeDAO.validate(login, pwd);

		return emp;
	}

}