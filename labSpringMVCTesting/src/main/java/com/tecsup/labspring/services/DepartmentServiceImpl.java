package com.tecsup.labspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.labspring.dao.DepartmentDAO;
import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.exception.EmptyResultException;
import com.tecsup.labspring.model.Department;



@Service
public class DepartmentServiceImpl  implements DepartmentService {
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
//--------------------------------Buscar de manera individual------------------------------------------------------
	@Override
	public Department find(int department_id) throws DAOException, EmptyResultException {
		
		Department dpo = departmentDAO.findDepartment(department_id);

		return dpo;
	}

//.-------------------------------------Listar todos los departamentos---------------------------------------	
	@Override
	public List<Department> findAll() throws DAOException, EmptyResultException {
		
		List<Department> dpos = departmentDAO.findAllDepartments();
		return dpos;
	}
	
	
	//.-------------------------------------Actualizar un departamento---------------------------------------
	@Override
	public void update(String name, String description, String city) throws DAOException {
		
		departmentDAO.update(name, description, city);
		
	}
	
	//.-------------------------------------Borrar un departamento---------------------------------------
	@Override
	public void delete(String name) throws DAOException {
		
		departmentDAO.delete(name);
	}

	//.-------------------------------------Crear un departamento---------------------------------------
	@Override
	public void create(String name, String description, String city) throws DAOException {
		departmentDAO.create(name, description, city);
		
	}

}
