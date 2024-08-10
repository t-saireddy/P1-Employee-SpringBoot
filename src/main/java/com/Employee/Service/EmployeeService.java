package com.Employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Model.Employee;
import com.Employee.Repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{
	@Autowired
	EmployeeRepository emprepo;

	@Override
	public Employee createEmployee(Employee employee) {
		return emprepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return emprepo.findAll();
	}

	@Override
	public Employee getById(Integer id) {
		Optional<Employee> e = emprepo.findById(id);
		return e.get();
	}

	@Override
	public Employee updateEmployee(Integer id, Employee employee) {
		Optional<Employee> e = emprepo.findById(id);
		if(e.isPresent()) {
			Employee emp = e.get();
			emp.setName(employee.getName());
			emp.setDepartment(employee.getDepartment());
			emp.setSalary(employee.getSalary());
			return emprepo.save(emp);
		}else
			return null;
	}

	@Override
	public void deleteEmpById(Integer id) {
		emprepo.deleteById(id);
		
	}





}
