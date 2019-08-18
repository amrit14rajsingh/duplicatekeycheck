package com.tarento.duplicatekeycheck.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tarento.duplicatekeycheck.domain.Employee;
import com.tarento.duplicatekeycheck.repository.EmployeeRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class KeyCheckServiceImplTest {

	
	@MockBean
	EmployeeRepository employeeRepository;
	
	KeyCheckServiceImpl keyCheckServiceImpl;
	
	 @Before
	 public void setUp() {
	        // With this call to initMocks we tell Mockito to process the annotations 
	        MockitoAnnotations.initMocks(this);
	        keyCheckServiceImpl = new KeyCheckServiceImpl(employeeRepository);
	    }
	
	
	@Test
	public void testCreateEmployeeFalse() {
		//given
		Employee e1 = new Employee("A1071","Amrit","Raj","Computer",1000);
		given(employeeRepository.findById(e1.getId())).willReturn(Optional.of(e1));
		
		//when
		boolean ifEmployeeCreated = keyCheckServiceImpl.createEmployee(e1);
		
		//then
		assertThat(ifEmployeeCreated).isTrue();
		
	}
	
	@Test
	public void testCreateEmployeeTrue() {
		//given
		Employee e1 = new Employee("A1071","Amrit","Raj","Computer",1000);
		given(employeeRepository.findById(e1.getId())).willReturn(Optional.empty());
		
		//when
		boolean ifEmployeeCreated = keyCheckServiceImpl.createEmployee(e1);
		
		//then
		assertThat(ifEmployeeCreated).isFalse();
		
	}

	@Test
	public void testCheckIfDuplicateTrue() {
		//given
		Employee e1 = new Employee("A1071","Amrit","Raj","Computer",1000);
		given(employeeRepository.findById(e1.getId())).willReturn(Optional.of(e1));
		
		//when
		boolean ifKeyPresent = keyCheckServiceImpl.checkIfDuplicate(e1);
		
		//then
		assertThat(ifKeyPresent).isTrue();
	}
	
	@Test
	public void testCheckIfDuplicateFalse() {
		//given
		Employee e1 = new Employee("A1071","Amrit","Raj","Computer",1000);
		given(employeeRepository.findById(e1.getId())).willReturn(Optional.empty());
		
		//when
		boolean ifKeyPresent = keyCheckServiceImpl.checkIfDuplicate(e1);
		
		//then
		assertThat(ifKeyPresent).isFalse();
	}

}
