package com.tecsup.labspring.services;

import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.exception.EmptyResultException;
import com.tecsup.labspring.model.Employee;

public interface EmployeeService {

	Employee find(int employee_id) throws DAOException, EmptyResultException;
}
