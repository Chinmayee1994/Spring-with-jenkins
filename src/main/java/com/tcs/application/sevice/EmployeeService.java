package com.tcs.application.sevice;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.application.dto.EmployeeDto;
import com.tcs.application.entity.Employee;
import com.tcs.application.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private ModelMapper modelMapper;

	public EmployeeService() {
		modelMapper = new ModelMapper();
	}

	private EmployeeDto convertToDto(Employee employee) {

		return modelMapper.map(employee, EmployeeDto.class);
	}

	private Employee convertToEntity(EmployeeDto employee) {
		return modelMapper.map(employee, Employee.class);
	}

	public EmployeeDto saveEmployee(EmployeeDto employee) {
		EmployeeDto emp = null;
		Employee empl = convertToEntity(employee);
		Employee newEmployee = employeeRepository.save(empl);
		emp = this.convertToDto(newEmployee);
		return emp;
	}

	public EmployeeDto getEmployee(int empId) {
		Employee empl = employeeRepository.findById(empId).get();
		return convertToDto(empl);
	}

	public EmployeeDto updateEmployee(int empId, EmployeeDto newEmployee) {
		Employee empl = this.convertToEntity(newEmployee);
		empl.setEmpId(empId);
		Employee updatedEmp = employeeRepository.save(empl);
		return this.convertToDto(updatedEmp);
	}

	public List<EmployeeDto> getAllEmployee() {

		List<Employee> listOfEmp = employeeRepository.findAll();
		List<EmployeeDto> listOfEmpDto = listOfEmp.stream().map(emp -> this.convertToDto(emp))
				.collect(Collectors.toList());
		return listOfEmpDto;
	}

	public void deleteEmployee(int empId) {
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employeeRepository.delete(employee);
	}

	public void deleteAllEmployee() {
		employeeRepository.deleteAll();
	}

}
