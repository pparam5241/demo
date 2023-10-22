package com.param.lecture.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.param.lecture.entities.Employee;
import com.param.lecture.exceptions.CustomException;
import com.param.lecture.model.EmployeeRequest;
import com.param.lecture.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Page<Employee> getAllEmployees(int page, int pageSize) {
		Pageable pageable = PageRequest.of(page, pageSize);
		return employeeRepository.findAllEmployee(pageable);
	}

	public Employee addEmployee(EmployeeRequest request) {
		// Write a code to map the request with entity and save record to database
		Employee employee = new Employee();
		employee.setName(request.getName());
		employee.setAddress(request.getAddress());
		employee.setCity(request.getCity());
		employee.setState(request.getState());
		employee.setMobileNo(request.getMobileNo());

		System.out.println(employee);
		employeeRepository.save(employee);
		System.out.println(employee);
		return employee;
	}

	public Employee editEmployee(EmployeeRequest request) {
		if (request.getId() <= 0)
			throw new CustomException("Id is required. Missing in request.");
		Employee employee = employeeRepository.findById(request.getId());
		if (request.getName() != null && request.getName().trim().length() > 0) {
			employee.setName(request.getName());
		}
		return employeeRepository.save(employee);
	}

	public String deleteEmployeeHard(int id) {
		// TODO Auto-generated method stub
		// DeletebyObject -> Using Object
		// DeleteById -> Using Id
		// Employee employee = employeeRepository.findById(id);
		employeeRepository.deleteById(id);
		return "Employee Deleted Successfully!";
	}

	public Employee deleteEmployeeSoft(int id) {
		Employee employee = employeeRepository.findById(id);
		employee.setIsDeleted(1);
		return employeeRepository.save(employee);
	}
}