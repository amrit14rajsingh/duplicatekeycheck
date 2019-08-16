package com.tarento.duplicatekeycheck.service;

import java.util.Optional;

import com.tarento.duplicatekeycheck.domain.Employee;

public interface KeyCheckService {

	boolean createEmployee(Employee employee);
    boolean checkIfDuplicate(final Employee employee);
}
