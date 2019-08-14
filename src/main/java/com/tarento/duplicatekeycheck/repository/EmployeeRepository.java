package com.tarento.duplicatekeycheck.repository;

import org.springframework.data.repository.CrudRepository;

import com.tarento.duplicatekeycheck.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
