package com.param.lecture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.param.lecture.entities.Employee;
import com.param.lecture.exceptions.CustomException;
import com.param.lecture.model.EmployeeRequest;
import com.param.lecture.services.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/all")
	public ResponseEntity<Page<Employee>> getAllEmployee(@RequestParam("page") int page,
			@RequestParam("pageSize") int pageSize) {
		return ResponseEntity.ok(employeeService.getAllEmployees(page, pageSize));
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeRequest request) {
		return ResponseEntity.ok(employeeService.addEmployee(request));
	}

	@PutMapping("/edit")
	public ResponseEntity<Object> editEmployee(@RequestBody EmployeeRequest request) {
		try {
			return ResponseEntity.ok(employeeService.editEmployee(request));
		} catch (CustomException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployeeHard(@PathVariable int id) {
		return ResponseEntity.ok(employeeService.deleteEmployeeHard(id));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Employee> deleteEmployeeSoft(@RequestParam int id) {
		return ResponseEntity.ok(employeeService.deleteEmployeeSoft(id));
	}
}