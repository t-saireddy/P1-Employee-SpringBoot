package com.Employee.Service;

import java.util.List;

import com.Employee.Model.Employee;

public interface IEmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployee();

	Employee getById(Integer id);

	Employee updateEmployee(Integer id, Employee employee);

	void deleteEmpById(Integer id);


	

}
