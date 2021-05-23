package com.tcs.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.application.dto.EmployeeDto;
import com.tcs.application.sevice.EmployeeService;

@RestController("/emp")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "/saveEmp", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employee) {
		EmployeeDto empl = employeeService.saveEmployee(employee);

		if (empl == null) {
			return new ResponseEntity<>(empl, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(empl, HttpStatus.OK);
	}

	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
		List<EmployeeDto> listOfEmployees = null;

		listOfEmployees = employeeService.getAllEmployee();
		if (listOfEmployees == null) {
			return new ResponseEntity<>(listOfEmployees, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(listOfEmployees, HttpStatus.OK);
	}

	@GetMapping(value = "/get/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "empId") int empId) {
		EmployeeDto employee = null;

		employee = employeeService.getEmployee(empId);
		if (employee == null) {
			return new ResponseEntity<>(employee, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PutMapping(value = "/update/{empId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(value = "empId") int empId,
			@RequestBody EmployeeDto employee) {
		EmployeeDto updatedEmployeeDto = null;

		updatedEmployeeDto = employeeService.updateEmployee(empId, employee);
		if (updatedEmployeeDto == null) {
			return new ResponseEntity<>(updatedEmployeeDto, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(updatedEmployeeDto, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{empId}")
	public void deleteEmployeeById(@PathVariable(value = "empId") int empId) {
		employeeService.deleteEmployee(empId);
	}

	@DeleteMapping(value = "deleteAll")
	public void deleteAllEmployee() {
		employeeService.deleteAllEmployee();
	}

	@GetMapping(value = "ping")
	public String checkAlive() {
		return "Alive !";
	}
}
