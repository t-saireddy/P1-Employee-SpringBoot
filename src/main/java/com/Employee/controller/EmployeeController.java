package com.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Model.Employee;
import com.Employee.Service.IEmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class EmployeeController {
	@Autowired
	private IEmployeeService empserv;
	
	@PostMapping("/post")
	public Employee postMethodName(@RequestBody Employee employee) {
		
		return empserv.createEmployee(employee);
	}
	
	@GetMapping("/getall")
	public List<Employee> getAll(){
		return empserv.getAllEmployee();
	}
	
	@GetMapping("/FindByID/{id}")
	public Employee getByEmployeeId(@PathVariable Integer id) {
		return empserv.getById(id);
		
	}
	
	@PutMapping("/update/{id}")
	public Employee putMethodName(@PathVariable Integer id, @RequestBody Employee employee) {
		return empserv.updateEmployee(id,employee);
	}
	
	@DeleteMapping("/delete/{id}")
		public void deleteEmployee(@PathVariable Integer id) {
			empserv.deleteEmpById(id);
		}

}
