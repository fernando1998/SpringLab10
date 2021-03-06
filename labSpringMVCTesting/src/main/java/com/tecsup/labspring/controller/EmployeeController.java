package com.tecsup.labspring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tecsup.labspring.exception.DAOException;
import com.tecsup.labspring.model.Department;
import com.tecsup.labspring.model.Employee;
import com.tecsup.labspring.services.DepartmentService;
import com.tecsup.labspring.services.EmployeeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	// @Autowired
	// private DepartmentService departmentService;

	@GetMapping("/user/menu")
	public String menu() {

		return "/user/menu";
	}

	@GetMapping("/user/403")
	public String accessDenied() {

		return "/user/403";
	}

	@GetMapping("/admin/emp/list")
	public String list(@ModelAttribute("SpringWeb") Employee employee, ModelMap model) {

		try {
			
		//	Employee e=(Employee)employeeService.findAll();
			
			model.addAttribute("employees", employeeService.findAll());
			
			
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/emp/list";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/{employee_id}")
	public ModelAndView home(@PathVariable int employee_id, ModelMap model) {

		ModelAndView modelAndView = null;
		Employee emp = new Employee();
		try {
			emp = employeeService.find(employee_id);
			logger.info(emp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		modelAndView = new ModelAndView("home", "command", emp);

		return modelAndView;
	}

	// -----------------------------------------------------------------------------------------------------------
	@GetMapping("/admin/emp/{action}/{employee_id}")
	public ModelAndView form(@PathVariable String action, @PathVariable int employee_id, ModelMap model) {

		// action = {"editform","deleteform"}
		logger.info("action = " + action);
		ModelAndView modelAndView = null;

		try {
			Employee emp = employeeService.find(employee_id);
			logger.info(emp.toString());
			modelAndView = new ModelAndView("admin/emp/" + action, "command", emp);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/emp/" + action, "command", new Employee());
		}

		return modelAndView;
	}

	@PostMapping("/admin/emp/editsave")
	public ModelAndView editsave(@ModelAttribute("SpringWeb") Employee emp, ModelMap model) {

		logger.info("emp = " + emp);

		ModelAndView modelAndView = null;

		try {
			employeeService.update(emp.getLogin(), emp.getPassword(), emp.getFirstname(), emp.getLastname(),
					emp.getSalary(), -1);

			modelAndView = new ModelAndView("redirect:/admin/emp/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/emp/list");
		}

		return modelAndView;
	}

	// --------------------------------------------------------------------------------------------------------------

	@PostMapping("/admin/emp/delete")
	public ModelAndView delete(@ModelAttribute("SpringWeb") Employee emp, ModelMap model) {

		ModelAndView modelAndView = null;

		try {
			employeeService.delete(emp.getLogin());
			modelAndView = new ModelAndView("redirect:/admin/emp/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/emp/list");
		}

		return modelAndView;
	}

	// ------------------------------------------------------------------------------------------------------------
	@GetMapping("/admin/emp/createform")
	public ModelAndView createform() {

		Employee emp = new Employee();

		ModelAndView modelAndView = new ModelAndView("admin/emp/createform", "command", emp);

		return modelAndView;
	}

	@PostMapping("/admin/emp/create")
	public ModelAndView create(@ModelAttribute("SpringWeb") Employee emp, ModelMap model) {

		ModelAndView modelAndView = null;

		try {
			employeeService.create(emp.getLogin(), emp.getPassword(), emp.getFirstname(), emp.getLastname(),
					emp.getSalary(), 12);
			logger.info("new Employee login = " + emp.getLogin());
			modelAndView = new ModelAndView("redirect:/admin/emp/list");
		} catch (DAOException e) {
			logger.error(e.getMessage());
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/emp/createform", "command", emp);
		}

		return modelAndView;
	}

	
////////////////////////////////////////////////////////////////////////////////////
// CREATION WITH ROLE //
////////////////////////////////////////////////////////////////////////////////////
@GetMapping("/admin/emp/createformWithRole")
public ModelAndView createformWithRole() {

Employee emp = new Employee();

ModelAndView modelAndView = new ModelAndView("admin/emp/createformWithRole", "employee", emp);

return modelAndView;
}


@PostMapping("/admin/emp/createWithRole")
public ModelAndView createWithRole(@ModelAttribute("employee") Employee emp, ModelMap model) {

ModelAndView modelAndView = null;


try {
employeeService.createWithRole(emp.getLogin(), emp.getPassword(), emp.getFirstname(),
emp.getLastname(), emp.getSalary(), 12, emp.getRole().getRoleId());
logger.info("new Employee login = " + emp.getLogin());

modelAndView = new ModelAndView("redirect:/admin/emp/list");
} catch (Exception e) {
logger.error(e.getMessage());
model.addAttribute("message", e.getMessage());
modelAndView = new ModelAndView("admin/emp/createformWithRole", "employee", emp);
}

return modelAndView;
}

//Get  EDIT-ROLE AND DELETE-ROLE

@GetMapping("/admin/emp/role/{action}/{employee_id}")
public ModelAndView formRole(@PathVariable String action, @PathVariable int employee_id, ModelMap model) {

	// action = {"editformrole","deleteformrole"}
	logger.info("action = " + action);
	ModelAndView modelAndView = null;

	try {
		Employee emp = employeeService.find(employee_id);
		logger.info(emp.toString());
		modelAndView = new ModelAndView("admin/emp/role/" + action, "command", emp);
	} catch (Exception e) {
		model.addAttribute("message", e.getMessage());
		modelAndView = new ModelAndView("admin/emp/role/" + action, "command", new Employee());
	}

	return modelAndView;
}

@PostMapping("/admin/emp/role/editsaverole")
public ModelAndView editsaverole(@ModelAttribute("SpringWeb") Employee emp, ModelMap model) {

	logger.info("emp = " + emp);

	ModelAndView modelAndView = null;

	try {
		
		employeeService.updateRole(emp.getRole().getRoleId(), emp.getLogin());

		modelAndView = new ModelAndView("redirect:/admin/emp/list");
	} catch (Exception e) {
		model.addAttribute("message", e.getMessage());
		modelAndView = new ModelAndView("redirect:/admin/emp/list");
	}

	return modelAndView;
}


@PostMapping("/admin/emp/role/deleterole")
public ModelAndView deleterole(@ModelAttribute("SpringWeb") Employee emp, ModelMap model) {

	ModelAndView modelAndView = null;

	try {
		employeeService.delete(emp.getLogin());
		employeeService.deleteRole(emp.getLogin());
		modelAndView = new ModelAndView("redirect:/admin/emp/list");
	} catch (Exception e) {
		model.addAttribute("message", e.getMessage());
		modelAndView = new ModelAndView("redirect:/admin/emp/list");
	}

	return modelAndView;
}


}
