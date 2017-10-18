package com.tecsup.labspring.dao;

import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.exception.EmptyResultException;
import com.tecsup.labspring.model.Employee;

public interface EmployeeDAO {

	Employee findEmployee(int id) throws DAOException, EmptyResultException;
}
