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
import com.tecsup.labspring.services.DepartmentService;

@Controller
public class DepartmentController {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;
	
	//----------------------------------Listar todos los Departments---------------------------------------
		//Departments  /admin/dpto/list
		
		
		@GetMapping("/admin/dpto/Deplist")
		public String Deplist(@ModelAttribute("SpringWeb") Department department, ModelMap model) {

			try {
				model.addAttribute("dptos", departmentService.findAll());
			} catch (Exception e) {
				logger.info(e.getMessage());
				model.addAttribute("message", e.getMessage());
			}

			return "admin/dpto/Deplist";
		}
		
		//--------------------------------Creando Departments----------------------------------------
			
		@GetMapping("/admin/dpto/createDepform")
		public ModelAndView createDepform() {

			Department emp = new Department();

			ModelAndView modelAndView = new ModelAndView("admin/dpto/createDepform", "command", emp);

			return modelAndView;
		}


		@PostMapping("/admin/dpto/createDep")
		public ModelAndView createDep(@ModelAttribute("SpringWeb") Department dpo, ModelMap model) {

			
			ModelAndView modelAndView = null;
			
			try {
				departmentService.create(dpo.getName(), dpo.getDescription(), dpo.getCity());
				
				logger.info("new Department name = " + dpo.getName());
				
				modelAndView = new ModelAndView("redirect:/admin/dpto/Deplist");
			} catch (DAOException e) {
				logger.error(e.getMessage());
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("admin/dpto/createDepform","command", dpo);
			}

			return modelAndView;
		}
		
	//-------------------------------------------------------------------------------------------	
		
			@GetMapping("/admin/dpto/{action}/{department_id}")
			public ModelAndView Depform(@PathVariable String action, @PathVariable int department_id, ModelMap model) {

				// action = {"editDepform","deleteDepform"}
				logger.info("action = " + action);
				ModelAndView modelAndView = null;

				try {
					Department emp = departmentService.find(department_id);
					logger.info(emp.toString());
					modelAndView = new ModelAndView("admin/dpto/" + action, "command", emp);
				} catch (Exception e) {
					model.addAttribute("message", e.getMessage());
					modelAndView = new ModelAndView("admin/dpto/" + action, "command", new Department());
				}

				return modelAndView;
			}
			//Update department and save
			@PostMapping("/admin/dpto/Depeditsave")
			public ModelAndView Depeditsave(@ModelAttribute("SpringWeb") Department dpo, ModelMap model) {

				
				logger.info("emp = " + dpo);
				
				ModelAndView modelAndView = null;

				try {
					departmentService.update(dpo.getName(), dpo.getDescription(), dpo.getCity());

					modelAndView = new ModelAndView("redirect:/admin/dpto/Deplist");
				} catch (Exception e) {
					model.addAttribute("message", e.getMessage());
					modelAndView = new ModelAndView("redirect:/admin/dpto/Deplist");
				}

				return modelAndView;
			}
		//--------------------------------------------Delete Department ------------------------------------------------
			@PostMapping("/admin/dpto/Depdelete")
			public ModelAndView Depdelete(@ModelAttribute("SpringWeb") Department dpo, ModelMap model) {

				ModelAndView modelAndView = null;

				try {
					departmentService.delete(dpo.getName());
					modelAndView = new ModelAndView("redirect:/admin/dpto/Deplist");
				} catch (Exception e) {
					model.addAttribute("message", e.getMessage());
					modelAndView = new ModelAndView("redirect:/admin/dpto/Deplist");
				}

				return modelAndView;
			}
		
	}