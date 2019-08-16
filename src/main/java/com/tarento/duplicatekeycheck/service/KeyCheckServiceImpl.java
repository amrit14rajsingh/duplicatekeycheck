package com.tarento.duplicatekeycheck.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarento.duplicatekeycheck.domain.Employee;
import com.tarento.duplicatekeycheck.repository.EmployeeRepository;


@Service
public class KeyCheckServiceImpl implements KeyCheckService{
	
	EmployeeRepository employeeRepository;
	
	@Autowired
	public KeyCheckServiceImpl(final EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		boolean ifduplicate = checkIfDuplicate(employee);
		if(ifduplicate == false) {
			employeeRepository.save(employee);
			return false;
		  }
		
		return true;
	}

	/*@Override
	public Optional<Boolean> checkIfDuplicate(Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());
		if(employeeOptional.isPresent())
		   return Optional.of(true);
		return Optional.of(false);
	}*/

	@Override
	public boolean checkIfDuplicate(Employee employee) {
		Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());
		if(employeeOptional.isPresent())
		   return true;
		return false;
	}

}
