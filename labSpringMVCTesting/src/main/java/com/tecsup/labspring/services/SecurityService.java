package com.tecsup.labspring.services;

import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.exception.LoginException;
import com.tecsup.labspring.model.Employee;

public interface SecurityService {

	Employee validate(String login, String pwd) throws LoginException, DAOException;
	
}