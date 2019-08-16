package com.tarento.duplicatekeycheck.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tarento.duplicatekeycheck.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
